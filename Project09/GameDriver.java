package edu.mtc.egr281;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Ryan LeBoeuf
 * Project 09
 * Due  : 03.17.21
 * Date : 03.16.21
 * 
 * This program simulates the game Chutes and Ladders.
 */

public class GameDriver {

	// constants
	public static final int START_TILE = 0;
	public static final int FINISH_TILE = 100;
	
	private static HashMap<Integer, Integer> tilePairings;	// hashmap to model the chutes and ladders
	private static HashMap<Integer, String> tileStrings;	// hashmap to model the text of the chutes and ladders tiles
	
	// Main method
	public static void main(String[] args) {
		Scanner inputStream = new Scanner(System.in);	// keyboard
		Player p1, p2;									// players
		Spinner spinner = new Spinner();				// spinner
		
		// instantiate player 1
		System.out.print("Enter name for Player 1: ");
		p1 = new Player(inputStream.next());
		
		// instantiate player 2
		System.out.print("Enter name for Player 2: ");
		p2 = new Player(inputStream.next());
		
		/* initialize the hashmaps with the appropriate pairings for 
		 * the chutes and ladders, along with the appropriate text for all
		 * named tiles*/
		GameDriver.initializeMaps();
		
		// main game loop
		while (p1.getCurrentTile() < FINISH_TILE && p2.getCurrentTile() < FINISH_TILE) {
			// spin and move
			p1.updateCurrentTile(spinner.spin());
			
			// spin and move 
			p2.updateCurrentTile(spinner.spin());
			
			System.out.println();
		}// Ending bracket of while loop
		
		inputStream.close();
	}// Ending bracket of method main
	
	public static boolean isPairedTile(Integer tile) {
		return tilePairings.containsKey(tile);
	}// Ending bracket of method isPairedTile
	
	// returns the tile that is paired with key
	public static Integer getPairedTile(Integer key) {
		return tilePairings.get(key);
	}// Ending bracket of method getPairedTile
	
	// returns the string that is paired with tile
	public static String getTileString(Integer tile) {
		return tileStrings.get(tile);
	}// Ending bracket of method printTileString
	
	private static void initializeMaps() {
		// instantiate the HashMaps
		tilePairings = new HashMap<Integer, Integer>();
		tileStrings = new HashMap<Integer, String>();
		
		// chutes
		tilePairings.put(98, 78);
		tilePairings.put(95, 75);
		tilePairings.put(93, 73);
		tilePairings.put(87, 24);
		tilePairings.put(64, 60);
		tilePairings.put(62, 19);
		tilePairings.put(56, 53);
		tilePairings.put(49, 11);
		tilePairings.put(47, 26);
		tilePairings.put(16, 6);
		
		// ladders
		tilePairings.put(1, 38);
		tilePairings.put(4, 14);
		tilePairings.put(9, 31);
		tilePairings.put(21, 42);
		tilePairings.put(28, 84);
		tilePairings.put(36, 44);
		tilePairings.put(51, 67);
		tilePairings.put(71, 91);
		tilePairings.put(80, 100);
		
		// assign text associated with ladder tiles
		tileStrings.put(1, "You sacrificed your firstborn");
		tileStrings.put(38, "Odin is pleased");
		
		tileStrings.put(4, "You killed 50% of the population");
		tileStrings.put(14, "You stopped global warming");
		
		tileStrings.put(9, "You pretended to be sick");
		tileStrings.put(31, "Your mom let you stay home");
		
		tileStrings.put(21, "You gave Dobby a sock");
		tileStrings.put(42, "Dobby is a free elf");
		
		tileStrings.put(28, "You adopted a dog");
		tileStrings.put(84, "Fenrir is pleased");
		
		tileStrings.put(36, "You ate your fiber");
		tileStrings.put(44, "Your bowels are happy");
		
		tileStrings.put(51, "You decided to be vegan");
		tileStrings.put(67, "Humans and animals live happily ever after");
		
		tileStrings.put(71, "You returned Zeus's lightning bolt");
		tileStrings.put(91, "Olympus is pleased");
		
		tileStrings.put(80, "You deleted System32");
		tileStrings.put(100, "YOU WIN THE GAME");
		
		// assign associated text with chute tiles
		tileStrings.put(98, "You cat-called a beautiful woman");
		tileStrings.put(78, "The woman was your mom");
		
		tileStrings.put(95, "You stepped on a crack");
		tileStrings.put(75, "You broke your mother's back");
		
		tileStrings.put(93, "You graffiti a local business");
		tileStrings.put(73, "You have to do 12 hours of community service");
		
		tileStrings.put(87, "You took a bite of the apple");
		tileStrings.put(24, "Jesus died for your sins");
		
		tileStrings.put(64, "You hit a deer on the interstate");
		tileStrings.put(60, "You pay for the fender damage");
		
		tileStrings.put(62, "You took EGR 281");
		tileStrings.put(19, "Your GPA dropped");
		
		tileStrings.put(56, "You played Jumanji");
		tileStrings.put(53, "Robin Williams is your father");
		
		tileStrings.put(49, "You ate an entire box of cookies");
		tileStrings.put(11, "You now have diabetes");
		
		tileStrings.put(47, "You drove a diesel truck on the interstate");
		tileStrings.put(26, "The polar ice caps melted");
		
		tileStrings.put(16, "You tried to compare Strings with ==");
		tileStrings.put(6, "You must now wear the cone of shame");
		
	}// Ending bracket of method initializeMaps

}// Ending bracket of class GameDriver
