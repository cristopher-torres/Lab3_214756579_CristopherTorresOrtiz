package org.lab3.Clases;

import org.lab3.Interfaces.PlayerInterface;

/**
 * Clase que representa un jugador en el juego.
 * Implementa la interfaz PlayerInterface.
 * @author Cristopher Torres
 */
public class Player implements PlayerInterface {
    /**
     * Atributo: Id : Int.
     */
    public int id;
    public String name;
    /**
     * Atributo: Color : String.
     */
    public String color;
    /**
     * Atributo: Wins : Int.
     */
    public int wins;
    /**
     * Atributo: Losses : Int.
     */
    public int losses;
    /**
     * Atributo: Draws : Int.
     */
    public int draws;
    /**
     * Atributo: RemainingPieces : Int.
     */
    public int remainingPieces;

    /**
     * Constructor: instancia un player.
     *
     * @param id:Int
     * @param name:String
     * @param color:String
     * @param wins:int
     * @param losses:int
     * @param draws:int
     * @param remainingPieces:int
     *
     */
    public Player(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }

    /**
     * Retorna el Id del jugador.
     *
     * @return id:Int.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Retorna el Nombre del jugador.
     *
     * @return name:String.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retorna el Color del jugador.
     *
     * @return color:String.
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * Retorna las victorias del jugador.
     *
     * @return wins:Int.
     */
    @Override
    public int getWins() {
        return wins;
    }

    /**
     * Retorna las derrotas del jugador.
     *
     * @return losses:Int.
     */
    @Override
    public int getLosses() {
        return losses;
    }

    /**
     * Retorna los empates del jugador.
     *
     * @return draws:Int.
     */
    @Override
    public int getDraws() {
        return draws;
    }

    /**
     * Retorna las fichas del jugador.
     *
     * @return remainingPieces:Int.
     */
    @Override
    public int getRemainingPieces() {
        return remainingPieces;
    }

    /**
     * Metodo que actualiza las estadisticas (victorias,derrotas,empates) del jugador.
     *
     * @param result:String
     * @return Player.
     */
    @Override
    public Player updatedStats(String result) {
        if (result.equals("Win")){
            wins += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }else if (result.equals("Loss")){
            losses += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        } else if (result.equals("Draw")){
            draws += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }else{
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }
    }

    /**
     * Cambia el numero de fichas de un jugador.
     *
     * @param remainingPieces:int
     */
    @Override
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }
}
