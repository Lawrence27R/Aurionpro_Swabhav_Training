package day._04;

import java.util.Scanner;

public class PrimeNumberPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int number = sc.nextInt();
        int primeCount = 1;
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(getNthPrime(primeCount++) + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }

    private static int getNthPrime(int n) {
        int count = 0;
        int num = 2;
        
        while (count < n) {
            if (isPrime(num)) {
                count++;
            }
            num++;
        }

        return num - 1;
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
