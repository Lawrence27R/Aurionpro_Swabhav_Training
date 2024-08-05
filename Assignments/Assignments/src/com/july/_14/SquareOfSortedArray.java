package com.july._14;

import java.util.Scanner;

public class SquareOfSortedArray {
	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int array[] = new int[size];
		System.out.println("Enter the elements of array of size "+size);
		for (int i=0; i<size; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Array after squaring elements : ");
		for (int i=0; i<size; i++) {
			array[i] = array[i]* array[i];
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("Sorted array : ");
		for (int i=0; i<size; i++) {
			for (int j=i+1; j<size; j++) {
				
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			System.out.print(array[i]+" ");
		}
	}
}
