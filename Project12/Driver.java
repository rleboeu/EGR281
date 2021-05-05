package edu.mtc.egr281;

import java.util.Scanner;

/*
 * Ryan LeBoeuf
 * Project 11
 * Due: 04.07.21
 * 
 * This program simulates the game Cootie with 2 players. Each player rolls a die to
 * complete the different parts of their Cootie (or Bug). If a player rolls and adds a part
 * to their Cootie, they are allowed to roll again. Ties are not possible.
 * 
 * All system output takes place in the Player.roll() method
 */
public class Driver {

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		// declare players and die, instantiate die
		Player p1, p2;
		BugPartDie bpDie = new BugPartDie();
		
		// ask for player names and instantiate Players
		System.out.print("Enter name for player 1: ");
		p1 = new Player(keyboard.next());
		
		System.out.print("Enter name for player 2: ");
		p2 = new Player(keyboard.next());
		
		// main game loop
		while (!p1.hasFinished() && !p2.hasFinished()) {
			if (!p2.hasFinished()) {
				p1.roll(bpDie);	
			}// Ending bracket of if
			
			if (!p1.hasFinished()) {
				p2.roll(bpDie);
			}// Ending bracket of if
			
		}// Ending bracket of while
		
		keyboard.close();	// begone!!
	}// Ending bracket of method main
	
}// Ending bracket of class Driver
