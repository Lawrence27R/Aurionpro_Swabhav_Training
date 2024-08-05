package com.aurionpro.creational.builder.model;

public class Customer {
	private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String primaryMobileNumber;
    private String secondaryMobileNumber;
    
    public Customer(CustomerBuilder customerBuilder) {
        this.customerId = customerBuilder.getCustomerId();
        this.firstName = customerBuilder.getFirstName();
        this.lastName = customerBuilder.getLastName();
        this.email = customerBuilder.getEmail();
        this.primaryMobileNumber = customerBuilder.getPrimaryMobileNumber();
        this.secondaryMobileNumber = customerBuilder.getSecondaryMobileNumber();
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryMobileNumber() {
		return primaryMobileNumber;
	}

	public void setPrimaryMobileNumber(String primaryMobileNumber) {
		this.primaryMobileNumber = primaryMobileNumber;
	}

	public String getSecondaryMobileNumber() {
		return secondaryMobileNumber;
	}

	public void setSecondaryMobileNumber(String secondaryMobileNumber) {
		this.secondaryMobileNumber = secondaryMobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", primaryMobileNumber=" + primaryMobileNumber + ", secondaryMobileNumber="
				+ secondaryMobileNumber + "]";
	}

	
}

