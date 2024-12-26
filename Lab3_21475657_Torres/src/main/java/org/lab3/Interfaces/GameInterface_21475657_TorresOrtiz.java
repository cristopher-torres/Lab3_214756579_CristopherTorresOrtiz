package org.lab3.Interfaces;

import org.lab3.Clases.Player_21475657_TorresOrtiz;

import java.util.List;

/**
 * Interfaz donde se mencionan los metodos a utilizar por la clase Game.
 */
public interface GameInterface_21475657_TorresOrtiz {
    /**
     * Metodo que genera un historial de movimientos
     *
     * @param column:int
     * @param color:String
     */
    public void gameHistory(int column, String color);

    /**
     * Metodo que verifica si el juego es empate o no.
     *
     * @return boolean: - true si es empate
     *                  - false si no es empate
     */
    public boolean isDraw();

    /**
     * Metodo que obtiene el jugador cuyo turno esta en curso.
     *
     * @return Player
     */
    public Player_21475657_TorresOrtiz getCurrentPlayer();
    /**
     * Metodo que entrega por pantalla el estado actual del tablero en el juego.
     */
    public void boardGetState();
    /**
     * Metodo que finaliza el juego actualizando las estadísticas de los jugadores según el resultado
     * y no permitiendo futuras jugadas.
     */
    public void gameEnd();
    /**
     * Método que permite a un jugador realizar un movimiento.
     *
     * @param player:Player
     * @param column:int
     */
    public void gamePlayerSetMove(Player_21475657_TorresOrtiz player, int column);

    /**
     * Retorna la lista history.
     * @return history:Una lista de string con pares (int column, string color).
     */
    public List<String> getHistory();

    /**
     * Cambia el currentTurn del game.
     *
     * @param currentTurn:int
     */
    public void setCurrentTurn(int currentTurn);

    /**
     * Retorna currentTurn.
     * @return currentTurn:int.
     */
    public int getCurrentTurn();

    /**
     * Retorna al Player 1.
     *
     * @return Player.
     */
    public Player_21475657_TorresOrtiz getPlayer1();

    /**
     * Retorna al player 2.
     *
     * @return Player.
     */
    public Player_21475657_TorresOrtiz getPlayer2();
}
