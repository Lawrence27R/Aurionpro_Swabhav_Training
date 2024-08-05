package com.aurionpro.srp.solution.test;

import com.aurionpro.srp.solution.model.Labour;
import com.aurionpro.srp.solution.model.Robot;

//ISP SOLID PRINCIPLES
public class WorkerTest {
	public static void main(String[] args) {
		Labour labour = new Labour();
		labour.start();
		labour.stop();
		labour.eat();
		labour.rest();
		
		Robot robot = new Robot();
		robot.start();
		robot.stop();
	}
}
