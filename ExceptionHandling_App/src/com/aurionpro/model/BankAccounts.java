package com.aurionpro.model;

import com.aurionpro.exception.InvalidAmountException;

public class BankAccounts {

	private double accountNumber;
	private String name;
	protected double balance;

	public BankAccounts(double accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
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
	
	double amount = 0;
	public double deposit(double amount) {
	    if (amount < 0) throw new InvalidAmountException();
	    return balance += amount;
	}

	@Override
	public String toString() {
		return "BankAccounts [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", amount="
				+ amount + "]";
	}
}
