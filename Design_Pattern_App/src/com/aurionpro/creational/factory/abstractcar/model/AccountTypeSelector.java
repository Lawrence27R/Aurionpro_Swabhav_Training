package com.aurionpro.creational.factory.abstractcar.model;

import com.aurionpro.creational.factory.model.AccountType;

public class AccountTypeSelector {
    public static IAccountFactory getFactory(AccountType accountType) {
        if (accountType == AccountType.SAVINGSACCOUNT) {
            return new SavingsAccountFactory();
        }
        if (accountType == AccountType.CURRENTACCOUNT) {
            return new CurrentAccountFactory();
        }
        throw new IllegalArgumentException("Invalid account type");
    }
}
