package com.aurionpro.exception;

public class OverdraftLimitExceededException extends RuntimeException {
	private double balance;
	
    	public OverdraftLimitExceededException(double balance) {
		super();
		this.balance = balance;
	}

		public String getMessage() {
    		return "Overdraft limit exceeded.(Limit is 15000) : your balance is : "+balance;
    	}
}
