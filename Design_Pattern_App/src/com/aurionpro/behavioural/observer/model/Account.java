package com.aurionpro.behavioural.observer.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private int accountNumber;
	private String name;
	private double balance;
	private List<INotifier> notifiers;

	public Account(int accountNumber, String name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.notifiers = new ArrayList<>();
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

	public List<INotifier> getNotifiers() {
		return notifiers;
	}

	public void setNotifiers(List<INotifier> notifiers) {
		this.notifiers = notifiers;
	}
	
	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Enter a positive amount.");
			return;
		}
		balance += amount;
		notifyAllNotifiers("Deposited amount is " + amount + ", Current Balance: " + balance);
	}
	
	public void withdrawal(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException();
		}
		balance -= amount;
		notifyAllNotifiers("Withdrawn amount is " + amount + ", Current Balance: " + balance);
	}
	
    public void registerNotifier(INotifier notifier) {
        if (notifier != null) {
            notifiers.add(notifier);
        }
    }
    
    private void notifyAllNotifiers(String message) {
        for (INotifier notifier : notifiers) {
            notifier.notify(this, message);
        }
    }
}
