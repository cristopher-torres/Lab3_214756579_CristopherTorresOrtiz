package org.lab3.Clases;

import org.lab3.Interfaces.PlayerInterface;

public class Player implements PlayerInterface {
    public int id;
    public String name;
    public String color;
    public int wins;
    public int losses;
    public int draws;
    public int remainingPieces;

    public Player(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getRemainingPieces() {
        return remainingPieces;
    }

    @Override
    public Player updatedStats(String result) {
        if (result.equals("Win")){
            wins += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }else if (result.equals("Loss")){
            losses += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        } else if (result.equals("Draw")){
            draws += 1;
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }else{
            return new Player(id, name, color, wins, losses, draws, remainingPieces);
        }
    }

    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }
}
