package com.aurionpro.test;

import java.util.function.BiConsumer;

public class BiConsumerTest {
	public static void main(String[] args) {
		
        BiConsumer<Integer, Integer> addNumbers = (number1, number2) -> {
            int result = number1 + number2;
            System.out.println("Result: " + result);
        };
        addNumbers.accept(10, 20);
	}
}
