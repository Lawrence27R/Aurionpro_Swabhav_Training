package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.exception.EmailNotValidException;
import com.aurionpro.exception.PasswordNotValidException;
import com.aurionpro.model.User;

public class UserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = null;
        String password = null;
        boolean validEmail = false;
        boolean validPassword = false;

        while (!validEmail) {
            try {
                System.out.println("Enter email id: ");
                email = scanner.next();
                User.validateEmail(email); 
                validEmail = true;
            } catch (EmailNotValidException exception) {
                System.out.println(exception.getMessage());
            }
        }


        while (!validPassword) {
            try {
                System.out.println("Enter password: ");
                password = scanner.next();
                User.validatePassword(password);
                validPassword = true;
            } catch (PasswordNotValidException exception) {
                System.out.println(exception.getMessage());
            }
        }


        User user = new User(email, password);
        System.out.println("User Email: " + user.getEmail());
        System.out.println("User Password: " + user.getPassword());

        try {
            System.out.println("Enter new email id: ");
            email = scanner.next();
            User.validateEmail(email);
            user.setEmail(email);
        } catch (EmailNotValidException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println("Enter new password: ");
            password = scanner.next();
            User.validatePassword(password);
            user.setPassword(password);
        } catch (PasswordNotValidException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("User Email: " + user.getEmail());
        System.out.println("User Password: " + user.getPassword());

        scanner.close();
    }
}
