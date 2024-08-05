package day.july._12;

import java.util.Scanner;

public class ArrayApp {
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
			System.out.print("Array is : "+array[j]+"\t");
		}
	}
}
