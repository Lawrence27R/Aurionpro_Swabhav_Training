package day.july._12;

import java.util.Scanner;

public class ReverseElementsInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size : ");
		int size = sc.nextInt();
		int array[];
		array = new int[size];
		for(int i=0; i<size; i++) {
			System.out.println("Enter array elemnent :");
			array[i] = sc.nextInt();
		}
		for(int j=0; j<size; j++) {
			System.out.print(+array[j]+" ");
		}
		System.out.println("Reverse array is :");
		for (int i=size-1; i>=0; i--) {
			System.out.print(+array[i]+" ");
		}
	}
}
