package com.aurionpro.exception;

public class MinimumBalanceException extends RuntimeException {
    private double balance;

    public MinimumBalanceException(double balance) {
        super();
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "Minimum balance requirement not met: your balance is " + balance;
    }
}
