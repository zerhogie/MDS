import sys
sys.path.append("/Users/Zerhogie/SimilitudCodigos/Proyecto/")

import unittest
import shutil
from datetime import datetime

import os
from ModuloSimilitud import tools
from ModuloSimilitud import settings
from ModuloSimilitud import main

from ModuloSimilitud.Informacion import select
from ModuloSimilitud.Informacion import MetaCodigo

class PruebaModuloSimilitud(unittest.TestCase):
    ## PRUEBAS DE TOOLS ##
    ruta = "/Users/Zerhogie/SimilitudCodigos/Proyecto/Tests/" # Ruta de maquina de pruebas
    def test_ls(self):
        self.assertCountEqual(tools.ls(self.ruta), [self.ruta + '__init__.py', self.ruta + 'Archivos', self.ruta + 'ModSim_Test.py'])

    def test_lsArchivo(self):
        self.assertCountEqual(tools.ls(self.ruta, see = "file"), [self.ruta + "ModSim_Test.py", self.ruta + "__init__.py"])

    def test_lsDirectorio(self):
        self.assertCountEqual(tools.ls(self.ruta, see = "dir"), [self.ruta + "Archivos"])

    def test_obtenerArchivos(self):
        self.assertCountEqual(tools.obtenerArchivos(self.ruta), [self.ruta + "__init__.py", self.ruta + "ModSim_Test.py", self.ruta + "Archivos/arbolEnDict", self.ruta + "Archivos/PruebasTesis.java", self.ruta + "Archivos/anidada/archivo2.py", self.ruta + "Archivos/anidada/pruebameta1.mc"])

    def test_encontrarMC(self):
        self.assertEqual(tools.encontrarMC(1, [self.ruta + "__init__.py", self.ruta + "ModSim_Test.py", self.ruta + "Archivos/arbolEnDict", self.ruta + "Archivos/PruebasTesis.java", self.ruta + "Archivos/anidada/archivo2.py", self.ruta + "Archivos/anidada/pruebameta1.mc"]), self.ruta + "Archivos/anidada/pruebameta1.mc")

    def test_encontrarMCNoExistente(self):
        self.assertFalse(tools.encontrarMC(-1))

    def test_crearDir(self):
        tools.createDir(self.ruta + "Archivos/anidada/directorio")
        self.assertTrue(os.path.exists(self.ruta + "Archivos/anidada/directorio"))
        shutil.rmtree(self.ruta + "Archivos/anidada/directorio")
        

class PruebasInformacion(unittest.TestCase):
    ## PRUEBAS DE SE LECT ##
    def test_extension(self):
        self.assertEqual(select.extension("pruebas.py"), "py")
        self.assertEqual(select.extension("/una/ruta/artificial.java"), "java")

    def test_obtenerCodigo(self):
        self.assertEqual(select.obtenerCodigo("/Users/Zerhogie/SimilitudCodigos/Proyecto/Tests/Archivos/PruebasTesis.java"), '/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage pruebastesis;\n\n/**\n *\n * @author zerhogie\n */\npublic class PruebasTesis {\n    private int contatras(int i){\n        if(i>0)\n            System.out.println(contatras(i-1));\n        return i;\n    }\n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n        System.out.println(new PruebasTesis().contatras(10));\n    }\n}\n')


class PruebasMetaCodigo(unittest.TestCase):
    mc = MetaCodigo(0,0,0)

    def test_constructor(self):
        self.assertIsInstance(self.mc, MetaCodigo)

    def test_constructorLeerVacio(self):
        self.assertEqual(MetaCodigo(-1,0,0).leer(),"No existe MetaCodigo con id=-1")

    def test_setEx(self):
        self.mc.setExt("java")
        self.assertTrue(self.mc.MetaInfo["ext"])

    def test_setCodigo(self):
        self.mc.setCodigo("/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage pruebastesis;\n\n/**\n *\n * @author zerhogie\n */\npublic class PruebasTesis {\n    private int contatras(int i){\n        if(i>0)\n            System.out.println(contatras(i-1));\n        return i;\n    }\n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n        System.out.println(new PruebasTesis().contatras(10));\n    }\n}\n")
        self.assertTrue(self.mc.MetaInfo["codigo"])

    def test_setTokens(self):
        self.mc.setTokens(["token1", "token2", "token3"])
        self.assertTrue(self.mc.MetaInfo["tokens"])

    def test_setAST(self):
        self.mc.setAST(["Rama1", ["Rama2", ["Hoja1", "Hoja2"], "Hoja 3"]])
        self.assertTrue(self.mc.MetaInfo["ast"])

    def test_getEx(self):
        self.mc.setExt("java")
        self.assertEqual(self.mc.getExt(), "java")

    def test_getCodigo(self):
        self.mc.setCodigo("/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage pruebastesis;\n\n/**\n *\n * @author zerhogie\n */\npublic class PruebasTesis {\n    private int contatras(int i){\n        if(i>0)\n            System.out.println(contatras(i-1));\n        return i;\n    }\n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n        System.out.println(new PruebasTesis().contatras(10));\n    }\n}\n")
        self.assertEqual(self.mc.getCodigo(), "/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage pruebastesis;\n\n/**\n *\n * @author zerhogie\n */\npublic class PruebasTesis {\n    private int contatras(int i){\n        if(i>0)\n            System.out.println(contatras(i-1));\n        return i;\n    }\n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n        System.out.println(new PruebasTesis().contatras(10));\n    }\n}\n")

    def test_getTokens(self):
        self.mc.setTokens(["token1", "token2", "token3"])
        self.assertEqual(self.mc.getTokens(), ["token1", "token2", "token3"])

    def test_getAST(self):
        self.mc.setAST(["Rama1", ["Rama2", ["Hoja1", "Hoja2"], "Hoja 3"]])
        self.assertEqual(self.mc.getAST(), ["Rama1", ["Rama2", ["Hoja1", "Hoja2"], "Hoja 3"]])

    def test_guardarVacio(self):
        fecha = datetime.strftime(datetime.now(), "%Y/%m/%d/")
        mcVacio = MetaCodigo(-1,0,0)
        self.assertEqual(mcVacio.guardar(), "Nada que guardar")
        self.assertFalse(os.path.exists(os.path.join(settings.RUTA_METACODIGO, str(0), fecha, "meta" + str(mcVacio.idAlumno) + '.mc')))

    def test_guardar(self):
        fecha = datetime.strftime(datetime.now(), "%Y/%m/%d/")
        self.mc.setExt('java')
        self.mc.setCodigo("/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage pruebastesis;\n\n/**\n *\n * @author zerhogie\n */\npublic class PruebasTesis {\n    private int contatras(int i){\n        if(i>0)\n            System.out.println(contatras(i-1));\n        return i;\n    }\n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n        System.out.println(new PruebasTesis().contatras(10));\n    }\n}\n")
        self.mc.guardar()
        self.assertTrue(os.path.exists(os.path.join(settings.RUTA_METACODIGO, str(0), fecha, "meta" + str(self.mc.idAlumno) + '.mc')))

    def test_constructorLleno(self): ## Detección de vicios (archivos sin cerrar)
        mc2 = MetaCodigo(0,0,0)
        self.assertTrue(mc2.getExt() == 'java')
    

if __name__ == "__main__":
    unittest.main()