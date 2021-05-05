package edu.mtc.egr281;

import java.util.Scanner;

/*
 * Ryan LeBoeuf
 * Project 13
 * Due: 04.14.21
 * -- TMR Calculator
 * 
 * This program calculates the monetary reimbursement based on the users travel path.
 * 

 */

public class TMRDriver {
	
	public static void main(String[] args) {
		
		// declarations and instantiations
		Scanner keyboard = new Scanner(System.in);
		TMRCalculator calc = new TMRCalculator();
		
		// main loop
		boolean running = true;
		while (running) {
			calc.startNewCalculation(keyboard);
			calc.printStatusReport();
			running = TMRDriver.yesNoDialog("Go again?", keyboard);
		}// Ending bracket of while
		
		keyboard.close();
	}// Ending bracket of method main
		
	// ensures the user enters either y or n, returns True if user enters y and false if n is entered.
	// probably should have used regex for this but they give me migraines
	private static boolean yesNoDialog(String prompt, Scanner input) {
		String userAnswer, acceptableAnswers = "yn";
		boolean acceptableAnswer = false;
		
		do {
			System.out.print(prompt + " [" + acceptableAnswers + "]: ");
			userAnswer = "" + input.next().toLowerCase().charAt(0);
			
			if (acceptableAnswers.contains(userAnswer)) {
				acceptableAnswer = true;
			}// Ending bracket of if
		} while (!acceptableAnswer);	// 1+
		
		return userAnswer.contains("y");
	}// Ending bracket of method confirmDialog
	
	
}// Ending bracket of class TMRDriver
