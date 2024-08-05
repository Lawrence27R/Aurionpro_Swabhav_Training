package day._04;

import java.util.Scanner;

public class ReverseNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		int rev = 0;
		int temp = num;
		while (num > 0) {
			int rem = num % 10;
			rev = rev*10+rem;
			num /=10;
		}
		System.out.println(rev);
		if(rev == temp) {
			System.out.println(rev+" is palindrome");
		}
		else {
			System.out.println(rev+" is not palindrome");
		}
	}
}
