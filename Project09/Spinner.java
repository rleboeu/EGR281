package edu.mtc.egr281;

/*
 * The Spinner (or token) class
 */

public class Spinner {

	// constants
	private final int LOWER_BOUND = 1;
	private final int UPPER_BOUND = 6;
	
	// fields
	private int currentValue;
	
	// default constructor
	public Spinner() {
		this.setCurrentValue(this.LOWER_BOUND);
	}// Ending bracket of constructor
	
	// accessor for currentValue
	public int getCurrentValue() {
		return this.currentValue;
	}// Ending bracket of method getCurrentValue
	
	// mutator for currentValue
	private void setCurrentValue(int newValue) {
		this.currentValue = newValue;
	}// Ending bracket of method setCurrentValue
	
	/* Randomly generates a value between LOWER_BOUND and UPPER_BOUND, sets
	 * the new value, then returns the currentValue */
	public int spin() {
		this.setCurrentValue( (int) (Math.random() * UPPER_BOUND + LOWER_BOUND) );
		return this.getCurrentValue();
	}// Ending bracket of method spin
	
}// Ending bracket of class Spinner
