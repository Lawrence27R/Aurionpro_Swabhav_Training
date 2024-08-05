package day._04;

public class OddNumbers {
	public static void main(String[] args) {
		int number = 1;
		while (number <=100) {
			if (number % 2 != 0) {
				System.out.println(number);
			}
			number++;
		}
	}
}
