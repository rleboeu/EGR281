package edu.midlandstech.egr281;

/*
 * Ryan LeBoeuf
 * Project 05
 * Due: 02.17.21
 * 
 * Date: 02.11.21
 * 
 * This program prints a menu with two options: 1 will recommend classes for people to take
 * based on user input and 2 will print the lyrics for the twelve days of Christmas depending
 * on user input.
 */

import java.util.Scanner;

public class Project05 {

	public static final int PLACEMENT = 1;
	public static final int CHRISTMAS = 2;
	
	public static final String[] MAIN_MENU = { "#1: Course Placement",
										  	   "#2: The Twelve Days of Christmas" };
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int menuChoice;
		
		// print the main menu
		for (String choice : MAIN_MENU) {
			System.out.println(choice);
		}//Ending bracket of for each loop
		
		// get the user's choice
		System.out.print("Type the number of your choice: ");
		menuChoice = keyboard.nextInt();
		
		
		switch (menuChoice) {
		case PLACEMENT:
			
			int readingScore, writingScore;
			
			System.out.print("Enter Compass Reading Score: ");
			readingScore = keyboard.nextInt();
			
			System.out.print("Enter Writing Score: ");
			writingScore = keyboard.nextInt();
			
			// determine RDG class placement (if any)
			if (readingScore <= 35) {
				System.out.println("RDG - DO NOT PLACE");
			} else if (readingScore >= 36 && readingScore <= 60) {
				System.out.println("RDG 032");
			} else if (readingScore >= 61 && readingScore <= 79) {
				System.out.println("RDG 100");
			} else if (readingScore >= 80 && readingScore <= 87) {
				System.out.println("RDG 101 (if required by major)");
			} else {
				System.out.println("No RDG required.");
			}//Ending bracket of if else statement
			
			// determine ENG class placement (if any)
			if (writingScore == 10 && readingScore > 35) {
				System.out.println("ENG - DO NOT PLACE");
			} else if ( (writingScore == 20 || writingScore == 30) && readingScore < 61 ) {
				System.out.println("NO ENG until RDG 032 completed");
			} else if (writingScore == 20 && readingScore >= 61) {
				System.out.println("ENG 100");
			} else if (writingScore == 30 && readingScore < 80) {
				System.out.println("Complete RDG 100 before taking ENG 101");
			} else if (writingScore == 30 && readingScore >= 80) {
				System.out.println("ENG 101");
			} else {
				System.out.println("ENG - Unable to determine placement");
			}//Ending bracket of if else statement
			
			break;
		case CHRISTMAS:
			int chosenDay;
			String dayString = "";
			
			System.out.print("Choose a day [1-12]: ");
			chosenDay = keyboard.nextInt();
			
			// assign value to dayString
			switch (chosenDay) {
			case 1:
				dayString = "First";
				break;
			case 2:
				dayString = "Second";
				break;
			case 3:
				dayString = "Third";
				break;
			case 4:
				dayString = "Fourth";
				break;
			case 5:
				dayString = "Fifth";
				break;
			case 6:
				dayString = "Sixth";
				break;
			case 7:
				dayString = "Seventh";
				break;
			case 8:
				dayString = "Eighth";
				break;
			case 9:
				dayString = "Ninth";
				break;
			case 10:
				dayString = "Tenth";
				break;
			case 11:
				dayString = "Eleventh";
				break;
			case 12:
				dayString = "Twelfth";
				break;
			default:
				System.out.print("Invalid choice");
				System.exit(0);
			}//Ending bracket of inner switch statement
			
			// print lyrics based on day
			System.out.print("On the " + dayString + " day of Christmas my true love sent to me ");
			switch (chosenDay) {
			case 12:
				System.out.print("Twelve Drummers Drumming, ");
			case 11:
				System.out.print("Eleven Pipers Piping, ");
			case 10:
				System.out.print("Ten Lords a-Leaping, ");
			case 9:
				System.out.print("Nine Ladies Dancing, ");
			case 8:
				System.out.print("Eight Maids a-Milking, ");
			case 7:
				System.out.print("Seven Swans a-Swimming, ");
			case 6:
				System.out.print("Six Geese a-Laying, ");
			case 5:
				System.out.print("Five Gold Rings, ");
			case 4:
				System.out.print("Four Calling Birds, ");
			case 3:
				System.out.print("Three French Hens, ");
			case 2:
				System.out.print("Two Turtle Doves and ");
			case 1:
				System.out.print("a Partridge in a Pear Tree.");
			}//Ending bracket of inner switch statement
			
			break;
		default:
			System.out.println("Invalid choice.");
		} //Ending bracket of outer switch statement
		
		keyboard.close();

	}// Ending bracket of method main

}//Ending bracket of class Project05
