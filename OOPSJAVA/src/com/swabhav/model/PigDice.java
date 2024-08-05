package com.swabhav.model;

public class PigDice {
	private int totalScore;
    private int maxTurns;
    private int turns;
	public PigDice(int totalScore, int maxTurns, int turns) {
		super();
		this.totalScore = totalScore;
		this.maxTurns = maxTurns;
		this.turns = turns;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getMaxTurns() {
		return maxTurns;
	}
	public void setMaxTurns(int maxTurns) {
		this.maxTurns = maxTurns;
	}
	public int getTurns() {
		return turns;
	}
	public void setTurns(int turns) {
		this.turns = turns;
	}
	@Override
	public String toString() {
		return "PigDice [totalScore=" + totalScore + ", maxTurns=" + maxTurns + ", turns=" + turns + "]";
	}
    
    
}
