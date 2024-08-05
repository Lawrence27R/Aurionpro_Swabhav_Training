package com.aurionpro.creational.factory.abstractcar.model;

public class CurrentAccount implements IAccount {
    private int accountNumber;
    private String name;
    private double balance;
    private double overDraftLimit;

    public CurrentAccount(int accountNumber, String name, double balance, double overDraftLimit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.overDraftLimit = overDraftLimit;
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



	public double getOverDraftLimit() {
		return overDraftLimit;
	}



	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}



	@Override
    public void credit(double amount) {
        balance += amount;
        System.out.println("Balance: " + balance);
    }

    @Override
    public void debit(double amount) {
        if ((balance - amount) < overDraftLimit) {
            System.out.println("The entered amount exceeds the overdraft limit.");
            return;
        }
        balance -= amount;
        System.out.println("Balance: " + balance);
    }
}
