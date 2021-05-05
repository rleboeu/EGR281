package edu.mtc.egr281;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * Extra Credit 04
 * Ryan LeBoeuf
 * Due: 04.28.21
 * Date: 04.26.21
 * 
 * A more efficient version of EC04. Redirects stdout to a file instead of using java's FileWriter class.
 * This program takes an input file and writes 2 words per line to a designated output file.
 */

public class FileCorrector {

	public static void main(String[] args) {
		PrintStream outFile = null;
		Scanner inFile = null;
		try {
			outFile = new PrintStream(new File("out.txt"));
			inFile = new Scanner(new File("in.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);	// just in case
		}// Ending bracket of try/catch

		System.setOut(outFile);	// stdout > outFile
		
		int lineWordCount = 1;
		while (inFile.hasNext()) {
			System.out.print(inFile.next());
			
			if ((lineWordCount & 1) == 0) {
				lineWordCount = 1;
				System.out.println();
			} else {
				System.out.print(" ");
				lineWordCount++;
			}// Ending bracket of if
		}// Ending bracket of while
		
		outFile.close();
		inFile.close();
	}// Ending bracket of method main

}// Ending bracket of class FileCorrector
