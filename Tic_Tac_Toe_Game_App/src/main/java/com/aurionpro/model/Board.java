package com.aurionpro.model;

public class Board implements IBoard {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    @Override
    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < board[row].length - 1) {
                	System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < board.length - 1) {
            	System.out.println("--+---+--");
            }
        }
    }

    @Override
    public boolean placeMove(int row, int col, char player) {
        if (board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        }
        return false;
    }
}
