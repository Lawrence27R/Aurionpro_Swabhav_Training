package sum.of.numbers;

public class SwappingNums {
	public static void main(String[] args) {
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		int temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("Numbers after swapping "+num1+ " and "+num2);
				
	}
}
