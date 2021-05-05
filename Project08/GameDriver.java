package edu.mtc.egr281;

/*
 * Ryan LeBoeuf
 * Project 08
 * Due: 03.10.21
 * Date: 03.07.21
 * 
 * This program allows the user to play either Rock Paper Scissors 
 * or Rock Paper Scissors Lizard Spock. 
 * 
 * This program also gave me a migraine.
 * 
 * === stubb_rat ===
 */

import java.util.Scanner;

public class GameDriver {

	public static Scanner inputStream;
	
	public static void main(String[] args) {
		GameDriver.inputStream = new Scanner(System.in);
		
		GameBoard board = new GameBoard();
		board.startGame();
		
		GameDriver.inputStream.close();
	}// Ending bracket of method main

}// Ending bracket of class GameDriver
