import java.util.Scanner;
import Zoologico.Jaula;
import java.util.ArrayList;





public class MainConsola {
	public static int IngresarMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------");
		System.out.println(" ****Sistema en Zoologico*** ");
		System.out.println("-----------------------------");
		System.out.println("Menu de opciones");
		System.out.println("1) Agregar una jaula");
		System.out.println("2) Agregar un animal a una jaula");
		System.out.println("3) Ver animales en jaula");
		int respuesta = sc.nextInt();
		
		return respuesta;
		
	}
	public static void opcion1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nueva Jaula");
		System.out.println("Capacidad");
		int capacidad=sc.nextInt();
		System.out.println("Numero de jaula");
		int Njaula = 1;
		Jaula nueva = new Jaula(capacidad, Njaula);
		
		
		
	}

	
}




class Rinoceronte extends Hervivoro {
	
	

	public Rinoceronte(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "¡Wigh wigh eh !";
	  }
}



public abstract class Carnivoro extends Animal{

	public Carnivoro(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	

	

}


//import Zoologico.Animal;

class Jaula {

  protected ArrayList<Animal> animales = new ArrayList<Animal>();
  protected int  Njaula;
  protected int capacidad;
  protected int carni;
  
  public Jaula(int capacidad, int Njaula) {
	  this.capacidad=capacidad;
	  this.Njaula=Njaula;
	  
  }
  @Override
  public void VerJaula() {
    for (int i = 0; i < this.animales.size(); i++) {
      Animal actual = this.animales.get(i);
      System.out.println(actual.emitirSonido());
      System.out.println(actual.veranimal());
    }



  }

  public boolean agregarAnimal(Animal animal) {
	  
    if (this.animales.size() == 0) { // jaula vacía
      this.animales.add(animal);
      return true;
    }

    // la jaula no est� vac�a
    Animal primerAnimal = this.animales.get(0);
    if (primerAnimal instanceof Hervivoro) {
      if (animal instanceof Hervivoro) { // no hay problema
    	  
        this.animales.add(animal);
        System.out.println(this.animales +"es hervivoro");
        
        return true;
      } else if (animal instanceof Carnivoro) {
    	  System.out.println(this.animales +"es hervivoro");
        return false;
        
      }
    } else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Hervivoro) {
    	  
        System.out.println(this.animales +"es carnivoro");
        carni=1;
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




class Puma extends Carnivoro {
	
	

	public Puma(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "WUUAAAAAAAAGHHHRR!";
	  }
}



public abstract  class Hervivoro extends Animal {

	public Hervivoro(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	
	

}



class Elefante extends Hervivoro {

	

	

	public Elefante(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "¡BUrrrrrhhhh !";
	  }
}



class Jaguar extends Carnivoro{

	


	public Jaguar(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "BRRRRRRRRRRRWAAAGH!";
	  }

}



class Zoologico {
	
	
	

	public void agregarJaula () {
		
	
		
	}



}



class Koala extends Hervivoro {

	
	public Koala(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "¡Jiu jujuju !";
	  }
}



public abstract class Animal {
	protected int espacio;
	
	
	public Animal(int espacio) {
		 this.espacio=espacio;
	}
	public void setEspacio(int espacio){
		this.espacio=espacio;
	}
	public int getEspacio() {
	    return this.espacio;
	  }
	

	
	public abstract  String emitirSonido();
	public String veranimal () {
		String resultado = "";
	    return resultado += "ESPACIO:  " + this.espacio ;

	}

}




class TigreBlanco extends Carnivoro {

	




	public TigreBlanco(int espacio) {
		super(espacio);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String emitirSonido() {
	    
	    return "¡WRAGGGHHHHHBRRWRAGGHH!";
	  }
}
