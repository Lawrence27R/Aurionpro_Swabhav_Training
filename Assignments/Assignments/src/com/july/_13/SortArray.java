package com.july._13;

import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
		int array[];
		array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the element of array at index " + i + ": ");
            array[i] = sc.nextInt();
        }
        System.out.println("Sorted array is :");
        for (int i=0; i<size; i++) {
        	for(int j=i+1; j<size; j++) {
        		if (array[i]>array[j]) {
        			int temp = array[i];
        			array[i] = array[j];
        			array[j] = temp;
        		}
        	}
        	System.out.print(array[i]+" ");
        }
        System.out.println(array[size-2]);
        sc.close();
    }
}
