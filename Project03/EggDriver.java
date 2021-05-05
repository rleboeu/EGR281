/*
 * Ryan LeBoeuf
 * Project 03
 * Due: 2.03.21
 * Last Modified: 1.28.21
 * 
 * This program calculates the price of a transaction of eggs by
 * getting the amount of eggs from the user.
 */

import javax.swing.JOptionPane;

public class EggDriver {

	public static final double PRICE_PER_DOZEN = 3.25;
	public static final double PRICE_PER_LOOSE = 0.45;
	public static final int ONE_DOZEN = 12;
	
	public static void main(String[] args) {

		String eggString = JOptionPane.showInputDialog("How many eggs are in your order?");
		int totalEggs = Integer.parseInt(eggString);
		
		double totalForDozens, totalForLoose, totalCost;
		
		// calculate totals
		totalForDozens = (int) (totalEggs / ONE_DOZEN) * PRICE_PER_DOZEN;
		totalForLoose = (totalEggs % ONE_DOZEN) * PRICE_PER_LOOSE;
		totalCost = totalForDozens + totalForLoose;
		
		// neatly format data for user to read
		String report = "You ordered " + totalEggs + " eggs.\n\n";
		report += "You have " + totalEggs / ONE_DOZEN + " dozen eggs at $" + PRICE_PER_DOZEN + " per dozen\n";
		report += "and " + totalEggs % ONE_DOZEN + " loose eggs at $" + PRICE_PER_LOOSE + " each.\n\n";
		report += "The total price for your order is $" + totalCost + ".";
		
		JOptionPane.showMessageDialog(null, report);
		
		System.exit(0);
	}	// Ending bracket of method main

}	// Ending bracket of class EggDriver
