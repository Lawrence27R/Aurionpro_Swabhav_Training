package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(MarkType.EMPTY);
    }

    @Test
    void testCellInitialization() {
        assertEquals(MarkType.EMPTY, cell.getMark());
        assertTrue(cell.isCellEmpty());
    }

    @Test
    void testSetMark() {
        cell.setMark(MarkType.X);
        assertEquals(MarkType.X, cell.getMark());

        cell.setMark(MarkType.O);
        assertEquals(MarkType.O, cell.getMark());
    }

    @Test
    void testIsCellEmpty() {
        assertTrue(cell.isCellEmpty());

        cell.setMark(MarkType.X);
        assertFalse(cell.isCellEmpty());

        cell.setMark(MarkType.O);
        assertFalse(cell.isCellEmpty());

        cell.setMark(MarkType.EMPTY);
        assertTrue(cell.isCellEmpty());
    }
}
