package com.swabhav.techlabs;

public class BitwiseOperator {
	public static void main(String[] args) {
		
		int number1 = 7;
		int number2 = 5;
		
		System.out.println("Bitwise And Operation on "+number1+ " and "+number2+" is "+(number1 & number2));
		System.out.println("Bitwise Or Operation on "+number1+ " and "+number2+" is "+(number1 | number2));
		System.out.println("Bitwise left Operation on "+(number1>>1));
		System.out.println("Bitwise left Operation on "+(number1<<1));
	}
}
