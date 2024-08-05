package com.aurionpro.exception;

public class InsufficientBalanceException extends RuntimeException {
    private double balance;
    
    public InsufficientBalanceException(double balance) {
        super();
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "The amount entered is greater than the account balance. Please enter lesser amount: " + balance;
    }
}
