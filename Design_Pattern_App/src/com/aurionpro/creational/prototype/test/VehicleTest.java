package com.aurionpro.creational.prototype.test;

import com.aurionpro.creational.prototype.model.Bike;
import com.aurionpro.creational.prototype.model.Car;
import com.aurionpro.creational.prototype.model.Vehicle;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle bike = new Bike(1, 2, "Black", "Petrol");
        Vehicle car = new Car(5, 4, "White", "Electric");

        Vehicle clonedBike = bike.clone();
        Vehicle clonedCar = car.clone();

        clonedBike.setColor("Red");
        clonedBike.setFuel("Diesel");
        clonedCar.setColor("Blue");

        System.out.println("Original Objects:");
        System.out.println(bike);
        System.out.println(car);

        System.out.println("Cloned Objects:");
        System.out.println(clonedBike);
        System.out.println(clonedCar);
    }
}
