package edu.mtc.egr281;

/*
 * Scale enum
 */

public enum Scale {

	C("Celsius"), F("Fahrenheit"), K("Kelvin");
	
	private String scaleString;
	
	// constructor
	private Scale(String scaleStr) {
		this.scaleString = scaleStr;
	}// Ending bracket of constructor 
	
	public String getScaleString() {
		return this.scaleString;
	}// Ending bracket of method getScaleString
	
}// Ending bracket of enum Scale
