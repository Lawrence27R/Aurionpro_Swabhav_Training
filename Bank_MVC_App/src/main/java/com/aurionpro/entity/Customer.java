package com.aurionpro.entity;

public class Customer {
    private String customerId;
    private String customerFName;
    private String customerLName;
    private String emailId;

  

    public Customer() {
		super();
		this.customerId = customerId;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.emailId = emailId;
	}

	public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerLName() {
        return customerLName;
    }

    public void setCustomerLName(String customerLName) {
        this.customerLName = customerLName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
