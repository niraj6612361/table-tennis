package com.niraj;

public class Player {
    private Person person;
    private int score;
    private int serveCount;
    private boolean changeTurn;

    public Player(Person person) {
        this.person = person;
        this.score = 0;
        this.serveCount = 0;
        this.changeTurn = false;
    }

    public Person getPerson() {
        return person;
    }

    public int getScore() {
        return score;
    }

    public void setChangeTurn(boolean changeTurn) {
        this.changeTurn = changeTurn;
    }

    public boolean isChangeTurn() {
        return changeTurn;
    }

    public void incrementScore() {
        this.score++;
    }

    public int serve() {
        serveCount++;
        if (serveCount == Constants.MAX_CONSECUTIVE_SERVE_COUNT) {
            serveCount = 0;
            changeTurn = true;
        }
        return (int) (Math.random() * 10) % 2;
    }

    @Override
    public String toString() {
        return "Player{" +
                "person=" + person +
                ", score=" + score +
                '}';
    }
}
