package com.aurionpro.exception;

public class InvalidAmountException extends RuntimeException{
	
	public String getMessage() {
		return "Invalid Amount Entered. Amount should be in positive Integer.";
	}
}
