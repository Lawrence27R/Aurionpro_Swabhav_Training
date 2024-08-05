package com.aurionpro.behavioural.state.model;

public class Packet {
	IPacketState packetState;

	public Packet(IPacketState packetState) {
		super();
		this.packetState = packetState;
	}

	public IPacketState getPacketState() {
		return packetState;
	}

	public void setPacketState(IPacketState packetState) {
		this.packetState = packetState;
	}
	
	public void goToNextState(){
		packetState.next(this);
	}
	
	public void goToPreviousState() {
		packetState.previous(this);
		setPacketState(packetState);
	}
	
	public void printCurrentState() {
		packetState.current(this);
	}
}
