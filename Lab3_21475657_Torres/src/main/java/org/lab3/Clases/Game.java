package org.lab3.Clases;

import org.lab3.Interfaces.GameInterface;

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
}
