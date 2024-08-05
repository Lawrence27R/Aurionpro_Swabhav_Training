package com.aurionpro.test;

import java.util.function.BiFunction;

public class BiFunctionTest {
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> additionOfNumbers = 
				(Integer number1, Integer number2) -> number1+number2;
		
		method(additionOfNumbers);
	}
	
	private static void method(BiFunction<Integer, Integer, Integer> additionOfNumbers) {
		System.out.println(additionOfNumbers.apply(20, 30));
	}
}
