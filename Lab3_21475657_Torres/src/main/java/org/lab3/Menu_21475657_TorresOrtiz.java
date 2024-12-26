package org.lab3;

import org.lab3.Clases.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Clase Menu que representa un menu para interactuar con el juego conecta 4.
 *
 * @author Cristopher Torres
 */
public class Menu_21475657_TorresOrtiz {
    /**
     * Atributo: players: Lista de jugadores del juego.
     */
    private List<Player_21475657_TorresOrtiz> players = new ArrayList<>();
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
    private Board_21475657_TorresOrtiz board = new Board_21475657_TorresOrtiz();
    /**
     * Atributo: game: Game.
     */
    private Game_21475657_TorresOrtiz game;
    /**
     * Atributo: returnToMenu: boolean.
     */
    private boolean returnToMenu = false;

    /**
     * Se crea el constructor vacio, ya que es solo para inicializar la clase
     */
    public Menu_21475657_TorresOrtiz() {}

    /**
     * Menu principal donde se crea un juego y otras opciones
     */
    public void menuPrincipal(){
        scanner = new Scanner(System.in);
        boolean inGame = false;

        int option = 0;
        do{
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
            switch(option){
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
                    Player_21475657_TorresOrtiz player1 = new Player_21475657_TorresOrtiz(1, namePlayer1, "Rojo", 0, 0, 0, cantRemainingPieces);
                    Player_21475657_TorresOrtiz player2 = new Player_21475657_TorresOrtiz(2, namePlayer2, "Amarillo", 0, 0, 0, cantRemainingPieces);
                    players.add(player1);
                    players.add(player2);

                    System.out.println("Jugadores creados de la partida:");
                    for (Player_21475657_TorresOrtiz player : players) {
                        System.out.println("Jugador (Id) = " + player.getId());
                        System.out.println("Nombre = " + player.getName());
                        System.out.println("Color = " + player.getColor() );
                        System.out.println("Partidas Ganadas = " + player.getWins());
                        System.out.println("Partidas Perdidas = " + player.getLosses());
                        System.out.println("Partidas empatadas = " + player.getDraws());
                        System.out.println("Fichas = " + player.getRemainingPieces());
                        System.out.println("\n");

                    }
                    for (Player_21475657_TorresOrtiz player : players) {
                        player.setRemainingPieces(cantRemainingPieces);
                    }
                    board = new Board_21475657_TorresOrtiz();
                    game = new Game_21475657_TorresOrtiz(players,board,1);
                    menuGame();
                    break;
                case 2:
                    System.out.println("==== Estadisticas de los jugadores ====\n");
                    if (players.isEmpty()) {
                        System.out.println("No hay estadisticas de los jugadores,debido a que no se han jugado partidas");
                    }
                    for (Player_21475657_TorresOrtiz player : players) {
                        System.out.println(player.getName() + " (" + player.getColor()+ ")");
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
                        if (game.getBoard().whoIsWinner() == 1){
                            System.out.println("\n");
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer1().getName());
                        } else if (game.getBoard().whoIsWinner() == 2) {
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer2().getName());
                        } else if (game.isDraw()) {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " termino en empate");
                        }else{
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " no se termino de jugar");
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n==== Historial de movimientos final de la ultima partida ====\n");
                    if(game == null) {
                        System.out.println("Aun no se han jugado partidas");
                    }else {
                        for (String move : game.getHistory()) {
                            System.out.println(move);
                        }
                        if (game.getBoard().whoIsWinner() == 1){
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer1().getName());
                        } else if (game.getBoard().whoIsWinner() == 2) {
                            System.out.println("El ganador de la ultima partida fue " + game.getPlayer2().getName());
                        }else if (game.isDraw()) {
                            System.out.println("La ultima partida entre " + game.getPlayer1().getName() + " y "
                                    + game.getPlayer2().getName() + " termino en empate");
                        }else{
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
        }while(option != 5);

    }
    /**
     * Menu de partida, donde se ven todas la opciones que el usuario puede acceder mientras juega la partida.
     */
    public void menuGame(){
        int option = 0;
        do{
            if(returnToMenu) {
                return;
            }
            System.out.println("------------------- Menu de partida -------------------\n");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Realizar movimiento");
            System.out.println("2. Ver historial de movimientos de la partida");
            System.out.println("3. Se puede jugar en el tablero actual?");
            System.out.println("4. Ver estado actual del tablero");
            System.out.println("5. Salir de la partida y volver al menu principal");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: \n");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    playGame();
                    break;
                case 2:
                    System.out.println("\n==== Historial de movimientos de la partida ====\n");
                    if(game.getHistory().isEmpty()) {
                        System.out.println("Aun no se realiza ningun movimiento en la partida");
                    }else {
                        for (String move : game.getHistory()) {
                            System.out.println(move);
                        }
                    }
                    break;
                case 3:
                    if(game.getBoard().canPlay()){
                        System.out.println("Si se puede jugar en el tablero actual");
                    }else{
                        System.out.println("No se puede jugar en el tablero actual");
                    }
                    break;
                case 4:
                    System.out.println("\n==== Estado actual del tablero ====\n");
                    game.boardGetState();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion no valida");
                    scanner.nextLine();
            }
        }while(option != 5 && !returnToMenu);
    }

    /**
     * Metodo donde se realiza el desarrollo de una partida hasta finalizar.
     */
    public void playGame(){
        if(game.getCurrentTurn() == 1) {
            System.out.println("Tablero inicial");
            game.boardGetState();
        }
        boolean endgame = false;

        while(!endgame){
            Player_21475657_TorresOrtiz currentPlayer = game.getCurrentPlayer();
            System.out.println("Turno de: " + currentPlayer.getName() +"(" + currentPlayer.getColor() + ")");
            System.out.println("Fichas: " + currentPlayer.getRemainingPieces());
            System.out.println("Escoja una columna (1-7): ");
            try{
                int column = scanner.nextInt();
                Piece_21475657_TorresOrtiz piece = new Piece_21475657_TorresOrtiz(currentPlayer.getColor());
                scanner.nextLine();
                if(column > 0 && column < 8 && game.getBoard().whoIsWinner() == 0){
                    try {
                        game.gamePlayerSetMove(currentPlayer, column);
                        if (game.getBoard().whoIsWinner() == 0 && !game.isDraw()) {
                            System.out.println("\nMovimiento realizado correctamente");
                            game.boardGetState();
                        } else {
                            System.out.println("\nEstado final del tablero");
                            game.boardGetState();
                        }
                        if (game.getBoard().whoIsWinner() != 0) {
                            System.out.println("\n=== GAME OVER ===");
                            if (game.getBoard().checkHorizontalWinner() != 0) {
                                if (game.getBoard().whoIsWinner() == 1) {
                                    System.out.println("VICTORIA de " + game.getPlayer1().getName() +
                                            " (Color: " + game.getPlayer1().getColor() + ") "
                                            + "Coloco 4 fichas horizontales consecutivas (victoria horizontal)");
                                } else {
                                    System.out.println("VICTORIA de " + game.getPlayer2().getName() +
                                            " (Color: " + game.getPlayer2().getColor() + ") "
                                            + "Coloco 4 fichas horizontales consecutivas (victoria horizontal)");
                                }
                            } else if (game.getBoard().checkDiagonalWinner() != 0) {
                                if (game.getBoard().whoIsWinner() == 1) {
                                    System.out.println("VICTORIA de " + game.getPlayer1().getName() +
                                            " (Color: " + game.getPlayer1().getColor() + ") "
                                            + "Coloco 4 fichas diagonales consecutivas (victoria diagonal)");
                                } else {
                                    System.out.println("VICTORIA de " + game.getPlayer2().getName() +
                                            " (Color: " + game.getPlayer2().getColor() + ") "
                                            + "Coloco 4 fichas diagonales consecutivas (victoria diagonal)");
                                }
                            } else if (game.getBoard().checkVerticalWinner() != 0) {
                                if (game.getBoard().whoIsWinner() == 1) {
                                    System.out.println("VICTORIA de " + game.getPlayer1().getName() +
                                            " (Color: " + game.getPlayer1().getColor() + ") "
                                            + "Coloco 4 fichas verticales consecutivas (victoria vertical)");
                                } else {
                                    System.out.println("VICTORIA de " + game.getPlayer2().getName() +
                                            " (Color: " + game.getPlayer2().getColor() + ") "
                                            + "Coloco 4 fichas verticales consecutivas (victoria vertical)");
                                }
                            }
                            System.out.println("==== Estadisticas actualizadas ====");
                            for (Player_21475657_TorresOrtiz player : players) {
                                System.out.println(player.getName() + " (" + player.getColor() + ")");
                                System.out.println("Partidas Ganadas = " + player.getWins());
                                System.out.println("Partidas Perdidas = " + player.getLosses());
                                System.out.println("Partidas empatadas = " + player.getDraws());
                                System.out.println("\n");
                            }
                            endgame = true;
                        } else if (game.isDraw()) {
                            System.out.println("\n=== GAME OVER ===");
                            System.out.println("La partida termino en empate");
                            System.out.println("==== Estadisticas actualizadas ====");
                            for (Player_21475657_TorresOrtiz player : players) {
                                System.out.println(player.getName() + " (" + player.getColor() + ")");
                                System.out.println("Partidas Ganadas = " + player.getWins());
                                System.out.println("Partidas Perdidas = " + player.getLosses());
                                System.out.println("Partidas empatadas = " + player.getDraws());
                                System.out.println("\n");
                            }
                            endgame = true;
                        }
                    }catch (IllegalStateException e) {
                        System.out.println("La columna esta llena. Ingrese otra columna.");
                    }
                }else {
                    System.out.println("Columna fuera del rango, ingrese un numero del 1 al 7");
                }
            } catch (Exception e) {
                System.out.println("Columna fuera del rango, ingrese un numero del 1 al 7");
                scanner.nextLine();
            }
            if (!endgame) {
                return;
            }
        }
        System.out.print("\nDesea jugar otra partida? (S/N): ");
        String playAgain = scanner.nextLine().toUpperCase();
        if(playAgain.equals("S")){
            for (Player_21475657_TorresOrtiz player : players) {
                player.setRemainingPieces(cantRemainingPieces);
            }
            board = new Board_21475657_TorresOrtiz();
            game = new Game_21475657_TorresOrtiz(players,board,1);
            menuGame();
        } else if (playAgain.equals("N")) {
            System.out.print("\nSe le devolvera al menu principal de conecta 4 ");
            returnToMenu = true;
            return;
        } else{
            System.out.print("Caracter invalido, ingrese S o N");
        }
    }
}
