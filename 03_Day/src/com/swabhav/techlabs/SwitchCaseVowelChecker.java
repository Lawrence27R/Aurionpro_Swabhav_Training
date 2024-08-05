package com.swabhav.techlabs;

import java.util.Scanner;

public class SwitchCaseVowelChecker {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the character : ");
		char ch = sc.nextLine().charAt(0);
		
		switch (ch)
		{
		case 'a': System.out.println("Entered value is vowel");
				break;
		case 'e': System.out.println("Entered value is vowel");
				break;
		case 'i': System.out.println("Entered value is vowel");
				break;
		case 'o': System.out.println("Entered value is vowel");
				break;
		case 'u': System.out.println("Entered value is vowel");
				break;
		default : System.out.println("Entered value is not vowel");
		}
	}
}
