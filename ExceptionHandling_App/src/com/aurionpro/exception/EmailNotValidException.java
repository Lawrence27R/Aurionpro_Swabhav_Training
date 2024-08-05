package com.aurionpro.exception;

public class EmailNotValidException extends RuntimeException {
    String email;

    public EmailNotValidException(String email) {
        super();
        this.email = email;
    }

    public String getMessage() {
        return "Invalid email: " + email;
    }
}
