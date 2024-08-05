package com.aurionpro.model;

public interface IBoard {
    char[][] getBoard();
    void printBoard();
    boolean placeMove(int row, int col, char player);
}
