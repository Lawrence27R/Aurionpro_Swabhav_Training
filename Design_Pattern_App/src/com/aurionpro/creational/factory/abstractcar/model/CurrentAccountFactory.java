package com.aurionpro.creational.factory.abstractcar.model;

public class CurrentAccountFactory implements IAccountFactory {
    @Override
    public IAccount createAccount(int accountNumber, String name, double balance) {
        double defaultOverDraftLimit = -10000;
        return new CurrentAccount(accountNumber, name, balance, defaultOverDraftLimit);
    }
}
