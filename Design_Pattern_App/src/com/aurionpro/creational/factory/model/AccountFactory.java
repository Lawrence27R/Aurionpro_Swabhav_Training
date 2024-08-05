package com.aurionpro.creational.factory.model;

public class AccountFactory {
    public IAccount createAccount(AccountType accountType, int accountNumber, String name, double balance, double extra) {
        switch (accountType) {
            case SAVINGSACCOUNT:
                return new SavingsAccount(accountNumber, name, balance);
            case CURRENTACCOUNT:
                return new CurrentAccount(accountNumber, name, balance, extra);
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
    }
}
