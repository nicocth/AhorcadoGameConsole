/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadogame;

/**
 * Esta clase modelara el juego del ahorcado
 * 
 * @author Nicolás Calderón Torres
 * @version 1
 */
import java.util.Random;//libreria necesaria para generar numero aleatorio
import java.util.Scanner;

public class Juego
{
    // instance variables
    private String[] mensaje = 
    {"Ohhhhh... Lo siento, has perdido","Última vida. Ya no puedes fallar", "Focus, focus... que no es tan difícil", "¡Una vida menos!",
     "Concéntrate se te acaban las vidas", "No te apresures aun te quedan varios intentos", "Piensa antes de escribir. Las vidas son algo muy preciado",
     "Las mismas que tiene un gato"};
    private Palabra palabraSecreta;
    private Palabra[] palabras;
    private Jugador jugador;
    private char[] letras;
    private char[] letrasCorrectas;
    private int digitosPS;
    private int digitosCorrectosPS;
    private Scanner teclado;
    private Random random;
    /**
     * Constructor para la clase Juego
     */
    public Juego()
    {
        // initialise instance variables
         this.palabras = new Palabra[8];
         teclado = new Scanner(System.in);
         random = new Random();
         generarPalabras();
         elegirPalabraSecretaAleatoriamente();
         cargarDatos();
         
    }

    /**
     * Metodo que añade las posibles palabras ocultas al juego
     */
    public void generarPalabras()
    {
         palabras[0] = new Palabra("EXAMEN");
         palabras[1] = new Palabra("ORDENADOR");
         palabras[2] = new Palabra("PROGRAMACION");
         palabras[3] = new Palabra("COMENTARIO");
         palabras[4] = new Palabra("MOCHILA");
         palabras[5] = new Palabra("RATON");
         palabras[6] = new Palabra("CURSOR");
         palabras[7] = new Palabra("INSTITUTO");
    }
    
    /**
     * Metodo que extrae de forma aleatoria una de las palabras del array palabras
     * @return palabra del array palabras
     */
    public Palabra elegirPalabraSecretaAleatoriamente()
    {
        //definimos el atributo palabra secreta usando una palabra del array palabras
        palabraSecreta = palabras[random.nextInt(8)];// nos crea un numero aleatorio de 0 a 7.
        return palabraSecreta;
        
    }
    
     /**
     * Metodo que cuenta los digitos de la palabra cargada, transforma la palabra secreta a un array y lo almacena en letras y crea en letrasCorrectas
     * un array de la misma longitud que la palabra secreta donde todos sus caracteres son guiones bajos.
     */
    public void cargarDatos()
    {
        String texto = palabraSecreta.toString();
        digitosPS = texto.length(); //asignamos la longitud del a palabra secreta
        this.letras = new char[digitosPS];//definimos array segun longitud de la palabra
        for (int i = 0; i < digitosPS; i++){
            letras[i] = texto.charAt(i);//almacenamos en cada campo un caracter de la palabra secreta
        }
        this.letrasCorrectas = new char[digitosPS];
        for (int i = 0; i < digitosPS; i++){
            letrasCorrectas[i] = '_';
        }
    }
    
     /**
     * Este metodo almacenara y mostrara las letras que el usuario va introduciendo, mostrara el progreso de la resolucion de la palabra y un mensaje
     * personalizado segun el numero de vidas que le quede al usuario despues de cada intento.
     */
    public void jugar(Jugador jugador)
    {
        char intentos[] = new char[40];
        int numIntentos = 0;
        char opcion;
        boolean acierto;
        boolean fin = false;
        String concat = "";
        String palabraAdivinada = "";
        do{
            acierto = false;
            concat = "";
            System.out.println("\nEsta es la palabra secreta que teneis que adivinar\n");//Explicacion del juego al usuario
            for (int i = 0; i < digitosPS; i++){
                System.out.print(letrasCorrectas[i]);
            }
            System.out.println("\nIntroduzca una letra");
            opcion = Character.toUpperCase(teclado.nextLine().charAt(0));//Leemos la respuesta y convertimos a mayusculas 
            intentos[numIntentos] = opcion;
            System.out.println("\nIntentos: ");
            for (int i = 0; i <= numIntentos; i++){
                System.out.print(intentos[i]);
            }
            //comprobamos si coincide con algun caracter
            for (int i = 0; i < digitosPS; i++){
                if (opcion == letras[i]){
                    letrasCorrectas[i] = opcion;
                    acierto = true;
                    System.out.println("\n¡Has acertado! ");
                }
            }
            if(acierto == false){
                System.out.println("\nLa letra no aparece en la palabra secreta.");
                jugador.pierdeVida();
            }
            if(jugador.getVidas() == 0){
                fin = true;
            }
            //hacemos un string con los caracteres almacenados en letrasCorrectas
            for (int i = 0; i < digitosPS; i++){
                concat += letrasCorrectas[i];
            }
            palabraAdivinada = concat;
            //comprobamos si ha adivinado ya la palabra
            if(palabraAdivinada.equals(palabraSecreta.toString())){
                fin = true;
                System.out.println("\nHas acertado la palabra!!! Enhorabuena. ");
            }
            if(fin == false){
            System.out.println("\n¿Cuantas vidas te quedan? ");
            System.out.println("\n" + jugador.getVidas() + " vidas "+ mensaje[jugador.getVidas()]);
            numIntentos++;
            }
        }while(fin != true);
    }
}