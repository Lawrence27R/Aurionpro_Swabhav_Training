package com.aurionpro.model;

public class SavingBankAccount extends BankAccounts{
	private double minBalance;



	public SavingBankAccount(double accountNumber, String name, int balance, double minBalance) {
		super(accountNumber, name, balance);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "SavingAccount \nMinimum Balance=" + minBalance + ", Account Number =" + getAccountNumber() + ", Name ="
				+ getName() + ", Balance =" + getBalance() ;
	}


}
