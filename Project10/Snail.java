package edu.mtc.egr281;

/*
 * 	------------------------------------------
 * 				    Snail.java
 * 	------------------------------------------
 * 	- snailColor : ColoredDie.DIE_COLOR
 * 	- currentPosition : int
 * 	------------------------------------------
 * 	+ getColor() : ColoredDie.DIE_COLOR
 * 	- setColor(ColoredDie.DIE_COLOR) : void
 * 	- setCurrentPosition(int) : void
 * 	+ getCurrentPosition() : int
 * 	+ updatePosition(int) : void
 * 	+ toString() : String
 * 	-------------------------------------------
 */

public class Snail {

	// fields
	private ColoredDie.DIE_COLOR snailColor;	// main identifier of the snail
	private int currentPosition;
	
	// primary constructor
	public Snail() {
		this(ColoredDie.DIE_COLOR.Orange);
	}// Ending bracket of primary constructor
	
	// secondary constructor
	public Snail(ColoredDie.DIE_COLOR newColor) {
		this.setColor(newColor);
		this.setCurrentPosition(GameDriver.START_TILE);
	}// Ending bracket of secondary constructor
	
	// accessor for snailColor
	public ColoredDie.DIE_COLOR getColor() {
		return this.snailColor;
	}// Ending bracket of method getColor
	
	// mutator for snailColor
	private void setColor(ColoredDie.DIE_COLOR newColor) {
		this.snailColor = newColor;
	}// Ending bracket of method setColor
	
	// mutator for currentPosition
	private void setCurrentPosition(int newPos) {
		// stop at the finish line
		if (newPos > GameDriver.FINISH_TILE) {
			this.currentPosition = GameDriver.FINISH_TILE;	
		} else {
			this.currentPosition = newPos;
		}// Ending bracket of if
	}// Ending bracket for method setCurrentPosition
	
	// accessor for currentPosition
	public int getCurrentPosition() {
		return this.currentPosition;
	}// Ending bracket of method getCurrentPosition
	
	// mutator for currentPosition
	public void updatePosition(int tilesToMove) {
		this.setCurrentPosition(this.getCurrentPosition() + tilesToMove);
	}// Ending bracket of method updatePosition
	
	// toString
	public String toString() {
		return this.getColor().toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class Snail
