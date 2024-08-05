package day._04;

import java.util.Scanner;

public class ArmstrongNum {
	public static void main(String[] args) {
		System.out.println("Enter the number :");
		Scanner sc = new Scanner(System.in);
		int sum =0;
		int num = sc.nextInt();
		int storedNum = num;
		int temp = num;
		int pow = 0;
		while (num > 0) {
			pow++;
			num /=10;
		}
		while (temp >0) {
			int rem = temp % 10;
			sum += (int)(Math.pow(rem, pow));
			temp = temp / 10;
		}
		if (sum == storedNum) {
			System.out.println("Number is Armstrong number");
		}
		else {
			System.out.println("Number is not armstrong number");
		}
	}
}
