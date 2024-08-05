package com.aurionpro.model;

import com.aurionpro.exception.MinimumBalanceException;

public class SavingBankAccount extends BankAccounts {
    private double minBalance;

    public SavingBankAccount(double accountNumber, String name, double balance, double minBalance) {
        super(accountNumber, name, balance);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void withdraw(double amount) {
        if ((getBalance() - amount) < minBalance) {
            throw new MinimumBalanceException(getBalance());
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return "SavingAccount \nMinimum Balance=" + minBalance + ", Account Number =" + getAccountNumber() + ", Name ="
                + getName() + ", Balance =" + getBalance();
    }
}
