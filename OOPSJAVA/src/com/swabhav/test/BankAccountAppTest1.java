package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.BankAccountApp;

public class BankAccountAppTest1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of account to be created : ");
		int number = scanner.nextInt();
		BankAccountApp bankaccountapp[] = new BankAccountApp[number];
		int targetAccountNumber;
		
		for (int i=0; i<bankaccountapp.length; i++) {
			System.out.println("Enter Account Number : ");
			int accountNumber = scanner.nextInt();
			System.out.println("Enter Account Holder name : ");
			String name = scanner.next();
			System.out.println("Enter Initial Balance : ");
			double balance =scanner.nextDouble();
			System.out.println("Enter the type of account : ");
			
			String accountType = scanner.next();
			bankaccountapp[i] = new BankAccountApp(accountNumber, name, balance, AccountType);
		}
		
		for (int i=0; i<bankaccountapp.length; i++) {
			System.out.println("Account Number : "+bankaccountapp[i].getAccountNumber());
			System.out.println("Account Holder Name : "+bankaccountapp[i].getName());
			System.out.println("Current Balance : "+bankaccountapp[i].getBalance());
			System.out.println("Account Type : "+bankaccountapp[i].getAccountType());
		}
		while (true) {
		    System.out.println("Enter the Account Number to perform operation or 0 to exit: ");
		    targetAccountNumber = scanner.nextInt();
		    
		    if (targetAccountNumber == 0) {
		        break; 
		    }
		    
		    BankAccountApp targetAccount = null;
		    
		    for (int i = 0; i < bankaccountapp.length; i++) {
		        if (targetAccountNumber == bankaccountapp[i].getAccountNumber()) {
		            targetAccount = bankaccountapp[i];
		            break;
		        }
		    }
		    
		    if (targetAccount != null) {
		        int choice = 0;
		        while (choice != 4) {
		            System.out.println("1. Check Balance");
		            System.out.println("2. Deposit");
		            System.out.println("3. Withdraw");
		            System.out.println("4. Exit");
		            choice = scanner.nextInt();
		            
		            switch (choice) {
		                case 1:
		                    System.out.println("Account Balance: " + targetAccount.getBalance());
		                    break;
		                case 2:
		                    targetAccount.creditAmount();
		                    break;
		                case 3:
		                    targetAccount.debitAmount();
		                    break;
		                case 4: break;
		                default:
		                	System.out.println("Invalid choice. Please enter a number between 1 and 3.");
		                	break;
					}
		       }
		    }
		    else {
		    	System.out.println("Account not found with Account Number: " + 2);
		    }
		    
		    
		}
		double maximumBalance = 0;
		for(int i=0; i < bankaccountapp.length; i++) {
			if (bankaccountapp[i].getBalance() > maximumBalance) {
				maximumBalance = bankaccountapp[i].getBalance();
				System.out.println("Maximum Balance AccountNumber is : "+bankaccountapp[i].getAccountNumber());
			}
		}
		scanner.close();
	}
}
