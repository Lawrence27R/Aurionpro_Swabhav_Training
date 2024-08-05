package com.swabhav.model;

public class CricketPlayer {
	private int playerId;
	private String name;
	private int numberOfMatches;
	private int runs;
	private int wickets;
	private double average;
	
	public CricketPlayer() {
		
	}
	
	public CricketPlayer(int playerId, String name, int numberOfMatches, int runs, int wickets) {
		this.playerId=playerId;
		this.name=name;
		this.numberOfMatches=numberOfMatches;
		this.runs=runs;
		this.wickets=wickets;
		
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId=playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches=numberOfMatches;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs=runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets=wickets;
	}
	public double average() {
	    if (getNumberOfMatches() > 0) {
	        average = (double) getRuns() / getNumberOfMatches();
	    } else {
	        average = 0.0;
	    }
		return average;
	}
	
	
}
