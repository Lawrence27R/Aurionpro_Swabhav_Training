package com.aurionpro.creational.factory.model;

public class SavingsAccount implements IAccount {
    private int accountNumber;
    private String name;
    private double balance;

    public SavingsAccount(int accountNumber, String name, double balance) {
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



	@Override
    public void credit(double amount) {
        balance += amount;
        System.out.println("Total balance: " + balance);
    }

    @Override
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Entered amount should be less than current balance: " + balance);
            return;
        }
        balance -= amount;
        System.out.println("Balance: " + balance);
    }
}
