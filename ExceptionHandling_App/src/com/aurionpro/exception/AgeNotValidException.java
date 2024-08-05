package com.aurionpro.exception;

public class AgeNotValidException extends RuntimeException{
	
	int age;
	
	public AgeNotValidException(int age) {
		super();
		this.age = age;
	}

	public String getMessage(){
		return "Invalid age. Age must be greater than 18. Entered Age value is : "+age;	
	}
}
