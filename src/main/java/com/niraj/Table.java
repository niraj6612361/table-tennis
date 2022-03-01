package com.niraj;

public class Table {
    private Player firstPlayer;
    private Player secondPlayer;

    public Table(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Player getOppositePlayer(Player player) {
        if (player == firstPlayer)
            return secondPlayer;
        else
            return firstPlayer;
    }
}
