package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.aurionpro.model.Account;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> accounts = accountInput();

        Optional<Account> minimumBalanceAccount = accounts.stream()
                .min(Comparator.comparing(Account::getBalance));

        if (minimumBalanceAccount.isPresent()) {
            System.out.println("Minimum account balance is: " + minimumBalanceAccount.get());
        }

        Optional<Account> maximumBalanceAccount = accounts.stream()
                .max(Comparator.comparing(Account::getBalance));

        if (maximumBalanceAccount.isPresent()) {
            System.out.println("Maximum account balance is: " + maximumBalanceAccount.get());
        }

        System.out.println("First three alphabets of account holders' names:");
        accounts.stream()
                .map(account -> account.getName().substring(0, 3))
                .forEach(System.out::println);

        Double totalBalance = accounts.stream()
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);

        System.out.println("Total balance: " + totalBalance);
    }

    private static List<Account> accountInput() {
        List<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of accounts to be created : ");
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
        scanner.close();
        return accounts;
    }
}
