package org.lab3.Interfaces;

import org.lab3.Clases.Game;
import org.lab3.Clases.Player;

public interface GameInterface {
    public void gameHistory(int column, String color);
    public boolean isDraw();
    public Player getCurrentPlayer();
    public void boardGetState();
    public void gameEnd();
}
