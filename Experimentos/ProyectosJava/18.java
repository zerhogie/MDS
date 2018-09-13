import java.util.Scanner;
import Programacion.Leon;
import Java.AlmacenJaula;
import Programacion.Jirafa;
import Programacion.Elefante;
import Programacion.OsoPolar;
import Programacion.Pinguino;
import Programacion.Cebra;
import Programacion.Jaula;
import Programacion.Animal;
import java.util.ArrayList;
import Programacion.Jaula;
import Java.AlmacenJaula;
import java.util.ArrayList;

//import Java.AlmacenAnimal;


public class mainConsola {
    
    private static int suma1,suma2,suma3,suma4,suma5,suma6;
    public static int regresarMenu() {
     Scanner sc = new Scanner(System.in);
     System.out.println("**********************************");
     System.out.println("---Administracion de un zoologico---");
     System.out.println("***********************************");
     System.out.println("");
     System.out.println("Menu de opciones.");
     System.out.println("1) Agregar una jaula nueva.");
     System.out.println("2) Agregar un animal a una jaula.");
     System.out.println("3) Ver los animales que se encuentran en la jaula.");
     System.out.println("");
     System.out.print("Elije una opcion: ");
     int respuesta = sc.nextInt();
     return respuesta;
    }
    
    public static void opcion1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué numero de jaula es?");
        int noJaula = sc.nextInt();
        System.out.println("¿Qué capacidad tiene la jaula?");
        int capacidad = sc.nextInt();
        Jaula jaulas =  new Jaula(capacidad, noJaula);
        jaulas.registrar();
        System.out.println("Se ha registrado  la jaula");
        
            
    }
    
    public static void opcion2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿A qué jaula deseas agregar un animal?");
        int noJaula = sc.nextInt();
        int tamano;
        
        Jaula jaulas =  AlmacenJaula.recuperarJaulas(noJaula);
        if(jaulas == null){
            System.out.println("No se encontro la jaula que buscas.");
            return ;
        }
        
                System.out.println("Escoje un animal para agregar a la jaula.");
                System.out.println("1) León.");
                System.out.println("2) Oso polar.");
                System.out.println("3) Pinguino.");
                System.out.println("4) Jirafa.");
                System.out.println("5) Cebra.");
                System.out.println("6) Elefante.");
                System.out.println("Escoje una animal: ");
                System.out.println();
                int escoger = sc.nextInt();
                
                if(escoger == 1){
                    System.out.println("Has escogido un León.");
                    System.out.println("¿De qué tamaño es el león?");
                    tamano = sc.nextInt();                        
                    suma1 += tamano;
                    if(suma1 > jaulas.getCapacidad()){
                    System.out.println("Se ha sobrepasado la capacidad de la jaula.");
                    suma1 = 0;
                    }
                    else{ 
                    Leon leon = new Leon(tamano);
                    jaulas.agregarAnimal(leon);
                        System.out.println("Se ha registrado el animal a la jaula");
                    }              
                    }
                        if(escoger ==2){
                        System.out.println("Has escogido un Oso Polar");
                        System.out.println("¿De qué tamaño es el Oso Polar?");
                        tamano = sc.nextInt();
                        suma2 += tamano;
                        if(suma2 > jaulas.getCapacidad()){
                        System.out.println("Se ha sobrepasado la capacidad de la jaula.");
                        suma2 = 0;
                        }
                        else{
                        OsoPolar osopolar = new OsoPolar(tamano);
                        jaulas.agregarAnimal(osopolar);
                        System.out.println("Se ha registrado el animal a la jaula");
                        }
                        }
                            if(escoger ==3){
                            System.out.println("Has escogido un Pinguino");
                            System.out.println("¿De qué tamaño es el Pinguino?");
                            tamano = sc.nextInt();
                            suma3 += tamano;
                            if(suma3 > jaulas.getCapacidad()){
                            System.out.println("Se ha sobrepasado la capacidad de la jaula.");
                            suma3 = 0;
                            }
                            else{
                            Pinguino pinguino = new Pinguino(tamano);
                            jaulas.agregarAnimal(pinguino);
                            System.out.println("Se ha registrado el animal a la jaula");
                            }
                            }
                                if(escoger ==4){
                                System.out.println("Has escogido una Jirafa");
                                System.out.println("¿De qué tamaño es la Jirafa?");
                                tamano = sc.nextInt();
                                suma4 += tamano;
                                if(suma4 > jaulas.getCapacidad()){
                                System.out.println("Se ha sobrepasado la capacidad de la jaula.");
                                suma4 = 0;
                                }
                                else{
                                Jirafa jirafa = new Jirafa(tamano);
                                jaulas.agregarAnimal(jirafa);
                                System.out.println("Se ha registrado el animal a la jaula");
                                }
                                }
                                    if(escoger ==5){
                                    System.out.println("Has escogido una Cebra");
                                    System.out.println("¿De qué tamaño es la Cebra?");
                                    tamano = sc.nextInt();
                                    suma5 += tamano;
                                    if(suma5 > jaulas.getCapacidad()){
                                    System.out.println("Se ha sobrepasado la capacidad de la jaula.");
                                    suma5 = 0;
                                    }
                                    else{
                                    Cebra cebra = new Cebra(tamano);
                                    jaulas.agregarAnimal(cebra);
                                    System.out.println("Se ha registrado el animal a la jaula");
                                    }
                                    }
                                        if(escoger ==6){
                                        System.out.println("Has escogido un Elefante");
                                        System.out.println("¿De qué tamaño es el Elefante?");
                                        tamano = sc.nextInt();
                                        suma6 += tamano;
                                        if(suma6 > jaulas.getCapacidad()){
                                        System.out.println("Se ha sobrepasado la capacidad la capacidad de la jaula.");
                                        suma6 = 0;
                                        }
                                        else{
                                        Elefante elefante = new Elefante(tamano);
                                        jaulas.agregarAnimal(elefante);
                                        System.out.println("Se ha guardado el animal en la jaula");
                                        }
                                        }
                                            
    }
  
    public static void opcion3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De qué jaula deseas saber la información?");
        int noJaula = sc.nextInt();
        Jaula jaula = AlmacenJaula.recuperarJaulas(noJaula);
        System.out.println(jaula.verJaula());

    }
    

   
    public static void main(String[] args) {
     int opcion = mainConsola.regresarMenu();
     while (opcion !=0){
         switch (opcion){
             case 1:
                 opcion1();
                 break;
             case 2:
                 opcion2();
                 break;
             case 3:
                 opcion3();
                 break;
                 
             default:
                 break;
         }
         
         opcion = mainConsola.regresarMenu();
     
     }
           
    }
}




class AlmacenJaula {
    
    private static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();
    
        public static void almacenarJaulas(Jaula jaulas){
            AlmacenJaula.jaulas.add(jaulas);
        }
        
      
        
        
    public static Jaula recuperarJaulas(int noJaula){
        
    for (int i = 0; i < AlmacenJaula.jaulas.size(); i++) {
      Jaula ja = AlmacenJaula.jaulas.get(i);
      if (ja.getNoJaula() == noJaula){
          return ja;
      }
    }
    return null;

    }

    

  
}    




public abstract class Animal {
    private int tamano;
     public abstract String emitirSonido();
    
    
    public int getTamano(){
        return this.tamano;
               
    }       
}





public abstract class Carnivoro extends Animal {
    
    
    
}



class Cebra extends  Herbivoro {
    
    private int tamano;

    public Cebra(int tamano) {  
        
    }

    @Override
    public String emitirSonido() {
      return "Soy la cebra: pffff";
    }
    
    public int getTamano(){
    return this.tamano = tamano;
    }
    
}



class Elefante extends  Herbivoro {

    private int tamano;
    
    public Elefante(int tamano) {
       
    }

    @Override
    public String emitirSonido() {
      return "Elefante: guaaaaaaaaaaaaaaaaa";
        
    }
    
    public int getTamano(){
        return this.tamano = tamano;
    }
    
}




public abstract class Herbivoro extends Animal{
    

}




class Jaula {
    private int capacidad;
    private int noJaula;
    private final ArrayList<Animal> animales = new ArrayList<Animal>();
    
 public Jaula(int capacidad, int noJaula) {
    this.capacidad = capacidad;
    this.noJaula = noJaula;
   
 }
 
  public boolean agregarAnimal(Animal animal) {
      Jaula jaulacap = new Jaula(capacidad, noJaula);
    if (this.animales.size() == 0 && animal.getTamano() <= jaulacap.getCapacidad() ) {
        this.animales.add(animal);
      return true;
      
    }//else{
        
       // System.out.println("no cabe");
    //}
    
 
   
    Animal primerAnimal = this.animales.get(0);
    if (primerAnimal instanceof Herbivoro) {
        if(animal instanceof Herbivoro && animal.getTamano() <= jaulacap.getCapacidad() ) {
        this.animales.add(animal);
        return true;
      } else if (animal instanceof Carnivoro) {
        return false;
      }
    
    }else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herbivoro) {
        return false;
      }
 
    if (primerAnimal.getClass() == animal.getClass() && animal.getTamano() <= jaulacap.getCapacidad()) {
        this.animales.add(animal);
        return true;
      }
    }
    return false;
  }


 public String verJaula() {
 String palabra = "";
 System.out.println(" ");
 System.out.println("Información de la jaula: ");
 palabra += "Numero de jaula: " + this.noJaula + "\n";
 palabra += "Capacidad: " + this.capacidad + "\n";
 palabra += "Los animales son:\n";
    for (int i = 0; i < this.animales.size(); i++) {
        //if(this.animales.size() > this.capacidad){
          //  return "no se puede sobrepasar capacidad";
        //}
    //  Animal actual = this.animales.get(i);
      palabra += "      " + this.animales.get(i).emitirSonido()+ "\n";
    }
    return palabra;
 }   
 
 
 public int getNoJaula() {
      return this.noJaula;
 }
 
 public int getCapacidad(){
     return this.capacidad;
 }
 
 public void registrar() {
    AlmacenJaula.almacenarJaulas(this);
  }    
 public ArrayList<Animal> getAnimal(){
     return this.animales;
 }
 
 //public void recuperarJaula(){
   //  AlmacenJaula.recuperarJaulas(noJaula);
// }
 
 

}



class Jirafa extends  Herbivoro {

    private int tamano;
    
    
    public Jirafa(int tamano) {
        this.tamano = tamano;
              
    }

    @Override
    public String emitirSonido() {
        return "Jirafa: lalala";
    }
    
    public int getTamano(){
        return this.tamano = tamano;
    }
    
}



class Leon extends  Carnivoro {
    private int tamano;

    
    public Leon (int tamano) {
        this.tamano = tamano;   
       
    }

    @Override
    public String emitirSonido() {
        return "Soy un león: RUAAAAAGGGGGHHHHH!";       
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class OsoPolar extends  Animal {

    private int tamano;
    
    public OsoPolar(int tamano) {
        
    }

    @Override
    public String emitirSonido() {
        return "Oso polar: grssssss";
        
    }
    
    public int getTamano(){
        return this.tamano = tamano;
    }
}



class Pinguino extends  Animal {

    private int tamano;
    
    public Pinguino(int tamano) {
 
    }

    @Override
    public String emitirSonido() {
        return "Pinguino: Soy Skipper ";
        
    }
    
    public int getTamano(){
        return this.tamano = tamano;
    }
    
}

