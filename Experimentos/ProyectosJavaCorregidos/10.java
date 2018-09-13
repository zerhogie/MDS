import java.util.Scanner;
import anim.Animal;
import anim.Carnivoro;
import anim.Herbivoro;
import anim.Koala;
import anim.Jirafa;
import anim.Ciervo;
import anim.Nutria;
import anim.Lobo;
import anim.Pantera_Negra;
import anim.Jaula;
import MetodJau.AgregarAnimal;
import anim.Animal;
import anim.Carnivoro;
import anim.Herbivoro;
import java.util.ArrayList;
import anim.Jaula;
import anim.Animal;
import MetodJau.AgregarJaula;


public class mainZoo {
	
	public static int Menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido\n");
		System.out.println("Menu de opciones");
		System.out.println("1. Agregar Jaula");
		System.out.println("2. Agregar animal a una jaula");
		System.out.println("3. Ver animales en las jaulas");
		System.out.println("4. Salir");
		
		int respuesta = sc.nextInt();
		return respuesta;
	}
	
	public static void opcion1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero de jaula");
		int numJ = sc.nextInt();
		System.out.println("Capacida de la jula");
		int capacidad = sc.nextInt();
		Jaula nuevo = new Jaula(numJ, capacidad);
		System.out.println("Se agrego la jaula correctamente");
		
	}
	
	public static void opcion2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Espacio que ocupa el animal");
		int espacio = sc.nextInt();
		
		Jaula jaula =  new Jaula(numJ, espacio);
		jaula.agregarAnimal(jaula);
		System.out.println("Se agrego el animal con exito");
	}
	
	public static void opcion3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero de la jaula");
		int numJ = sc.nextInt();
		if (jaula == null) {
		  System.out.println("No se encontro la jaula que busca");
			return;
		}
		new AgregarAnimal().mostrar();
	}
	
	public static void main(String[] args) {
		int opcion = mainZoo.Menu();
		
		while (opcion !=4) {
			
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
			opcion = mainZoo.Menu();
		}
	}

}



class Ciervo {
	
	public String emitirSonido() {
		return "beeeee beeee";
	}

}



class Lobo {
	
public String emitirSonido() {
	return "aauuuuu";
 }
}




class AgregarAnimal {
private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	public String agregarAnimal(Animal animal) {
		if (this.animals.size() == 0) {
			this.animals.add(animal);
			return "El animal ha sido agregado con exito";
		}
		
		Animal Animal1 = this.animals.get(0);
		if (Animal1 instanceof Herbivoro) {
		  if(animal instanceof Herbivoro) {
			this.animals.add(animal);
			return "Animal añadido con exito";
			}
		  else if (animal instanceof Carnivoro) {
			  return "El animal es un carnoivoro, intente en otra jaula";
		  }
		}
		else if (Animal1 instanceof Carnivoro) {
			if (animal instanceof Herbivoro) {
				return "El animal es Herbivoro, intente en otra jaula";
			}
			if (Animal1.getClass() == animal.getClass()) {
				this.animals.add(animal);
				return "El animal se ha añadido con exito ";
			}
		}
		return" Error ";
	}
	
	public void mostrar() {
		for (int i = 0; i < this.animals.size(); i++) {
			Animal actual = this.animals.get(i);
			System.out.println(actual.emitirSonido());
		}
	}

}



class AgregarJaula {
	
	private static Jaula jaul = new Jaula(numJ, espacio);
	
	public static void agregaJaula(Jaula jaula) {
		AgregarJaula.jaul.add(jaula);
	}
	
}



public abstract class Carnivoro extends Animal{
	
	public Carnivoro(int espacio,String sonido ) {
	super(espacio,sonido);
}
}


class Jirafa {

}



class Jaula {
private int numJ;
private int capacidad;

public Jaula(int numJ,int capacidad) {
	this.numJ=numJ;
	this.capacidad=capacidad;
}

public int GetNumJ() {
	return this.numJ;
}
public void SetNumJ(int numJ) {
	this.numJ=numJ;
}

public int GetCapacidad() {
	return this.capacidad;
}
public void SetCapacidad(int capacidad) {
	this.capacidad=capacidad;
}

	
}


class Pantera_Negra {
	
	public String emitirSonido() {
		return "grrrrrrniau";
	}

}



public abstract class Nutria  {

	public String emitirSonido() {
		return "chiu chiu...";
	}
}



public abstract class Herbivoro extends Animal {
	
	public Herbivoro(int espacio,String sonido) {
		super(espacio,sonido);
	
	}

}



class Koala {
	
	public String emitirSonido() {
		return"bibirib";
	}

}



public abstract class Animal {
private int espacio;
private String sonido;

public Animal (int espacio,String sonido) {
	this.espacio=espacio;
	this.sonido=sonido;
}

public float GetEspacio() {
	return this.espacio;
}
public void SetEspacio(int espacio) {
	this.espacio=espacio;
}

public String GetSonido() {
	return this.sonido;
}
public void SetSonido(String sonido) {
	this.sonido=sonido;
}
public abstract String verInformacion();

public abstract String emitirSonido();
}
