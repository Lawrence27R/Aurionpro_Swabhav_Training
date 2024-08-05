package com.swabhav.techlabs;

import java.util.Scanner;

public class AssignmentOperators {
	public static void main(String[] args) {
		
		int number2 = 15;
		boolean num = false;
		Scanner sc = new Scanner(System.in);
		
		int number1 = sc.nextInt();
		
		number1 += 3;
		System.out.println("Addition "+number1);  
		number1-=4;  
		System.out.println("Substraction "+number1);  
		number1*=2; 
		System.out.println("Multiplication "+number1);  
		number1/=2;
		System.out.println("Division "+number1);
		
		number1 = number2;
		System.out.println("Equal to operator : "+number1);
		System.out.println("Negation opeator :"+ !num);
		
		
	}
}
