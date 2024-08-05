package day._04;

import java.util.Scanner;

public class TableOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();
		for (int i =1; i<=10; i++) {
			for (int j =1; j<=10; j++) {
				System.out.print(i*j+"\t");
			}
			System.out.println(" ");
		}
	}
}
