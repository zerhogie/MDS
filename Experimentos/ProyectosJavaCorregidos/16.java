import dominio.Jaula;
import dominio.Puma;
import dominio.Panda;
import dominio.Cabra;
import dominio.Llena;
import dominio.Borrego;
import dominio.Leon;
import java.util.Scanner;
import persistencia.AlmacenJaula;
import dominio.Animal;
import java.util.ArrayList;
import interfazusuario.MainConsola;
import java.util.ArrayList;
import dominio.Jaula;
import java.util.ArrayList;
import persistencia.AlmacenJaula;


public class MainConsola {
  public static int regresarMenu(){
    System.out.println("**************************************************");
    System.out.println("**********Sistema de control del Zoologico********");
    System.out.println("**************************************************");
    System.out.println("");   
    System.out.println("1)Agregar una jaula:  ");
    System.out.println("2)Agregar un animal a la jaula:  ");
    System.out.println("3)Ver animales en cada jaula:  ");
    System.out.println("4)Salir del sistema:  ");
    System.out.println("Elegir pocion:  ");
    Scanner sc = new Scanner(System.in);
  }
  public static void opcion1(){
   Scanner sc = new Scanner(System.in);
   System.out.println("Escribe datos de la jaula: ");
   System.out.println("Escribe la capacidad de la jaula: ");   
   String numJaula = sc.nextLine();
   System.out.println("Escribe la capacidad de la jaula: ");  
   int capacidad = sc.nextInt();
   Jaula nuevo = new Jaula (numJaula, capacidad);
   nuevo.registrar();
   System.out.println("\n Se ha registrado una jaula nueva \n");
  }    
  public static void opcion2(){
    Scanner sc = new Scanner (System.in);
    System.out.println("Num. de jaula: ");
    String numJaula = sc.nextLine();
    Jaula jaula = AlmacenJaula.recuperarJaula(numJaula);
    int i;
    if (jaula == null){
       System.out.println("No se ha encontrago la jaula "); 
       System.out.println("No se ve bien"); 
       return;
    }
    System.out.println("Registrar nuevo animal en la jaula: "); 
    String seguir = sc.nextLine();
    segir = "si";
    while (seguir.equals("si")){
        Scanner nr = new Scanner(System.in);
        System.out.println("1)Puma: ");  
        System.out.println("2)Panda: ");  
        System.out.println("3)Cabra: ");  
        System.out.println("4)Llena: ");         
        System.out.println("5)Borrego: ");
        System.out.println("6)Leon: ");  
        System.out.println("Elige el animal que deseas registrar: ");  
        System.out.println("");  
        int elege = nr.nextInt();
        
        if (elige == 1){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Puma puma = new Puma(espaOcupa);
          jaula.registrarAnimal(puma);
          System.out.println("Se ha agregado un puma a la jaula ");
       }   
        if (elige == 2){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Panda panda = new Panda(espaOcupa);
          jaula.registrarAnimal(panda);
          System.out.println("Se ha agregado un panda a la jaula ");
       }   
        if (elige == 3){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Cabra cabra = new Cabra(espaOcupa);
          jaula.registrarAnimal(cabra);
          System.out.println("Se ha agregado una cabra a la jaula ");
       }     
        if (elige == 4){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Llena llena = new Llena(espaOcupa);
          jaula.registrarAnimal(llena);
          System.out.println("Se ha agregado una llena a la jaula ");
       }   
        if (elige == 5){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Borrego borrego = new Borrego(espaOcupa);
          jaula.registrarAnimal(borrego);
          System.out.println("Se ha agregado un borrego a la jaula ");
       }     
        if (elige == 6){
          System.out.println("¿Cuanto espacio ocupa?: "); 
          int espaOcupa = nr.nextInt();
          Leon leon = new Leon(espaOcupa);
          jaula.registrarAnimal(leon);
          System.out.println("Se ha agregado un leon a la jaula ");
       }   
   }
}
  public static void opcion3(){
    Scanner sc = new Scanner (System.in);
    System.out.println("Ver detalles de la jaula : ");
    String numJaula = sc.nextLine();
    Jaula jaula = AlmacenJaula.recuperarJaula(numJaula);
    if (jaula == null){
       System.out.println("No se ha encontrago la jaula "); 
       return;
    }  
    System.out.println(jaula.verJaula());
}
    public static int menuOpcion(){
        int opcion = MainConsola.regresarMenu();
        while (opcion != 4){
            
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
            opcion = MainConsola.regresarMenu();
         } 
        return MainConsola.regresarMenu();
    }
      
    public static void main(String[] args){  
        MainConsola.menuOpcion();
        
        /*int opcion = MainConsola.regresarMenu();
        while (opcion != 4){
            
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
            opcion = MainConsola.regresarMenu();
         }       */
        }
        
    }



class AlmacenAnimal {
    
    public static ArrayList<Animal> animal = new ArrayList<Animal>();
    
    public static void almacenarAnimal(Animal animal){
        AlmacenAnimal.animal.add(animal);
    }
    
    public static Animal recuperarAnimal(String clasificacion){
        
        for(int i = 0; i < AlmacenAnimal.animal.size(); i++){
            Animal actual = AlmacenAnimal.animal.get(i);
            
        }
        
        
        return null;
    }    
    
    
}



class Cabra extends Herbivoro {
  private final int espaOcupa;
  public Cabra(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido() {
    return "berrrrr";
  }
 
}


class Borrego extends Herbivoro{
  private final int espaOcupa;
  public Borrego(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido(){
   return "beeeeee";
  }
}


public abstract class Carnivoro extends Animal{
  public Carnivoro( int espaOcupa){
     super(espaOcupa);
  }
}

 
class Jaula {
 
  private ArrayList<Animal> animales = new ArrayList<Animal>();
  private int capacidad;
  private String numJaula;
 
  public Jaula(String numJaula, int capacidad) {
    this.numJaula = numJaula;
    this.capacidad = capacidad;
    }
  public String getNumJaula(){
    return numJaula;
  }
  public int getCapacidad(){
    return this.capacidad;
  }
 public String verJaula(){
   String ser = "";
   System.out.println("El numero de jaula es: "+ this.numJaula +"\n");
   System.out.println("Con capacidad de: " + this.capacidad + "\n");
   
   System.out.println("Animal animal");
   for(int i =0;i<this.animales.size(); i++){
     ser+= "" + this.animales.get(i).emiteSonido();
   }
   return ser;
  }
 
  public boolean agregarAnimal(Animal animal) {
    Jaula jaulatama = new Jaula(numJaula, capacidad);
    if (this.animales.size() == 0 || animal.getEspaOcupa() <= jaulatama.getCapacidad()) {
      this.animales.add(animal);
      return true;
    }
    /*else{
       System.out.println("No se puede registral el animal \n");
       int opcion = MainConsola.regresarMenu();
       while (opcion !=4){
         switch (opcion){
           case 1: 
              MainConsola.opcion1();
              break;
          case 2:
              MainConsola.opcion2();
              break;
          case 3:
              MinConsola.opcion3();}
              break;
          default;
          break;
        }
        opcion = MainConsola.regresarMenu();
      }
    }*/
    else{
       MainConsola.menuOpcion();
    }
    Animal primerAnimal = this.animales.get(0);
    if (primerAnimal instanceof Herbivoro) {
      if (animal instanceof Herbivoro && animal.getEspaOcupa() <= jaulatama.getCapacidad()) { 
        this.animales.add(animal);
        return true;
      } 
      else if (animal instanceof Carnivoro) {
        System.out.println.add("Error en la jaula ");
        return false;
      }
      else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herbivoro) {
        System.out.print("Error en la jaula ");
        return false;
      }
 
      if (primerAnimal.getClass() == animal.getClass() && animal.getEspaOcupa() <= jaulatama.getCapacidad()) {
        this.animales.add(animal);
        return true;
      }
    }
   }
    System.out.println("El animal no se pudo registrar ");
    return false;
  }
  public void registrar(){
    AlmacenJaula.almacenarJaula(this);
 
  }
 
}


class Puma extends Carnivoro {
  private final int espaOcupa;
  public Puma(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido() {
    return "grrrrrrr";
  }
} 




class AlmacenJaula {
    
    public static ArrayList<Jaula> jaula = new ArrayList<Jaula>();
    
    public static void almacenarJaula(Jaula jaula){
        AlmacenJaula.jaula.add(jaula);     
        
    }


    public static Jaula recuperarJaula(String numJaula) {
        for (int i=0; i < AlmacenJaula.jaula.size(); i++){
            Jaula actual = AlmacenJaula.jaula.get(i);
            if (actual.getNumJaula().equals(numJaula)){
               return actual;
            }
        }
        
        
        return null;
    }
    
}


class Llena extends Carnivoro {
  private final int espaOcupa;
  public Llena(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido() {
    return "niiiaaa";
  }
} 



public abstract class Herbivoro extends Animal {
   public Herbivoro( int espaOcupa){
     super(espaOcupa);
  }
}


class Leon extends Carnivoro {
  private final int espaOcupa;
  public Leon(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido() {
    return "grrrrrrr";
  }
} 



class Panda extends Herbivoro{
  private final int espaOcupa;
  public Panda(int espaOcupa){
     super(espaOcupa);
     this.espaOcupa = espaOcupa;
  }
  public String verInformaAnimal(){
    return "La informacion del animal es: " + "" + this.espaOcupa;
  }
  public String emiteSonido() {
    return "aahaahaah";
  }
 
}

public abstract class Animal{
  protected int espaOcupa;
    public Animal(int espaOcupa){ 
      this.espaOcupa = espaOcupa;
  }
  public int getEspaOcupa(){
    return this.espaOcupa = espaOcupa;
  }
  public abstract String emiteSonido();
  public abstract String verInformaAnimal();
}
