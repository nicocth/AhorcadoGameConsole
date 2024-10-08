/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadogame;

/**
 * Esta clase va a modelar el comportamiento de un jugador
 * 
 * @author Nicolás Calderón Torres
 * @version 1
 */
public class Jugador
{
    // instance variables
    private String usuario;
    private String dificultad;
    private int vidas;

   /**
     * Constructor para la clase Jugador
     * inicializara la clase con valores predeterminados
     */
    public Jugador()
    {
        // initialise instance variables
        usuario = "Prueba";
        dificultad = "Fácil";
        vidas = 7;
    }

    /**
     * Constructor para la clase Jugador
     * inicializara la clase con valores dados y asignara las vidas segun la dificultad
     * @param1 nombre del jugador 
     * @param2 dificultad del juego (Facil = 8 vidas, Normal = 6 vidas, Dificil = 4 vidas)
     */
    public Jugador(String usuario, String dificultad)
    {
        // initialise instance variables
        this.usuario = usuario;
        this.dificultad = dificultad;
        switch (dificultad) { 
            case "Facil":
             vidas = 7;
             break;
            case "Normal":
             vidas = 6;
             break;
            case "Dificil":
             vidas = 4;
             break;
              }
    }
    
    /**
     * Metodo que decrementa el numero de vidas 
     */
    public int pierdeVida()
    {
        vidas--;
        return vidas;
    }
    
    /**
     * Accesor al atributo usuario
     * @return valor de usuario
     */
    public String getUsuario()
    {
        return usuario;
    }
    
    /**
     * Mutador para el atributo usuario
     * @param nuevo valor del String usuario
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    /**
     * Accesor al atributo dificultad
     * @return valor de dificultad
     */
    public String getDificultad()
    {
        return dificultad;
    }
    
    /**
     * Mutador para el atributo dificultad
     * @param nuevo valor del String dificultad
     */
    public void setDificultad(String dificultad)
    {
        this.dificultad = dificultad;
    }
    
     /**
     * Accesor al atributo vidas
     * @return valor de vidas
     */
    public int getVidas()
    {
        return vidas;
    }
    
    /**
     * Mutador para el atributo vidas
     * @param nuevo valor para el atributo vidas
     */
    public void setVidas(int vidas)
    {
        this.vidas = vidas;
    }
}