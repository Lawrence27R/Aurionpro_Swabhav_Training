package day.july._12;

import java.util.Scanner;

public class MultiplicationOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows for matrix A: ");
        int rowsA = sc.nextInt();
        System.out.println("Enter the number of columns for matrix A: ");
        int colsA = sc.nextInt();
        
        int matrixA[][] = new int[rowsA][colsA];
        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of rows for matrix B: ");
        int rowsB = sc.nextInt();
        System.out.println("Enter the number of columns for matrix B: ");
        int colsB = sc.nextInt();
        
        int matrixB[][] = new int[rowsB][colsB];
        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }
        
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible.");
        } 
        else {
            int resultMatrix[][] = new int[rowsA][colsB];
            
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
            
            System.out.println("Resultant matrix after multiplication:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        
        sc.close();
    }
}
