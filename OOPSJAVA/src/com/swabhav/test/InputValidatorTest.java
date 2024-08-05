package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.InputValidator;

public class InputValidatorTest {
 
	public static void main(String[] args) {
 
        InputValidator validator=new InputValidator();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Username");
        String username=scanner.next();
        checkUsername(validator, username);
        System.out.println("Enter Passowrd");
        String password=scanner.next();
        checkPassword(validator, password);
        System.out.println("Enter Email");
        String email=scanner.next();
        checkEmail(validator, email);
 
	}
	private static void checkUsername(InputValidator validator, String username)
	{
		if(!validator.validateUsername(username))
        {
        	System.out.println("Username is invalid");
        	return;
        }
        System.out.println("Username is valid");
	}
	private static void checkPassword(InputValidator validator, String password)
	{
		if(!validator.validatePassword(password))
        {
        	System.out.println("Passowrd is invalid");
        	return;
        }
        System.out.println("Password is valid");
	}
	private static void checkEmail(InputValidator validator, String email)
	{
		if(!validator.validatePassword(email))
        {
        	System.out.println("Email is invalid");
        	return;
        }
        System.out.println("Email is valid");
	}
 
}