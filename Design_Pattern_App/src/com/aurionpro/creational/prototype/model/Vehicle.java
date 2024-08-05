package com.aurionpro.creational.prototype.model;

public abstract class Vehicle implements Cloneable {
    private int seats;
    private int tyres;
    private String color;
    private String fuel;

    public Vehicle() {
    }

    public Vehicle(int seats, int tyres, String color, String fuel) {
        this.seats = seats;
        this.tyres = tyres;
        this.color = color;
        this.fuel = fuel;
    }

    public void setAttributes(int seats, int tyres, String color, String fuel) {
        this.seats = seats;
        this.tyres = tyres;
        this.color = color;
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public int getTyres() {
        return tyres;
    }

    public String getColor() {
        return color;
    }

    public String getFuel() {
        return fuel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public abstract Vehicle clone();

    @Override
    public String toString() {
        return "Seats: " + seats + ", Tyres: " + tyres + ", Color: " + color + ", Fuel: " + fuel;
    }
}
