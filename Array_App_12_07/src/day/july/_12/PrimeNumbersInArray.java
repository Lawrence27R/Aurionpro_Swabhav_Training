package day.july._12;

import java.util.Scanner;

public class PrimeNumbersInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = sc.nextInt();
		int array[];
		array = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.println("Enter the elements in the array for : "+i);
			array[i] = sc.nextInt();
		}
		System.out.println("Array is : "+array);
		
		boolean prime = true;
		System.out.println("Prime number are : ");
		for (int i=0; i<size; i++) {
			if (array[i] == 0 || array[i] == 1) {
				prime = false; 
			}
			else {
				for (int j=2; i<array[i]/2; j++) {
					prime = false;
					break;
				}
			}
			if (prime == true) {
				System.out.println(array[i]+" ");
			}
		}
	}
}
