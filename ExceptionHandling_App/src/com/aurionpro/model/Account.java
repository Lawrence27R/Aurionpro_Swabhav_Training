package com.aurionpro.model;

import com.aurionpro.exception.InsufficientBalanceException;

public class Account {
    private int accountNumber;
    private String name;
    private double balance;
    
    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double creditAmount(double amount) {
        return balance += amount;
    }
    
    public double debitAmount(double amount) {
        if(amount > balance) {
            throw new InsufficientBalanceException(balance);
        }
        return balance -= amount;
    }
}
