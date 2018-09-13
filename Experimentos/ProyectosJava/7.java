import almacen.AlmacenJaula;
import java.util.*;
import java.util.*;
import Animales.Jaula;
import java.util.*;
import almacen.AlmacenJaula;


public class Zoo {
    public static int regresarMenu() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("---el zoologico----");
    System.out.println("");
    System.out.println("1 Agregar jaula");
    System.out.println("2 Agregar animal en jaula");
    System.out.println("3 Ver jaula");
    System.out.println("4 salir del programa");
    System.out.println("");
    System.out.print("Elija una opccion ");
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
    System.out.println("Se a registró la jaula");
    }
    
    public static void opcion2() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Numero de jaula");
    String numj = sc.nextLine();
    int tamano;
    Jaula jaula = AlmacenJaula.recuperarJaula(numj);
    if (jaula == null) {
      System.out.println("la jaula no aparece");
      System.out.println("la jaula no se a almacenado");
      return;
    }
      System.out.println("los animales disponibles son los sigientes");
      System.out.println("1-------chita");
      System.out.println("2-------Conejo");
      System.out.println("3-------elefante");
      System.out.println("4-------leon");
      System.out.println("5-------puma");
      System.out.println("6-------venado");
      int selec = sc.nextInt();
      switch (selec){
case 1: System.out.println("Tamaño del animal "); tamano = sc.nextInt();
Chita chita = new Chita(tamano);
jaula.registrarAnimal(chita);
break;
case 2: System.out.println("Tamaño del animal "); tamano = sc.nextInt(); 
Conejo conejo = new Conejo(tamano);
jaula.registrarAnimal(conejo);
break;           
case 3: System.out.println("Tamaño del animal "); tamano = sc.nextInt(); 
Elefante elefante = new Elefante(tamano);
jaula.registrarAnimal(elefante);
break;           
case 4: System.out.println("Tamaño del animal "); tamano = sc.nextInt(); 
Puma leon = new Puma(tamano);
jaula.registrarAnimal(leon);
break;          
case 5: System.out.println("Tamaño del animal "); tamano = sc.nextInt(); 
Puma puma = new Puma(tamano);
jaula.registrarAnimal(puma);
break;           
case 6: System.out.println("Tamaño del animal "); tamano = sc.nextInt(); 
Venado venado = new Venado(tamano);
jaula.registrarAnimal(venado);
break;
      }
     
    }
    
    public static void opcion3() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Numero de jaula ");
    String njaula = sc.nextLine();
    Jaula jaula = AlmacenJaula.recuperarJaula(njaula);
    if (jaula == null) {
      System.out.println("La jaula no aparece ");
      return;
    }
    System.out.println(jaula.verJaula());
  }
    
    public static void main(String[] args) {
 
    int opcion = Zoo.regresarMenu();
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
 
      opcion = Zoo.regresarMenu();
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



public abstract class Carnivoro extends Animal{
    
}



class Chita extends Carnivoro{
    private final int tamano;
    
    public Chita(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "chita:---CHIRPCHIRPCHRIP";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class Conejo extends Herbivoro{
    private final int tamano;
    
    public Conejo(int tamano){
        this.tamano = tamano;
    }
    
    @Override 
    public String emitirSonido(){
        return "conejo:---Soy un cocodrilo";
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
        return "elefante:---EEEEEEEEEEEEEEWWWWWWWWWWW!!!!!﻿";
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
    
    public boolean registrarAnimal(Animal animal) { // <---- Aqui esta
        Jaula jaulatam = new Jaula(numJaula, capacidad);
        if (this.animales.size() == 0 && animal.getTamano() <= jaulatam.getCapacidad()) { 
            this.animales.add(animal);
            return true;
        }else{
            System.out.println("Error el animal no cabe.");
        }
    
        Animal primerAnimal = this.animales.get(0);
        
        if (primerAnimal instanceof Herbivoro) { 
            if (animal instanceof Herbivoro && animal.getTamano() <= jaulatam.getCapacidad()) {
                this.animales.add(animal);
                return true;
            } else if (animal instanceof Carnivoro ) {
                return false;
            }
        } else if (primerAnimal instanceof Carnivoro ) {
            if (animal instanceof Herbivoro) {
                return false;
            }
            if (primerAnimal.getClass() == animal.getClass() && animal.getTamano() <= jaulatam.getCapacidad()) {
                this.animales.add(animal);
                 return true;
            }
        }
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




class Leon extends Carnivoro{
    private final int tamano;
    
    public Leon(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "leon:---¡RUAAAAAAAAAGHHH!";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class Puma extends Carnivoro{
    private final int tamano;
    
    public Puma(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "puma:---¡wuuuuuuaaaaaa!";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}



class Venado extends Herbivoro{
    private final int tamano;
    
    public Venado(int tamano){
        this.tamano = tamano;
    }
    
    @Override
    public String emitirSonido(){
        return "venado:---Bee bee,uff uff﻿";
    }
    
    public int getTamano(){
        return this.tamano;
    }
}
