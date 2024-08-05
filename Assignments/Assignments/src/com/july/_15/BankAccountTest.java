package com.july._15;

import java.util.Scanner;

import com.july._14.BankAccount;

public class BankAccountTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount bankaccount = new BankAccount();
        
        System.out.println("Enter the Account Number : ");
        int num = sc.nextInt();
        bankaccount.setAccountNumber(num);
        System.out.println("Account Number is "+getAccountNumber());

        int choice = 0;
        while (choice != 4) {
            bankaccount.display();
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    bankaccount.checkBalance();
                    break;
                case 2:
                    bankaccount.deposit(sc);
                    break;
                case 3:
                    bankaccount.withdrawal(sc);
                    break;
                case 4:
                    bankaccount.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        sc.close();
    }
}