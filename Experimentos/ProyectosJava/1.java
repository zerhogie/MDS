import java.util.Scanner;
import Zoologico.Animal;
import Zoologico.Jaula;
import Agregaciones.AlmacenJaulas;
import Zoologico.Herbivoro;
import Zoologico.Alpaca;
import Zoologico.Elefante;
import Zoologico.Capibara;
import Zoologico.Carnivoro;
import Zoologico.Hiena;
import Zoologico.Lobo;
import Zoologico.Oso;
import java.util.ArrayList;
import Zoologico.Jaula;
import java.util.ArrayList;
import Agregaciones.AlmacenJaulas;




public class Main {
	
	public static int regresarMenu() {
		 Scanner sc = new Scanner(System.in);
		    System.out.println("|-----------------------------------|");
		    System.out.println("|Bienvenido al sistema del Zoologico|");
		    System.out.println("|-----------------------------------|");
		    System.out.println("");
		    System.out.println("Menu");
		    System.out.println("1) Crear Jaula");
		    System.out.println("2) Agregar animal en una jaula");
		    System.out.println("3) Ver una Jaula");
		    System.out.println("4) Salir");
		    
		    int respuesta= sc.nextInt();
		    return respuesta; 
	}
	
	public static void opcion1() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Ingresa el numero que tendra la jaula:");
		String numjaula = sc.nextLine();
		
		System.out.println("Ingresa la capacidad de la Jaula");
		int capacidad = sc.nextInt();
		
		Jaula jaula = new Jaula(numjaula,capacidad);
		jaula.agregar();
		System.out.println("Se ha creado la jaula");
		
		
	}
	
	public static void opcion2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa  el numero de una Jaula ya creada:");
		String numjaula = sc.nextLine();
		Jaula jaula = AlmacenJaulas.recuperarJaula(numjaula);
		if (jaula == null) {
			System.out.println("No se encontro la jaula");
			System.out.println("No se puede agregar el animal");
			return;
		}else {
			int opcAnim;
			int espacioAnim;
			
	do  {
System.out.println("Que animal deceas agregar");
System.out.println("1-Alpaca");
System.out.println("2-Elefante");
System.out.println("3-Capibara");
System.out.println("4-Hiena");
System.out.println("5-Lobo");
System.out.println("6-Oso");
System.out.println("7-Salir");

opcAnim = sc.nextInt();
		switch(opcAnim)  {
		case 1:
			System.out.println("Ingresa el espacio que ocupa");
			espacioAnim =  sc.nextInt();
			Alpaca alpaca = new Alpaca("Alpaca",espacioAnim);
			jaula.agregarAnimal(alpaca);
			break;
		
		case 2:
			System.out.println("Ingresa el espacio que ocupa");
			espacioAnim =  sc.nextInt();
			Elefante elefante = new Elefante ("Elefante",espacioAnim);
			jaula.agregarAnimal(elefante);
			break;
			
		case 3:
			System.out.println("Ingresa el espacio que ocupa");
			espacioAnim =  sc.nextInt();
			Capibara capibara = new Capibara ("Capibara",espacioAnim);
			jaula.agregarAnimal(capibara);
			break;
			
		case 4:
			System.out.println("Ingresa el espacio de la Hiena");
			espacioAnim =  sc.nextInt();
			Hiena hiena = new Hiena ("Hiena",espacioAnim);
			jaula.agregarAnimal(hiena);
			break;
			
		case 5:
			System.out.println("Ingresa el espacio que ocupa");
			espacioAnim =  sc.nextInt();
			Lobo lobo = new Lobo ("Lobo",espacioAnim);
			jaula.agregarAnimal(lobo);
			break;
		case 6:
			System.out.println("Ingresa el espacio que ocupa");
			espacioAnim =  sc.nextInt();
			Oso oso = new Oso("Oso",espacioAnim);
			jaula.agregarAnimal(oso);
			break;
		
		}
	} while(opcAnim !=7);
	
	}
	}
	
	public static void opcion3(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el numero de la jaula que desea ver");
		String numjaula = sc.nextLine();
		Jaula jaula = AlmacenJaulas.recuperarJaula(numjaula);
		if (jaula == null) {
			System.out.println("No se encontro la jaula");
			return;
	}
		
	System.out.println(jaula.mostrarJaula());	
}
	
		
		
	
	 public static void main(String[] args) {
		 
		  int opcion = Main.regresarMenu();
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
			  
			  opcion = Main.regresarMenu();
		  }
	 }
	 
}





class Lobo extends Carnivoro {
	public Lobo (String nombre,int espacio){
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+"  Espacio: "+ getEspacio();
		}
		public  String emitirSonido(){return "Auuuuuuuuuuuu";}
	}


class AlmacenJaulas {

	private static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();
	 
	  public static void almacenarJaula(Jaula jaula) {
	    AlmacenJaulas.jaulas.add(jaula);
	  }
	 
	  public static Jaula recuperarJaula(String numjaula) {
	    for (int i = 0; i < AlmacenJaulas.jaulas.size(); i++) {
	      Jaula actual = AlmacenJaulas.jaulas.get(i);
	      if (actual.getNumjaula ().equals( numjaula)) {
	        return actual;
	      }
	    }
	 
	    return null;
	  }
	 
	}




public abstract class Carnivoro extends Animal {
	
	public Carnivoro (String nombre, int espacio){
		super (nombre,espacio);
		
		
	}
	
	public abstract String mostrarAnimal (); 
}



class Jaula {
	
	private String  numjaula; 
	private int  capacidad; 
	private ArrayList<Animal> animales = new ArrayList<Animal>();
	
	public Jaula (String numjaula, int capacidad) {
		this.numjaula = numjaula;
		this.capacidad = capacidad; 
		this.animales = new ArrayList<Animal>();
		
	}
	
	public void   setNumjaula (String numjaula) {this.numjaula = numjaula;}
	public void  setCapacidad (int capacidad) {this.capacidad = capacidad;}
	
	public void verJaula() {
		for (int i = 0; i < this.animales.size(); i++) {
			Animal actual = this.animales.get(i);
			System.out.println(actual.emitirSonido());
		} 
	}
	
	
	public boolean agregarAnimal(Animal animal) {
		if (this.animales.size()== 0) {
			if (this.capacidad>animal.getEspacio()) {
				this.animales.add(animal);
				this.capacidad=(this.capacidad-animal.getEspacio());
				return true;
			}else {
				System.out.println("No hay espacio suficiente, llevalo a otra jaula\n");
				return false;
			}
	}
		Animal primerAnimal =  this.animales.get(0);
		if (primerAnimal instanceof Herbivoro) {
			if (animal instanceof Herbivoro) {
				if (this.capacidad>animal.getEspacio()) {
					this.animales.add(animal);
					this.capacidad=(this.capacidad-animal.getEspacio());
					return true;
				}else {
					System.out.println("No hay espacio suficiente, llevalo a otra jaula\n");
					return false;
				}
			}
			else if (animal instanceof Carnivoro) {
				System.out.println("No puedes agregar un carnivoro con un herbivoro\n");
				return false;
			}
		}
		
		else if (primerAnimal instanceof Carnivoro) {
			if(animal instanceof Herbivoro) {
				System.out.println("No puedes agregar un carnivoro con un herbivoro\n");
				return false;
			}
			
			if (primerAnimal.getClass()== animal.getClass()) {
				if (this.capacidad>animal.getEspacio()) {
					this.animales.add(animal);
					this.capacidad=(this.capacidad-animal.getEspacio());
					return true;
				}else {
					System.out.println("No hay espacio suficiente, llevalo a otra jaula\n");
					return false;
				}
			}
		}
		System.out.println("No puedes agregar dos carnivoros de diferente especie");
		return false; 
	}

	
	
	public String getNumjaula () {return this.numjaula;}
	public int getCapacidad () {return this.capacidad;}
	public  ArrayList<Animal> getAnimal() {return this.animales;}
	public void agregar() {AlmacenJaulas.almacenarJaula(this);}
	public String mostrarJaula() {
		String resultado = "";
		resultado += "Numero de jaula.-   " + this.numjaula+ "\n";
		resultado += "Capacidad de la jaula.-  " + this.capacidad+"\n";
		
	for (int i = 0; i < this.animales.size(); i++) {
		resultado += "  "+ this.animales.get(i).mostrarAnimal() + "    " + this.animales.get(i).emitirSonido()+"\n";	
	}
	 return resultado;
	}
	

}



class Capibara extends Herbivoro {
	public Capibara (String nombre,int espacio) {
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+ "  Espacio: "+getEspacio();
		}
		public  String emitirSonido(){return "wiii wii wiiwi";}
	}



class Alpaca extends Herbivoro {
	public Alpaca (String nombre,int espacio){
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+ "  Espacio: "+getEspacio();
		}
		public  String emitirSonido(){return "Paca paca";}
	}




class Elefante extends Herbivoro {
	public Elefante (String nombre, int espacio){
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+  "  Espacio: "+getEspacio();
		}
		public  String emitirSonido(){return "Fruuuuu";}
	}



class Hiena extends Carnivoro {
	public Hiena (String nombre, int espacio){
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+"  Espacio: "+getEspacio();
		}
		public  String emitirSonido(){return "Jijiji jaja";}
	}



public abstract class Herbivoro extends Animal {
	
	
	
	public Herbivoro (String nombre,int espacio){
		super (nombre,espacio);
		
		
	}

	public abstract  String mostrarAnimal(); 		
	

}


public abstract class Animal {
	
	private String nombre;
	private int  espacio; 
	public Animal (String nombre,int espacio){
		
		this.nombre = nombre;
		this.espacio = espacio;
		
		
	}
	/*Metodos set*/
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setEspacio(int espacio) {this.espacio = espacio;}
	

	/* Metodos get*/ 
	
	public String getNombre () {return this.nombre;} 
	public int    getEspacio() {return this.espacio;} 

	public abstract String mostrarAnimal();
	public abstract String emitirSonido();
	
	
}
	
	
	
	
	





class Oso extends Carnivoro {
	public Oso (String nombre, int espacio){
		super (nombre,espacio);
	}
		@Override 
		public String mostrarAnimal() {
		return "Nombre: " +getNombre()+ "  Espacio: "+getEspacio();
		}
		public  String emitirSonido(){return " Rwooooooar";}
	}
