package day._04;

import java.util.Scanner;

public class TableNumberPrinter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();
		int result = 0;
		
		for (int i = 1; i<=10; i++) {
			System.out.println("Table is:");
			result = number * i;
			System.out.println(result);
		}
	}
}
