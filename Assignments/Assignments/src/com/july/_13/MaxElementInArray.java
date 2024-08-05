package com.july._13;

import java.util.Scanner;

public class MaxElementInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = sc.nextInt();
		int array[];
		array = new int[size];
		int max = 0;
		for (int i=0; i<size; i++) {
			System.out.println("Enter the element of array of index : "+i);
			array[i] = sc.nextInt();
		}
		for (int i=0; i<size; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		System.out.println("Maximum element in array : "+max);
		sc.close();
	}
}
