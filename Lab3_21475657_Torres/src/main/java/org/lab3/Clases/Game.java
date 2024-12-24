package org.lab3.Clases;

import org.lab3.Interfaces.GameInterface;

import java.util.ArrayList;
import java.util.List;


public class Game implements GameInterface {
    private List<Player> players;
    private Board board;
    private int currentTurn;

    public Game(List<Player> players, Board board, int currentTurn) {
        this.players = players;
        this.board = board;
        this.currentTurn = currentTurn;
    }
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

    public Player getPlayer1() {
        return players.get(0);
    }

    public Player getPlayer2() {
        return players.get(1);
    }
    public Player getCurrentPlayer() {
        int currentPlayer = currentTurn % 2;
        if (currentPlayer == 1){
            return getPlayer1();
        }else{
            return getPlayer2();
        }
    }

    public Board getBoard() {
        return board;
    }

    public void boardGetState() {
        Board currentBoard = getBoard();
        currentBoard.mostrarBoard();
    }
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

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }
}
