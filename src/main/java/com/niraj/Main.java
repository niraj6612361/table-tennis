package com.niraj;

public class Main {

    public static void main(String[] args) {
        Person firstPerson = new Person("ASD", "asd@gmail.com");
        Person secondPerson = new Person("ZXC", "zxc@gmail.com");
        Player firstPlayer = new Player(firstPerson);
        Player secondPlayer = new Player(secondPerson);
        Table table = new Table(firstPlayer, secondPlayer);
        Game game = new Game(table);
        game.startGame();
        System.out.println("WINNER: " + game.getWinnerPlayer());
    }

}
