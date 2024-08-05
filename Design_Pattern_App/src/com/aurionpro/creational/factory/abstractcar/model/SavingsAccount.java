package com.aurionpro.creational.factory.abstractcar.model;

public class SavingsAccount implements IAccount {
    private int accountNumber;
    private String name;
    private double balance;
    private static final double MINIMUM_BALANCE = 2000;

    public SavingsAccount(int accountNumber, String name, double balance) {
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least " + MINIMUM_BALANCE);
        }
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



	public static double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}



	@Override
    public void credit(double amount) {
        balance += amount;
        System.out.println("Total balance: " + balance);
    }

    @Override
    public void debit(double amount) {
        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println("Debit amount exceeds the minimum balance requirement. Balance must remain at least " + MINIMUM_BALANCE);
            return;
        }
        balance -= amount;
        System.out.println("Balance: " + balance);
    }
}
