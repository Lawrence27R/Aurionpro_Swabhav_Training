package com.aurionpro.test;

import com.aurionpro.model.CurrentBankAccount;
import com.aurionpro.model.SavingBankAccount;

public class BankAccountsTest {
	public static void main(String[] args) {
		SavingBankAccount savingAccounts1 = new SavingBankAccount(011123, "Suhas", 450000, 2000);
		System.out.println(savingAccounts1);
		
		System.out.println();
		
		CurrentBankAccount currentAccounts1 = new CurrentBankAccount(0223131, "Swabhav", 3000000, 15000);
		System.out.println(currentAccounts1);
	}
}
