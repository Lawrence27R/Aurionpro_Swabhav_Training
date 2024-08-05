package com.aurionpro.test;

import com.aurionpro.main.Animal;
import com.aurionpro.main.Animal.Dog;

//Used when inner class is static
public class NestedClass {
    public static void main(String[] args) {

        Animal.Dog dog = new Animal.Dog();
        System.out.println("Number of legs = " + dog.numLegs);
        dog.makeSound();
    }
}
