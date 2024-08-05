package day._04;

import java.util.Scanner;

public class PerfectNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		
		int temp = num;
		int i = 1;
		int sum = 0;
		while (i <= num/2) {
			if (num % i == 0) {
				
				sum += i;
			}
			i++;
		}
		if (sum == temp) {
			System.out.println(temp+" is a perfect number.");
		}
		else {
			System.out.println(temp+" is a not perfect number.");
		}
	}
}
