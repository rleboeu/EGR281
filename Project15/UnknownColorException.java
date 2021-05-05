package edu.mtc.egr281;
/*
 * UnknownColorException.java
 * 
 * Custom exception for if a color is not contained in the Color class
 */

public class UnknownColorException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_MESSAGE = "Unknown Color!";
	
	public UnknownColorException() {
		this(DEFAULT_MESSAGE);
	}// Ending bracket of constructor
	
	public UnknownColorException(String message) {
		super(message);
	}// Ending bracket of constructor
	
}// Ending bracket of class UnknownColorException
