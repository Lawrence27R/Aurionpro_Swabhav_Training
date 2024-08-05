package com.aurionpro.model;

import com.aurionpro.exception.OverdraftLimitExceededException;

public class CurrentBankAccount extends BankAccounts {
    private double overDraftLimit;

    public CurrentBankAccount(double accountNumber, String name, double balance, double overDraftLimit) {
        super(accountNumber, name, balance);
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public void withdraw(double amount) {
        if (getBalance() - amount < -(overDraftLimit)) {
            throw new OverdraftLimitExceededException(getBalance());
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return "CurrentAccount \nOver Draft Limit=" + overDraftLimit + ", AccountNumber =" + getAccountNumber()
                + ", Name =" + getName() + ", Balance=" + getBalance();
    }
}
