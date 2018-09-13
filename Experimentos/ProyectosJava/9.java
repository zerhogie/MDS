import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;

public class mainConsola{
    public static int regresarMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Los animalitos :v");
		System.out.println("Opciones");
		System.out.println("1 Registrar Animales carnivoros");
		System.out.println("2 Registrar Animales Herviboros");
		System.out.println("3 Ver animales Herviboros");
		System.out.println("4 Ver animales carnivoros");

		int respuesta = sc.nextInt();
   		return respuesta;
	}
    
    	public static void opcion1(){
		 Scanner sc = new Scanner(System.in);
   		 System.out.println("Clase del animal");
   		 String clase = sc.nextLine();
   		 System.out.println("Especie del animal");
  		 String especie = sc.nextLine();
  		 System.out.println("Sonido Caracteristico");
  		 String sonido = sc.nextLine();
  		 carnivoros nuevo = new carnivoros(clase, especie, sonido);
  		 nuevo.registrar();
  		 System.out.println("\nSe registró el carnivoro");
	}
	public static void opcion2(){
		 Scanner sc = new Scanner(System.in);
   		 System.out.println("Clase del animal");
   		 String clase = sc.nextLine();
   		 System.out.println("Especie del animal");
  		 String especie = sc.nextLine();
  		 System.out.println("Sonido Caracteristico");
  		 String sonido = sc.nextLine();
  		 herbivoros nuevo = new herbivoros(clase, especie, sonido);
  		 nuevo.registrar();
  		 System.out.println("\nSe registró el carnivoro");
	}
    	  public static void main(String[] args) {

    int opcion = mainConsola.regresarMenu();
    while (opcion != 5) {

      switch (opcion) {
        case 1:
          opcion1();
          break;
        case 2:
          opcion2();
          break;


        default:
          break;
      	}
  	  }
	}
}




class AlmacenarCarnivoros {

  private static ArrayList<carnivoros> carnivoros = new ArrayList<carnivoros>();
    private static Object nomRegistro;

  public static void almacenarCarnivoros(carnivoros carnivoros) {
    AlmacenarCarnivoros.carnivoros.add(carnivoros);
  }

  public static carnivoros recuperarcarnivoro(String nomregistro) {

    for (int i = 0; i < AlmacenarCarnivoros.carnivoros.size(); i++) {
      carnivoros actual = AlmacenarCarnivoros.carnivoros.get(i);
      if (actual.getNomRegistro().equals(nomRegistro)) {
        return actual;
      }
    }

    return null;
  }

}





class AlmacenarHerbivoros {

  private static ArrayList<herbivoros> herbivoros = new ArrayList<herbivoros>();
    private static Object nomRegistro;

  public static void almacenarHerbivoros(herbivoros herbivoros) {
    AlmacenarHerbivoros.herbivoros.add(herbivoros);
  }

  public static herbivoros recuperarcarnivoro(String nomregistro) {

    for (int i = 0; i < AlmacenarHerbivoros.herbivoros.size(); i++) {
      herbivoros actual = AlmacenarHerbivoros.herbivoros.get(i);
      if (actual.getNomRegistro().equals(nomRegistro)) {
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
 * @author Dell
 */
class Almacenarherbivoros {
    
}

public abstract class Animal{

	private String clase;
	protected String especie;
	private String sonido;


	public Animal (String clase, String especie, String sonido){
		
		this.clase = clase;
		this.especie = especie;
		this.sonido = sonido;

	} 
         public abstract String verInformacion();
}
    
class carnivoros extends Animal {

  protected String nomRegistro;

   public carnivoros(String clase, String especie, String sonido) {
        super(clase, especie, sonido);
    this.nomRegistro = nomRegistro; 
    }

    @Override
    public String verInformacion() {
        return "Nom de Registro: " + this.nomRegistro + " " + this.especie;
  }

  public String getNomRegistro() {
    return this.nomRegistro;
  }

  public void registrar() {
    AlmacenarCarnivoros.almacenarCarnivoros(this);
  }
    }

class herbivoros extends Animal{

protected String nomRegistro;

   public herbivoros(String clase, String especie, String sonido) {
        super(clase, especie, sonido);
    this.nomRegistro = nomRegistro; 
    }

    @Override
    public String verInformacion() {
        return "Nom de Registro: " + this.nomRegistro + " " + this.especie;
  }

  public String getNomRegistro() {
    return this.nomRegistro;
  }

  public void registrar() {
    AlmacenarHerbivoros.almacenarHerbivoros(this);
  }
    }    
class jaula{
    private String tipoAnimal;
    
    public jaula(String tipoAnimal){
        this.tipoAnimal = tipoAnimal;
        
    }
    public void registrarAnimal(Animal animal){
        this.Animal.add(Animal);
    }
    
    public String verJaula(){
        String resultado = "";
        resultado += tipoAnimal;
        for (int i = 0; i < this.Animal.size(); i++) {
      resultado += "   " + this.Animal.get(i).verInformacion() + "\n";
    }
        return resultado;
    }
}