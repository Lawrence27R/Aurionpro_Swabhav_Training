package com.aurionpro.exception;

public class PasswordNotValidException extends RuntimeException {
    String password;

    public PasswordNotValidException(String message) {
        super(message);
        this.password = message;
    }

    public String getMessage() {
        return "Password error: " + password;
    }
}
