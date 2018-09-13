import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author cobi
 */


public class Zoo  {

    protected ArrayList<Animal> animalito = new ArrayList<Animal>();

    
   /* public void verJaula() {
        
    for (int i = 0; i < this.animalito.size(); i++) {
      Animal actual  = this.animalito.get(i);
      System.out.println(actual.chillar());
      
    }
    
}*/
    

   public boolean agregarAnimal(Animal animal) {
    if (this.animalito.size() == 0) { // jaula vacía
      this.animalito.add(animal);
      return true;
    }

    // la jaula no está vacía
    Animal primerAnimal = this.animalito.get(0);
    if (primerAnimal instanceof Herbivoro) {
      if (animal instanceof Herbivoro) { // no hay problema
        this.animalito.add(animal);
        return true;

        
      } else if (animal instanceof Carnivoro) {
        return false;
        
      }
    } else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herbivoro) {
        return false;
      }

      if (primerAnimal.getClass() == animal.getClass()) {
        this.animalito.add(animal);
        
        return true;
      }
    }

    return false;
  }

        public static void main(String[] args) {
            
         
             
             
              Zoo objeto = new Zoo ();
            
            Jaula jaula1 = new Jaula();
           
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int anim;
            

          
          while (!salir){
           System.out.println("___________________________________________________________ ");
           System.out.println("Bienvenido al Sistema de Zoo de Uriel Esaú (Cobi_Unicorn) ");
           System.out.println("1. Crear Jaula");
           System.out.println("2. Meter Animal dentro de Jaula");
           System.out.println("3. Ver Jaula ");
           System.out.println("4. Salir");
           System.out.println("Que deceas hacer?");
           
           anim = sn.nextInt();
           
            switch(anim){
               
                
                
 /*Crear Jaula*/    case 1:   System.out.println("Crear Jaula");
                   
                   
                   			int CrearJaula = 0;

	                   do {
                                System.out.println(" Creación de Jaulas ");
                                System.out.println(" ¿De que tamaño será la jaula ?");
                                System.out.println("1.Grande ");
                                System.out.println("2.Mediana");
                                System.out.println("3.Chica");
                                System.out.println("4. Cancela y volver atras ");
				

				CrearJaula = sn.nextInt();
                              
			switch (CrearJaula){
/* Tamaño de Jaula */
			case 1: System.out.println("Jaula Grande Creada");
                        
                       
                        
                        System.out.println ("Jaula creada");
                        
                        
                                
                        
                        break;
                        
                        case 2: System.out.println("Jaula Meiana creada ");
                        
                        
                        break;
                        
                        case 3: System.out.println("Jaula chica Creada "); 
                        
                        
                        break ;
                        default: System.out.println("Selecciono Volver Atras.");

			}

 

                         }while (CrearJaula < 3) ;

			break;
                    
                        
                        
                        
                        
 /*Meter Animal*/ case 2:  System.out.println("___________________________________________________________ ");
     
                        System.out.println("Meter animal dentro de Jaula");
 
 
                                        
                   
                    System.out.println("¿Que clase de Animal Quieres Meter?");
                   
                   
                   			int MeterAnimal = 0;

	do {
                             
                                                                           
                               
                               
                              
                                System.out.println("1.Carnivoro ");
                                System.out.println("2.Herviboro");
                                System.out.println("3. Cancelar y volver atras ");
				

				MeterAnimal = sn.nextInt();
                              
			switch (MeterAnimal){

	       case 1:       System.out.println("___________________________________________________________ ");
                             System.out.println(" Has Seleccionado Carnivoro");
                             System.out.println ("¿Que clase de Carnivoro quieres meter? ");
                        
                         int ClaseAnimal = 0;

	do {                                                
                                  
                                System.out.println("1. Tigre ");
                                System.out.println("2. Aguila ");
                                System.out.println("3. Lagarto");
                                System.out.println("4. Cancela y volver atras ");
				

				ClaseAnimal = sn.nextInt();
                              
			switch (ClaseAnimal){
                            
                            
                            
                            
                            
                            
/* ClaseAnimal*/
                            
                            
	         case 1: System.out.println("___________________________________________________________ ");
                         System.out.println("Haz Seleccionado tigre");
                         Tigre tg = new Tigre ();
                         objeto.agregarAnimal(tg);
                         System.out.println(jaula1.agregarAnimal(tg) == true ); // true
                         break;
                        
                 case 2: System.out.println("___________________________________________________________ ");
                         System.out.println(" Aguila ");
                        
                        Aguila Ag = new Aguila();
                        objeto.agregarAnimal(Ag);
                        System.out.println(jaula1.agregarAnimal(Ag) == true); // true
                        
                
                        break;
                        
                 case 3: System.out.println("haz Seleccionado lagarto "); 
                      
                        Lagarto lg = new Lagarto ();
                        objeto.agregarAnimal(lg);
                        System.out.println(jaula1.agregarAnimal(lg) == true); // true
                        
                        break ;
                        
               default: System.out.println("Volver Atras.");

			}

 

                         }while (ClaseAnimal < 4 ) ;

			break;

          case 2:              System.out.println("___________________________________________________________ ");
                               System.out.println (" ¿Que clase de Herviboro quieres meter?");
                       
                                int ClaseAni = 0;

	do {
                                System.out.println("1. Venado ");
                                System.out.println("2. Cebra ");
                                System.out.println("3. Unicornio ");
                                System.out.println("4. Cancela y volver atras ");
				

				ClaseAni = sn.nextInt();
               
         switch (ClaseAni){
                                                     
/* ClaseAnimal*/
			case 1: System.out.println("Haz Seleccionado Venado ");
                        
                                 Venado ven = new Venado ();
                                 objeto.agregarAnimal(ven);
                                 System.out.println(jaula1.agregarAnimal(ven) == true); // true
                                     
                                 break;
                        
                        case 2: System.out.println(" Cebra ");
                                Cebra C = new Cebra ();
                                objeto.agregarAnimal(C);
                                System.out.println(jaula1.agregarAnimal(C) == true); // true
    
                                 break;
                        
                        case 3: System.out.println(" Unicornio  "); 
                        
                                 Unicornio un = new Unicornio ();
                                 objeto.agregarAnimal(un);
                                 System.out.println(jaula1.agregarAnimal(un) == true); // true
                    
                                  break ;
                                  
                                  
                       default: System.out.println("Volver Atras ");

			}

 

                         }while (ClaseAni < 4) ;

			break;
                        
                        
                        default: System.out.println(" Volver Atras.");

			}

 

                               }while (MeterAnimal < 3) ;


                   break;
                
                  case 3:
                      
                   System.out.println(" Animales dentro de Jaula ");
         
                                            
                      jaula1.verJaula();
                      

                   break;
                case 4:
                   salir=true;
                   break;
                
                default:
                   System.out.println("Solo números entre 1 y 4");
           }
            
       }
       
       
   }   

   


   

  }




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Aguila extends Carnivoro {

    @Override
    public String chillar() {
        
        return "FIUUU FIUUUU ";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
public abstract class Animal {
    
   
    
        public abstract String chillar ();
   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
public abstract class Carnivoro extends Animal {
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Cebra extends Herbivoro {
    
    @Override 
    
    public String chillar () {
        
        return "ALEEEEEEEX : v " ;
    }
    
    
}

/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author cobi
     */
public abstract class Herbivoro extends Animal {
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Jaula extends Zoo {
     protected ArrayList<Jaula> Jaulita = new ArrayList<Jaula>();
    

   
    public void verJaula() {
         for (int i = 0; i < this.animalito.size(); i++) {
      Animal actual  = this.animalito.get(i);
      System.out.println(actual.chillar());
      
      
      
      
    }
   
    
    }
    
    
    
    public void AgregarJaula () {
        Jaula jaula1 = new Jaula();
            Jaula jaula2 = new Jaula();
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Lagarto  extends Carnivoro {

    @Override
    public String chillar() {
       return " GRRRISIS ";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Tigre extends Carnivoro {
    
    
    @Override 
    public String chillar() {
        System.out.println (" Tigre  ");
        return " GRRRRR  GRRRRR  ";
    }
    
}


/**
 *
 * @author cobi
 */
class Unicornio extends Herbivoro {
    @Override
  public String chillar() {
    // TODO Auto-generated method stub
    System.out.println(" [Unicornio] ");
     System.out.println(" ");
                        System.out.println(",=\\.-----\"\"\"\"^^==-  ");
                        System.out.println(" ;;'( ,___,,/~\\;   ");
                        System.out.println("  '  )/>/   \\|-,     ");
                        System.out.println("     | `\\    | \"    ");
                        System.out.println("     \"   \"   \"    ");
  
return " NIIII NIIII NIIIII i'm fucking Unicorn !! ";
      }
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobi
 */
class Venado extends Herbivoro {
    
    @Override 
    
    public String chillar () {
    
    return "BAMBIIII ";
}
}
