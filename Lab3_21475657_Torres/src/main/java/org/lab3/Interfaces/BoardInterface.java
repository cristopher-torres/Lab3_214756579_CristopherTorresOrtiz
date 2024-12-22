package org.lab3.Interfaces;

import org.lab3.Clases.Board;
import org.lab3.Clases.Piece;

public interface BoardInterface {
    public boolean canPlay();
    public void playPiece(int column, Piece piece);
    public int checkVerticalWinner();
    public int checkHorizontalWinner();
    public int checkDiagonalWinner();
    public int whoIsWinner();
}
