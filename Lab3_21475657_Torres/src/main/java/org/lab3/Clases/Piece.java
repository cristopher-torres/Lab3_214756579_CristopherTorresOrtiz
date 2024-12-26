package org.lab3.Clases;

import org.lab3.Interfaces.PieceInterface;

/**
 * Clase que representa una ficha en el juego.
 * Implementa la interfaz PieceInterface.
 *
 * @author Cristopher Torres
 */
public class Piece implements PieceInterface {
    /**
     * Atributo: Color : String.
     */
    private String color;

    /**
     * Constructor: instancia una piece (ficha)
     *
     * @param color:String
     */
    public Piece(String color) {
        this.color = color;
    }

    /**
     * Retorna color.
     *
     * @return color:String.
     */
    public String getColor() {
        return color;
    }
}
