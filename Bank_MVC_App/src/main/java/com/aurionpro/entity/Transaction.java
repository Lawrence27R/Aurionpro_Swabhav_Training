package com.aurionpro.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private Timestamp transactionDate;
    private double amount;
    private String transactionType;
    
    public Transaction() {
    	
    }
    
	public Transaction(int transactionId, Timestamp transactionDate, double amount, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", amount="
				+ amount + ", transactionType=" + transactionType + "]";
	}
    
    
}