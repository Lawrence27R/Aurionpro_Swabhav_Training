package com.aurionpro.model;

public class Player implements IPlayer {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
