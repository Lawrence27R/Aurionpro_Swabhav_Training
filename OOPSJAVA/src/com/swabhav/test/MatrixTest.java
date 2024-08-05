package com.swabhav.test;

import java.util.Scanner;

public class MatrixTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int matrix[][] = new int[3][3];
		
		System.out.println("Enter the element of matrix : ");
		createRows(matrix, scanner);
		
		System.out.println("Matrix is : ");
		printMatrix(matrix);

	}
	
	public static void readRowElements(int matrix[][], Scanner scanner, int row) {
		for (int col=0; col<3; col++) {
			matrix[row][col] = scanner.nextInt();
		}
	}
	
	public static void createRows(int matrix[][], Scanner scanner) {
		for (int row=0; row<3; row++) {
			readRowElements(matrix, scanner, row);
		}
	}
	
	public static void printRowElements(int matrix[][], int row) {
		for (int col=0; col<3; col++) {
			System.out.print(matrix[row][col]+" ");
		}
		System.out.println("");
	}
	public static void printMatrix(int matrix[][]) {
		for (int row=0; row<3; row++) {
			printRowElements(matrix, row);
		}
		
	}
}
