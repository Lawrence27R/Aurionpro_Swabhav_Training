package sum.of.numbers;

public class SimpleInterestCalc {
	public static void main(String[] args) {
		
		double principal = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		double timePeroid = Double.parseDouble(args[2]);
		
		double interest = (principal*rate*timePeroid)/100;
		
		System.out.println("Principal interest is "+interest);
				
	}
}
