package com.july._13;

import java.util.Scanner;

public class ElementExitsInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the element of array at index " + i + ": ");
            array[i] = sc.nextInt();
        }

        System.out.println("Enter the element to check: ");
        int element = sc.nextInt();
        boolean exists = false;

        for (int i = 0; i < size; i++) {
            if (element == array[i]) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println(element + " exists in the array.");
        } else {
            System.out.println(element + " does not exist in the array.");
        }

        sc.close();
    }
}
