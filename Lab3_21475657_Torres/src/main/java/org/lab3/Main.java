package org.lab3;

import org.lab3.MainMenu;

/**
 * Clase main para ejecutar el programa.
 *
 * @author Cristopher Torres
 */
public class Main {
    /**
     * Constructor: inicializa el programa
     * @param args: los argumentos de la linea de comando
     */
    public static void main(String[] args) {
        MainMenu Menu = new MainMenu();
        Menu.menuPrincipal();
    }
}