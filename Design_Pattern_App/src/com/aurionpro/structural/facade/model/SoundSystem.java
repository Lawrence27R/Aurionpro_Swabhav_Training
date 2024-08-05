package com.aurionpro.structural.facade.model;

public class SoundSystem implements ISoundSystem{
	public void start(){
		System.out.println("Sound system started");
	}
	public void stop(){
		System.out.println("Sound system stopped");
	}
	public void volume(int level){
		level = 100;
		System.out.println("Level set to "+level);
	}
}
