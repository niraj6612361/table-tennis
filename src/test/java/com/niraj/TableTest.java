package com.niraj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {
    Player firstPlayer;
    Player secondPlayer;
    Table table;

    @BeforeEach
    void initEach() {
        firstPlayer = new Player(new Person("ASD", "asd@gmail.com"));
        secondPlayer = new Player(new Person("ZXC", "zxc@gmail.com"));
        table = new Table(firstPlayer, secondPlayer);
    }

    @Test
    void testGetOppositePlayer1() {
        Assertions.assertEquals(table.getOppositePlayer(firstPlayer), secondPlayer);
    }

    @Test
    void testGetOppositePlayer2() {
        Assertions.assertEquals(table.getOppositePlayer(secondPlayer), firstPlayer);
    }
}