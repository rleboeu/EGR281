package edu.mtc.egr281;

import java.util.Random;	// rest in peace Math.random()

/*
 * 	-------------------------------
 * 			ColoredDie.java
 * 	-------------------------------
 * 	+ DIE_COLOR : enum
 * 	- NUMBER_OF_SIDES : int
 *	- currentColor : DIE_COLOR
 * 	- randomizer : Random
 * 	-------------------------------
 * 	- setColor(DIE_COLOR) : void
 * 	+ getColor() : DIE_COLOR
 * 	+ roll() : void
 * 	-------------------------------
 */

public class ColoredDie {
	
	// possible colors
	public static enum DIE_COLOR { Orange, Green, Pink, Red, Blue, Yellow };
	
	// constant
	private final int NUMBER_OF_SIDES = DIE_COLOR.values().length;
	
	// fields
	private DIE_COLOR currentColor;
	private Random randomizer;
	
	// constructor
	public ColoredDie() {
		randomizer = new Random();
		this.setColor(DIE_COLOR.Orange);
	}// Ending bracket of constructor

	// muator for currentColor
	private void setColor(DIE_COLOR newColor) {
		this.currentColor = newColor;
	}// Ending bracket of method setColor
	
	// accessor for currentColor
	public DIE_COLOR getColor() {
		return this.currentColor;
	}// Ending bracket for method getColor
	
	// generate a random color
	public void roll() {
		this.setColor( DIE_COLOR.values()[ randomizer.nextInt(NUMBER_OF_SIDES) ] );
	}// Ending bracket of method roll
	
}// Ending bracket of class ColoredDie
