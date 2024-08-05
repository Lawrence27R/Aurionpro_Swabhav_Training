package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultCheckerTest {

    ResultChecker resultChecker;

    @BeforeEach
    void setUp() {
        resultChecker = new ResultChecker();
    }

    @Test
    void testIsDrawWhenBoardIsFull() {
        char[][] fullBoard = {
            {'X', 'O', 'X'},
            {'X', 'X', 'O'},
            {'O', 'X', 'O'}
        };
        assertTrue(resultChecker.isDraw(fullBoard));
    }
    
    @Test
    void testHaveWonRow() {
        char[][] winningBoard = {
            {'X', 'X', 'X'},
            {'O', ' ', ' '},
            {'O', ' ', ' '}
        };
        assertTrue(resultChecker.haveWon(winningBoard, 'X'));
    }
    
    @Test
    void testHaveWonColumn() {
        char[][] winningBoard = {
            {'O', 'X', ' '},
            {'O', 'X', ' '},
            {'O', ' ', ' '}
        };
        assertTrue(resultChecker.haveWon(winningBoard, 'O'));
    }
    
    @Test
    void testHaveWonDiagonal() {
        char[][] winningBoard = {
            {'X', 'O', 'X'},
            {'O', 'X', ' '},
            {'O', ' ', 'X'}
        };
        assertTrue(resultChecker.haveWon(winningBoard, 'X'));
    }
}
