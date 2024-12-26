package org.lab3.Interfaces;

import org.lab3.Clases.Board;
import org.lab3.Clases.Piece;

/**
 * Interfaz donde se mencionan los metodos a utilizar por la Board.
 */
public interface BoardInterface {

    /**
     * Metodo que revisa si se puede realizar un movimiento en la board.
     *
     * @return boolean: - true si se puede realizar un movimiento.
     *                  - false si no se puede realizar un movimiento.
     */
    public boolean canPlay();

    /**
     * Metodo que coloca una ficha en la board
     * @param column:int
     * @param piece:Piece
     */
    public void playPiece(int column, Piece piece);

    /**
     * Metodo que verifica si hay cuatro fichas del mismo color consecutivas verticalmente.
     * @return int: - 0 si no hay ningun ganador.
     *              - 1 si gano el jugador 1 (Piece = 'R').
     *              - 2 si gano el jugador 2 (Piece = 'A').
     */
    public int checkVerticalWinner();

    /**
     * Metodo que verifica si hay cuatro fichas del mismo color consecutivas horizontalmente.
     * @return int: - 0 si no hay ningun ganador.
     *              - 1 si gano el jugador 1 (Piece = 'R').
     *              - 2 si gano el jugador 2 (Piece = 'A').
     */
    public int checkHorizontalWinner();

    /**
     * Metodo que verifica si hay cuatro fichas del mismo color consecutivas diagonalmente.
     * @return int: - 0 si no hay ningun ganador.
     *              - 1 si gano el jugador 1 (Piece = 'R').
     *              - 2 si gano el jugador 2 (Piece = 'A').
     */
    public int checkDiagonalWinner();

    /**
     * Metodo que verifica si hay cuatro fichas del mismo color consecutivas de cualquier forma.
     * @return int: - 0 si no hay ningun ganador.
     *              - 1 si gano el jugador 1 (Piece = 'R').
     *              - 2 si gano el jugador 2 (Piece = 'A').
     */
    public int whoIsWinner();

    /**
     * Metodo que imprime el tablero.
     */
    public void mostrarBoard();
}
