package com.july._13;

import java.util.Scanner;

public class NumberOfDuplicateElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = sc.nextInt();
		int array[];
		array = new int[size];
		int count = 0;
		
		for (int i=0; i<size; i++) {
			System.out.println("Enter the element in the array for index "+i);
			array[i] = sc.nextInt();
		}
		for(int i=0; i<size; i++) {
			for (int j=i+1; j<size; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}
		}
		System.out.println("Number of duplicate element "+count);
	}
}
