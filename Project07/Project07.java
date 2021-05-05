package edu.midlandstech.egr281;

/*
 * Ryan LeBoeuf
 * 
 * Project 07
 * Due: 3.3.21
 * Date: 2.26.21
 * 
 * This program creates a diamond shape based on the value of n
 * that the user inputs.
 * 
 * Notes: 
 * 	numDollarSigns = numAsterisks - 1
 *  numOfSpacesInLine = maxLineSize - currentLineSize
 */

import java.util.Scanner;

public class Project07 {

	public static void main(String[] args) {
		
		// keyboard
		Scanner inputStream = new Scanner(System.in);
		
		// store value of n
		System.out.print("Value of n: ");
		int numLines = inputStream.nextInt();	// numLines = max line size
		
		// done with the keyboard
		inputStream.close();
		
		// stores the lines that program generates
		String[] generatedLines = new String[numLines];

		int lineNumber;		// keeps track of current line
		String line;		// current generated line string
		
		/*
		 * The total number of lines that will be printed is 
		 * equal to (numLines * 2) - 1, however we only need
		 * to generate numLines unique lines since we are storing
		 * the generated lines into an array.
		 * 
		 * this loop generates numLines lines
		 */
		for (lineNumber = 1; lineNumber <= numLines; lineNumber++) {
			line = "";	// clear the line
			
			/* populate the line with lineNumber asterisks and
			 * lineNumber - 1 dollar signs.
			 * lineNumber is the same as line.length().
			 */
			for (int i = 0; i < lineNumber; i++) {
				line += "*";
				
				if (i != lineNumber - 1)
					line += "$";
			}//Ending bracket of inner for loop
			
			/*
			 * since lineNumber is the same as line size, add spaces
			 * to the front of the string equal to numLines - lineNumber
			 * so that the output will create a triangular shape
			 */
			for (int j = 0; j < numLines - lineNumber; j++) {
				line = " " + line;
			}//Ending bracket of inner for loop
			
			// print and store the generated line
			System.out.println(line);
			generatedLines[lineNumber - 1] = line;
		}//Ending bracket of outer for loop
		
		/*
		 * currently we have a triangular shape, however we need a diamond. 
		 * this loop prints the triangle in reverse order while omitting the last
		 * string in generatedLines so that the program prints a perfect diamond.
		 */
		for (int i = numLines - 2; i >= 0; i--) {
			System.out.println(generatedLines[i]);
		}//Ending bracket of for loop
		
	}//Ending bracket of method main

}//Ending bracket of class Project07
