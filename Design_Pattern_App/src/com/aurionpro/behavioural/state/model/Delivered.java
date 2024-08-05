package com.aurionpro.behavioural.state.model;

public class Delivered implements IPacketState{

	@Override
	public void next(Packet packet) {
//		System.out.println("Unboxing");
		
	}

	@Override
	public void previous(Packet packet) {
		packet.setPacketState(new Dispatched());
		System.out.println("Packet is ready for Dispatch to return");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet is in Delivered State");
		
	}

}
