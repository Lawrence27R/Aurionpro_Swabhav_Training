package day.july._12;

import java.util.Scanner;

	public class PrimeNumberPattern {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number : ");
			int number = sc.nextInt();
			
			for (int prime = 3; prime<= number; i++) {
				if (prime %  != 0) {
					System.out.println();
				}
			}
			int count = 1;
			
			for (int i = 1; i<=number; i++) {
				for (int j=1; j<=i; j++) {
					System.out.print(count+" ");
					count++;
				}
				System.out.println(" ");
			}
		}
}
