package com.aurionpro.model;

public class Board {
    private Cell[] cells;

    public Board() {
        cells = new Cell[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(MarkType.EMPTY);
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.getMark() == MarkType.EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void setCellMark(int location, MarkType mark) throws CellAlreadyMarkedException {
        if (cells[location].getMark() != MarkType.EMPTY) {
            throw new CellAlreadyMarkedException();
        }
        cells[location].setMark(mark);
    }
}
