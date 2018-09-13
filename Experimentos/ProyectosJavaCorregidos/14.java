import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;

public class Zoologico {

    public static void main(String[] args) {
        int opc, opc2;
        do{
            System.out.println("***** M E N U *****");
            System.out.println("1) Agregar una jaula.");
            System.out.println("2) Aregar un animal a una jaula.");
            System.out.println("3) Ver animales en cada jaula.");
            System.out.println("4) Salir.");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    System.out.println("Ingrse el numero de jaula.");
                    int numerojaula = sc.nextInt();
                    System.out.println("Ingrese la capacidad de la jaula.");
                    double capacidad = sc.nextDouble();
                    Jaula nueva = new AlmacenJaula.recuperarJaula(numerojaula);
                    nueva.registrarJaula(nueva);
                    System.out.println("\nSe registró el maestro satisfactoriamente");
                    break;
                case 2:
                    System.out.println("¿Que animal deseas agregar?");
                    do{
                        Tigre tigre1 = new Tigre();
                        Jaula jaula1 = new Jaula();
                        System.out.println("1) Tigre");
                        System.out.println(jaula1.agregarAnimal(tigre1));
                        System.out.println("2) Venado");
                        System.out.println("3) Regresar");
                        opc2 = sc.nextInt();
                        
                    }while(opc2!=3);
                    break;
                case 3:
                        System.out.println("¿Que jaula quieres ver?");
                        numerojaula = sc.nextInt();
                        Jaula idJaula = AlmacenJaula.recuperarJaula(numerojaula);
                        idJaula.verJaula();
                        if (idJaula == null) {
                        System.out.println("Error: no se encontró la jaula");
                        return;
                        }
                        
                    break;
            }
            
        }while(opc !=4);
    }
    
}


class AlmacenJaula {
     private static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();
     
     public static void almacenarJaula(Jaula jaulas){
         AlmacenJaula.jaulas.add(jaulas);
     }
     public static Jaula recuperarJaula(int numerojaula){
         for (int i = 0; i < AlmacenJaula.jaulas.size(); i++){
             Jaula act = AlmacenJaula.jaulas.get(i);
             if(act.getnumeroJaula() == numerojaula){
                 return act;
             }
         }
         return null;
     }
}



public abstract class Animal {
    public abstract String sonido();
}



public abstract class Carnivoro extends Animal{
    
}



public abstract class Herbivoro extends Animal {
    
}


   
class Jaula {

  private ArrayList<Animal> animales = new ArrayList<Animal>();
  private int numerojaula;
  private double capacidad;
  private ArrayList<Jaula> jaulas;
  
  public void registrarJaula(Jaula jaulas){
      this.jaulas.add(jaulas);
  }

  public int getnumeroJaula(){
      return this.numerojaula;
  }
  
  public void verJaula() {  
    for (int i = 0; i < this.animales.size(); i++) {
      Animal actual = this.animales.get(i);
      System.out.println(actual.sonido());
    }



  }

  public boolean agregarAnimal(Animal animal) {
    if (this.animales.size() == 0) { // jaula vacía
      this.animales.add(animal);
      return true;
    }

    // la jaula no está vacía
    Animal primerAnimal = this.animales.get(0);
    if (primerAnimal instanceof Herbivoro) {
      if (animal instanceof Herbivoro) { // no hay problema
        this.animales.add(animal);
        return true;
      } else if (animal instanceof Carnivoro) {
        return false;
      }
    } else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herbivoro) {
        return false;
      }

      if (primerAnimal.getClass() == animal.getClass()) {
        this.animales.add(animal);
        return true;
      }
    }

    return false;
  }

}





class Jirafa extends Herbivoro{
    @Override public String sonido(){
    return "el que sea";
    } 
}



class Leopardo extends Carnivoro{
        @Override public String sonido(){
        return "rugido";
    }
}



public abstract class Panda extends Animal {
    @Override public String sonido(){
        return "el que sea";
    } 
}



class Puma extends Carnivoro{
    @Override public String sonido(){
        return "rugido";
    }
}


//de carnivoro
class Tigre extends Carnivoro{
    @Override public String sonido(){
        return "rugido";
    }
}


//de herbivoro

class Venado extends Herbivoro{
    @Override public String sonido(){
        return "berrido";
    }    
    
   /* @Override public double espacio(){
        return 211.3;
    }*/
}
