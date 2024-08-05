package com.swabhav.model;

import java.util.Scanner;

public class BankAccountApp {
	private int accountNumber;
	private String name;
	private double balance=5000;
	private String accountType;
	private double maximumBalance = 0;
	
	Scanner scanner = new Scanner(System.in);
	public BankAccountApp() {
		
	}
	
	public BankAccountApp(int accountNumber, String name, double balance, String accountType) {
		this.accountNumber=accountNumber;
		this.name=name;
		this.balance=balance;
		this.accountType=accountType;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType=accountType;
	}
	
	public void creditAmount() {
		System.out.println("Enter Amount to deposit : ");
		double depositAmount = scanner.nextDouble();
		if (depositAmount > 0) {
			balance += depositAmount;
			System.out.println("The total balance is : "+balance);
			
		}
		else {
			System.out.println("Enter valid amount");
		}
	}
	
	public void debitAmount() {
		System.out.println("Enter Amount to withdraw : ");
		double withdrawalAmount = scanner.nextDouble();
		if (withdrawalAmount > 0 && withdrawalAmount < balance) {
			balance -= withdrawalAmount;
			System.out.println("The total balance is : "+balance);
		}
		else if (withdrawalAmount > balance){
			System.out.println("Your Account balance is less than Amount Entered");
		}
		else {
			System.out.println("Enter amount in positive integers.");
		}
	}
	
	public void maximumBalanceAccount() {
		if (balance > maximumBalance) {
			maximumBalance = balance;
			System.out.println("Maximum Balance AccountNumber is : "+accountNumber);
		}
	}
}
