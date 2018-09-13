import almacen.AlmacenJaula;
import java.util.*;
import java.util.*;
import zoologico.Jaula;
import zoologico.Animal;
import java.util.*;
import almacen.AlmacenJaula;
import static zoologico.Zoologico.opcion1;
import static zoologico.Zoologico.opcion2;
import static zoologico.Zoologico.opcion3;


public class Zoologico {
    private static int suma1,suma2,suma3,suma4,suma5,suma6;
    public static int regresarMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println("******************************************");
    System.out.println("---Administracion de un zoolgico----");
    System.out.println("******************************************");
    System.out.println("");
    System.out.println("Menú de opciones:");
    System.out.println("1) Agregar jaula.");
    System.out.println("2) Agregar animal en jaula.");
    System.out.println("3) Ver jaula.");
    System.out.println("4) Salir del sistema");
    System.out.println("");
    System.out.print("Elije una opción: ");
    int respuesta = sc.nextInt();
    return respuesta;
    }
    
    public static void opcion1() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Numero de jaula: ");
    String numJaula = sc.nextLine();
    System.out.println("Capacidad: ");
    int capacidad = sc.nextInt();
    Jaula nueva = new Jaula(numJaula, capacidad);
    nueva.registrar();
    System.out.println("\nSe registró la jaula");
    }
    
    public static void opcion2() { 
    Scanner sc = new Scanner(System.in);
    System.out.println("Numero de jaula:");
    String numj = sc.nextLine();
    int tamano;
    Jaula jaula = AlmacenJaula.recuperarJaula(numj);
    if (jaula == null) {
      System.out.println("Error: no se encontró la jaula");
      System.out.println("No se almacenó nada");
      return;
    }
      System.out.println("***Animales***");
      System.out.println("1) Leon.");
      System.out.println("2) Cocodrilo.");
      System.out.println("3) Buho.");
      System.out.println("4) Elefante.");
      System.out.println("5) Jirafa.");
      System.out.println("6) Koala.");
      System.out.println("Seleccione al animal: ");
      int selec = sc.nextInt();
      switch (selec){
            case 1: System.out.println("Tamaño del animal: "); tamano = sc.nextInt();
                 suma1 += tamano;
                 if(suma1 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma1 = 0;
                 }else{
                 Leon leon = new Leon(tamano);
                 jaula.registrarAnimal(leon);
                 }
                 break;
            case 2: System.out.println("Tamaño del animal: "); tamano = sc.nextInt(); 
                 suma2 += tamano;
                 if(suma2 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma2 = 0;
                 }else{
                 Cocodrilo cocodrilo = new Cocodrilo(tamano);
                 jaula.registrarAnimal(cocodrilo);
                 }
                 break;           
            case 3: System.out.println("Tamaño del animal: "); tamano = sc.nextInt();
                 suma3 += tamano;
                 if(suma3 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma3 = 0;
                 }else{
                 Buho buho = new Buho(tamano);
                 jaula.registrarAnimal(buho);
                 }
                 break;           
            case 4: System.out.println("Tamaño del animal: "); tamano = sc.nextInt(); 
                 suma4 += tamano;
                 if(suma4 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma4 = 0;
                 }else{
                 Elefante elefante = new Elefante(tamano);
                 jaula.registrarAnimal(elefante);
                 }
                 break;          
            case 5: System.out.println("Tamaño del animal: "); tamano = sc.nextInt(); 
                 suma5 += tamano;
                 if(suma5 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma5 = 0;
                 }else{
                 Jirafa jirafa = new Jirafa(tamano);
                 jaula.registrarAnimal(jirafa);
                 }
                 break;           
            case 6: System.out.println("Tamaño del animal: "); tamano = sc.nextInt(); 
                 suma6 += tamano;
                 if(suma6 > jaula.getCapacidad()){
                     System.out.println("Error, No se puede guardar al animal");
                     suma6 = 0;
                 }else{
                 Koala koala = new Koala(tamano);
                 jaula.registrarAnimal(koala);
                 }
                 break;
            
      }
      System.out.println("Si desea verificar el registro del animal seleccion la opcion 3.");
      
    }
    
    public static void opcion3() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Numero de jaula: ");
    String njaula = sc.nextLine();
    Jaula jaula = AlmacenJaula.recuperarJaula(njaula);
    if (jaula == null) {
      System.out.println("Error: no se encontró la jaula.");
      return;
    }
    System.out.println(jaula.verJaula());
  }
    
    public static void main(String[] args) {
 
    int opcion = Zoologico.regresarMenu();
    while (opcion != 4) {
 
      switch (opcion) {
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
 
      opcion = Zoologico.regresarMenu();
    }
  }
   
}



class AlmacenJaula {
    private static ArrayList<Jaula> jaula = new ArrayList<Jaula>();
    
    public static void almacenarJaula(Jaula jaula) {
        AlmacenJaula.jaula.add(jaula);
    }
    
    public static Jaula recuperarJaula(String numJaula) {
        for (int i = 0; i < AlmacenJaula.jaula.size(); i++) {
            Jaula actual = AlmacenJaula.jaula.get(i);
            if (actual.getNumJaula().equals(numJaula)) {
                return actual;
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



class Buho extends Carnivoro{
    private final int tamano;
    
    public Buho(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "Soy un buho";
    }
    @Override
    public int getTamano(){
        return this.tamano;
    }
}



public abstract class Carnivoro extends Animal{
    
}



class Cocodrilo extends Carnivoro{
    private final int tamano;
    
    public Cocodrilo(int tamano){
        this.tamano = tamano;
    }
    
    @Override 
    public String emitirSonido(){
        return "Soy un cocodrilo";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}




class Elefante extends Herbivoro{
    private final int tamano;
    
    public Elefante(int tamano){
        this.tamano = tamano;
    }
    
    @Override 
    public String emitirSonido(){
        return "Soy un elefante";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}




public abstract class Herbivoro extends Animal{
    
}



class Jaula {
    private final String numJaula;
    private final int capacidad;
    private final ArrayList<Animal> animales = new ArrayList<Animal>();
    
    public Jaula(String numJaula, int capacidad){
        this.numJaula = numJaula;
        this.capacidad = capacidad;
        
    }
    
    
    public boolean registrarAnimal(Animal animal) { 
        Jaula jaulatam = new Jaula(numJaula, capacidad);
        if (this.animales.size() == 0 && animal.getTamano() <= jaulatam.getCapacidad()) {
            
            this.animales.add(animal);
            return true;
        }
        
        Animal primerAnimal = this.animales.get(0);
        if (primerAnimal instanceof Herbivoro) { 
            if (animal instanceof Herbivoro && animal.getTamano() <= jaulatam.getCapacidad()) {
                this.animales.add(animal);
                return true;
            } else if (animal instanceof Carnivoro ) {
                System.out.println("Error el animal no pudo ser registrado.");
                return false;
            }
        } else if (primerAnimal instanceof Carnivoro ) {
            if (animal instanceof Herbivoro) {
                System.out.println("Error el animal no pudo ser registrado.");
                return false;
            }
            if (primerAnimal.getClass() == animal.getClass() && animal.getTamano() <= jaulatam.getCapacidad()) {
                this.animales.add(animal);
                 return true;
            }
        }
       System.out.println("Error el animal no pudo ser registrado.");
       return false;
    }
    
    public String verJaula() {
    String res = "";
    System.out.println(" ");
    System.out.println("**Contenido de la jaula** ");
    res += "Numero de jaula: " + this.numJaula + "\n";
    res += "Capacidad: " + this.capacidad + "\n";
    res += "Animales:\n";
    for (int i = 0; i < this.animales.size(); i++) {
      res += "   " + this.animales.get(i).emitirSonido()+ "\n";
    }
    return res;
    }
    
    public String getNumJaula(){
        return this.numJaula;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    public void registrar(){
        AlmacenJaula.almacenarJaula(this);
    }
    public ArrayList<Animal> getAnimal(){
        return this.animales;
    }
}




class Jirafa extends Herbivoro{
    private final int tamano;
    
    public Jirafa(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "Soy una jirafa";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class Koala extends Herbivoro{
    private final int tamano;
    
    public Koala(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "Soy un koala";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class Leon extends Carnivoro{
    private final int tamano;
    
    public Leon(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "Soy un leon!";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}
