package com.aurionpro.srp.solution.model;

//OSP SOLID PRINCIPLES
public class FixedDeposit {

	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
//	private double festivalInterest;
	
	public FixedDeposit(int accountNumber, String name, double principal, int duration) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
//		this.festivalInterest = festivalInterest;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

//	public double getFestivalInterest() {
//		return festivalInterest;
//	}
//
//	public void setFestivalInterest(double festivalInterest) {
//		this.festivalInterest = festivalInterest;
//	}
	
	
	public double simpleInterestCalculator(IFestivalInterest festival) {
		return (this.principal*this.duration*festival.getInterest())/100;
	}
}
