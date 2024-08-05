package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.*;

public class AccountTest {
    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();

        IAccount savingsAccount = accountFactory.createAccount(AccountType.SAVINGSACCOUNT, 123, "Alice", 3000, 0);
        savingsAccount.credit(500);
        savingsAccount.debit(200);

        IAccount currentAccount = accountFactory.createAccount(AccountType.CURRENTACCOUNT, 456, "Bob", 5000, -10000);
        currentAccount.credit(1000);
        currentAccount.debit(7000);
    }
}
