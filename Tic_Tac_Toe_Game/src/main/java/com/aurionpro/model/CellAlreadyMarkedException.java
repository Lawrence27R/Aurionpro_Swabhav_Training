package com.aurionpro.model;

public class CellAlreadyMarkedException extends Exception {
    @Override
    public String getMessage() {
        return "Cell is already marked";
    }
}
