import java.util.Scanner;
import dominio.Animal;
import dominio.Jaula;
import persistencia.AlmacenJaula;
import java.util.ArrayList;
import dominio.Jaula;
import persistencia.AlmacenJaula;

public interface MainConsola {
	


	public class Main{

	  public static int regresarMenu() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("******************************************");
	    System.out.println("---animales zoologico----");
	    System.out.println("******************************************");
	    System.out.println("Vaca, Cocodrilo, Pantera, Leon, Elefante, Mono");
	    System.out.println("Menu de opciones:");
	    System.out.println("1) Agregar una Jaula");
	    System.out.println("2) poner animal en jaula");
	    System.out.println("3) mostrar animal en jaula");
	  
	    System.out.println("Elije una opcion:");

	    int respuesta = sc.nextInt();
	    return respuesta;
	  }

	  public static void opcion1() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Capacidad de la Jaula :");
	    String capacidad = sc.nextLine();

	  }
	  public static void opcion2() {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("introduce animal :");
		    String Animal= sc.nextLine();
        
		} 
		public static void main(String[] args){
	   
			int opcion;
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
	 

	






class Vaca extends Hervivoro {

	  @Override
	  public String emitirSonido() {
	    return "muuuuuu";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	}



class Animal {

}



class Cocodrilo extends Carnivoro {

	  @Override
	  public String emitirSonido() {
	    // TODO Auto-generated method stub
	    return "RARARARA";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	}


class Pantera extends Carnivoro {

	  @Override
	  public String emitirSonido() {
	    // TODO Auto-generated method stub
	    return "Miaumiau";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	}


public abstract class Carnivoro extends Animal  {

}




class Jaula {

  private ArrayList<Animal> animales = new ArrayList<Animal>();

  public void verJaula() {
    for (int i = 0; i < this.animales.size(); i++) {
      Animal actual = this.animales.get(i);
      System.out.println(actual.emitirSonido());
    }



  }

  public boolean agregarAnimal(Animal animal) {
    if (this.animales.size() == 0) { // jaula vacía
      this.animales.add(animal);
      return true;
    }

    // la jaula no est� vac�a
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

  public static void main(String[] args) {
    Leon leon1 = new Leon();
    Leon leon2 = new Leon();
    Cocodrilo cocodrilo1 = new Cocodrilo();
    Cocodrilo cocodrilo2 = new Cocodrilo();
    Vaca vaca1 = new Vaca();
    Vaca vaca2 = new Vaca();
    Pantera pantera1 = new Pantera();
    Pantera pantera2 = new Pantera();
    Mono mono1 = new Mono();
    Mono mono2 = new Mono();
    Elefante elefante1 = new Elefante();
    Elefante elefante2 = new Elefante();
    

    Jaula jaula1 = new Jaula();
    Jaula jaula2 = new Jaula();
    Jaula jaula3 = new Jaula();
    Jaula jaula4 = new Jaula();
    Jaula jaula5 = new Jaula();
    Jaula jaula6 = new Jaula();



    System.out.println(jaula1.agregarAnimal(leon1) == true); // true
    System.out.println(jaula1.agregarAnimal(vaca1) == false); // false
    System.out.println(jaula1.agregarAnimal(leon2) == true); // true
    System.out.println(jaula1.agregarAnimal(cocodrilo1) == false); // false
    System.out.println(jaula1.agregarAnimal(elefante1) == false); // false
    System.out.println(jaula1.agregarAnimal(mono1) == false); // false
    System.out.println(jaula1.agregarAnimal(pantera1) == false); // false


    System.out.println(jaula2.agregarAnimal(vaca1) == true); // true
    System.out.println(jaula2.agregarAnimal(vaca2) == true); // true
    System.out.println(jaula2.agregarAnimal(leon1) == false); // false
    System.out.println(jaula2.agregarAnimal(elefante1) == true); // true
    System.out.println(jaula2.agregarAnimal(mono1) == true); // true
    System.out.println(jaula2.agregarAnimal(pantera1) == false); // false
    System.out.println(jaula2.agregarAnimal(cocodrilo1) == false); // false
    
    System.out.println(jaula3.agregarAnimal(pantera1) == true); // true
    System.out.println(jaula3.agregarAnimal(vaca1) == false); // false
    System.out.println(jaula3.agregarAnimal(pantera2) == true); // true
    System.out.println(jaula3.agregarAnimal(cocodrilo1) == false); // false
    System.out.println(jaula3.agregarAnimal(elefante1) == false); // false
    System.out.println(jaula3.agregarAnimal(leon1) == false); // false
    System.out.println(jaula3.agregarAnimal(mono1) == false); // false


    System.out.println(jaula4.agregarAnimal(mono1) == true); // true
    System.out.println(jaula4.agregarAnimal(mono2) == true); // true
    System.out.println(jaula4.agregarAnimal(leon1) == false); // false
    System.out.println(jaula4.agregarAnimal(vaca1) == true); // true
    System.out.println(jaula4.agregarAnimal(elefante1) == true); // true
    System.out.println(jaula4.agregarAnimal(pantera1) == false); // false
    System.out.println(jaula4.agregarAnimal(cocodrilo1) == false); // false

    System.out.println(jaula5.agregarAnimal(cocodrilo1) == true); // true
    System.out.println(jaula5.agregarAnimal(vaca1) == false); // false
    System.out.println(jaula5.agregarAnimal(cocodrilo2) == true); // true
    System.out.println(jaula5.agregarAnimal(pantera1) == false); // false
    System.out.println(jaula5.agregarAnimal(leon1) == false); // false
    System.out.println(jaula5.agregarAnimal(mono1) == false); // false
    System.out.println(jaula5.agregarAnimal(elefante1) == false); // false


    System.out.println(jaula6.agregarAnimal(elefante1) == true); // true
	System.out.println(jaula6.agregarAnimal(elefante2) == true); // true
    System.out.println(jaula6.agregarAnimal(leon1) == false); // false
    System.out.println(jaula6.agregarAnimal(vaca1) == true); // true
    System.out.println(jaula6.agregarAnimal(mono1) == true); // true
    System.out.println(jaula6.agregarAnimal(pantera1) == false); // false
    System.out.println(jaula6.agregarAnimal(cocodrilo1) == false); // false


    jaula1.verJaula();
    jaula2.verJaula();
    jaula3.verJaula();
    jaula4.verJaula();
    jaula5.verJaula();
    jaula6.verJaula();



  }

}





class AlmacenJaula {

	public static void almacenJaula(Jaula jaula) {
		// TODO Auto-generated method stub
		
	}

}



public abstract class Hervivoro extends Animal {

}


class Elefante extends Hervivoro {

	  @Override
	  public String emitirSonido() {
	    return "heeeee";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	}




class Mono extends Hervivoro {
	 @Override
	  public String emitirSonido() {
	    return "huhuhuhuhu";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	}


class Jaula {
	


          public void registrar() {
	    AlmacenJaula.almacenJaula(this);
	  }

	}





public  class Leon extends Carnivoro {

	  @Override
	  public String emitirSonido() {
	    // TODO Auto-generated method stub
	    return "RUAAAAAAAAAGHHH!";
	  }

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

		  
	  
	}



public abstract class Animal {
	public abstract String emitirSonido();
	public abstract int capacidad(); 
	

	
}