package com.aurionpro.model;

public class ResultAnalyzer {
    private Board board;

    public ResultAnalyzer(Board board) {
        this.board = board;
    }

    public void horizontalWinCheck() {
        if (checkRows()) {
            System.out.println("Horizontal win detected!");
        }
    }

    
    public boolean checkRows() {
        for (int i = 0; i < 9; i += 3) {
            if (board.getCells()[i].getMark() != MarkType.EMPTY &&
                board.getCells()[i].getMark() == board.getCells()[i + 1].getMark() &&
                board.getCells()[i + 1].getMark() == board.getCells()[i + 2].getMark()) {
                return true;
            }
        }
        return false;
    }


    public void verticalWinCheck() {
        if (checkColumns()) {
            System.out.println("Vertical win detected!");
        }
    }
    
    public boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.getCells()[i].getMark() != MarkType.EMPTY &&
                board.getCells()[i].getMark() == board.getCells()[i + 3].getMark() &&
                board.getCells()[i + 3].getMark() == board.getCells()[i + 6].getMark()) {
                return true;
            }
        }
        return false;
    }




    public boolean checkDiagonals() {
        Cell[] cells = board.getCells();
        
        if (cells[0].getMark() != MarkType.EMPTY &&
            cells[0].getMark() == cells[4].getMark() &&
            cells[4].getMark() == cells[8].getMark()) {
            return true;
        }
        
        if (cells[2].getMark() != MarkType.EMPTY &&
            cells[2].getMark() == cells[4].getMark() &&
            cells[4].getMark() == cells[6].getMark()) {
            return true;
        }
        
        return false;
    }

    public void diagonalWinCheck() {
        if (checkDiagonals()) {
            System.out.println("Diagonal win detected!");
        }
    }


    public ResultType analyzeResult() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            return ResultType.WIN;
        }
        
        if (board.isBoardFull()) {
            return ResultType.DRAW;
        }
        
        return ResultType.PROGRESS;
    }

}
