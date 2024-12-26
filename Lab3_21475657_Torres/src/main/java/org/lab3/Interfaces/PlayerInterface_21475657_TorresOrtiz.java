package org.lab3.Interfaces;
import org.lab3.Clases.Player_21475657_TorresOrtiz;

/**
 * Interfaz donde se mencionan los metodos a utilizar por la clase Player.
 */
public interface PlayerInterface_21475657_TorresOrtiz {
    /**
     * Retorna el Id del jugador.
     *
     * @return id:Int.
     */
    public int getId();
    /**
     * Retorna el Nombre del jugador.
     *
     * @return name:String.
     */
    public String getName();
    /**
     * Retorna el Color del jugador.
     *
     * @return color:String.
     */
    public String getColor();
    /**
     * Retorna las victorias del jugador.
     *
     * @return wins:Int.
     */
    public int getWins();
    /**
     * Retorna las derrotas del jugador.
     *
     * @return losses:Int.
     */
    public int getLosses();
    /**
     * Retorna los empates del jugador.
     *
     * @return draws:Int.
     */
    public int getDraws();
    /**
     * Retorna las fichas del jugador.
     *
     * @return remainingPieces:Int.
     */
    public int getRemainingPieces();
    /**
     * Cambia el numero de fichas de un jugador.
     *
     * @param remainingPieces:int.
     */
    public void setRemainingPieces(int remainingPieces);
    /**
     * Metodo que actualiza las estadisticas (victorias,derrotas,empates) del jugador.
     *
     * @param result:String
     * @return Player.
     */
    public Player_21475657_TorresOrtiz updatedStats(String result);
}
