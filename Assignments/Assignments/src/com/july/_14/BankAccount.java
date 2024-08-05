package com.july._14;

import java.util.Scanner;

public class BankAccount {

    private int accountNumber;
    private String name;
    private int balance;
    Scanner sc = new Scanner(System.in);
    
    public BankAccount() {
    	accountNumber = 989999989;
    	name = "Lawrence";
    	
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Account Balance is : " + balance);
    }

    public void deposit(Scanner sc) {
        System.out.println("Enter the amount to deposit : ");
        int depositAmt = sc.nextInt();
        if (depositAmt > 0) {
            balance += depositAmt;
            System.out.println("Your Account balance is : " + balance);
        } else {
            System.out.println("Enter Valid Amount");
        }
    }

    public void withdrawal(Scanner sc) {
        System.out.println("Enter the amount to withdraw : ");
        int withdrawalAmt = sc.nextInt();
        if (withdrawalAmt > balance) {
            System.out.println("Your Account balance is less than withdrawal amount.");
            System.out.println("Your Account balance is : " + balance);
        } else if (withdrawalAmt < 0) {
            System.out.println("Invalid Amount");
        } else {
            balance -= withdrawalAmt;
            System.out.println("Your Account balance is : " + balance);
        }
    }

    public void exit() {
        System.out.println("Program Terminated");
    }

    public void display() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }
}