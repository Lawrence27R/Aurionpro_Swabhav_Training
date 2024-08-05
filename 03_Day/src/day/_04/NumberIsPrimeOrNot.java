package day._04;

import java.util.Scanner;

public class NumberIsPrimeOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		int i = 2;
		if (num < 2) {
			System.out.println(num+" is not a prime number ");
		}
		else {
			while (i < num) {
				if (num % i == 0) {
					System.out.println(num+" is not prime number");
					break;
				}
				i++;
			}
			if (num == i) {
				System.out.println(num+" is a prime number");
			}
		}
	}
}
