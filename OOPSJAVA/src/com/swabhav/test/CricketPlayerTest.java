package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.CricketPlayer;

public class CricketPlayerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of players : ");
		int number = scanner.nextInt();
		CricketPlayer cricketplayers[] = new CricketPlayer[number];
	    double average;
	    double maxAverage = 0;
		
		for (int i=0; i<cricketplayers.length; i++) {
			
			System.out.println("Enter Player ID : ");
			int playerId = scanner.nextInt();
			System.out.println("Enter Name : ");
			String name = scanner.next();
			System.out.println("Enter number of matches played : ");
			int numberOfMatches = scanner.nextInt();
			System.out.println("Enter Total Runs Score : ");
			int runs = scanner.nextInt();
			System.out.println("Enter Total Wickets taken : ");
			int wickets = scanner.nextInt();
			cricketplayers[i] = new CricketPlayer(playerId, name, numberOfMatches, runs, wickets);
			
		}
		
		for (int i=0; i<cricketplayers.length; i++) {
			System.out.println("Player ID : "+cricketplayers[i].getPlayerId());
			System.out.println("Player Name : "+cricketplayers[i].getName());
			System.out.println("Number of Matches Played : "+cricketplayers[i].getNumberOfMatches());
			System.out.println("Number of runs Scored : "+cricketplayers[i].getRuns());
			System.out.println("Number of Wickets taken : "+cricketplayers[i].getWickets());
			cricketplayers[i].average();
		    System.out.println("Average of Player: " + cricketplayers[i].average());
		    
		    if (cricketplayers[i].average() > maxAverage) {
		        maxAverage = cricketplayers[i].average();
		    }
		}
		System.out.println();
		for (int i=0; i<cricketplayers.length; i++) {
			if (maxAverage == cricketplayers[i].average()) {
				
				System.out.println("Maximum average is "+maxAverage);
				System.out.println("Player ID : "+cricketplayers[i].getPlayerId());
				System.out.println("Player Name : "+cricketplayers[i].getName());
			}
		}
		
		for (int i=0; i<cricketplayers.length-1; i++) {
			for (int j=i+1; j<cricketplayers.length; j++) {
				if (cricketplayers[i].average() > cricketplayers[j].average()) {
				    CricketPlayer temp = cricketplayers[i];
				    cricketplayers[i] = cricketplayers[j];
				    cricketplayers[j] = temp;
				}
			}
		}
		System.out.println();
		for (int i=0; i<cricketplayers.length; i++) {
			System.out.println(cricketplayers[i].getName()+ " " + cricketplayers[i].getPlayerId()+ " ");
		}
		

		scanner.close();
	}
	
}
