package day._04;

import java.util.Scanner;

public class SumofDigits {
	public static void main(String[] args) {
		System.out.println("Enter the number :");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int sum = 0;
		while (num > 0) {
			int rem = num % 10;
			sum +=rem;
			num /=10;
		}
		System.out.println("Sum is "+sum);
	}
}
