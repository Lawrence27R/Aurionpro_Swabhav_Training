package com.aurionpro.test;

import com.aurionpro.cal.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		
		int a = 20;
		int b = 10;
		
		System.out.println("Addition is : " + Calculator.addition(a, b));
		System.out.println("Substraction is : " + Calculator.substraction(a, b));
		System.out.println("Multiplication is : " + Calculator.multiplication(a, b));
		System.out.println("Division is : " + Calculator.division(a, b));
	}
}


