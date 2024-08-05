package com.aurionpro.creational.builder.model;

public interface ICustomerBuilder {
	ICustomerBuilder customerId(int customerId);
    ICustomerBuilder firstName(String firstName);
    ICustomerBuilder lastName(String lastName);
    ICustomerBuilder email(String email);
    ICustomerBuilder primaryMobileNumber(String primaryMobileNumber);
    ICustomerBuilder secondaryMobileNumber(String secondaryMobileNumber);
	Customer build();
}

