package day.july._12;

import java.util.Scanner;

public class CountEvenNumbersInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size : ");
		int size = sc.nextInt();
		int array[];
		int count = 0;
		array = new int[size];
		for(int i=0; i<size; i++) {
			System.out.println("Enter array elemnent :");
			array[i] = sc.nextInt();
		}
		for(int j=0; j<size; j++) {
			System.out.print(+array[j]+" ");
		}
		System.out.println("\n");
		System.out.println("Even Number in array :");
		for (int i=0; i<size; i++) {
			if (array[i]%2==0) {
				System.out.println(+array[i]+" ");
				count++;
			}
		}
		System.out.println("Count of even elements : "+count);
	}
}
