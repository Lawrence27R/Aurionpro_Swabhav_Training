package com.aurionpro.test;

import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountsTesting {
public static void main(String[] args) {
	SavingAccount savingAccounts1 = new SavingAccount(011123, "Suhas", 450000, 2000);
	System.out.println(savingAccounts1);
	
	System.out.println();
	
	CurrentAccount currentAccounts1 = new CurrentAccount(0223131, "Swabhav", 3000000, 15000);
	System.out.println(currentAccounts1);
}
}
