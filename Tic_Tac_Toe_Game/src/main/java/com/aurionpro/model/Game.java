package com.aurionpro.model;

public class Game {
    private Player currentPlayer;
    private Player[] players;
    private Board board;
    private ResultAnalyzer analyzer;

    public Game(Player currentPlayer, Player[] players, Board board, ResultAnalyzer analyzer) {
        this.currentPlayer = currentPlayer;
        this.players = players;
        this.board = board;
        this.analyzer = analyzer;
    }

    public void play(int location) throws CellAlreadyMarkedException {
        board.setCellMark(location, currentPlayer.getMark());
        ResultType result = analyzer.analyzeResult();
        if (result == ResultType.PROGRESS) {
            switchCurrentPlayer();
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
