package org.lab3.Clases;

import org.lab3.Interfaces.GameInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el juego.
 * Implementa la interfaz GameInterface.
 *
 * @author Cristopher Torres
 */
public class Game implements GameInterface {
    /**
     * Atributo: players : Lista de jugadores
     */
    private List<Player> players;
    /**
     * Atributo: board : Board.
     */
    private Board board;
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
    public Game(List<Player> players, Board board, int currentTurn) {
        this.players = players;
        this.board = board;
        this.currentTurn = currentTurn;
        this.history = new ArrayList<>();
    }

    /**
     * Metodo que genera un historial de movimientos
     *
     * @param column:int
     * @param color:String
     */
    @Override
    public void gameHistory(int column, String color){
        String newMove = "("+column+","+color+")";
        history.add(newMove);
    }

    /**
     * Metodo que verifica si el juego es empate o no.
     *
     * @return boolean: - true si es empate
     *                  - false si no es empate
     */
    @Override
    public boolean isDraw(){
        Player player1 = getPlayer1();
        Player player2 = getPlayer2();
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
     * Retorna al Player 1.
     *
     * @return Player.
     */
    public Player getPlayer1() {
        return players.get(0);
    }

    /**
     * Retorna al player 2.
     *
     * @return Player.
     */
    public Player getPlayer2() {
        return players.get(1);
    }

    /**
     * Metodo que obtiene el jugador cuyo turno esta en curso.
     *
     * @return Player
     */
    @Override
    public Player getCurrentPlayer() {
        int currentPlayer = currentTurn % 2;
        if (currentPlayer == 1){
            return getPlayer1();
        }else{
            return getPlayer2();
        }
    }

    /**
     * Retorna el objeto Board
     *
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Metodo que entrega por pantalla el estado actual del tablero en el juego.
     */
    @Override
    public void boardGetState() {
        Board currentBoard = getBoard();
        currentBoard.mostrarBoard();
    }

    /**
     * Metodo que finaliza el juego actualizando las estadísticas de los jugadores según el resultado
     * y no permitiendo futuras jugadas.
     */
    @Override
    public void gameEnd(){
        Player player1 = getPlayer1();
        Player player2 = getPlayer2();
        Board currentBoard = getBoard();

        if(currentBoard.whoIsWinner() == 1){
            player1 = player1.updatedStats("Win");
            player2 = player2.updatedStats("Loss");
        } else if (currentBoard.whoIsWinner() == 2) {
            player1 = player1.updatedStats("Loss");
            player2 = player2.updatedStats("Win");
        } else if (isDraw()) {
            player1 = player1.updatedStats("Draw");
            player2 = player2.updatedStats("Draw");
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
    public void gamePlayerSetMove(Player player,int column){
        if (player.getId() != getCurrentPlayer().getId()){
            System.out.println("No es tu turno");
        }
        if (player.getRemainingPieces() > 0) {
            Piece piece = new Piece(player.getColor());
            getBoard().playPiece(column, piece);
            int newRemainingPieces = player.getRemainingPieces() - 1;
            player.setRemainingPieces(newRemainingPieces);
            gameHistory(column, player.getColor());
            int newCurrentTurn = currentTurn + 1;
            setCurrentTurn(newCurrentTurn);
            if (getBoard().whoIsWinner() != 0 || isDraw()) {
                gameEnd();
            }
        }else{
            System.out.println("El jugador no tiene fichas disponibles");
        }

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
     * Cambia el currentTurn del game.
     *
     * @param currentTurn:int
     */
    @Override
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    /**
     * Retorna currentTurn.
     * @return currentTurn:int.
     */
    @Override
    public int getCurrentTurn() {
        return currentTurn;
    }
}
