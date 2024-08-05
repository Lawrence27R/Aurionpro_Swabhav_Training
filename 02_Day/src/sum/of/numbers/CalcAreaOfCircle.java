package sum.of.numbers;

public class CalcAreaOfCircle {
	public static void main(String[] args) {
		
		int raidus = Integer.parseInt(args[0]);
		
		double area = 3.14 * raidus * raidus;
		System.out.println("Area of circle with radius "+raidus+" is "+area);
	}
}
