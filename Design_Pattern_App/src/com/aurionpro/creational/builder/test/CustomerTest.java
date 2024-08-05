package com.aurionpro.creational.builder.test;

import com.aurionpro.creational.builder.model.Customer;
import com.aurionpro.creational.builder.model.CustomerBuilder;
import com.aurionpro.creational.builder.model.Director;

public class CustomerTest {
    public static void main(String[] args) {
        CustomerBuilder builder = new CustomerBuilder();
        Director director = new Director(builder);
        Customer customer = director.createCustomer();

        System.out.println(customer);
    }
}

