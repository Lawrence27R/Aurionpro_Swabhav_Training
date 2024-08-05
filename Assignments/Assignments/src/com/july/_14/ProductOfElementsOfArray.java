package com.july._14;

import java.util.Scanner;

public class ProductOfElementsOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int[] result = productOfElements(array);
        System.out.println("The product array is:");
        printArray(result);
        
        scanner.close();
    }
    
    public static int[] productOfElements(int[] array) {
        int n = array.length;
        int[] product = new int[n];

        if (n == 0) return product;

        for (int i = 0; i < n; i++) {
            product[i] = 1;
        }

        int temp = 1;
        for (int i = 0; i < n; i++) {
            product[i] = temp;
            temp *= array[i];
        }

        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] *= temp;
            temp *= array[i];
        }

        return product;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
