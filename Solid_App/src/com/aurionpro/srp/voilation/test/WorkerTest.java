package com.aurionpro.srp.voilation.test;

import com.aurionpro.srp.voilation.model.IWorker;
import com.aurionpro.srp.voilation.model.Labour;
import com.aurionpro.srp.voilation.model.Robot;

//ISP SOLID PRINCIPLES
public class WorkerTest {
	public static void main(String[] args) {
		IWorker labour = new Labour();
		labour.startWork();
		labour.stopWork();
		labour.drink();
		labour.eat();
		
		IWorker robot = new Robot();
		robot.startWork();
		robot.stopWork();
		robot.drink();
		robot.eat();
	}
}
