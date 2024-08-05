package day.july._12;

import java.util.Scanner;

public class AdditionOfMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter for first matrix :");
		System.out.println("Enter the number of rows : ");
		int n1rows = sc.nextInt();
		System.out.println("Enter the number of columns : ");
		int n1columns = sc.nextInt();
		
		int array1[][] = new int[n1rows][n1columns];
		System.out.println("Enter the elemnents in array : ");
		for (int i=0; i<n1rows; i++) {
			for (int j=0; j<n1columns; j++) {
				array1[i][j] = sc.nextInt();
			}
		}
		System.out.println("The matix is : ");
		for (int i=0; i<n1rows; i++) {
			for (int j=0; j<n1columns; j++) {
				System.out.print(array1[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("Enter for second matrix :");
		System.out.println("Enter the number of rows : ");
		int n2rows = sc.nextInt();
		System.out.println("Enter the number of columns : ");
		int n2columns = sc.nextInt();
		
		int array2[][] = new int[n2rows][n2columns];
		System.out.println("Enter the elemnents in array : ");
		for (int i=0; i<n2rows; i++) {
			for (int j=0; j<n2columns; j++) {
				array2[i][j] = sc.nextInt();
			}
		}
		System.out.println("The matix is : ");
		for (int i=0; i<n2rows; i++) {
			for (int j=0; j<n2columns; j++) {
				System.out.print(array2[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		int array3[][] = new int[n1rows][n1columns];
		System.out.println("The addition of matrix is : ");
		for (int i=0; i<n1rows; i++) {
			for (int j=0; j<n1columns; j++) {
				array3[i][j] = array1[i][j] + array2[i][j];
				System.out.print(array3[i][j]+ " ");
			}
			System.out.print("\n");
		}
	}
}
