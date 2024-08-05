package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testInitialization() {
        char[][] expectedBoard = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

}
