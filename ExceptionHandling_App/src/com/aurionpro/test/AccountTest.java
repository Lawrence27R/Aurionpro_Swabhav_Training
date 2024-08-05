package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InsufficientBalanceException;
import com.aurionpro.model.Account;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter the name: ");
        String name = scanner.next();
        System.out.println("Enter the balance: ");
        double balance = scanner.nextDouble();
        
        Account account = new Account(accountNumber, name, balance);
        System.out.println("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.creditAmount(depositAmount);
        System.out.println("Deposit successful. Balance is: " + account.getBalance());

        System.out.println("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        try {
            account.debitAmount(withdrawAmount);
            System.out.println("Withdrawal successful. Balance is: " + account.getBalance());
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.getMessage());
        }
        

        scanner.close();
    }
}
