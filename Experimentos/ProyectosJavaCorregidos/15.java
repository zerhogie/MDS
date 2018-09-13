import javax.swing.*;
import Jaulas.*;
import Animales.*;
import Animales.*;
import Animales.Carnivoro;
import Animales.Herbivoro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;


public class ZooMain {

	public static void opcion1() {
		String numero;
		int capacidad;
		numero=JOptionPane.showInputDialog(null, "Ingrese numero de jaula:");
		capacidad=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese capacidad:"));
		Jaula jaula=new Jaula(numero,capacidad);
		jaula.registrarJaula();
		JOptionPane.showMessageDialog(null, "Se Registro Correctamente");
	}
//****************************************************************************************************************************
	public static void opcion2() {
		String esco="si";
		String numero;
		numero=JOptionPane.showInputDialog(null,"Ingresa el numero de jaula para asignar el animal:");
		Jaula jaula=AlmacenarJaulas.regresarJaula(numero);
		if (jaula==null) {
			JOptionPane.showMessageDialog(null, "Error no exite esa jaula");
			JOptionPane.showMessageDialog(null, "No se almaceno nada");
			return;
		}
		String animal;
		String color;
		int espacioOcupado;
		do {
			animal=JOptionPane.showInputDialog(null,"Que Animal deseeas agregar:"+"TREX\n"+"Comodo\n"+"Hiena\n"+"Canguro\n"+"Conejo\n"+"Koala");
			switch(animal) {
				case "trex":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					TRex trex=new TRex(color,espacioOcupado);
					jaula.anadirAnimal(trex);
				break;
				
				case "comodo":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					Comodo comodo=new Comodo(color,espacioOcupado);
					jaula.anadirAnimal(comodo);
				break;
				
				case "hiena":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					Hiena hiena=new Hiena(color,espacioOcupado);
					jaula.anadirAnimal(hiena);
				break;
				
				case "canguro":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					Canguro canguro=new Canguro(color,espacioOcupado);
					jaula.anadirAnimal(canguro);
				break;
					
				case "conejo":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					Conejo conejo=new Conejo(color,espacioOcupado);
					jaula.anadirAnimal(conejo);
				break;
					
				case "koala":
					color=JOptionPane.showInputDialog(null, "Ingresa color:");
					espacioOcupado=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Espacio que ocupa:"));
					Koala koala=new Koala(color,espacioOcupado);
					jaula.anadirAnimal(koala);
				break;
			}
			esco=JOptionPane.showInputDialog(null,"¿Desea registrar otro Animal?\nsi o no");
			if (jaula.getCapacidad()==0) {
					JOptionPane.showMessageDialog(null, "Ya no hay espacio");
					esco="no";
			}
		}while(esco.equals("si"));
	}
//******************************************************************************************************************************
	public static void opcion3() {
		String numero;
		numero=JOptionPane.showInputDialog(null,"Numero de la jaula:");
		Jaula jaula=AlmacenarJaulas.regresarJaula(numero);
		if(jaula==null) {
			 System.out.println("Error: no se encontró el grupo");
		      return;
		    }
		jaula.verJaula();
	}
	
//*******************************************************************************************************************************
	public static void main(String[]args){
	    int a=0;
	    do{
	        a=Integer.parseInt(JOptionPane.showInputDialog(null,"Selecciona una opcion:\n"+"1.- Agregar jaula\n"+"2.- Agregar animal\n"+"3.- Ver animales\n"+"4.- Salir"));
	      switch(a){
	        case 1:
	        	opcion1();
	        break;
	        case 2:
	        	opcion2();
	        break;
	        case 3:
	        	opcion3();
	        break;
	        
	      }
	    }while(a!=4);

	  }
}



class Comodo extends Carnivoro{

	
	public Comodo(String color, int espacioOcupado) {
		super(color, espacioOcupado);
	}

	@Override
	public String informarcion() {
		
		return "Soy Comodo";
	}

	@Override
	public String decirSonido() {
		return "ssssssssssssssssssssss";
	}

}



class Canguro extends Herbivoro{

	public Canguro(String color,int espacioOcupado) {
		super(color,espacioOcupado);
	}

	@Override
	public String informarcion() {
		return "soy Canguro";
	}

	@Override
	public String decirSonido() {
		return "niiiiiiiiiiiiin";
	}

}


public abstract class Carnivoro extends Animal{
	public Carnivoro (String color,int espacioOcupado){
	    /* El constructor de la subclase invoca al constructor de la superclase. Para ello se incluye, obligatoriamente, la palabra clave super como primera l�nea del constructor de la subclase. La palabra super irá seguida de paréntesis dentro de los cuales pondremos los parámetros que requiera el constructor de la superclase al que queramos invocar.*/
	    super(color,espacioOcupado);
	  }
	
	
}



class Jaula {
	private String numero;
	  private int capacidad;
	  private ArrayList<Animal> arrayanimales = new ArrayList<Animal>();

	  public Jaula (String numero,int capacidad){
	    this.numero=numero;
	    this.capacidad=capacidad;
	  }
//**********************************************************************}
	  public String getNumero(){
		  return this.numero;
	  }
	  
	  
	  public int getCapacidad() {
		return capacidad;
	  }
	
	//***********************************************************************
	  public void registrarJaula() {
		  AlmacenarJaulas.almacenarJaulas(this);
	  }
	  
	  public void verJaula() {
		  for (int i = 0; i < this.arrayanimales.size(); i++) {
			  Animal actual = this.arrayanimales.get(i);
			  if (actual instanceof Hiena) {
				  JOptionPane.showMessageDialog(null, "Hiena"+(i+1));
			  }
			  if (actual instanceof TRex) {
				  JOptionPane.showMessageDialog(null, "TREX"+(i+1));
			  }
			  if (actual instanceof Comodo) {
				  JOptionPane.showMessageDialog(null, "Comodo"+(i+1));
			  }
			  if (actual instanceof Koala) {
				  JOptionPane.showMessageDialog(null, "Koala"+(i+1));
			  }
			  if (actual instanceof Conejo) {
				  JOptionPane.showMessageDialog(null, "Conejo"+(i+1));
			  }
			  if (actual instanceof Canguro) {
				  JOptionPane.showMessageDialog(null, "Canguro"+i);
			  }
			  JOptionPane.showMessageDialog(null,actual.decirSonido());
		  }
	  }
	  
	  public boolean anadirAnimal(Animal animal) {
		  	
		  if (this.arrayanimales.size() == 0) { 
			  if (this.capacidad>=animal.getEspacioOcupado()) {
				  this.arrayanimales.add(animal);
				  this.capacidad=this.capacidad-animal.getEspacioOcupado();
				  return true;
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "No cabe en la jaula");
				  return false;
			  }
		  }
		  //si la jaula esta ocupada
		  Animal AnimalOriginal = this.arrayanimales.get(0);//para ver que clase es el animal0
		  
		  
		  //instanceof sirve para ver si un objeto pertenece a una clase 
		  //comparamos si animal en la posicion 0 es herbivoro y animal que ongresaremos es herbivoro
		  if (AnimalOriginal instanceof Herbivoro) {
			  if (animal instanceof Herbivoro) {
				  
			    	  if (this.capacidad>=animal.getEspacioOcupado()) {
			    		  this.arrayanimales.add(animal);
			    		  this.capacidad=this.capacidad-animal.getEspacioOcupado();
			    		  return true;
			    	  }
			    	  else {
			    		  JOptionPane.showMessageDialog(null, "No cabe en la jaula");
			    	  }
			      }
			     
		         
		  
			  //comparamos carnivoros
			  else if (animal instanceof Carnivoro) {
				JOptionPane.showMessageDialog(null, "No se agrego por que es carnivoro y se comeria al herbivoro");
		        return false;
		      }
		  } 
		  else 
			  if (AnimalOriginal instanceof Carnivoro) {
		  		if (animal instanceof Herbivoro) {
		  			JOptionPane.showMessageDialog(null, "No se agrego agrego herbivoro porque el carivoro se lo comeria");
		  			return false;
		  		}
		      if (AnimalOriginal.getClass() == animal.getClass()) {
		    	  if (this.capacidad>=animal.getEspacioOcupado()) {
		    		  this.arrayanimales.add(animal);
		    		  this.capacidad=this.capacidad-animal.getEspacioOcupado();
		    		  return true;
		    	  }
		    	  else {
		    		  JOptionPane.showMessageDialog(null, "No cabe en la jaula");
		    	  }
		      }
		      else {
		    	  JOptionPane.showMessageDialog(null, "No se agrego porque no son de la misma clase");  
		      }
			  }
	        return false;
		  }
	  
	  
}



class TRex extends Carnivoro{
	
	public TRex(String color, int espacioOcupado) {
		super(color, espacioOcupado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String informarcion() {
		
		return "soy T-rex";
	}

	@Override
	public String decirSonido() {
		return "GRRRRRRRRRRRRRRRRRRUM";
	}
	
}



class Hiena extends Carnivoro{
	

	public Hiena(String color, int espacioOcupado) {
		super(color, espacioOcupado);
	}

	@Override
	public String informarcion() {
		return "Soy Hiena";
	}

	@Override
	public String decirSonido() {
		return "jijijijijijiji jejejejejej jajajajaja";
	}

}



public abstract class Herbivoro extends Animal{
	public Herbivoro (String color,int espacioOcupado){
		super(color,espacioOcupado);
	}
	
}



class AlmacenarJaulas {
	
	private static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();
	
	 public static void almacenarJaulas(Jaula jaula) {
		    AlmacenarJaulas.jaulas.add(jaula);
		  }

		  public static Jaula regresarJaula(String numero) {

		    for (int i = 0; i < AlmacenarJaulas.jaulas.size(); i++) {
		      Jaula actual = AlmacenarJaulas.jaulas.get(i);
		      if (actual.getNumero().equals(numero)) {
		        return actual;
		      }
		    }

		    return null;
		  }
}



class Koala extends Herbivoro{

	public Koala(String color, int espacioOcupado) {
		super(color, espacioOcupado);
	}

	@Override
	public String informarcion() {
		return "Soy Koala";
	}

	@Override
	public String decirSonido() {
		return "grupppp gruppp";
	}

}



public abstract class Animal {
	private String color;
	private int espacioOcupado;

	
	public Animal(String color, int espacioOcupado) {
		
		this.color = color;
		this.espacioOcupado = espacioOcupado;
	}

//************************************************************************
	
	public int getEspacioOcupado() {
		return espacioOcupado;
	}
	
	public String getColor() {
		return color;
	}

	
	public void setColor(String color) {
		this.color = color;
	}

	public void setEspacioOcupado(int espacioOcupado) {
		this.espacioOcupado = espacioOcupado;
	}
//***************************************************************************
	public abstract String informarcion();
	public abstract String decirSonido();
	
}




class Conejo extends Herbivoro{

	public Conejo(String color, int espacioOcupado) {
		super(color, espacioOcupado);
	}

	@Override
	public String informarcion() {
		return "soy Conejo";
	}

	@Override
	public String decirSonido() {
		return "niiiiim niiiiiim";
	}

}
