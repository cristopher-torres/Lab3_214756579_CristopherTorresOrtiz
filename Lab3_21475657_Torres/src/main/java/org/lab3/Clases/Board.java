package org.lab3.Clases;
import java.util.ArrayList;
import java.util.List;

public class Board {
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
}
