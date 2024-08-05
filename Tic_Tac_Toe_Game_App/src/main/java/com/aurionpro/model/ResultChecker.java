package com.aurionpro.model;

public class ResultChecker implements ICheck {
    @Override
    public boolean isDraw(char[][] board) {
        return board != null && !hasEmptyCells(board);
    }

    private boolean hasEmptyCells(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean haveWon(char[][] board, char player) {
        return checkRows(board, player) || checkColumns(board, player) || checkDiagonals(board, player);
    }

    private boolean checkRows(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[][] board, char player) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char[][] board, char player) {
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
