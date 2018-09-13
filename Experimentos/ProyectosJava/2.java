import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


public class Zoo {

    protected ArrayList<Animal> animal = new ArrayList<Animal>();
    
        

    

   public boolean agregarAnimal(Animal animal) {
    if (this.animal.size() == 0) { // jaula vacía
      this.animal.add(animal);
      return true;
    }

    // la jaula no está vacía
    Animal primerAnimal = this.animal.get(0);
    if (primerAnimal instanceof Herbivoro) {
      if (animal instanceof Herbivoro) { // no hay problema
        this.animal.add(animal);
        return true;

        
      } else if (animal instanceof Carnivoro) {
        return false;
        
      }
    } else if (primerAnimal instanceof Carnivoro) {
      if (animal instanceof Herbivoro) {
        return false;
      }

      if (primerAnimal.getClass() == animal.getClass()) {
        this.animal.add(animal);
        
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
           System.out.println(" Zoologico Amigos de los Animales ");
           System.out.println("Bienvenido al Sistema de Zoo");
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
                                System.out.println("1. Chica");
                                System.out.println("2. Mediana");
                                System.out.println("3. Grade");
                                System.out.println("4. Cancela y volver atras ");
				

				CrearJaula = sn.nextInt();
                              
			switch (CrearJaula){
/* Tamaño de Jaula */
			case 1: System.out.println("Jaula Chica Creada");
                        
                       
                        
                        System.out.println ("Jaula creada");
                        
                        
                                
                        
                        break;
                        
                        case 2: System.out.println("Jaula Mediana creada ");
                        
                        
                        break;
                        
                        case 3: System.out.println("Jaula Grande Creada "); 
                        
                        
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
                         System.out.println("Haz Seleccionado Tigre");
                         Tigre tig = new Tigre ();
                         objeto.agregarAnimal(tig);
                         System.out.println(jaula1.agregarAnimal(tig) == true ); // true
                         break;
                        
                 case 2: System.out.println("___________________________________________________________ ");
                            
                         System.out.println(" Haz seleccionado Aguila ");
                        
                        Aguila Agui = new Aguila();
                        objeto.agregarAnimal(Agui);
                        System.out.println(jaula1.agregarAnimal(Agui) == true); // true
                        
                
                        break;
                        
                 case 3: System.out.println("______________________________________________________________");
                        System.out.println("Haz Seleccionado Lagarto "); 
                         
                        Lagarto lag = new Lagarto ();
                        objeto.agregarAnimal(lag);
                        System.out.println(jaula1.agregarAnimal(lag) == true); // true
                        
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
                                System.out.println("3. Vaca");
                                System.out.println("4. Cancela y volver atras ");
				

				ClaseAni = sn.nextInt();
               
         switch (ClaseAni){
                                                     
/* ClaseAnimal*/
			case 1: System.out.println("Haz Seleccionado Venado ");
                        
                                 Venado vena = new Venado ();
                                 objeto.agregarAnimal(vena);
                                 System.out.println(jaula1.agregarAnimal(vena) == true); // true
                                     
                                 break;
                        
                        case 2: System.out.println(" Haz Seleccionado Cebra ");
                                Cebra Ceb = new Cebra ();
                                objeto.agregarAnimal(Ceb);
                                System.out.println(jaula1.agregarAnimal(Ceb) == true); // true
    
                                 break;
                        
                        case 3: System.out.println(" Haz Seleccionado Vaca  "); 
                        
                                 Vaca vac = new Vaca ();
                                 objeto.agregarAnimal(vac);
                                 System.out.println(jaula1.agregarAnimal(vac) == true); // true
                    
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
                   System.out.println("Solo las opciones que se te dan.");
           }
            
       }
       
       
   }   

    private void agregarAnimal(Vaca vac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


   

  }

    
    




class Aguila extends Carnivoro {
    @Override
    public String chillar(){
        return "FIUUUUUUUUU";
    }
}




public abstract class Animal {
    
    
    public abstract String chillar();
}




public abstract class Carnivoro extends Animal{
    
}




class Cebra extends Herbivoro{
    @Override
    public String chillar(){
        return "MUEEEEEEEEE";
    }
    
}




public abstract class Herbivoro extends Animal {
    
}



class Jaula extends Zoo {
    protected ArrayList<Jaula> jaula = new ArrayList<Jaula>();
    
    public void verJaula(){
        for(int i = 0; i <this.animal.size(); i++ ){
           Animal actual = this.animal.get(i);
           System.out.println(actual.chillar());
        }
    }

    boolean agregarAnimal(Vaca vac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}




class Lagarto extends Carnivoro {
    @Override
    public String chillar(){
        return "TSSSSSSSSSS";
    }
    
}




class Tigre extends Carnivoro {
    @Override
    public String chillar(){
        return "GRRRRRR";
    }
    
}




class Vaca extends Herbivoro {
    @Override
    public String chillar(){
        return "MUUUUUUUUU";
    }
    
}




class Venado extends Herbivoro {
    @Override
    public String chillar(){
        return "BRRRRRRR";
    }
}
