package com.aurionpro.test;

import com.aurionpro.main.Animal;


//When Innerclass is non-static
public class InnerClass {
    public static void main(String[] args) {
    	Animal animal = new Animal();
    	Animal.Dog dog = animal.new Dog();
        System.out.println("Number of legs = " + dog.numLegs);
        dog.makeSound();
    }
}
