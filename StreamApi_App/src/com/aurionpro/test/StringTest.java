package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh");
		
		
		System.out.println();
		names.stream()
			.sorted().limit(3).forEach((name)->System.out.println(name));
		
		System.out.println();
		names.stream().filter((name)->name.contains("a"))
			.sorted().limit(3).forEach((name)->System.out.println(name));
		
		System.out.println();
		names.stream().sorted(Comparator.reverseOrder())
			.forEach((name)->System.out.println(name));
		
		System.out.println();
		names.stream().map((name)-> name.substring(0,3))
					.forEach((name)->System.out.println(name));
		
		
//			show names of less than 4 characters
	}
}
