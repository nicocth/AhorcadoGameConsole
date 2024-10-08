/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadogame;


/**
 * Menu para acceder a opciones del Juego el Ahorcado
 * 
 * @author Nicolas Calderon Torres 
 * @version 1
 */
import java.util.Scanner;

public class Menu
{
    // instance variables - replace the example below with your own
    private Scanner teclado;

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        teclado = new Scanner(System.in);
        iniciar();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void iniciar()
    {
        Juego juego;
        Jugador jugador;
        String opcion;
        boolean exit = false;
        System.out.println("\nJUEGO DEL AHORCADO. Opciones disponibles:");
        System.out.println("\n1-Jugar.");
        System.out.println("\n2-Creditos.");
        System.out.println("\n3-Cambiar dificultad.");
        System.out.println("\n4-Cambiar usuario");
        System.out.println("\n5-Salir.");
        do{
        opcion = teclado.nextLine();
        switch (opcion){
                case "1":
                    juego = new Juego();
                    jugador = new Jugador("Usuario examen", "Normal");
                    System.out.println("\nBienvenido Usuario examen estas jugando en dificultad normal");
                    juego.jugar(jugador);
                    break;
                case "2":
                    System.out.println("\nCreador del Juego: Nicolas Calderon Torres.");
                    break;
                case "3":
                    System.out.println("\nEn desarrollo");
                    break;
                case "4":
                    System.out.println("\nEn desarrollo");
                    break;
                case "5":
                    exit = true;
            }
        }while(exit=false);    
    }
}
