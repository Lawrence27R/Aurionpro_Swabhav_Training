package com.aurionpro.test;

import com.aurionpro.model.*;

import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", MarkType.X);
        Player player2 = new Player("Player 2", MarkType.O);
        Player[] players = {player1, player2};

        Board board = new Board();
        ResultAnalyzer analyzer = new ResultAnalyzer(board);
        Game game = new Game(player1, players, board, analyzer);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current Board:");
            printBoard(board);
            
            System.out.println(game.getCurrentPlayer().getPlayerName() + "'s turn. Enter a position (0-8):");
            int position = scanner.nextInt();

            try {
                game.play(position);
                ResultType result = analyzer.analyzeResult();
                
                if (result == ResultType.WIN) {
                    System.out.println("Current Board:");
                    printBoard(board);
                    System.out.println(game.getCurrentPlayer().getPlayerName() + " wins!");
                    break;
                } else if (result == ResultType.DRAW) {
                    System.out.println("Current Board:");
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }
            } catch (CellAlreadyMarkedException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printBoard(Board board) {
        Cell[] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            System.out.print(cells[i].getMark() + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}
