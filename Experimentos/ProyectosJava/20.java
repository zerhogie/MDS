import java.util.Scanner;
import java.util.Scanner;
public class Zoologico3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //mis objetos
               jaula nj = new jaula();
               animal na = new animal();
       //mi listas de opciones  
       System.out.println("ENTRANDO AL ZOOLOGICO");
        int respuesta;
       do{  
          
           System.out.println("******SELECCIONE UNA OPCION*****");
           System.out.println("1.-ANIMALES");
           System.out.println("2.-JAULAS");
           System.out.println("3.-AGREGAR JAULA");
           System.out.println("4.-AGREGAR ANIMAL");
           System.out.println("5.-VER ANIMALES ENJAULADOS");
           System.out.println("6.- ******Salir*****");
           System.out.print("OPCION SELECCIONADA ");
           respuesta = sc.nextInt();
           switch(respuesta){
               case 1:
                  nj.verAnimales();
                   break;
                          
               case 2: 
                   nj.espacio();
                   break;
               case 3:
                    nj.agregarJaula();
                   break;
               case 4:
                   nj.agregarAnimal();
                   break;
               case 5:
                   nj.verJaulas();
                   break;
            }
       }while(respuesta !=6);
       
       System.out.println("SALIENDO DE ZOOLOGICO");
       
    }
    
  
   
}

class animal {
      public void jaulaCarnivoros(){
        car carnivoros = new car();
        System.out.println("Animales Carnivoros enjaulados");
                carnivoros.verCarnivoros();
    }
  
    public void jaulaHerbivoro(){
     her herbivoros = new her();
             System.out.println("Animales Herbivoros enjaulados");
             herbivoros.verHerbivoros();
    }

    void VerCarnivoro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void verHerbivoro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa
 */
class c {

    static void mostrarCarnivoros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



class car {

    static void verCarnivoros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      private String especie;
        private double espacio;
        public void VerCarnivoros(){
            //investigar cuanto mide cada animal
            System.out.println("puma-Animal de mediana estatura y territorial");
            puma pu= new puma();
            pu.emitirSonido();
            System.out.println("oso- animal grande  come puro pezcado");
            oso os = new oso();
            os.emitirSonido();
            System.out.println("lagarto- animal de sangre fria  y pequeña estatura");        
            lagarto la = new lagarto();
            la.emitirSonido();
        }
}


class cebra {
     public void emitirSonido(){
        System.out.println("jiijiiijiiiiijijijijijiji");
    }
}


class foca {
     public void emitirSonido(){
        System.out.println("ajoouuuuu ajouuuuuu");
    }
}



class her {

 
    private String especie;
        private double espacio;
        
        public void verHerbivoros(){
          System.out.println("jirafa- animal muy grande");
          jirafa ji = new jirafa();
          ji.emitirSonido();
          System.out.println("foca-animal pequeño ");
          foca fo = new foca();
          fo.emitirSonido();
          System.out.println("Cabra: animal pequeño a comparacion de los otros dos.");
          cebra ce= new cebra();
          ce.emitirSonido();
        }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa
 */
class herbivoro {
    
}


class jaula {
    animal animal = new animal();
   puma pu = new puma();
    oso os= new oso();
    lagarto la = new lagarto();
    jirafa ji = new jirafa();
    foca fo = new foca();
    cebra ce = new cebra();
    
    Scanner sc =  new Scanner(System.in);
    // utilizare matrices en este caso busque en internet y se me hizo mas facil y un compañero me ayudo en este caso 
    private int her[][]= new int [4][3];
    private int car[][]=new int [4][3];
    private int herv;
    private int numJa;
    private int posicion;
    private String anim;
    public void agregarAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que tipo de animal quiere agregar?");
        System.out.println("1.Herbivoros       2.-Carnivoros");    
        int herca = sc.nextInt();
      
        if(herca==1){
           System.out.println("Ingresa el numero de la jaula que acabas de crear");
           int numJa= sc.nextInt();
           System.out.println("¿Animales existentes en jaula?");
           System.out.println("agragar animal 1");
           int pos = sc.nextInt();
           System.out.println("Ingresa el animal que deseas meter en la jaula: ");
           System.out.println("1.jirafa  2.-Cebra    3.-foca");
           int he = sc.nextInt();
           if(numJa==3){
              if(he<3){
               System.out.println("El animal no cabe, es muy chica la jaula");
               while(he<3){
                   System.out.println("Solo puedes ingresar este animal en esta jaula");
                   System.out.println("3.-foca");
                   he= sc.nextInt();
                    System.out.println("Ingresando animal a la jaula: " + numJa);
                          
               }
               her[numJa][pos]=he;
              }
           }else{
               if(numJa==2){
                  if(he<2){
                   System.out.println("El animal no cabe, la caja es mediana.");
                   while(he<2){
                   System.out.println("Solo puedes ingresar estos  animales a la jaula");
                   System.out.println("2.-cebra     3.-foca");
                   he= sc.nextInt();
                   System.out.println("Ingresando animal a la jaula: " + numJa);
                  }
                   her[numJa][pos]=he;
               }
               }else{
                   if(numJa==1){
                      System.out.println("Ingresando animal a la jaula");
                      her[numJa][pos]=he;
                   }
               }
           }
           
          
           System.out.println("");
      
        }
      
        if(herca==2){
            numJa=0;
            posicion=0;
            System.out.println("Agregar nuevo animal carnivoro");
            System.out.println("numero de jaula Creada");
            int numJa= sc.nextInt();
            System.out.println("¿Cuantos animales existen  en la jaula?");
            System.out.println("para ingresar animal escribe 1");
            int pos = sc.nextInt();
            System.out.println("Ingresa el animal que deseas meter en la jaula: ");
            System.out.println("1.-puma     2.-oso    3.-lagarto");
            car[numJa][pos]= sc.nextInt();
            if(pos==1){
                 while(car[numJa][0]!=car[numJa][1]){
                    System.out.println("No se pueden meter diferentes especies en las jaulas");
                   System.out.println("1.-puma     2.-oso    3.-lagarto");
                    car[numJa][1]= sc.nextInt();
                }
            }
            System.out.println("Animal agregado a la jaula numero: " + numJa);
        }
       
   
    }
      
    public void agregarJaula(){
      System.out.println("Solo puede meter  tres  animale ");
      System.out.println("¿Para que tipo de animal?");
      System.out.println("1.-Carnivoro      2.-Herbivoro");
      int respuesta=sc.nextInt();
     
      if(respuesta==1){
            System.out.println("¿Qué jaulas  quieres agregar?: ");
            System.out.println("1.-Grande   2.-Mediana  3.-Chica");
            respuesta = sc.nextInt();
            if(respuesta==1){
                String carni [][] = new String [1][1];
                System.out.println("Se creo una jaula Grande...");
                System.out.println("Tu jaula es la numero 1");
            }
            if(respuesta==2){
                String hcarni [][] = new String [2][1];
                System.out.println("Se creo una jaula mediana...");
                System.out.println("Tu jaula es la numero 2");
            }
            if(respuesta==3){
                String carni [][] = new String [3][1];
                System.out.println("Se creo una jaula chica...");
                System.out.println("Tu jaula es la numero 3");
            }
      }
      //creando jaulas para herbivoros
      if(respuesta==2){
            System.out.println("¿Qué jaulas  quieres agregar?: ");
            System.out.println("1.-Chica   2.-Mediana  3.-Grande");
            respuesta = sc.nextInt();
            if(respuesta==1){
                String herbivo [][] = new String [1][1];
                System.out.println("Se a creado una jaula Chica");
                System.out.println("Tu jaula es la numero 1");
            }
            if(respuesta==2){
                String herbivo [][] = new String [2][1];
                System.out.println("Se creo una jaula Medeiana");
                System.out.println("Tu jaula es la numero 2");
            }
            if(respuesta==3){
                String herbivo [][] = new String [3][1];
                System.out.println("Se a creado una jaula Grnde");
                System.out.println("Tu jaula es la numero 3");
            }
      }
      System.out.println("");
      
    }

    public void verAnimales(){
       System.out.println("Animales carnivoros: ");
       animal.VerCarnivoro();
       System.out.println("");
       System.out.println("Animales herbivoros: ");
       animal.verHerbivoro();
       System.out.println("");
    }


    public void espacio(){
        //muestra el tamaño de las jaulas que estan disponibles dentro del zoologico
        System.out.println("Tamaño de jaulas");
        System.out.println("1.-jaula chica 80m");
        System.out.println("La jaula es para animales pequeños ");
        System.out.println("2.-jaula mediana 150m");
        System.out.println("La jaula es para animales de tamaño mediano");
        System.out.println("3.-jaula grande 300m");
        System.out.println("La jaula es para animales de tamaño grande");
        
     }
  
    public void verJaulas(){
          System.out.println("¿Que Tipos de animales que deseas ver?");
          System.out.println("1.Carnivoros      2.-Herbivoros");
          int respuesta= sc.nextInt();
          if(respuesta==1){
               System.out.println("¿Que jaula quieres ver?");
                respuesta = sc.nextInt();
                for(int i=0;i<=respuesta;i++){
                    if(car[respuesta][i]==1){
                        System.out.println("oso");
                        os.emitirSonido();
                    }else{
                    
                    }
                    if(car[respuesta][i]==2){
                        System.out.println("puma");
                        pu.emitirSonido();
                    }
                    if(car[respuesta][i]==3){
                        System.out.println("lagarto");
                        la.emitirSonido();
                    }
                    
                }
          }   
          if(respuesta==2){
                System.out.println("¿Que jaula quieres ver?");
                respuesta = sc.nextInt();
                for(int i=0;i<=respuesta;i++){
                    if(her[respuesta][i]==3){
                        System.out.println("jirafa");
                        ji.emitirSonido();
                    }else{
                    
                    }
                    if(her[respuesta][i]==2){
                        System.out.println("cebra");
                        ce.emitirSonido();
                    }
                    if(her[respuesta][i]==1){
                        System.out.println("foca");
                        fo.emitirSonido();
                    }  
                }
          }
          
    }
 }


class jirafa {
     public void emitirSonido(){
        System.out.println("jipffjipff");
    }
}


class lagarto {
     public void emitirSonido(){
        System.out.println("gluglugluuugluu");// se esta sumergiendo bajo el agua
    }
}


class oso {
     public void emitirSonido(){
        System.out.println("grrrrrr grrrr grrrr grrrr");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class puma {
    public void emitirSonido(){
        System.out.println("ruaaaaarrrr ruaarrrrr");
    } 
}
