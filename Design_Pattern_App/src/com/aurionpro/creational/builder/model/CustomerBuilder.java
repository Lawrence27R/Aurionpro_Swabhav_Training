package com.aurionpro.creational.builder.model;

public class CustomerBuilder implements ICustomerBuilder{

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String primaryMobileNumber;
	private String secondaryMobileNumber;

	@Override
	public ICustomerBuilder customerId(int customerId) {
		this.customerId = customerId;
        return this;
	}

	@Override
	public ICustomerBuilder firstName(String firstName) {
		this.firstName = firstName;
        return this;
	}

	@Override
	public ICustomerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
	}

	@Override
	public ICustomerBuilder email(String email) {
        this.email = email;
        return this;
	}

	@Override
	public ICustomerBuilder primaryMobileNumber(String primaryMobileNumber) {
        this.primaryMobileNumber = primaryMobileNumber;
        return this;
	}

	@Override
	public ICustomerBuilder secondaryMobileNumber(String secondaryMobileNumber) {
        this.secondaryMobileNumber = secondaryMobileNumber;
        return this;
	}
	
    public Customer build() {
        return new Customer(this);
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPrimaryMobileNumber() {
        return primaryMobileNumber;
    }

    public String getSecondaryMobileNumber() {
        return secondaryMobileNumber;
    }
}
