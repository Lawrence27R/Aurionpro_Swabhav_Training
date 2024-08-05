package com.aurionpro.model;

public class CurrentAccount extends Account {
private double overDraftLimit;



public CurrentAccount(double accountNumber, String name, int balance, double overDraftLimit) {
	super(accountNumber, name, balance);
	this.overDraftLimit = overDraftLimit;
}

public double getOverDraftLimit() {
	return overDraftLimit;
}

public void setOverDraftLimit(double overDraftLimit) {
	this.overDraftLimit = overDraftLimit;
}

@Override
public String toString() {
	return "CurrentAccount \nOver Draft Limit=" + overDraftLimit + ", AccountNumber =" + getAccountNumber()
			+ ", Name =" + getName() + ", Balance=" + getBalance();
}


}
