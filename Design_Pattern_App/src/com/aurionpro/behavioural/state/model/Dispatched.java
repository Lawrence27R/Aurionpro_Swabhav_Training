package com.aurionpro.behavioural.state.model;

public class Dispatched implements IPacketState{

	@Override
	public void next(Packet packet) {
		packet.setPacketState(new Delivered());
		System.out.println("Packet is ready to be Deliver");
		
	}

	@Override
	public void previous(Packet packet) {
		packet.setPacketState(new Ordered());
		System.out.println("Packet is moving to Ordered state in factory for return");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet is in Dispatched state");
		
	}

}
