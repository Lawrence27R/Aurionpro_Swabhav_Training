package com.aurionpro.model;

public interface ICheck {
	boolean isDraw(char[][] board);
	boolean haveWon(char[][] board, char player);
}
