package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Board;
import com.aurionpro.model.IBoard;
import com.aurionpro.model.ICheck;
import com.aurionpro.model.IPlayer;
import com.aurionpro.model.Player;
import com.aurionpro.model.ResultChecker;
import com.aurionpro.model.TicTacToeGame;

public class TicTacToeGameTest {
    public static void main(String[] args) {
        IBoard board = new Board();
        IPlayer playerX = new Player('X');
        IPlayer playerO = new Player('O');
        ICheck resultChecker = new ResultChecker();

        TicTacToeGame game = new TicTacToeGame(board, playerX, playerO, resultChecker);
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            game.printBoard();
            System.out.print("Player " + game.getCurrentPlayer().getSymbol() + " enter (row and column from 0 to 2 index Eg[0 1]: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (!game.makeMove(row, col)) {
                System.out.println("The cell is already marked. Please enter valid index");
                continue;
            }

            if (game.checkGameOver()) {
                System.out.println("Player " + game.getCurrentPlayer().getSymbol() + " has won");
                gameOver = true;
                continue;
            }

            if (game.isDraw()) {
                System.out.println("The match is a tie");
                gameOver = true;
                continue;
            }

            game.switchPlayer();
        }

        game.printBoard();
    }
}
