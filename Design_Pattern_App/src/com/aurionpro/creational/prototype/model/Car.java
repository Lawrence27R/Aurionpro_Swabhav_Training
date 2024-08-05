package com.aurionpro.creational.prototype.model;

public class Car extends Vehicle {

    public Car() {
    }

    public Car(int seats, int tyres, String color, String fuel) {
        super(seats, tyres, color, fuel);
    }

    @Override
    public Car clone() {
        return new Car(getSeats(), getTyres(), getColor(), getFuel());
    }
}
