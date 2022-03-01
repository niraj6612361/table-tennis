package com.niraj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Player player;

    @BeforeEach
    void initEach() {
        player = new Player(new Person("ASD", "asd@gmail.com"));
    }


    @Test
    void testServe() {
        Assertions.assertEquals(player.serve(), 0, 1);
    }
}