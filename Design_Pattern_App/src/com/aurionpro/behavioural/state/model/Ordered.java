package com.aurionpro.behavioural.state.model;

public class Ordered implements IPacketState{

	@Override
	public void next(Packet packet) {
		packet.setPacketState(new Dispatched());
		System.out.println("Packet is ready for Dispatched");
		
	}

	@Override
	public void previous(Packet packet) {
		System.out.println("Packet is successfully returned");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet is in Ordered State");
		
	}

}
