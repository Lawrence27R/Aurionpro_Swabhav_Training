package day._04;
//For loop is used when the number is specified i.e "n" & while loop is used when not specified

import java.util.Scanner;

public class ForLoopNumbers {
	public static void main(String[] args) {
		System.out.println("Enter the number : ");
		Scanner sc = new Scanner(System.in);
		for (int i=1; i<=100; i++) {
			System.out.println(i);
		}
	}
}
