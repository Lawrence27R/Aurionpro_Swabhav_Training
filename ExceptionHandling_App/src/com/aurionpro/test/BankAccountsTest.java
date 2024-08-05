package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InvalidAmountException;
import com.aurionpro.exception.MinimumBalanceException;
import com.aurionpro.exception.OverdraftLimitExceededException;
import com.aurionpro.model.CurrentBankAccount;
import com.aurionpro.model.SavingBankAccount;

public class BankAccountsTest {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        SavingBankAccount savingAccounts1 = new SavingBankAccount(7001, "Lawrence", 50000, 2000);
        System.out.println(savingAccounts1);
        
        try {
        	System.out.println("Enter Amount to deposit : ");
        	double amount = scanner.nextDouble();
        	savingAccounts1.deposit(amount);
        	System.out.println("Balance is : "+savingAccounts1.getBalance());
        	
        	System.out.println("Enter Amount to withdraw : ");
        	amount = scanner.nextDouble();
            savingAccounts1.withdraw(amount);
        } 
        catch (InvalidAmountException exception) {
        	System.out.println(exception.getMessage());
        }
        
        catch (MinimumBalanceException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(savingAccounts1);
        System.out.println();

        CurrentBankAccount currentAccounts1 = new CurrentBankAccount(7004, "AurionPro", 30000, 15000);
        System.out.println(currentAccounts1);

        try {
        	System.out.println("Enter Amount to deposit : ");
        	double amount = scanner.nextDouble();
        	currentAccounts1.deposit(amount);
        	
        	System.out.println("Balance is : "+currentAccounts1.getBalance());
        	System.out.println("Enter Amount to withdraw : ");
        	amount = scanner.nextDouble();
        	currentAccounts1.withdraw(amount);
        } 
        catch (InvalidAmountException exception) {
        	System.out.println(exception.getMessage());
        }
        
        catch (OverdraftLimitExceededException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(currentAccounts1);
    }
}
