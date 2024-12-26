package org.lab3;

import org.lab3.Clases.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Clase MainMenu que representa un menu para interactuar con el juego conecta 4.
 *
 * @author Cristopher Torres
 */
public class MainMenu {
    /**
     * Atributo: players: Lista de jugadores del juego.
     */
    private List<Player> players = new ArrayList<>();
    /**
     * Atributo: scanner: Scanner.
     */
    private Scanner scanner;
    /**
     * Atributo: cantRemainingPieces: int.
     */
    private int cantRemainingPieces;
    /**
     * Atributo: board: Board.
     */
    private Board board = new Board();
    /**
     * Atributo: game: Game.
     */
    private Game game;
    /**
     * Atributo: returnToMenu: boolean.
     */
    private boolean returnToMenu = false;

    /**
     * Se crea el constructor vacio, ya que es solo para inicializar la clase
     */
    public MainMenu() {
    }

    /**
     * Menu principal donde se crea un juego y otras opciones
     */
    public void menuPrincipal() {
        scanner = new Scanner(System.in);
        boolean inGame = false;

        int option = 0;
        do {
            returnToMenu = false;
            System.out.println("\n------------------- Menu principal De Conecta 4 -------------------\n");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Ver estadisticas de los jugadores de la ultima/s partidas");
            System.out.println("3. Ver estado final del tablero en la ultima partida");
            System.out.println("4. Ver Historial de movimientos final de la ultima partida");
            System.out.println("5. Salir del juego");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: \n");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    players.clear();
                    System.out.println("\n==== Creando partida ====\n");
                    System.out.println("ingrese nombre jugador 1:");
                    scanner.nextLine();
                    String namePlayer1 = scanner.nextLine();
                    System.out.println("Color asignado a " + namePlayer1 + " (jugador 1): Rojo");
                    System.out.println("ingrese nombre jugador 2:");
                    String namePlayer2 = scanner.nextLine();
                    System.out.println("Color asignado a " + namePlayer2 + " (jugador 2): Amarrillo");
                    boolean correctCantPieces = false;
                    while (!correctCantPieces) {
                        System.out.println("ingrese la cantidad de fichas para cada jugador (De 4-21): ");
                        cantRemainingPieces = scanner.nextInt();
                        if (cantRemainingPieces >= 4 && cantRemainingPieces <= 21) {
                            correctCantPieces = true;
                        } else {
                            System.out.println("Numero de fichas incorrectas, la cantidad de fichas debe estar entre 4 y 21. Intente nuevamente.");
                        }
                    }
                    scanner.nextLine();
                    Player player1 = new Player(1, namePlayer1, "Rojo", 0, 0, 0, cantRemainingPieces);
                    Player player2 = new Player(2, namePlayer2, "Amarillo", 0, 0, 0, cantRemainingPieces);
                    players.add(player1);
                    players.add(player2);

                    System.out.println("Jugadores creados de la partida:");
                    for (Player player : players) {
                        System.out.println("Jugador (Id) = " + player.getId());
                        System.out.println("Nombre = " + player.getName());
                        System.out.println("Color = " + player.getColor());
                        System.out.println("Partidas Ganadas = " + player.getWins());
                        System.out.println("Partidas Perdidas = " + player.getLosses());
                        System.out.println("Partidas empatadas = " + player.getDraws());
                        System.out.println("Fichas = " + player.getRemainingPieces());
                        System.out.println("\n");

                    }
                    for (Player player : players) {
                        player.setRemainingPieces(cantRemainingPieces);
                    }
                    board = new Board();
                    game = new Game(players, board, 1);
                    menuGame();
                    break;
                case 2:
                    System.out.println("==== Estadisticas de los jugadores ====\n");
                    if (players.isEmpty()) {
                        System.out.println("No hay estadisticas de los jugadores,debido a que no se han jugado partidas");
                    }
                    for (Player player : players) {
                        System.out.println(player.getName() + " (" + player.getColor() + ")");
                        System.out.println("Partidas Ganadas = " + player.getWins());
                        System.out.println("Partidas Perdidas = " + player.getLosses());
                        System.out.println("Partidas empatadas = " + player.getDraws());
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    System.out.println("\n==== Estado final del tablero en la ultima partida ====\n");
                    if (game == null) {
                        System.out.println("Aun no se han jugado partidas");
                    } else {
                        System.out.println("Estado final del tablero:");
                        game.boardGetState();
                        if (game.getBoard().whoIsWinner() == 1) {
                            System.out.println("\n");
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer1().getName());
                        } else if (game.getBoard().whoIsWinner() == 2) {
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer2().getName());
                        } else if (game.isDraw()) {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " termino en empate");
                        } else {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " no se termino de jugar");
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n==== Historial de movimientos final de la ultima partida ====\n");
                    if (game == null) {
                        System.out.println("Aun no se han jugado partidas");
                    } else {
                        for (String move : game.getHistory()) {
                            System.out.println(move);
                        }
                        if (game.getBoard().whoIsWinner() == 1) {
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer1().getName());
                        } else if (game.getBoard().whoIsWinner() == 2) {
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer2().getName());
                        } else if (game.isDraw()) {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " termino en empate");
                        } else {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " no se termino de jugar");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Gracias por jugar conecta 4");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    scanner.nextLine();
            }
        } while (option != 5);

    }
}
