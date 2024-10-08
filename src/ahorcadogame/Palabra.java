/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadogame;

/**
 * Esta clase contendra una palabra con un metodo toString()
 * 
 * @author Nicolás Calderón Torres
 * @version 1
 */
public class Palabra
{
    // instance variables 
    private String palabra;

    /**
     * Constructor para la clase Palabra
     * @param palabra que deseas almacenar en esta clase
     */
    public Palabra(String palabra)
    {
        // initialise instance variables
        this.palabra = palabra;
    }

    /**
     * metodo que devuelve un string que representa al objeto o su estado
     * 
     * @return     String almacenado 
     */
    public String toString()
    {
        
        return palabra;
    }
}