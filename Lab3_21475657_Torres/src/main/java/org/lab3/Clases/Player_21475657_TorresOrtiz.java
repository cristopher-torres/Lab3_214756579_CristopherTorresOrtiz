package org.lab3.Clases;

import org.lab3.Interfaces.PlayerInterface_21475657_TorresOrtiz;

/**
 * Clase que representa un jugador en el juego.
 * Implementa la interfaz PlayerInterface.
 * @author Cristopher Torres
 */
public class Player_21475657_TorresOrtiz implements PlayerInterface_21475657_TorresOrtiz {
    /**
     * Atributo: Id : Int.
     */
    private int id;
    /**
     * Atributo: name : String.
     */
    private String name;
    /**
     * Atributo: Color : String.
     */
    private String color;
    /**
     * Atributo: Wins : Int.
     */
    private int wins;
    /**
     * Atributo: Losses : Int.
     */
    private int losses;
    /**
     * Atributo: Draws : Int.
     */
    private int draws;
    /**
     * Atributo: RemainingPieces : Int.
     */
    private int remainingPieces;

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
    public Player_21475657_TorresOrtiz(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
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
     * Cambia el numero de fichas de un jugador.
     *
     * @param remainingPieces:int
     */
    @Override
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }

    /**
     * Metodo que actualiza las estadisticas (victorias,derrotas,empates) del jugador.
     *
     * @param result:String
     * @return Player.
     */
    @Override
    public Player_21475657_TorresOrtiz updatedStats(String result) {
        if (result.equals("Win")){
            wins += 1;
            return new Player_21475657_TorresOrtiz(id, name, color, wins, losses, draws, remainingPieces);
        }else if (result.equals("Loss")){
            losses += 1;
            return new Player_21475657_TorresOrtiz(id, name, color, wins, losses, draws, remainingPieces);
        } else if (result.equals("Draw")){
            draws += 1;
            return new Player_21475657_TorresOrtiz(id, name, color, wins, losses, draws, remainingPieces);
        }else{
            return new Player_21475657_TorresOrtiz(id, name, color, wins, losses, draws, remainingPieces);
        }
    }
}
