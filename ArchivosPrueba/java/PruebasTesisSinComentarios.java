
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
}