package day.july._12;

import java.util.Scanner;

public class FindSpecificElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        int nrows = sc.nextInt();
        System.out.println("Enter the number of columns : ");
        int ncolumns = sc.nextInt();
        
        int array[][] = new int[nrows][ncolumns];
        System.out.println("Enter the elements in the matrix : ");
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncolumns; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("The matrix is : ");
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncolumns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Enter the number to find in the matrix : ");
        int number = sc.nextInt();
        boolean found = false;
        
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncolumns; j++) {
                if (array[i][j] == number) {
                    found = true;
                    System.out.println(number + " found in the matrix at position (" + (i+1) + "," + (j+1) + ")");
                }
            }
        }
        
        if (!found) {
            System.out.println(number + " not found in the matrix");
        }
        
        sc.close();
    }
}
