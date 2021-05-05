package edu.mtc.egr281;

import java.util.Random;

/*
 * BugPartDie.java
 * 
 * Randomly generates an int value that corresponds to the index of a BugPart
 */
public class BugPartDie {
	
	// different bug parts, sorted in order of how they are to be acquired
	private static final BugPart[] ORDERED_PARTS = { BugPart.BODY, BugPart.HEAD, BugPart.ANTENNAE,
														BugPart.EYES, BugPart.MOUTH, BugPart.LEG };
	
	// fields
	private Random randomizer;
	private BugPart currentValue;
	
	public BugPartDie() {
		this.randomizer = new Random();
	}// Ending bracket of constructor
	
	public void roll() {
		this.setValue( ORDERED_PARTS[ this.randomizer.nextInt(ORDERED_PARTS.length) ] );
	}// Ending bracket of method roll
	
	/*
	 * Mutators and accessors
	 */
	
	private void setValue(BugPart part) {
		this.currentValue = part;
	}// Ending bracket of method setValue
	
	public BugPart getValue() {
		return this.currentValue;
	}// Ending bracket of method getValue
	
	
}// Ending bracket of class BugPartDie
