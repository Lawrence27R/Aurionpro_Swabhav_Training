package com.swabhav.techlabs;

import java.util.Scanner;

public class CharIsVowelOrNot {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);
		
		System.out.println("Enter the character : e");
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			System.out.println("The character entered is vowel");
		}
		else {
			System.out.println("The character entered is consonent");
		}
	}
}
