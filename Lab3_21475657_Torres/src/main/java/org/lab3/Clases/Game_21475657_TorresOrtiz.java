package org.lab3.Clases;

import org.lab3.Interfaces.GameInterface_21475657_TorresOrtiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el juego.
 * Implementa la interfaz GameInterface.
 *
 * @author Cristopher Torres
 */
public class Game_21475657_TorresOrtiz implements GameInterface_21475657_TorresOrtiz {
    /**
     * Atributo: players : Lista de jugadores
     */
    private List<Player_21475657_TorresOrtiz> players;
    /**
     * Atributo: board : Board.
     */
    private Board_21475657_TorresOrtiz board;
    /**
     * Atributo: currentTurn : int.
     */
    private int currentTurn;
    /**
     * Atributo: history : Lista de strings
     */
    private List<String> history;

    /**
     * Constructor: instancia un game
     *
     * @param players:Una lista con los jugadores de la partida.
     * @param board:Board
     * @param currentTurn:int
     */
    public Game_21475657_TorresOrtiz(List<Player_21475657_TorresOrtiz> players, Board_21475657_TorresOrtiz board, int currentTurn) {
        this.players = players;
        this.board = board;
        this.currentTurn = currentTurn;
        this.history = new ArrayList<>();
    }

    /**
     * Retorna la lista history.
     *
     * @return history: Una lista de string con pares (int column, string color).
     */
    @Override
    public List<String> getHistory() {
        return history;
    }

    /**
     * Retorna currentTurn.
     * @return currentTurn:int.
     */
    @Override
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Retorna al Player 1.
     *
     * @return Player.
     */
    @Override
    public Player_21475657_TorresOrtiz getPlayer1() {
        return players.get(0);
    }

    /**
     * Retorna al player 2.
     *
     * @return Player.
     */
    @Override
    public Player_21475657_TorresOrtiz getPlayer2() {
        return players.get(1);
    }

    /**
     * Retorna el objeto Board
     *
     * @return board
     */
    public Board_21475657_TorresOrtiz getBoard() {
        return board;
    }

    /**
     * Cambia el currentTurn del game.
     *
     * @param currentTurn:int
     */
    @Override
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    /**
     * Metodo que agrega un movimiento al historial de movimientos
     *
     * @param column:int
     * @param color:String
     */

    public void addGameHistory(int column, String color){
        String newMove = "("+column+","+color+")";
        history.add(newMove);
    }
    /**
     * Metodo que genera un historial de movimientos
     *
     */
    @Override
    public void gameHistory(){
        for (String move : history) {
            System.out.println(move);
        }
    }

    /**
     * Metodo que verifica si el juego es empate o no.
     *
     * @return boolean: - true si es empate
     *                  - false si no es empate
     */
    @Override
    public boolean isDraw(){
        Player_21475657_TorresOrtiz player1 = getPlayer1();
        Player_21475657_TorresOrtiz player2 = getPlayer2();
        int remainingPieces1 = player1.getRemainingPieces();
        int remainingPieces2 = player2.getRemainingPieces();

        if(remainingPieces1 == 0 && remainingPieces2 == 0 && board.whoIsWinner() == 0){
            return true;
        } else if (!board.canPlay() && board.whoIsWinner() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que obtiene el jugador cuyo turno esta en curso.
     *
     * @return Player
     */
    @Override
    public Player_21475657_TorresOrtiz getCurrentPlayer() {
        int currentPlayer = currentTurn % 2;
        if (currentPlayer == 1){
            return getPlayer1();
        }else{
            return getPlayer2();
        }
    }

    /**
     * Metodo que entrega por pantalla el estado actual del tablero en el juego.
     */
    @Override
    public void boardGetState() {
        Board_21475657_TorresOrtiz currentBoard = getBoard();
        currentBoard.mostrarBoard();
    }

    /**
     * Metodo que finaliza el juego actualizando las estadísticas de los jugadores según el resultado
     * y no permitiendo futuras jugadas.
     */
    @Override
    public void endGame(){
        Player_21475657_TorresOrtiz player1 = getPlayer1();
        Player_21475657_TorresOrtiz player2 = getPlayer2();
        Board_21475657_TorresOrtiz currentBoard = getBoard();

        if(currentBoard.whoIsWinner() == 1){
            player1 = player1.updateStats("Win");
            player2 = player2.updateStats("Loss");
        } else if (currentBoard.whoIsWinner() == 2) {
            player1 = player1.updateStats("Loss");
            player2 = player2.updateStats("Win");
        } else if (isDraw()) {
            player1 = player1.updateStats("Draw");
            player2 = player2.updateStats("Draw");
        }
        players.set(0, player1);
        players.set(1, player2);
    }

    /**
     * Método que permite a un jugador realizar un movimiento.
     *
     * @param player:Player
     * @param column:int
     */
    @Override
    public void gamePlayerSetMove(Player_21475657_TorresOrtiz player, int column){
        if (player.getId() != getCurrentPlayer().getId()){
            System.out.println("No es tu turno");
        }
        if (player.getRemainingPieces() > 0) {
            Piece_21475657_TorresOrtiz piece = new Piece_21475657_TorresOrtiz(player.getColor());
            getBoard().playPiece(column, piece);
            int newRemainingPieces = player.getRemainingPieces() - 1;
            player.setRemainingPieces(newRemainingPieces);
            addGameHistory(column, player.getColor());
            int newCurrentTurn = currentTurn + 1;
            setCurrentTurn(newCurrentTurn);
            if (getBoard().whoIsWinner() != 0 || isDraw()) {
                endGame();
            }
        }else{
            System.out.println("El jugador no tiene fichas disponibles");
        }

    }
}
