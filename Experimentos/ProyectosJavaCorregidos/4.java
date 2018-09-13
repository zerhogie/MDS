import java.util.Scanner;
import java.util.Scanner;
public class Zoologico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
               jaula ja = new jaula();
               animal ani = new animal();
       //apegarse mas a lo que quiere el maestro en el problema de emminus
       System.out.println("Bienvenidos al zoologico de redes y servicios de computo.");
        int respuesta;
       do{  
           System.out.println("*****************************");
           System.out.println("Por favor seleccione la opcion que usted desea.");
           System.out.println("1.-Animales del Zoologico**");
           System.out.println("2.-informacion sobre tamaños de jaulas**");
           System.out.println("3.-Agregar jaula");
           System.out.println("4.-Agregar animal");
           System.out.println("5.-ver jaulas con los animales");
           System.out.println("6.- Salir");
           System.out.println("*****************************");
           System.out.print("su respuesta: ");
           respuesta = sc.nextInt();
           switch(respuesta){
               case 1:
                  ja.mostrarAnimales();
                   break;
                          
               case 2: 
                   ja.espacio();
                   break;
               case 3:
                    ja.agregarJaula();
                   break;
               case 4:
                   ja.agregarAnimal();
                   break;
               case 5:
                   ja.mostrarJaulas();
                   break;
            }
       }while(respuesta !=6);
       System.out.println("Muchas gracias por su visita...");
       System.out.println("Saliendo del programa...");
       System.out.println("Alumno José Rafael Carmona Hernandez.");
       System.out.println("Redes y servicios de computo");
    }
    
  
   
}
public  class animal{
    public void mostrarEspacioCarnivoro(){
        carnivoro carni = new carnivoro() {};
        System.out.println("Los animales carnivoros del  zoologico con: ");
                carni.MostrarCarnivoros();
    }
  
    public void mostrarEspacioHerbivoro(){
     herbivoro herbi = new herbivoro() {};
             System.out.println("Los animales herbivoros del  zoologico con: ");
             herbi.mostrarHerbivoros();
    }
    
}

class Cabra extends herbivoro{
    public void emitirSonido(){
        System.out.println("¡BEEEE BEEEEE!");
    }
}


public abstract class carnivoro extends animal{
        private String especie;
        private double espacio;
        public void MostrarCarnivoros(){
            //investigar cuanto mide cada animal
            System.out.println("Leon: animal muy territorial, animal un poco grande");
            Leon le = new Leon();
            le.emitirSonido();
            System.out.println("Tigre: buenos para pelear, animal de mediana estatura");
            Tigre ti = new Tigre();
            ti.emitirSonido();
            System.out.println("Lobo: animal un poco pequeño pero feroz y mortal");        
            Lobo lo = new Lobo();
            lo.emitirSonido();
        }
        
}


class Cebra {
    public void emitirSonido(){
        System.out.println("¡JIJIJIJIIJIJIJIJ!");
    }
}


class Elefante extends herbivoro{
    public void emitirSonido(){
        System.out.println("¡pwet!");
    }
}

public abstract class herbivoro extends animal{
        private String especie;
        private double espacio;
        
        public void mostrarHerbivoros(){
          System.out.println("Elefante: muy grande.");
          Elefante el = new Elefante();
          el.emitirSonido();
          System.out.println("Cebra: mediano");
          Cebra ce = new Cebra();
          ce.emitirSonido();
          System.out.println("Cabra: animal pequeño a comparacion de los otros dos.");
          Cabra ca = new Cabra();
          ca.emitirSonido();
        }
}


class jaula {
    animal ani = new animal();
    Leon le = new Leon();
    Tigre ti= new Tigre();
    Lobo lo = new Lobo();
    Elefante el = new Elefante();
    Cebra ce = new Cebra();
    Cabra ca = new Cabra();
    Scanner sc =  new Scanner(System.in);
    private int herbivo[][]= new int [4][3];
    private int carni[][]=new int [4][3];
    private int he;
    private int numJa;
    private int pos;
    private String animal;
    public void agregarAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que tipo de animal quiere agregar?");
        System.out.println("1.Herbivoros       2.-Carnivoros");    
        int herca = sc.nextInt();
        //ingresar herbivoros a la jaula
        if(herca==1){
           System.out.println("Ingresa el numero de la jaula que acabas de crear");
           int numJa= sc.nextInt();
           System.out.println("¿Cuantos animales estan en la jaula?");
           System.out.println("si no has agregado algun animal ingresa cero, de lo contrario ingresa 1");
           int pos = sc.nextInt();
           System.out.println("Ingresa el animal que deseas meter en la jaula: ");
           System.out.println("1.-Elefante  2.-Cebra    3.-Cabra");
           int he = sc.nextInt();
           if(numJa==3){
              if(he<3){
               System.out.println("El animal no cabe, es muy chica la jaula");
               while(he<3){
                   System.out.println("Solo puedes ingresar este animal en esta jaula");
                   System.out.println("3.-Cabra");
                   he= sc.nextInt();
                    System.out.println("Ingresando animal a la jaula: " + numJa);
                          
               }
               herbivo[numJa][pos]=he;
              }
           }else{
               if(numJa==2){
                  if(he<2){
                   System.out.println("El animal no cabe, la caja es mediana.");
                   while(he<2){
                   System.out.println("Solo puedes ingresar estos  animales a la jaula");
                   System.out.println("2.-Cebra     3.-Cabra");
                   he= sc.nextInt();
                   System.out.println("Ingresando animal a la jaula: " + numJa);
                  }
                   herbivo[numJa][pos]=he;
               }
               }else{
                   if(numJa==1){
                      System.out.println("Ingresando animal a la jaula");
                      herbivo[numJa][pos]=he;
                   }
               }
           }
           
           //herbivo[numJa][pos]=sc.nextInt();
           System.out.println("");
      
        }
        //ingresar carnivoros a la jaula
        if(herca==2){
            numJa=0;
            pos=0;
            System.out.println("Agregar animal Carnivoro");
            System.out.println("Ingresa el numero de la jaula que acabas de crear");
            int numJa= sc.nextInt();
            System.out.println("¿Cuantos animales estan en la jaula?");
            System.out.println("si no has agregado algun animal ingresa cero, de lo contrario ingresa 1");
            int pos = sc.nextInt();
            System.out.println("Ingresa el animal que deseas meter en la jaula: ");
            System.out.println("1.-Leon     2.-Tigre    3.-Lobo");
            carni[numJa][pos]= sc.nextInt();
            if(pos==1){
                 while(carni[numJa][0]!=carni[numJa][1]){
                    System.out.println("¡ALERTA! NO SE PUEDE METER ESPECIES DISTINTAS DE CARNIVOROS...");
                   System.out.println("1.-Leon     2.-Tigre    3.-Lobo");
                    carni[numJa][1]= sc.nextInt();
                }
            }
            System.out.println("Animal agregado a la jaula numero: " + numJa);
        }
       
   
    }
      //aqui agregaremos una jaula y nos ayudaremos con el numero que  vaen aumento de acuerdo a las jaulas que  van metiendo
    public void agregarJaula(){
      System.out.println("Solo puede meter dos animale ");
      System.out.println("¿Para que tipo de animal vas a crear la jaula?");
      System.out.println("1.-Carnivoro      2.-Herbivoro");
      int respuesta=sc.nextInt();
      //creando jaulas para carnivoros
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
            System.out.println("1.-Grande   2.-Mediana  3.-Chica");
            respuesta = sc.nextInt();
            if(respuesta==1){
                String herbivo [][] = new String [1][1];
                System.out.println("Se creo una jaula Grande...");
                System.out.println("Tu jaula es la numero 1");
            }
            if(respuesta==2){
                String herbivo [][] = new String [2][1];
                System.out.println("Se creo una jaula mediana...");
                System.out.println("Tu jaula es la numero 2");
            }
            if(respuesta==3){
                String herbivo [][] = new String [3][1];
                System.out.println("Se creo una jaula chica...");
                System.out.println("Tu jaula es la numero 3");
            }
      }
      System.out.println("");
      
    }
    //****************************************************+++
    public void mostrarAnimales(){
       System.out.println("Animales carnivoros: ");
       ani.mostrarEspacioCarnivoro();
       System.out.println("");
       System.out.println("Animales herbivoros: ");
       ani.mostrarEspacioHerbivoro();
       System.out.println("");
    }

  //**********************************************************+
    public void espacio(){
        //muestra el tamaño de las jaulas que estan disponibles dentro del zoologico
        System.out.println("Jaulas: ");
        System.out.println("1.-jaula chica");
        System.out.println("La jaula mide 8.0 metros cuadrados perfecta para animales de especies pequeñas.");
        System.out.println("2.-jaula mediana");
        System.out.println("La jaula mide 32.0 metros cuadrados perfecta para animales de especies Medianas.");
        System.out.println("3.-jaula grande");
        System.out.println("La jaula mide 105 metros cuadrados perfecta para animales de mayor tamaño");
        System.out.println("******************************");
     }
    //********************************************************
    public void mostrarJaulas(){
          System.out.println("¿Que jaulas quieres ver?");
          System.out.println("1.Carnivoros      2.-Herbivoros");
          int respuesta= sc.nextInt();
          if(respuesta==1){
               System.out.println("ingresa el numero de jaula  que  quieras ver: ");
                respuesta = sc.nextInt();
                for(int i=0;i<=respuesta;i++){
                    if(carni[respuesta][i]==1){
                        System.out.println("Leon");
                        le.emitirSonido();
                    }else{
                    
                    }
                    if(carni[respuesta][i]==2){
                        System.out.println("Tigre");
                        ti.emitirSonido();
                    }
                    if(carni[respuesta][i]==3){
                        System.out.println("Lobo");
                        lo.emitirSonido();
                    }
                    
                }
          }   
          if(respuesta==2){
                System.out.println("ingresa el numero de jaula  que  quieras ver: ");
                respuesta = sc.nextInt();
                for(int i=0;i<=respuesta;i++){
                    if(herbivo[respuesta][i]==1){
                        System.out.println("Elefante");
                        el.emitirSonido();
                    }else{
                    
                    }
                    if(herbivo[respuesta][i]==2){
                        System.out.println("Cebra");
                        ce.emitirSonido();
                    }
                    if(herbivo[respuesta][i]==3){
                        System.out.println("Cabra");
                        ca.emitirSonido();
                    }  
                }
          }
          
    }
 }


class Leon extends carnivoro{

    public void emitirSonido(){
        System.out.println("¡RUAAAAAAHHHHHHH!");
    }
}


class Lobo extends carnivoro{
    public void emitirSonido(){
        System.out.println("¡AUUUUUUUUUHHHHHHHHH!");
    }
}


class Tigre extends carnivoro{
    public void emitirSonido(){
        System.out.println("¡grrrrrrrrr!");
    }
}
