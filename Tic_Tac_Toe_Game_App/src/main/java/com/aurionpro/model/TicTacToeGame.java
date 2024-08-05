package com.aurionpro.model;

public class TicTacToeGame {
    private IBoard board;
    private IPlayer playerX;
    private IPlayer playerO;
    private IPlayer currentPlayer;
    private ICheck resultChecker;

    public TicTacToeGame(IBoard board, IPlayer playerX, IPlayer playerO, ICheck resultChecker) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
        this.resultChecker = resultChecker;
    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean makeMove(int row, int col) {
        return board.placeMove(row, col, currentPlayer.getSymbol());
    }

    public boolean checkGameOver() {
        return resultChecker.haveWon(board.getBoard(), currentPlayer.getSymbol());
    }

    public boolean isDraw() {
        return resultChecker.isDraw(board.getBoard());
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }
}
