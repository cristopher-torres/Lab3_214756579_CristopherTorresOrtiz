package org.lab3.Clases;

import org.lab3.Interfaces.PieceInterface;

public class Piece implements PieceInterface {
    private String color;

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
