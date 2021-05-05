package edu.mtc.egr281;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ryan LeBoeuf
 * 
 * Project 10 - Snail Pace Race
 * 
 * Due	: 3.24.21
 * Date	: 3.21.21
 * 
 * This project simulates the children's board game "Snail's Pace Race".
 * There are 6 different colors of snails and 2 six-sided die that are rolled
 * to determine which snail(s) get(s) to move each turn. If a snail gets to the 
 * finish line the other snails continue to the end of the turn, therefore
 * it is possible to tie for both the winning and losing positions. 
 */

public class GameDriver {

	// constants
	public static final int START_TILE = 0, FINISH_TILE = 8;	// indices of starting and finishing points, respectively
	private static final int TRACK_SPACING = 6;	// used to control formatting in GameDriver.printTrack()
	
	// fields
	private static List<Snail> snails;	// coding against the interface is preferable
	private static Scanner inputStream;	// allows for input across the class

	private static Snail predictedWinner;
	private static Snail predictedLoser;
	
	// main method
	public static void main(String[] args) {
		GameDriver.inputStream = new Scanner(System.in);
		ColoredDie d1 = new ColoredDie();
		ColoredDie d2 = new ColoredDie();
		
		releaseTheSnails();	// instantiate and populate the GameDriver.snails List
		
		// user makes their predictions
		GameDriver.predictedWinner = GameDriver.pickSnail("Enter the number of your predicted winner: ");
		GameDriver.predictedLoser = GameDriver.pickSnail("Enter the number of your predicted loser: ");
	
		// main game loop
		boolean aSnailHasWon = false;
		while (!aSnailHasWon) {
			
			// roll the bones
			d1.roll();
			d2.roll();
			
			// each snail takes a turn to move (if they can)
			for (Snail snail : GameDriver.snails) {

				// update the snail's position based on the colors of the dice
				snail.updatePosition(GameDriver.calculateSpacesToMove(snail, d1, d2));
				
				// only update aSnailHasWon to a true value
				if (GameDriver.printTrack(snail)) {
					aSnailHasWon = true;
				}// Ending bracket of if
				
			}// Ending bracket of for
			
			System.out.println();	// formatting
		}// Ending bracket of while
		
		GameDriver.verifyPredictions();	// report validity of user's predictions
		
		GameDriver.inputStream.close(); // close the Scanner
	}// Ending bracket of method main

	/* private helper method verifyPredictions
	 * determines the winners and losers and tests to see if the user's
	 * predictions were correct */
	private static void verifyPredictions() {
		
		// the scale of possible positions is START_TILE to FINISH_TILE
		int losingPosition = GameDriver.FINISH_TILE;
		int winningPosition = GameDriver.START_TILE;
		
		// determine the winning and losing indices
		for (Snail snail : GameDriver.snails) {
			if (snail.getCurrentPosition() > winningPosition) {
				winningPosition = snail.getCurrentPosition();
			}// Ending bracket of if
			if (snail.getCurrentPosition() < losingPosition) {
				losingPosition = snail.getCurrentPosition();
			}// Ending bracket of if
		}// Ending bracket of for
		
		// determine if winning prediction was correct
		if (GameDriver.predictedWinner.getCurrentPosition() == winningPosition) {
			System.out.println("Congratulations! You predicted " + GameDriver.predictedWinner.toString() + " would win!");
		} else {
			System.out.println("Sorry! " + GameDriver.predictedWinner.toString() + " didn't win as you predicted!");
		}// Ending bracket of if
		
		// determine if losing prediction was correct
		if (GameDriver.predictedLoser.getCurrentPosition() == losingPosition) {
			System.out.println("Congratulations! You predicted " + GameDriver.predictedLoser.toString() + " would lose!");
		} else {
			System.out.println("Sorry! " + GameDriver.predictedLoser.toString() + " didn't lose as you predicted!");
		}// Ending bracket of if
		
	}// Ending bracket of method verifyPredictions

	/* private helper method calculateSpacesToMove
	 * 
	 * For each current color on the die that matches the snail,
	 * the snail is allowed to move 1 space */
	private static int calculateSpacesToMove(Snail snail, ColoredDie die1, ColoredDie die2) {
		int spacesToMove = 0;
		
		// die 1 color test
		if (snail.getColor().equals(die1.getColor())) {
			spacesToMove++;
		}// Ending bracket of if
		
		// die 2 color test
		if (snail.getColor().equals(die2.getColor())) {
			spacesToMove++;
		}// Ending bracket of if
		
		return spacesToMove;
	}// Ending bracket of method calculateSpacesToMove
	
	// private helper method printTrack
	private static boolean printTrack(Snail snail) {
		String trackString = "|"; 	// the string to be formatted for the snail's track
		
		// form the string to be printed
		for (int tile = 0; tile <= GameDriver.FINISH_TILE; tile++) {
			if (snail.getCurrentPosition() == tile) {	// tile contains a snail
				trackString += snail.getColor();
				
				/* if the length of the color text is less than the total width of the
				 * 'space' in the track, add " " to the string until all track spaces are
				 * aligned appropriately. */
				if (snail.getColor().toString().length() < GameDriver.TRACK_SPACING) {
					for (int i = 0; i < GameDriver.TRACK_SPACING - snail.getColor().toString().length(); i++) {
						trackString += " ";
					}// Ending bracket of for
				}// Ending bracket of if
				
				trackString += "|";
			} else {	// tile does not contain a snail
				// format spacing
				for (int i = 0; i < GameDriver.TRACK_SPACING; i++) {
					trackString += " ";
				}// Ending bracket of for
				
				trackString += "|";	
			}// Ending bracket of if
		}// Ending of for
		
		System.out.println(trackString); // print the snail's track
		
		return (snail.getCurrentPosition() == GameDriver.FINISH_TILE);
	}// Ending bracket of method printTrack
	
	/* private helper method pickSnail
	 * prompts the user to pick a color from the GameDriver.snails List */
	private static Snail pickSnail(String prompt) {
		// print the contents of the DIE_COLOR.values() array
		for (int i = 0; i < GameDriver.snails.size(); i++) {
			System.out.println((i+1) + ": " + snails.get(i));
		}// Ending bracket of for loop
		
		// prompt the user
		System.out.print(prompt);
		
		/* user input will be a length value, convert it to an index value
		 * return the chosen item */
		return GameDriver.snails.get(inputStream.nextInt() - 1);
	}// Ending bracket of method pickColor
	
	/* private helper method
	 * 
	 * instantiates one snail for each ColoredDie.DIE_COLOR and
	 * appends it to the snails List */
	private static void releaseTheSnails() {
		GameDriver.snails = new ArrayList<Snail>();
		
		// populate the snails ArrayList, one snail of each color
		for (ColoredDie.DIE_COLOR color : ColoredDie.DIE_COLOR.values()) {
			GameDriver.snails.add(new Snail(color));
		}// ending bracket of for
	}// ending bracket of method releaseTheSnails
	
}// Ending bracket of class GameDriver
