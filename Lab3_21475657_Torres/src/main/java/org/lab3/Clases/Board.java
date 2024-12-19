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
    public boolean CanPlay(){
        for (int i = 0; i <= filas; i++) {
            //se verifica solo en la primera fila si hay algun '_' , ya que el tablera se llena de abajo hacia arriba
            if (board.get(0).get(i) == '_') {
                return true; //si encuentra uno se puede jugar
            }
        }
        return false; // si no retorna false porque no se puede jugar
    }
    public int CheckVerticalWinner(){
        for (int col = 0; col < columnas; col++) {
            int accX = 0;
            int accO = 0;
            for (int row = 0; row < filas; row++) {
                if (board.get(row).get(col) == 'X') {
                    accX = accX + 1;
                    accO = 0;
                    if (accX == 4) {
                        return 1;
                    }
                } else if (board.get(row).get(col) == 'O') {
                    accO = accO + 1;
                    accX = 0;
                    if (accO == 4){
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
}
