package day.july._12;

import java.util.Scanner;

public class FindNumberInMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows : ");
		int nrows = sc.nextInt();
		System.out.println("Enter the number of columns : ");
		int ncolumns = sc.nextInt();
		
		int array[][] = new int[nrows][ncolumns];
		System.out.println("Enter the elemnents in array : ");
		for (int i=0; i<nrows; i++) {
			for (int j=0; j<ncolumns; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		System.out.println("The matix is : ");
		for (int i=0; i<nrows; i++) {
			for (int j=0; j<ncolumns; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("Enter the number to find in matrix : ");
		int number = sc.nextInt();
		boolean found = false;
		for (int i=0; i<nrows; i++) {
			for (int j=0; j<ncolumns; j++) {
				if (number == array[i][j]) {
					found = true;
				}
			}
		}
		if (found == true) {
			System.out.println(number+" found in matrix");
		}
		else {
			System.out.println(number+" not found in matrix");
		}
	}
}
