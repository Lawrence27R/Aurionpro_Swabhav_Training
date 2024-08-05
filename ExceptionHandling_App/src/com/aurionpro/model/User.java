package com.aurionpro.model;

import java.util.regex.Pattern;
import com.aurionpro.exception.EmailNotValidException;
import com.aurionpro.exception.PasswordNotValidException;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void validateEmail(String email) {
        if (email == null || email.isEmpty() || email.length() < 5 || email.length() > 50) {
            throw new EmailNotValidException("Email length should be between 5 and 50 characters.");
        }
        if (!email.contains("@")) {
            throw new EmailNotValidException("Email should contain '@'.");
        }
        if (!email.contains(".")) {
            throw new EmailNotValidException("Email should contain '.'.");
        }
    }

    public static void validatePassword(String password) {
        if (password == null || password.isEmpty() || password.length() < 8 || password.length() > 30) {
            throw new PasswordNotValidException("Password length must be between 8 and 30 characters.");
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            throw new PasswordNotValidException("Password must contain at least one uppercase letter.");
        }
        if (!Pattern.compile("[!, @, #, $, %, *]").matcher(password).find()) {
            throw new PasswordNotValidException("Password must contain at least one special character.");
        }
        if (!Pattern.compile("\\d").matcher(password).find()) {
            throw new PasswordNotValidException("Password must contain at least one digit.");
        }
    }
}
