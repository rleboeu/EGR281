package edu.midlandstech.egr281;

/*
 * Ryan LeBoeuf
 * Due: 	2.24.21
 * Date: 	2.19.21
 * 
 * This program will attempt to guess the user's number [0-999] and then report the
 * amount of guesses it took. The program will also detect if the user is cheating.
 */

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		
		Scanner inputStream = new Scanner(System.in);

		boolean numberGuessed = false;//whether or not the computer has correctly guessed the number
		
		int[] guessBounds = { 0, 999 };//upper [0] and lower [1] bounds of the computer's guess
		int computerGuess = ( guessBounds[0] + guessBounds[1] ) / 2;//the average of upper and lower bound
		int numberOfGuesses = 0;//how many guesses the computer has made
		
		String userAnswer;//String to store the user's answer
		
		// print initial statement
		System.out.println("Enter a number between " + guessBounds[0] + " and " + guessBounds[1]);
		
		// main loop
		do {
			
			// detect if user is cheating
			if (guessBounds[0] == guessBounds[1]) {
				System.out.println("DON'T CHEAT!");
				break;
			}//Ending bracket of if statement
			
			// since still in loop, computer will have to guess again
			numberOfGuesses++;
			
			// computer makes its guess
			System.out.println("Is it " + computerGuess + "?");
			
			// print instructions to the user
			System.out.print("(Enter y if it is,\nl if your number is lower,\nor h if your number is higher.) ");
			
			// store the user's answer as a non-case sensitive string
			userAnswer = inputStream.next().toLowerCase();
			
			// switch on the first character in userAnswer
			switch (userAnswer.charAt(0)) {
			
				// number was guessed correctly (results in a break from switch AND loop)
				case('y'):
					numberGuessed = true;
					System.out.println("I guessed your number, " + computerGuess + ", in " + numberOfGuesses + " guesses.");
					break;
			
				// user's number is higher than computerGuess
				case('h'):
					guessBounds[0] = computerGuess;
					computerGuess = ( guessBounds[0] + guessBounds[1] ) / 2 + 1;
					break;
			
				// user's number is lower than computerGuess
				case('l'):
					guessBounds[1] = computerGuess;
					computerGuess = ( guessBounds[0] + guessBounds[1] ) / 2;
					break;
					
				// user entered a string starting with character other than y h or l
				default:
					continue;
			}//Ending bracket of inner switch statement
			
			// spacing for formatting output
			System.out.println("");
			
		} while ( !numberGuessed ); //Ending of do-while loop
		
		inputStream.close();
	}//Ending bracket of method main

}//Ending bracket of class GuessNumber
