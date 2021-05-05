/*
 * Ryan LeBoeuf
 * 
 * Extra Credit 01
 * 
 * Due: 2.03.21
 * Last Modified: 1.28.21
 * 
 * This program takes input from the user as a binary
 * number and prints the decimal conversion. 
 * 
 * Valid data input is assumed.
 */

import java.util.Scanner;
import java.lang.Math;

public class BinaryConversion {

	public static final int BINARY_BASE = 2;
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		// get binary number from user
		System.out.print("Enter a binary number: ");
		
		String binaryString = keyboard.nextLine();
		binaryString = binaryString.trim();

		keyboard.close();
		
		// necessary variables for binary conversion
		int baseTenValue = 0;		// the final conversion value
		char currentCharacter;		// current character being iterated over
		int binaryPlaceExponent;	// 2^n | n = binaryPlaceExponent
		
		/*
		 * Iterate over each character from the back of the String to the front,
		 * only finds the place value to add if the character is a 1, otherwise it
		 * will skip over that place.
		 * 
		 * EX: 
		 * For Loop Direction		<-	<-	<-	<-	<-
		 * Binary String			1	0	1	0	1
		 * Place Value				16	8	4	2	1
		 * 
		 * baseTenValue = 1 + 4 + 16 = 21
		 */
		for (int index = binaryString.length() - 1; index >= 0; index--) {
			
			currentCharacter = binaryString.charAt(index);
			
			if (currentCharacter == '1') {
				binaryPlaceExponent = binaryString.length() - (index + 1);
				baseTenValue += Math.pow(BINARY_BASE, binaryPlaceExponent);
			}
		}
		
		// format results
		String report = "Binary (base 2) value : " + binaryString + "\n";
		report += 		"Decimal (base 10) value : " + baseTenValue;
		
		// print results
		System.out.println(report);
	
	} // Ending bracket of method main

} // Ending bracket of class BinaryConversion
