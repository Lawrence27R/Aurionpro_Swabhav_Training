package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.list.model.Car;

public class CarTest {
    public static void main(String[] args) {
        List<Car> cars = UserInput();

        System.out.println("Cars entered:");
        for (Car car : cars) {
            System.out.println(car);
        }
        
        double maxMileage = maximumMileage(cars);
        System.out.println("Maximum mileage of the cars entered: " + maxMileage);
        
    }

    public static List<Car> UserInput() {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        System.out.print("Enter the number of cars: ");
        int numberOfCars = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCars; i++) {
            System.out.println("Enter details for car " + (i + 1) + ":");
            System.out.print("Enter Car Id: ");
            int carId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Company name: ");
            String companyName = scanner.nextLine();

            System.out.print("Enter Car price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Car Mileage: ");
            double mileage = scanner.nextDouble();
            scanner.nextLine();

            cars.add(new Car(carId, companyName, price, mileage));
        }

        scanner.close();
        return cars;
    }
    
    public static double maximumMileage(List<Car> cars) {
        if (cars.isEmpty()) {
            return 0; 
        }

        double maxMileage = cars.get(0).getMileage();

        for (Car car : cars) {
            if (car.getMileage() > maxMileage) {
                maxMileage = car.getMileage();
            }
        }

        return maxMileage;
    }
}
