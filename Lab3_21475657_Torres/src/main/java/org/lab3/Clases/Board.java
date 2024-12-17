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
}
