/*
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
}