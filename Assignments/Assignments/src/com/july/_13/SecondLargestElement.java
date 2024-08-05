package com.july._13;

import java.util.Scanner;

public class SecondLargestElement {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		int size = scanner.nextInt();

		int array[];
		array = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the element of array at index " + i + ": ");
			array[i] = scanner.nextInt();
		}

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Second largest Element is:: " + array[size - 2]);
	}
}