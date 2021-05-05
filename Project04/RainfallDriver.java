package edu.midlandstech.egr281;

import java.text.DecimalFormat;

/*
 * Ryan LeBoeuf
 * Project 04
 * Due: 02.10.21
 * Last Modified: 02.04.21
 * 
 * This program prompts the user for the amount of rainfall in inches 
 * for each month of the year. The average monthly rainfall and total
 * yearly rainfall are then printed to the user.
 */

import java.util.Scanner;

public class RainfallDriver {

	// predefined months labels
	public static final String[] MONTHS = { "January", "February", "March", "April", "May", "June",
											"July", "August", "September", "October", "November", "December" };
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		DecimalFormat decFormat = new DecimalFormat("#.#");
		
		double yearlyRainfall = 0d;
		double[] monthlyRainfall = new double[MONTHS.length];
		double averageRainfall;
		
		// for every month, prompt the user for input, store that input, and add the input to the total rainfall
		for (int i = 0; i < MONTHS.length; i++) {
			System.out.print("Rainfall for " + MONTHS[i] + " = ");
			monthlyRainfall[i] = kb.nextDouble();
			yearlyRainfall += monthlyRainfall[i];
		}
		
		kb.close();	// finished with scanner
		
		// calculate average rainfall
		averageRainfall = yearlyRainfall / MONTHS.length;
		
		System.out.println("Yearly rainfall  = " + decFormat.format(yearlyRainfall) + " inches");
		System.out.println("Average monthly rainfall = " + decFormat.format(averageRainfall) + " inches");
		
	}

}
