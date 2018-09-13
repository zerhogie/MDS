import java.util.Scanner;
import Dominio.Jaula;
import Dominio.Animal;
import Dominio.Carnivoro;
import Dominio.León;
import Dominio.Jaguar;
import Dominio.Cocodrilo;
import Dominio.Herbivoro;
import Dominio.Koala;
import Dominio.Cebra;
import Dominio.Jirafa;
import almacenJaula.almacenarJaula;
import java.util.ArrayList;
import dominio.Jaula;
import java.util.Scanner;


public class MainConsola {
   public static int regresarMenu () {
    Scanner sc = new Scanner (System.in);
    System.out.println("******************************************");
    System.out.println("---Administración de Zoológico----");
    System.out.println("******************************************");
    System.out.println("");
    System.out.println("Menú de opciones:");
    System.out.println("1) Agregar jaula");
    System.out.println("2) Agregar animal a una jaula");
    System.out.println("3) Ver animal en cada jaula");
    System.out.println("4) Salir del sistema");
    System.out.println("");
    System.out.println("Elije una opción:");

    int respuesta = sc.nextInt();
    return respuesta;
  }
   
   public static void opcion1() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Numero de jaula");
    int numJaula = sc.nextInt();
    System.out.println("Capacidad");
    int capacidad = sc.nextInt();
    Jaula ja = new Jaula (numJaula, capacidad);
    System.out.println(ja);
    ja.agregar ();
    System.out.println("\nSe agregó la jaula correctamente");
   }
   
   public static void opcion2() {
    Scanner sc = new Scanner(System.in);
    System.out.println("El espacio que ocupa es de: ");
    int espaciOcupa = sc.nextInt();
    System.out.println("El sonido que emite es: ");
    int emitirSonido = sc.nextInt ();
    Animal anim;
    anim = new Animal (espaciOcupa, emitirSonido);
    System.out.println(anim);
    anim.agregar ();
    System.out.println("\nSe agregó el animal correctamente");
    }
}



class almacenarJaula {
    
    private stactic ArrayList<Jaula> jaulas = new ArrayList<Jaula>() ;
    
    public stactic void almacenJaula (Jaula jaula) {
        AlmacenarJaula.jaula.add(jaula);
    }
    public stactic Jaula recuperarJaula (String numJaula) {
        
        for (int i = 0; i < AlmacenarJaula.jaula.size () ; i++) {
            Jaula actual = AlmacenarJaula.jaula.get (i);
            if (actual.getNumJaula ().equals (numJaula)) {
                return actual;
            }
        }
        return null;    
    }
    
}



public abstract class Animal {
    
    protected String espacio;
    
    public Animal (String espacio) {
        this.espacio = espacio;
    }
   
    public String mostrarInform () {
        return "Espacio que ocupa: " + this.espacio;
    }
    
    public String getEspacio () {
        return this.espacio;
    }
    
    public abstract String emitirSonido();

    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}





class Carnivoro extends Animal {
    
    protected String emitirSonido;
    
    public Animal (String nombre, String espacio, String emitirSonido) {
        this.nombre = nombre;
        this.espacio = espacio;
        this.emitirSonido = emitirSonido;
    }
    
     + "n\Sonido que emite: " + this.emitirSonido;
    }
    
    public String getNombre () {
        return this.nombre
        
    }

}


class Cebra extends Herbivoro {
    protected String emitirSonido;
    
    public Animal (String espacio) {
        super(espacio);
        this.espacio = espacio;
    }
    
    @Override
    public String emitirSonido() {
        return "Jijijiji";
    }
}




class Cocodrilo extends Animal {

    @Override
    public String emitirSonido() {
        return "Gruaggg";
    }
}



public abstract class Herbivoro extends Animal {
}



class Jaguar extends Animal {

    @Override
    public String emitirSonido() {
        return "Rggggg";
    }
}


class Jaula {
    protected int numJaula;
    protected int capacidad;
    
    public Jaula(int numJaula, int capacidad){
    this.numJaula = numJaula;
    this.capacidad = capacidad;
    }
    public int getnumJaula() {
    return this.numJaula;
    }
    public int getCapacidad (){
        return this.capacidad;
    }
    public  static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Numero de jaula");
        int numJaula = sc.nextInt();
	System.out.println("Capacidad");
        int capacidad = sc.nextInt();
        Jaula ja = new Jaula (numJaula, capacidad);
        System.out.println(ja);
        }
    @Override
    public String toString(){
	return "Su número de jaula es = " + this.numJaula + "\nSu capacidas es = " + this.capacidad;       
	}

    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

	
	




class Jirafa extends Herbivoro {
    
    @Override
    public String emitirSonido() {
        return "Gliiiif";
    }
}




class Koala extends Herbivoro {
    
    @Override
    public String emitirSonido() {
        return "Rigggss";
    }
}



class León extends Carnivoro {
    
    @Override
    public String emitirSonido() {
        return "GRRRRR";
    }
}
