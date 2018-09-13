import sys
sys.path.append("/Users/Zerhogie/SimilitudCodigos/Proyecto/")
sys.path.append("/Users/Zerhogie/SimilitudCodigos/Proyecto/ModuloSimilitud")
import unittest

from ModuloSimilitud.Informacion.java import javalangMaster, metaJava, contraJava

class PruebasJava(unittest.TestCase):
    codigoPrueba = """/*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package pruebastesis;

    /**
    *
    * @author zerhogie
    */
    public class PruebasTesis {
        private int contatras(int i){
            if(i>0) //Comentario de prueba?.tal vezüósá
                System.out.println(contatras(i-1));
            return i;
        }
        /**
        * @param args the command line arguments
        */
        public static void main(String[] args) {
            System.out.println(new PruebasTesis().contatras(10));
        }
    }"""
    sinComentarios = """
    package pruebastesis;

    
    public class PruebasTesis {
        private int contatras(int i){
            if(i>0) 
                System.out.println(contatras(i-1));
            return i;
        }
        
        public static void main(String[] args) {
            System.out.println(new PruebasTesis().contatras(10));
        }
    }"""
    ## -- PRUEBAS DE METAJAVA -- ##
    def test_retirarComentarios(self):
        # Debe quitar todos los comentarios
        self.assertEqual(metaJava.retirarComentarios(self.codigoPrueba), self.sinComentarios)
    def test_reducir(self):
        # Debe quitar los espacios
        self.assertEqual(metaJava.reducir(self.sinComentarios), "packagepruebastesis;publicclassPruebasTesis{privateintcontatras(inti){if(i>0)System.out.println(contatras(i-1));returni;}publicstaticvoidmain(String[]args){System.out.println(newPruebasTesis().contatras(10));}}")
    def test_extraerCodigo(self):
        # Debe obtener el código sin comentarios y reducido
        self.assertEqual(metaJava.extraerCodigo("/Users/Zerhogie/SimilitudCodigos/Proyecto/ArchivosPrueba/java/PruebasTesis.java"), metaJava.reducir(self.sinComentarios))
    def test_extraerTokens(self):
        # Debe regresar la lista de tokens de un archivo
        self.assertCountEqual([str(i) for i in metaJava.extraerTokens("/Users/Zerhogie/SimilitudCodigos/Proyecto/ArchivosPrueba/java/pruebaPequena")], ['Identifier "System" line 1, position 0', 'Separator "." line 1, position 6', 'Identifier "out" line 1, position 7', 'Separator "." line 1, position 10', 'Identifier "print" line 1, position 11', 'Separator "(" line 1, position 16', 'String ""mohohoho"" line 1, position 17', 'Separator ")" line 1, position 27'])
    def test_extraerAST(self):
        # Debe arrojar un objeto 
        self.assertIsInstance(metaJava.extraerAST("/Users/Zerhogie/SimilitudCodigos/Proyecto/ArchivosPrueba/java/PruebasTesis.java"), javalangMaster.javalang.tree.CompilationUnit)
    ## -- PRUEBAS DE CONTRAJAVA -- ##
    def test_compararCodigo(self):
        # Comparación de cadenas de código
        self.assertEqual(contraJava.compararCodigo('System.out.print("Cacho de código")', 'System.out.print("Cacho de código")'), 1)
        self.assertGreater(contraJava.compararCodigo('System.out.print("Cacho de código")', 'System.out.print("Cacho código")'), 0.9)
        self.assertLess(contraJava.compararCodigo('System.out.print("Cacho de código")', 'System.out.print("Este es otra cosa")'), 0.8)
        self.assertLess(contraJava.compararCodigo('System.out.print("Cacho de código")', 'public void class Nueva() { }'), 0.4)

    def test_compararTokens(self):
        # Comparación entre listas (Se espera que se manden tokens, pero es posible hacer las pruebas bajo cualquier lista)
        self.assertEqual(contraJava.compararTokens([1,'a',3,'b',5,'c',7,8,9,0], [1,'a',3,'b',5,'c',7,8,9,0]), 1)
        self.assertGreater(contraJava.compararTokens([1,2,3,[],5,{},8,9,0], [1,2,3,[],5,{},8,9]), 0.9)
        self.assertLess(contraJava.compararTokens([1,2,3,4,5,6,7,8,9,0], [1,2,3,4,5,6,7,8]), 0.9)
        self.assertLess(contraJava.compararTokens([1,'a',3, 'b', 5], [1,2,3,4,5]), 0.7)
        self.assertLess(contraJava.compararTokens([1,2,3,4,5,6,7,8,9,0], [1,2,3]), 0.5)
        self.assertLess(contraJava.compararTokens(['a', 'b', 'c'], ['c', 1, {'a': 1, 'a':2}]), 0.5)

    def test_compararPorLongitud(self):
        # Compara el numero de elementos de los arreglos y segun su longitud determina una similitud
        self.assertEqual(contraJava.compararPorLongitud([1,2,3,4,5,6,7,8,9,0], [1,2,3,4,5,6,7,8,9,0]), 1)
        self.assertGreater(contraJava.compararPorLongitud([1,2,3,4,5,6,7,8], [1,2,3,4,5,6,7,8,9,0]), 0.8)
        self.assertLess(contraJava.compararPorLongitud([1,2], [1,2,3,4,5,6]), 0.6)
        self.assertLess(contraJava.compararPorLongitud([1,2,3,4,5,6], [1,2]), 0.6)
        self.assertEqual(contraJava.compararPorLongitud([], []), 1)
        self.assertEqual(contraJava.compararPorLongitud([], [1,2,3,4,5]), 0)
        self.assertEqual(contraJava.compararPorLongitud([1,2,3,4,5], []), 0)

    def test_compararASTIgual(self):
        # Mismo código pero sin comentarios debe ser igual al comparar arbol sintáctico
        ast1 = javalangMaster.javalang.parse.parse(self.codigoPrueba)
        ast2 = javalangMaster.javalang.parse.parse(self.sinComentarios)
        self.assertEqual(contraJava.compararAST(ast1, ast2), 1)

if __name__ == "__main__":
    unittest.main()