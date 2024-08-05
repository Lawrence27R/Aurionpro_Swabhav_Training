package com.aurionpro.test;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		
//		Inbuilt Interface Class Consumer
		Consumer<Integer> consumer = (Integer number) -> System.out.println("Square of the number "+number+" is "+number*number);
		consumer.accept(5);
	}
}
