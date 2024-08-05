package day._04;

import java.util.Scanner;

public class SumofNaturalNumbers {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		System.out.println("Enter number : ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		while (i <= number) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
}
