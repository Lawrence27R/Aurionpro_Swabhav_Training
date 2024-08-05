package day._04;

import java.util.Scanner;

public class SumOfEvenNums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int  i = 0;
		int sum = 0;
		while (i <= num) {
			sum += i;
			i+=2;
		}
		System.out.println("Sum of "+num+" Numbers is "+sum);
	}
}
