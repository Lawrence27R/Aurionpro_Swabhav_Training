package com.aurionpro.creational.builder.model;


public class Director {
    private ICustomerBuilder builder;

    public Director(ICustomerBuilder builder) {
        this.builder = builder;
    }

    public Customer createCustomer() {
        return builder.customerId(11)
                .firstName("Tony")
                .lastName("Stark")
                .email("tonystark@abc.com")
                .primaryMobileNumber("1234567890")
//                .secondaryMobileNumber("0987654321")
                .build();
    }
}
