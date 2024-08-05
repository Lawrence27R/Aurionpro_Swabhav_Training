package com.aurionpro.test;

import java.util.function.BiPredicate;

public class BiPredicateTest {
	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> numberEqualChecker = (Integer number1, Integer number2) -> (number1 == number2);
		
		System.out.println(numberEqualChecker.test(30, 30));
	}
}
