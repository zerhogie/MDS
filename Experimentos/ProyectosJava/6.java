import java.util.Scanner;
import datos.Jaula;
import guardarDatos.guardarDatos;
import zoo.Animal;
import zoo.Carnivoro;
import zoo.Herviboro;
import datos.Jaula;
import java.util.ArrayList;
import zoo.Animal;
import datos.Jaula;
import java.util.ArrayList;
import zoo.Animal;
import java.util.ArrayList;
import guardarDatos.guardarDatos;
import zoo.Animal;
import zoo.Carnivoro;
import zoo.Herviboro;
import zoo.Leon;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
public class Zoo {

   
 
    public static int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("sistema de adminirtracion de un zoologico");
        System.out.println("elige una de estas opciones");

        System.out.println("1--agregar jaula");
        System.out.println("2--agregar un animal a una jaula");
        System.out.println("3--ver animales en la jaula");
        System.out.println("4--salir");
        
        
        int opc = sc.nextInt();
        return opc;
    }
   
    public static void opc1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("numero de jaula a agregar:");
       String numJaula = sc.nextLine();
       System.out.println("capacida que va a tener:");
       String capacidad =sc.nextLine();
       Jaula jaula = new Jaula(capacidad,numJaula);
       jaula.agregar();
       System.out.println("la jaula se agrego correctamnete");
       
    }
    
    public static void opc2(){
    Scanner sc = new Scanner(System.in);
    System.out.println("escriba el numero de la jaula");
    String numJaula = sc.nextLine();
    Jaula jaula = guardarDatos.tenerJaula(numJaula);
    
    if (jaula == null) {
      System.out.println("Error: no se encontró la jaula");
      System.out.println("No se almacenó nada");
      return;
    }
    String av="si";
    while (av.equals("si")) {
     // System.out.println("especie del animal 1 para carnivoro 2 para hervivoro:");
      //String especie= sc.nextLine();
      System.out.println("animal a elegir:");
      String especie = sc.nextLine();
      System.out.println("espacio que ocupa:");
      String espacio = sc.nextLine();
    
   //   System.out.println("sonido:");
     // String sonido = sc.nextLine();
      //System.out.println("espacio del animal:");
      //String espacio = sc.nextLine();
      
      
     // jaula.agregarCarnivoro(carnivoro);
      System.out.println("Se registró el animal satisfactoriamente");
      System.out.println("¿Quieres registrar otro animal?:");
      av = sc.nextLine().trim(); // trim es para quitar espacios en blanco
    }
    }
    
    public static void opc3(){
        Scanner sc = new Scanner(System.in);
    System.out.println("Numero de la jaula:");
    String numJaula = sc.nextLine();
    Jaula jaula = guardarDatos.tenerJaula(numJaula);
    if (jaula == null) {
      System.out.println("Error: no se encontró la jaula");
      return;
    }
    System.out.println(jaula.verJaula());
  }
    
    
    public static void opc4(){
        System.out.println("usted esta saliendo");
        System.exit(0);
       // System.out.println("usted esta saliendo");
    }
    public static void main(String[] args) {
       int opc = Zoo.Menu();
       while(opc!=4){
           switch (opc){
               case 1:
                   opc1();
                   break;
               case 2:
                   opc2();
                   break;
               case 3:
                   opc3();
                   break;
               case 4:
                   System.out.println("usted esta saliendo");
                   opc4();
                   
                   break;
                   
               default:
                   System.out.println("esa opcion no existe");
                   break;
           }
           opc = Zoo.Menu();
       }
        
        
    }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
public  abstract class Animal {
    protected  float espacio;
  //  protected String especie;
     
    //public Animal(String espacio){
       // this.espacio=espacio;
       // this.especie=especie;
  //  }
    public abstract String sonido();
        /*
     public Animal(float espacio){
         this.espacio=espacio;
     }   
    */
   public float getEspacio(){
   return this.espacio;
   }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
public  abstract class Carnivoro extends Animal {
/*
    private String sonido;
    public Carnivoro(String espacio, String especie){
        super(espacio,especie);
    }
    
    
    @Override
    public String sonido(){
        return "espacio" + this.espacio + this.sonido;
    }

/*
    private String sonido;
    public Carnivoro(String espacio, String especie){
        super(espacio,especie);
    }
    
    
    @Override
    public String sonido(){
        return "espacio" + this.espacio + this.sonido;
    }
*/

    //public Carnivoro(String espacio) {
      //  super(espacio);
    //}
/*
    private String sonido;
    public Carnivoro(String espacio, String especie){
        super(espacio,especie);
    }
    
    
    @Override
    public String sonido(){
        return "espacio" + this.espacio + this.sonido;
    }

/*
    private String sonido;
    public Carnivoro(String espacio, String especie){
        super(espacio,especie);
    }
    
    
    @Override
    public String sonido(){
        return "espacio" + this.espacio + this.sonido;
    }
*/
     
}

/*


class DatosAnim {
     private static ArrayList<Animal> animal = new ArrayList<Animal>();
    
    public static void guardaAnim(Animal animal){
        DatosAnim.animal.add(animal);
    }
    
    public static Animal tenerAnimal(float espacio){
        for (int i = 0; i <DatosAnim.animal.size(); i++) {
      Animal actual = DatosAnim.animal.get(i);
      if (actual.getEspacio().equals(espacio)) {
        return actual;
      }
    }

    return null;
    }
}
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
class Elefante extends Herviboro{
     public Elefante(float espacio){
      this.espacio=60;   
     }
     
     public String sonido(){
         return "FIIIUUUUUU";
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josu
 */
class guardarDatos {
    private static ArrayList<Jaula> jaula = new ArrayList<Jaula>();
    
    public static void guardaDatos(Jaula jaula){
        guardarDatos.jaula.add(jaula);
    }
    
    public static Jaula tenerJaula(String numJaula){
        for (int i = 0; i < guardarDatos.jaula.size(); i++) {
      Jaula actual = guardarDatos.jaula.get(i);
      if (actual.getNumJaula().equals(numJaula)) {
        return actual;
      }
    }

    return null;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
public abstract class Herviboro extends Animal {
   
   /* public Herviboro(String espacio){
        super(espacio);
    }
    
    
    @Override
    public String sonido(){
        return "espacio" + this.espacio + this.sonido;
    }
*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josu
 */
class Jaula {

   
   
    private  String capacidad;
    private String numJaula;
    private ArrayList<Animal> animal = new ArrayList<Animal>();
    
    public Jaula(String capacidad, String numJaula){
        this.capacidad=capacidad;
        this.numJaula=numJaula;
    }
    
    public boolean agregarAnimal(Animal animal){
        //if(this.animal.size() == 0)  {     
           this.animal.add(animal);
        return true;
    }
         // la jaula no está vacía
    /*Animal primerAnimal = this.animal.get(0);
    if (primerAnimal instanceof Herviboro) {
      if (animal instanceof Herviboro) { // no hay problema
        this.animal.add(animal);
        return true;
      } else if (animal instanceof Carnivoro) {
        return false;
      }
    } else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herviboro) {
        return false;
      }

      if (primerAnimal.getClass() == animal.getClass()) {
        this.animal.add(animal);
        return true;
      }
    }
    return false;
    }
    */
    
     public String verJaula(){
         String mostrar= "";
         mostrar += "numero de jaula:"+ this.numJaula + "\n";
         mostrar +="capacidad de jaula:"+ this.capacidad +"\n" ;
        mostrar += "Animal:" + this.animal  +"\n";
    for (int i = 0; i < this.animal.size(); i++) {
      mostrar += "   " + this.animal.get(i).sonido() + "\n";
    }
      return mostrar;
     }
     
     
     //mostramos numero de jaula
     public String getNumJaula(){
         return this.numJaula;
     }
     // guardamos los datos de la jaula
     public void agregar(){
         guardarDatos.guardaDatos(this);
     }
    
   public ArrayList<Animal> getAnimal() {
   return this.animal;
 }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */

class Leon extends Carnivoro {

    public Leon(float espacio) {
       this.espacio = 30;
      
    }

    @Override
   public String sonido(){
        return "RUAGGGG!";
    }
   
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
class Lobo extends Carnivoro{
    public Lobo(float espacio){
        this.espacio=20;
    }
    
    @Override
    public String sonido(){
        return "AUUUUUUUUUUU!";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
class Oso extends Carnivoro {
     public Oso(float espacio){
         this.espacio=50;
     }
     
     @Override
     public String sonido(){
         return "GRUUUAUUU!!!";
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
class Rinoceronte extends Herviboro{
    public Rinoceronte(float espacio){
        this.espacio=40;
    }
     @Override
     public String sonido(){
         return "AAAGRRUU!!";
     }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josu
 */
class Vaca extends Herviboro {
    public Vaca(float espacio){
        this.espacio=35;
    }
    
    @Override
    public String sonido(){
        return "MUUUUUUU!";
    }
}
