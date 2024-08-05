import java.util.Scanner;

public class DebuggerTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first Number : ");
		int number1 = sc.nextInt();
		
		System.out.println("Enter second Number : ");
		int number2 = sc.nextInt();
		
		int result1 = addtion(number1, number2);
		System.out.println("Addition of numbers : "+result1);
		int result4 = division(number1, number2);
		System.out.println("Division of numbers : "+result4);
	}

	private static int addtion(int number1, int number2) {
		// TODO Auto-generated method stub
		int result3 = multipliaction(number1, number2);
		System.out.println("Multiplication of numbers : "+result3);
		return number1+number2;
	}
	private static int substraction(int number1, int number2) {
		// TODO Auto-generated method stub
		return number1-number2;
	}
	private static int division(int number1, int number2) {
		// TODO Auto-generated method stub
		int result2 = substraction(number1, number2);
		System.out.println("Substraction of numbers : "+result2);
		return number1/number2;
	}

	private static int multipliaction(int number1, int number2) {
		// TODO Auto-generated method stub
		return number1*number2;
	}


}
