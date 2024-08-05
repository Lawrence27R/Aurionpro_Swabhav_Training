package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.aurionpro.list.model.Account;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> accounts = accountDetails();

        System.out.println("Accounts before sorting:");
        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println();
        System.out.println("Account with maximum balance is : ");
        try {
            Account maxAccount = maximumBalanceAccount(accounts);
            System.out.println(maxAccount);
        } catch (ListCannotBeEmpty exception) {
            System.out.println(exception.getMessage());
        }
        
        Collections.sort(accounts, sortAccountBalance);

        System.out.println();
        System.out.println("Sorted accounts in ascending order:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static List<Account> accountDetails() {
        List<Account> accounts = new ArrayList<Account>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of accounts to be created.");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.println("Enter account number for " + (i + 1) + " account : ");
            int accountNumber = scanner.nextInt();
            System.out.println("Enter account holder name : ");
            String name = scanner.next();
            System.out.println("Enter initial balance : ");
            double balance = scanner.nextDouble();

            accounts.add(new Account(accountNumber, name, balance));
        }
        return accounts;
    }

    public static Account maximumBalanceAccount(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            throw new ListCannotBeEmpty();
        }

        Account maxBalanceAccount = accounts.get(0);
        double maxBalance = maxBalanceAccount.getBalance();

        for (Account account : accounts) {
            double balance = account.getBalance();
            if (balance > maxBalance) {
                maxBalanceAccount = account;
                maxBalance = balance;
            }
        }

        return maxBalanceAccount;
    }

    public static class ListCannotBeEmpty extends RuntimeException {
        @Override
        public String getMessage() {
            return "The accounts list cannot be null or empty";
        }
    }
    
    public static Comparator<Account> sortAccountBalance = new Comparator<Account>() {
        @Override
        public int compare(Account a1, Account a2) {
            return Double.compare(a1.getBalance(), a2.getBalance());
        }
    };
}
