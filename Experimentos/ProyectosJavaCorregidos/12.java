import dominio.Jaula;
import dominio.Mamut;
import dominio.Oso;
import dominio.OsoPerezoso;
import dominio.Tigre;
import dominio.Triceraptops;
import dominio.Tyranosaurio;
import java.util.Scanner;
import persistencia.AlmacenJaula;
import dominio.Animal;
import java.util.ArrayList;
import dominio.Jaula;
import java.util.ArrayList;
import interfazusuario.MainConsola;
import java.util.ArrayList;
import persistencia.AlmacenJaula;



public class MainConsola {
    
    
      private static int sum1, sum2, sum3, sum4, sum5, sum6;   
      public static int regresarMenu(){   
      
      
        System.out.println("***************************************************");
        System.out.println("********Sistema de control del Zoologico***********");
        System.out.println("***************************************************");
        System.out.println("");
        System.out.println("1)Agregar una jaula: ");
        System.out.println("2)Agregar un animal a la jaula: ");
        System.out.println("3)Ver animales en cada jaula: ");
        System.out.println("4)Salir del sistema: ");
        System.out.println("");
        System.out.println("Elegir opcion: ");
        
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return respuesta;
      
      }
      
      public static void opcion1(){
          Scanner sc = new Scanner(System.in);
          System.out.println("Escribir datos de la jaula: ");
          System.out.println("Escribir numero de la jaula");
          String numJaula = sc.nextLine();
          System.out.println("Escribir la capacidad de la jaula: ");
          int capacidad = sc.nextInt();
          
          Jaula nuevo = new Jaula(numJaula, capacidad);
          nuevo.registrar();
          System.out.println("\n Se ha registrado una nueva jaula \n");
          
          
      }
      
      public static void opcion2(){
          Scanner sc = new Scanner(System.in);
          System.out.println("Numero de jaula: ");
          String numJaula = sc.nextLine();
          Jaula jaula = AlmacenJaula.recuperarJaula(numJaula);
          int i;
          if(jaula == null){
              System.out.println("No se ha encontrado la jaula ");
              System.out.println("No se ve bien ");
              return;
          }//se ve mal
          
              
          /*System.out.println("Registrar un nuevo animal a la jaula: ");
          String seguir = sc.nextLine();
          seguir = "si";
          while(seguir.equals("si")){ */
              
                    
                        Scanner nr = new Scanner(System.in);
                        System.out.println("1)Mamut: ");
                        System.out.println("2)Oso: ");
                        System.out.println("3)Oso perezoso: ");
                        System.out.println("4)Tigre: ");
                        System.out.println("5)Triceratops: ");
                        System.out.println("6)Tyranosaurio: ");
                        System.out.println("Escoge el animal que quieres registrar: ");
                        System.out.println("");
                        int escoger = nr.nextInt();
                        switch (escoger){
                        
                            case 1:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            int espOcupa = nr.nextInt();
                            sum1 += espOcupa;
                            if(sum1 > jaula.getCapacidad()){
                                System.out.println("No se pudo guardar el animal ");
                            }
                            else{
                            Mamut mamut = new Mamut(espOcupa);
                            jaula.registrarAnimal(mamut);
                            System.out.println("Se ha agregado un mamut a la jaula :");
                            }
                            break;
                            case 2:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            espOcupa = nr.nextInt();
                            sum2 += espOcupa;
                            if(sum2 > jaula.getCapacidad()){
                                System.out.println("No se pudo agregar animal ");
                            }
                            else{
                            Oso oso = new Oso(espOcupa);
                            jaula.registrarAnimal(oso);
                            System.out.println("Se ha agregado un oso a la jaula :");
                            }
                            break;
                            case 3:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            espOcupa = nr.nextInt();
                            sum3 += espOcupa;
                            if(sum3 > jaula.getCapacidad()){
                                System.out.println("No se pudo agregar el animal ");
                            }
                            else{
                            OsoPerezoso osoPerezoso = new OsoPerezoso(espOcupa);
                            jaula.registrarAnimal(osoPerezoso);
                            System.out.println("Se ha agregado un oso perezoso a la jaula :");
                            }
                        break;
                            case 4:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            espOcupa = nr.nextInt();
                            sum4 += espOcupa;
                            if(sum4 > jaula.getCapacidad()){
                                System.out.println("No se pudo agregar animal, ");
                            }
                            else{
                            Tigre tigre = new Tigre(espOcupa);
                            jaula.registrarAnimal(tigre);
                            System.out.println("Se ha agregado un tigre a la jaula :");
                            }
                        break;
                            case 5:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            espOcupa = nr.nextInt();
                            sum5 += espOcupa;
                            if(sum5 > jaula.getCapacidad()){
                                System.out.println("No se pudo agregar el animal ");
                            }
                            else{
                            Triceraptops triceratops = new Triceraptops(espOcupa);
                            jaula.registrarAnimal(triceratops);
                            System.out.println("Se ha agregado un triceratops a la jaula :");
                            }
                        break;
                            case 6:
                            System.out.println("¿Cuanto espacio ocupa: ");
                            espOcupa = nr.nextInt();
                            sum6 += espOcupa;
                            if(sum6 > jaula.getCapacidad()){
                                System.out.println("No se pudo agregar el animal ");
                            }
                            else{
                            Tyranosaurio tyranosaurio = new Tyranosaurio(espOcupa);
                            jaula.registrarAnimal(tyranosaurio);
                            System.out.println("Se ha agregado un tyranosaurio a la jaula :");
                            }
                            break;
                        
}
                        
                    
                        
                    
                
                   
                    
                    
                    
                  
          //} 
    }  
             //componer
//} 
          
      
      
      public static void opcion3(){
          Scanner sc = new Scanner (System.in);
          System.out.println("Ver detalles de la jaula \n");
          String numJaula = sc.nextLine();
          Jaula jaula = AlmacenJaula.recuperarJaula(numJaula);
          if (jaula == null){
              System.out.println("No se ha encontrado la jaula ");
              return;
          }
         
        System.out.println(jaula.verJaula());
        
      }
    /*public static int menuOpcion(){
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
    } */
      
    public static void main(String[] args){  
       
        
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






public abstract class Animal {
    
    protected int espOcupa;
    
    
    public Animal(int espOcupa){
        this.espOcupa = espOcupa;
    }
    
    public int getEspOcupa(){
        return this.espOcupa;
    }
    
    
    public abstract String emitirSonido();
    
    
    public abstract String verInfoAnimal();
}




public abstract class Carnivoro extends Animal{
    public Carnivoro(int espOcupa) {
        super(espOcupa);
    }
    
    
    
}




public abstract class Herbivoro extends Animal{

    public Herbivoro(int espOcupa) {
        super(espOcupa);
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
        System.out.println("Numero de jaula: " + this.numJaula + "\n");
        System.out.println("Capacidad: " + this.capacidad + "\n");
        
        System.out.println("Animales:\n" );
        for (int i = 0; i < this.animales.size(); i++){
             ser += "" + this.animales.get(i).emitirSonido();
             
             
        }
        return ser;
    }
    
    public boolean registrarAnimal(Animal animal){
        Jaula jaulatam = new Jaula(numJaula, capacidad);
        
        if(this.animales.size() == 0 || animal.getEspOcupa() <= jaulatam.getCapacidad()){
            this.animales.add(animal);
            return true;
        }
        /*else{
            System.out.println("El animal no pudo registrarse \n");
            int opcion = MainConsola.regresarMenu();
            while (opcion != 4){
                switch (opcion){
                    case 1:
                        MainConsola.opcion1();
                        break;
                    case 2:
                        MainConsola.opcion2();
                        break;
                    case 3:
                        MainConsola.opcion3();
                        break;
                    
                    default:
                    break;
                }
                opcion = MainConsola.regresarMenu();
            }
        }*/
        
    
        Animal primerAnimal = this.animales.get(0);
        
        if (primerAnimal instanceof Herbivoro){
            if (animal instanceof Herbivoro && animal.getEspOcupa() <= jaulatam.getCapacidad()){
                this.animales.add(animal);
                return true;
            }
            else if (animal instanceof Carnivoro){
                System.out.println("Error en la jaula :( ");
                return false;
            }
            else if (primerAnimal instanceof Carnivoro){
                if (animal instanceof Herbivoro ){
                    System.out.print("Error en la jaula ");
                    return false;
                }
                if (primerAnimal.getClass() == animal.getClass() && animal.getEspOcupa() <= jaulatam.getCapacidad()){
                    this.animales.add(animal);
                    return true;
                }
            }
        }
        System.out.println("Error el animal no se pudo registrar ");
        return false;
    }
    
    
    public void registrar(){
        AlmacenJaula.almacenarJaula(this);
    }
}




class Mamut extends Herbivoro{
    private final int espOcupa;

    public Mamut(int espOcupa) {
        super(espOcupa);
        this.espOcupa = espOcupa;
    }
    
    
   

    @Override
    public String verInfoAnimal() {
        return "Informacion del animal: " + "" + this.espOcupa;
    }
    
    @Override
    public String emitirSonido(){
        return "soy un mamut, somebody? ";
    }
    
}




class Oso extends Carnivoro{
    private final int espOcupa;

    public Oso(int espOcupa) {
        super(espOcupa);
        this.espOcupa = espOcupa;
    }
    
      
    @Override
    public String verInfoAnimal(){
        return "Informacion del animal: " + this.espOcupa;
    }
    
    @Override
    public String emitirSonido(){
        return "Spring air ";
    }
    
}




class OsoPerezoso extends Herbivoro{
    private final int espOcupa; 
    

    public OsoPerezoso(int espOcupa) {
        super(espOcupa);
        this.espOcupa = espOcupa;
        
    }

    @Override
    public String verInfoAnimal() {
        return "Informcion del animal" + "" + this.espOcupa;
    }
    
    @Override
    public String emitirSonido(){
        return "3/10 ";
    }
    
}




class Tigre extends Carnivoro{
    private final int espOcupa;
       
       
       
       public Tigre(int espOcupa){
           super(espOcupa);
           this.espOcupa = espOcupa;
           
       } 

    @Override
    public String verInfoAnimal() {
        return "Informacion del animal: " + "" + this.espOcupa;
    }

    @Override
    public String emitirSonido() {
        return "Hara un tigre de ti ";
    }
    
}




class Triceraptops extends Herbivoro{
    private final int espOcupa;

    public Triceraptops(int espOcupa) {
        super(espOcupa);
        this.espOcupa = espOcupa;
    }

    @Override
    public String verInfoAnimal() {
        return "Informacion del animal: " + "" + this.espOcupa; 
    }

    @Override
    public String emitirSonido() {
        return "Escriban, dos puntos y a parte, teorema de Bayes ";
    }
    
}




class Tyranosaurio extends Carnivoro{
    private final int espOcupa;
    

    public Tyranosaurio(int espOcupa) {
        super(espOcupa);
        this.espOcupa = espOcupa;
        
    }

    @Override
    public String verInfoAnimal() {
        return "Informacion del animal: " + "" + this.espOcupa;
    }

    @Override
    public String emitirSonido() {
        return "RUARGGGGGGGGGGG!";
        }
    
}
