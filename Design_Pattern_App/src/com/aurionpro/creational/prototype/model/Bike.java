package com.aurionpro.creational.prototype.model;

public class Bike extends Vehicle {

    public Bike() {
    }

    public Bike(int seats, int tyres, String color, String fuel) {
        super(seats, tyres, color, fuel);
    }

    @Override
    public Bike clone() {
        return new Bike(getSeats(), getTyres(), getColor(), getFuel());
    }
}
