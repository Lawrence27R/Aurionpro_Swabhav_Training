package com.aurionpro.test;

public class Test {
	public static void main(String[] args) {
		
		try {
			int number1 = Integer.parseInt(args[0]);
			int number2 = Integer.parseInt(args[1]);
			double result = number1/number2;
			
			System.out.println("Result is : "+result);
		}
		catch (ArithmeticException exception) {
			System.out.println("Invalid number2 input. Division by zero");
		}
		
		catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Enter two number. Input numbers cannot be empty");
		}
		
		catch (NumberFormatException exception) {
			System.out.println("Invalid input. Only Integers value are allowed");
		}
		//Should be written at the end 
		catch (Exception exception) {
			System.out.println("Invalid number2 input. Division by zero");
		}
		finally {
			System.out.println("Inside finally. Closing Activities");
		}
		System.out.println("Existing main");
	}
}
