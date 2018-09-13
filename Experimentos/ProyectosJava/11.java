import java.util.ArrayList;
import java.util.Scanner;

/*@author daniel*/
public class Zoo {
     ArrayList<Animal> animales = new ArrayList<>();

     
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

    // la jaula no está vacía
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



    public static void main(String[] arg){
    Scanner sc=new Scanner(System.in);
    int op = 0;
    boolean salir=false;
    
        while(!salir){
            System.out.println("");
            System.out.println("\n ******Proyecto de Zoologico Daniel Rodriguez******");
            System.out.println("\n 1.- Agregar Jaula");
            System.out.println("\n 2.- Agregar un animal a la Jaula");
            System.out.println("\n 3.- Ver animales en las Jaulas");
            System.out.println("\n 4.- Salir ");
            System.out.println("\n Elija una opcion");
            System.out.println("*****************************************************");
            op= sc.nextInt();
            
            switch(op){
                
                case 1:
                    System.out.println("¿Que tipo de jaula desea agregar:");
                    
                        int CJaula = 0;
                        do{
                            System.out.println("\n Creacion de Jaulas");
                            System.out.println("\n 1.- Grande");
                            System.out.println("\n 2.- Mediana");
                            System.out.println("\n 3.- Chica");
                            System.out.println("\n Sino quiere Crear una Jaula: ");
                            System.out.println("\n 4.-volver al menu anterior");
                            System.out.println("");
                            
                            CJaula = sc.nextInt();
                            
                            
                            
                      switch(CJaula){ 
                          
                          case 1:
                              Jaula jaulaG = new Jaula();
                              System.out.println(jaulaG);
                              System.out.println("La jaula Grande a sido creada");
                              System.out.println("La Jaula se creo");
                              break;
                
                          case 2:
                              Jaula jaulaM = new Jaula();
                              System.out.println(jaulaM);
                              System.out.println("La Jaula Mediana a sido Creada");
                              System.out.println("La Jaula se creo");
                              break;
                
                          case 3:
                              Jaula jaulaC = new Jaula();
                              System.out.println(jaulaC);
                              System.out.println("La Jaula Chica a sido Creada");
                              System.out.println("La Jaula se creo");
                              break;
                
                          default:
                              System.out.println("A decidido volver Atras");
                              
                            }
                        }while (CJaula <= 3);
                            break;
            
                        
                        
                        
                        
                case 2:
                    System.out.println("Agregar Animales");
                    int CAnimal = 0;
                    
                    do{
                        System.out.println("\n Que tipo de animal quieres agregar? ");
                        
                        System.out.println("\n 1.- Carnivoro");
                        System.out.println("\n 2.- Herbivoro");
                        System.out.println("\n 3.- Volver al menu anterior");
                        CAnimal = sc.nextInt();
                        
                    switch(CAnimal){
                        case 1:
                            System.out.println("\n Agrega Animales Carnivoros");
                            System.out.println("\n Que Animal quieres agregar: ");
                        
                        do{
                           System.out.println("\n 1.-Leon");
                           System.out.println("\n 2.-Tigre");
                           System.out.println("\n 3.-Hiena");
                           System.out.println("\n 4.- Volver al menu anterior");
                           CAnimal = sc.nextInt();
                           
  
                    switch(CAnimal){       
                        
                        case 1:
                            System.out.println("El leon a sido creado");
                            Leon leon1 = new Leon();
                            Jaula jaulaC1 = new Jaula ();
                            System.out.println(jaulaC1);
                            System.out.println(leon1);
                            break;
                
                        case 2:
                            System.out.println("El tigre a sido creado");
                            Tigre tigre1 = new Tigre();
                            System.out.println(tigre1);
                        break;
                        
                        case 3:
                            System.out.println("L a Hiena a sido creada");
                            Hiena hiena1 = new Hiena();
                            System.out.println(hiena1);
                        
                        default:
                            System.out.println("A decidido volver Atras");
                            }
                        
                        }while (CAnimal <= 3 );
                            break;
                            
                        case 2:
                            System.out.println("\n Agregar Animales Herbivoros");
                            System.out.println("\n que animal quieres crear?");
                            
                            do{
                            System.out.println("\n 1.- Vaca");
                            System.out.println("\n 2.- Pato");
                            System.out.println("\n 3.- Cebra");
                            System.out.println("\n 4.- Volver al menu anterior");
                            CAnimal = sc.nextInt();
                            
                            
                        switch(CAnimal){    
                            
                        case 1:
                            System.out.println("La Vaca a sido creada");
                            
                            Vaca vaca1 = new Vaca();
                            System.out.println(vaca1);
                            break;
                
                        case 2:
                            System.out.println("El Pato a sido creado");
                            Pato pato1 = new Pato();
                            System.out.println(pato1);
                            break;
                        
                        case 3:
                            System.out.println("La Cebra a sido creada");
                            Cebra cebra1 = new Cebra();
                            System.out.println(cebra1);
                        
                        default:
                            System.out.println("A decidido volver Atras");
                            
                            }
                        }while (CAnimal <= 3 );
                            break;
                    }
                        }while (CAnimal <= 3 );
                            break;
                    
    
                            
                            
                            
                case 3:
                    System.out.println("Ver Animales en las jaulas");
                    int vAnimales = 0;
                    
                    do{
                       System.out.println("Que animal quieres ver? ");
                       System.out.println("\n 1.- Carnivoros");
                       System.out.println("\n 2.- Herbivoros");
                       System.out.println("\n 3.- Regresar al menu anterior");
                       vAnimales = sc.nextInt();
                       
                    switch (vAnimales){
                        case 1:
                            System.out.println("\n Estas viendo a los Animales Carnivoros");
                            System.out.println("\n Leon");
                            System.out.println(Leon.class);
                            System.out.println("\n ¡RUUUUUAAAAGHHH!");
                            System.out.println("*****************************************");
                            System.out.println("\n Tigre");
                            System.out.println(Tigre.class);
                            System.out.println("¡RUAAAAAGHH");
                            System.out.println("*****************************************");
                            System.out.println("\n Hiena");
                            System.out.println(Hiena.class);
                            System.out.println("¡JIJIJIJIJI!");
                            System.out.println("*****************************************");
                            break;
                            
                        case 2: 
                            System.out.println("Estas viendo a los Animales Herbivoros");
                            System.out.println("\n Vaca");
                            System.out.println(Vaca.class);
                            System.out.println("¡MUUUUHH!");
                            System.out.println("*****************************************");
                            System.out.println("\n Pato");
                            System.out.println(Pato.class);
                            System.out.println("¡CUUAAK!");
                            System.out.println("*****************************************");
                            System.out.println("\n Cebra");
                            System.out.println(Cebra.class);
                            System.out.println("¡JAJAJAJA!");
                            System.out.println("*****************************************");
                            break;
                            
                        default:System.out.println("A decidido volver Atras");
                    }
                    }while(vAnimales <= 3);
                    break;
                    
                    
                    
                    
                    
                case 4:
                    System.out.println("Adios");
                    salir = true;
                    break;
            }
                    }
        }
        }

/*@author daniel*/
public abstract class Animal {
    
    public abstract String emitirSonido();

    }



/*@author daniel*/
public abstract class Carnivoro extends Animal{
    
}


/*@author daniel*/
class Cebra extends Herbivoro{

    @Override
    public String emitirSonido() {
        return "¡JAJAJAJA!";
    }
    
}


/*@author daniel*/
public abstract class Herbivoro extends Animal{
    
}


/*@author daniel*/
class Hiena extends Carnivoro{

    @Override
    public String emitirSonido() {
        
        return "¡JIJIJIJIJI!";
    }
    
}


/*@author daniel*/
class Jaula extends Zoo{

    public void verJaula() {
    for (int i = 0; i < this.animales.size(); i++) {
      Animal actual = this.animales.get(i);
      System.out.println(actual.emitirSonido());
    }   
}
    public static void main(String[] args) {
        //Carnivoros
        Leon leon1 = new Leon();
        Tigre tigre1 = new Tigre();
        Hiena hiena1 = new Hiena();
        //Herbivoros
        Cebra cebra1 = new Cebra();
        Vaca vaca1 = new Vaca();
        Pato pato1 = new Pato();
    
        //Jaula Carnivoros
    Jaula jaulaC1 = new Jaula();
    Jaula jaulaC2 = new Jaula();
    Jaula jaulaC3 = new Jaula();
    
        //Jaula herbivoros
    Jaula jaulaH1 = new Jaula();
    Jaula jaulaH2 = new Jaula();
    Jaula jaulaH3 = new Jaula();

    System.out.println(jaulaC1.agregarAnimal(leon1) == true); // true
    System.out.println(jaulaC2.agregarAnimal(tigre1) == false); // false
    System.out.println(jaulaC3.agregarAnimal(hiena1)== true);
    
    System.out.println(jaulaH1.agregarAnimal(vaca1) == true); // true
    System.out.println(jaulaH2.agregarAnimal(pato1) == false); // false
    System.out.println(jaulaH3.agregarAnimal(cebra1) == false);
    
    //Carnivoros
    jaulaC1.verJaula();
    jaulaC2.verJaula();
    jaulaC3.verJaula();

    
    //Herbivoros
    jaulaH1.verJaula();
    jaulaH2.verJaula();
    jaulaH3.verJaula();
  }

}


/*@author daniel*/
class Leon extends Carnivoro{

    @Override
    public String emitirSonido() {
        
        return "¡RUUUUUAAAAGHHH!";
    }
    
}


/*@author daniel*/
class Pato extends Herbivoro{

    @Override
    public String emitirSonido() {
        return "¡CUUAAK!";
    }
    
}


/*@author daniel*/
class Tigre extends Carnivoro{

    @Override
    public String emitirSonido() {
        
        return "¡RUAAAAAGHH";
    }
    
}


/*@author daniel*/
class Vaca extends Herbivoro{

    @Override
    public String emitirSonido() {
        
        return "¡MUUUUHH!";
    }
    
    
}
