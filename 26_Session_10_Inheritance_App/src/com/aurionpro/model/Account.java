package com.aurionpro.model;

public class Account {
private double accountNumber;
private String name;
private int balance;



public Account(double accountNumber, String name, int balance) {
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
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}

}
