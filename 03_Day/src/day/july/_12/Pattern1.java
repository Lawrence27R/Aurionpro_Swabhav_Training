package day.july._12;

import java.util.Scanner;

public class Pattern1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = sc.nextInt();
		
		for (int i = 1; i<=number; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}
