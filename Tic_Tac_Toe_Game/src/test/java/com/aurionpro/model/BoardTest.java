package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testBoardInitialization() {
        Cell[] cells = board.getCells();
        assertNotNull(cells, "Cells array should be initialized");
        assertEquals(9, cells.length, "Board should have 9 cells");
        
        for (Cell cell : cells) {
            assertEquals(MarkType.EMPTY, cell.getMark(), "All cells should be initialized as EMPTY");
        }
    }

    @Test
    void testSetCellMark() throws CellAlreadyMarkedException {
        board.setCellMark(0, MarkType.X);
        assertEquals(MarkType.X, board.getCells()[0].getMark());
        
        board.setCellMark(1, MarkType.O);
        assertEquals(MarkType.O, board.getCells()[1].getMark());
    }

    @Test
    void testIsBoardFull_WhenBoardIsNotFull() throws CellAlreadyMarkedException {
        assertFalse(board.isBoardFull());

        board.setCellMark(0, MarkType.X);
        board.setCellMark(1, MarkType.O);
        board.setCellMark(2, MarkType.X);
        
        assertFalse(board.isBoardFull());
    }

    @Test
    void testIsBoardFull_WhenBoardIsFull() throws CellAlreadyMarkedException {
        for (int i = 0; i < 9; i++) {
            board.setCellMark(i, i % 2 == 0 ? MarkType.X : MarkType.O);
        }
        
        assertTrue(board.isBoardFull());
    }
}
