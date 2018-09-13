import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;



class Carnivoro extends animal {
	public Carnivoro(int pata) {
		super(pata);
		
	}
	protected static int pata;
	@SuppressWarnings("static-access")
	public void carnivoro (int pata){
		this.pata = pata;
	}
	@SuppressWarnings("resource")
	public static void main (String[]args) {
		@SuppressWarnings("unused")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		Carnivoro ca = new Carnivoro (pata);
	}

}




class Jaula {

	private int capacidad;
	private int numJaula;
	

	public Jaula (int numjaula, int capacidad){
		this.setNumJaula(numjaula);
		this.setCapacidad(capacidad);
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getNumJaula() {
		return numJaula;
	}


	public void setNumJaula(int numJaula) {
		this.numJaula = numJaula;
	}
    public int agregarAnimal (String[]arch) {
    	animal.main(arch);
    	return capacidad;
    }
	
}
	






class Herbivoro extends animal{
	
	public Herbivoro(int pata) {
		super(pata);
		
	}
	protected static int pata;
	@SuppressWarnings("static-access")
	public void herbivoro (int pata){
		this.pata = pata;
	}
	@SuppressWarnings("resource")
	public static void main (String[]args) {
		@SuppressWarnings("unused")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		Herbivoro he= new Herbivoro (pata);
	}

	

}





class animal {
	protected static int pata;

	public animal (int pata){
		animal.pata = pata;
	}
	@SuppressWarnings("resource")
	public static void main (String[]args) {
		@SuppressWarnings("unused")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		animal an= new animal (pata);
	}
}





class jaula1 {
	private int capacidad;
	private int numJaula;
	

	public void Jaula (int numjaula, int capacidad){
		this.setNumJaula(numjaula);
		this.setCapacidad(capacidad);
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getNumJaula() {
		return numJaula;
	}


	public void setNumJaula(int numJaula) {
		this.numJaula = numJaula;
	}
    public int agregarAnimal (String[]arch) {
    	animal.main(arch);
    	return capacidad;
    }
	
}
	



