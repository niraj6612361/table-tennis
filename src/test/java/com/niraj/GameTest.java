package com.niraj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    Player firstPlayer;
    Player secondPlayer;
    Table table;
    Game game;

    @BeforeEach
    void initEach() {
        firstPlayer = new Player(new Person("ASD", "asd@gmail.com"));
        secondPlayer = new Player(new Person("ZXC", "zxc@gmail.com"));
        table = new Table(firstPlayer, secondPlayer);
        game = new Game(table);
    }

    @Test
    void testStartGame(){
        game.startGame();
        Assertions.assertNotNull(game.getWinnerPlayer());
    }

}