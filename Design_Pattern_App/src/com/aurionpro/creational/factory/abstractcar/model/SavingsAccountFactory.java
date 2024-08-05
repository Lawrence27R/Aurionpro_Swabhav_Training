package com.aurionpro.creational.factory.abstractcar.model;

public class SavingsAccountFactory implements IAccountFactory {
    @Override
    public IAccount createAccount(int accountNumber, String name, double balance) {
        return new SavingsAccount(accountNumber, name, balance);
    }
}
