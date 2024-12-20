package org.lab3.Clases;
import org.lab3.Interfaces.BoardInterface;

import java.util.ArrayList;
import java.util.List;

public class Board implements BoardInterface {
    private List<List<Character>> board;
    private int filas = 6;
    private int columnas = 7;

    public Board() {
        board = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                row.add('_');
            }
            board.add(row);
        }
    }
    public boolean canPlay(){
        for (int i = 0; i < columnas; i++) {
            //se verifica solo en la primera fila si hay algun '_' , ya que el tablera se llena de abajo hacia arriba
            if (board.get(0).get(i) == '_') {
                return true; //si encuentra uno se puede jugar
            }
        }
        return false; // si no retorna false porque no se puede jugar
    }
    public void playPiece(int column, Piece piece){
        int newColumn = column - 1;
        if(column > 7 || column < 1){
            System.out.println("Columna fuera de rango");
            return;
        }
        for(int i = 5; i >= 0; i--){
            if(board.get(i).get(newColumn) == '_'){
                if(piece.getColor().equals("Rojo")){
                    board.get(i).set(newColumn, 'R');
                    return;
                } else if (piece.getColor().equals("Amarillo")) {
                    board.get(i).set(newColumn, 'A');
                    return;
                }
            }
        }
    }
    public int CheckVerticalWinner(){
        for (int col = 0; col < columnas; col++) {
            int accR = 0;
            int accY = 0;
            for (int row = 0; row < filas; row++) {
                if (board.get(row).get(col) == 'R') {
                    accR = accR + 1;
                    accY = 0;
                    if (accR == 4) {
                        return 1;
                    }
                } else if (board.get(row).get(col) == 'A') {
                    accY = accY + 1;
                    accR = 0;
                    if (accY == 4){
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
}
