package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.AgeNotValidException;
import com.aurionpro.model.Voter;

public class VoterTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Voter Id: ");
		int voterId = scanner.nextInt();
		System.out.println("Enter Voter FirstName: ");
		String firstName = scanner.next();
		System.out.println("Enter Voter LastName: ");
		String lastName = scanner.next();
		System.out.println("Enter age : ");
		int age = scanner.nextInt();
		
		Voter voter = null;
		try {
			if (age < 18) 
				voter = new Voter(voterId,firstName,lastName,age);
		}
		catch (AgeNotValidException exception){
			System.out.println(exception.getMessage());
		}
		System.out.println(voter);
		scanner.close();
	}
}
