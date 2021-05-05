package edu.mtc.egr281;

import java.util.Scanner;

/* DiamondDriver.java
 * 
 * Ryan LeBoeuf
 * Due 	: 04.07.21
 * Date : 03.30.21
 * 
 * This program creates a diamond out of a series of palindrome lines of characters.
 * The user provides the 'central' character for the diamond.
 * 
 */

public class DiamondDriver {

	public static void main(String[] args) {
		Scanner inputStream = new Scanner(System.in);
		int userCharAsInt, range, difference, highBound, lowBound = (int)'A';
		
		// user inputs their character
		System.out.print("Enter your character A-Z: ");	// 65 - 90
		userCharAsInt = (int) inputStream.next().charAt(0);
		
		// the ABSOLUTE maximum distance to the center of the palindrome line
		difference = userCharAsInt - lowBound;
		
		// form the diamond shape with a series of palindrome lines of characters
		for (int i = -difference; i <= difference; i++) {
			// print the appropriate number of spaces
			for (int x = 0; x < Math.abs(i); x++) {
				System.out.print(" ");
			}// Ending bracket of for
			
			// the RELATIVE maximum distance to the center of the palindrome line
			highBound = (userCharAsInt - Math.abs(i));
			range = highBound - lowBound;
			
			// print the current palindrome line
			for (int z = -range; z <= range; z++) {
				System.out.print((char)(highBound - Math.abs(z)));
			}// Ending bracket of for
			
			System.out.println();	// formatting
		}// Ending bracket of for
		
		inputStream.close();	// begone!
	}// Ending bracket of method main
	
}// Ending bracket of class DiamondDriver
