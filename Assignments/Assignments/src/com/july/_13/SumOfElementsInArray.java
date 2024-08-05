package com.july._13;

import java.util.Scanner;

public class SumOfElementsInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int size = sc.nextInt();
		int array[];
		array = new int[size];
		int sum = 0;
		
		for (int i=0; i<size; i++) {
			System.out.println("Enter the element of array of index :"+i);
			array[i] = sc.nextInt();
		}
		for (int i=0; i<size; i++) {
			sum += array[i];
		}
		System.out.println("Sum of elements in array :"+sum);
		sc.close();
	}
}
