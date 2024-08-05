package com.aurionpro.creational.factory.abstractcar.test;

import com.aurionpro.creational.factory.abstractcar.model.AccountTypeSelector;
import com.aurionpro.creational.factory.abstractcar.model.IAccount;
import com.aurionpro.creational.factory.abstractcar.model.IAccountFactory;
import com.aurionpro.creational.factory.model.AccountType;

public class AccountTest {
    public static void main(String[] args) {
        IAccountFactory savingsFactory = AccountTypeSelector.getFactory(AccountType.SAVINGSACCOUNT);
        IAccount savingsAccount = savingsFactory.createAccount(123, "Alice", 3000);
        System.out.println("Savings account");
        savingsAccount.credit(500);
        savingsAccount.debit(200);
        savingsAccount.debit(5000); 

        IAccountFactory currentFactory = AccountTypeSelector.getFactory(AccountType.CURRENTACCOUNT);
        IAccount currentAccount = currentFactory.createAccount(456, "Bob", 5000);
        System.out.println("Current account");
        currentAccount.credit(1000);
        currentAccount.debit(70000);
    }
}
