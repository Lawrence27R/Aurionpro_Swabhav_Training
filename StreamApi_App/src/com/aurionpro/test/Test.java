package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(20,24,30, 35, 45, 50);
		
//		Stream<Integer> numberStream = numbers.stream();
		
//		numbers.stream()
//			   .forEach((number)->System.out.println(number));
		
		List<Integer> filteredNumbers = numbers.stream()
			   .filter((number) -> (number%2!=0))
			   .filter((number)-> (number>25))
			   .collect(Collectors.toList());
			   
		filteredNumbers.forEach((number)->System.out.println(number));
		
//		Printing square of the numbers
		
		List<Integer> squaredNumbers = numbers.stream()
				.map((number)->number*number)
				.collect(Collectors.toList());
		
		squaredNumbers.forEach((number)->System.out.println(number));
			
//		Sum of the numbers
		
		int sum = numbers.stream().reduce(0, (number1, number2)-> number1+number2);
		System.out.println(sum);
		
		numbers.stream().sorted()
						.forEach((number)->System.out.println(number));	
		
		numbers.stream().sorted(Comparator.reverseOrder())
						.limit(3)
						.forEach((number)->System.out.println(number));	
		
		
		Optional<Integer> maxNum = numbers.stream().max((number1, number2)-> number1-number2);
		
		if(maxNum.isPresent()) {
			System.out.println("Max number is: "+maxNum.get());
		}
		
		Optional<Integer> minNum = numbers.stream().min((number1, number2)->number1-number2);
		
		if(minNum.isPresent()) {
			System.out.println("Min number is: "+minNum.get());
		}
		
	}
}
