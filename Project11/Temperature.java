package edu.mtc.egr281;

/*
 * Temperature.java
 * Stores a temperature value under a specific scale.
 * The current scale of the object is stored into currentScale and
 * the degree value is stored into degreeValue.
 */

public class Temperature {

	// fields
	private float degreeValue;
	private Scale currentScale;
	
	private final float roundingPlace = 10f;	// tenths place
	
	// default constructor
	public Temperature() {
		this(Scale.C, 0f);
	}// Ending bracket of default constructor
	
	// secondary constructor
	public Temperature(float degrees) {
		this(Scale.C, degrees);
	}// Ending bracket of secondary constructor
	
	// tertiary constructor
	public Temperature(Scale scale) {
		this(scale, 0f);
	}// Ending bracket of tertiary constructor
	
	// quaternary constructor
	public Temperature(Scale scale, float degrees) {
		this.setScale(scale);
		this.setDegrees(degrees);
	}// Ending bracket of quaternary constructor
	
	// accessor for tempCelsius to the nearest tenth
	public float getDegreesCelsius() {
		float returnDeg = 0f;
		
		switch (this.getCurrentScale()) {
		case C:
			returnDeg = this.getDegrees();
			break;
		case F:
			returnDeg = Temperature.FtoC(this.getDegrees());
			break;
		case K:
			returnDeg = Temperature.KtoC(this.getDegrees());
			break;
		}// Ending bracket of switch
		
		return Math.round(returnDeg * roundingPlace) / roundingPlace;
	}// Ending bracket of method getDegreeCelsius
	
	// accessor for tempFahrenheit to the nearest tenth
	public float getDegreesFahrenheit() {
		float returnDeg = 0f;
		
		switch (this.getCurrentScale()) {
		case C:
			returnDeg = Temperature.CtoF(this.getDegrees());
			break;
		case F:
			returnDeg = this.getDegrees();
			break;
		case K:
			returnDeg = Temperature.KtoF(this.getDegrees());
			break;
		}// Ending bracket of switch
		
		return Math.round(returnDeg * roundingPlace) / roundingPlace;
	}// Ending bracket of method getDegreeFahrenheit
	
	// accessor for tempKelvin to the nearest tenth
	public float getDegreesKelvin() {
		float returnDeg = 0f;
		
		switch (this.getCurrentScale()) {
		case C:
			returnDeg = Temperature.CtoK(this.getDegrees());
			break;
		case F:
			returnDeg = Temperature.FtoK(this.getDegrees());
			break;
		case K:
			returnDeg = this.getDegrees();
			break;
			
			default:
				break;
		}// Ending bracket of switch
		
		return Math.round(returnDeg * roundingPlace) / roundingPlace;
	}// Ending bracket of method getDegreeKelvin
	
	// returns the degree value in the current scale
	public float getDegrees() {
		return this.degreeValue;
	}// Ending bracket of method getDegrees
	
	// accessor for currentScale
	public Scale getCurrentScale() {
		return this.currentScale;
	}// Ending bracket of method getCurrentScale
	
	// mutator for degree value
	public void setDegrees(float degrees) {
		this.degreeValue = degrees;
	}// Ending bracket of method setDegrees
	
	// mutator for scale
	public void setScale(Scale scale) {
		this.currentScale = scale;
	}// Ending bracket of method setScale
	
	// mutator for degree and scale
	public void setDegreeAndScale(Scale scale, float degrees) {
		this.setScale(scale);
		this.setDegrees(degrees);
	}// Ending bracket of method setDegreeAndScale
	
	// equals method
	// returns true if both objects have the same degree value and the same scale
	public boolean equals(Temperature temp2) {

		// compare the degree values with a common scale
		return this.getDegreesKelvin() == temp2.getDegreesKelvin();
	}// Ending bracket of method equals
	
	// is this temperature greater than temp2
	public boolean greaterThan(Temperature temp2) {
		return this.getDegreesKelvin() > temp2.getDegreesKelvin();
	}// Ending bracket of method greaterThan
	
	// is this temperature less than temp2
	public boolean lessThan(Temperature temp2) { 
		return this.getDegreesKelvin() < temp2.getDegreesKelvin();
	}// Ending bracket of method lessThan
	
	// toString method
	public String toString() {
		StringBuffer formattedString = new StringBuffer();
		
		switch (this.getCurrentScale()) {
		case C:
			formattedString.append(this.getDegreesCelsius() + " degrees " + Scale.C.getScaleString() + "\n");	
			break;
		case F:
			formattedString.append(this.getDegreesFahrenheit() + " degrees " + Scale.F.getScaleString() + "\n");
			break;
		case K:
			formattedString.append(this.getDegreesKelvin() + " degrees " + Scale.K.getScaleString() + "\n");
			break;
			
			default:
				break;
		}// Ending bracket of switch
		
		return formattedString.toString();
	}// Ending bracket of toString
	
	/*
	 * Easy-access conversion methods
	 */
	
	// convert celsius to kelvin
	private static float CtoK(float degreesCelsius) {
		return (degreesCelsius + 273.15f);
	}// Ending bracket of method CtoK
	
	// convert celsius to fahrenheit
	public static float CtoF(float degreesCelsius) {
		return (degreesCelsius * (9f/5f) + 32f);
	}// Ending bracket of method CtoF
	
	// convert kelvin to celsius
	public static float KtoC(float degreesKelvin) {
		return (degreesKelvin - 273.15f);
	}// Ending bracket of method KtoC
	
	// convert kelvin to fahrenheit
	public static float KtoF(float degreesKelvin) {
		return Temperature.CtoF( Temperature.KtoC(degreesKelvin) );
	}// Ending bracket of method KtoF
	
	// convert fahrenheit to celsius
	public static float FtoC(float degreesFahrenheit) {
		return ((5f/9f) * (degreesFahrenheit - 32f));
	}// Ending bracket of method FtoC
	
	// convert fahrenheit to kelvin
	public static float FtoK(float degreesFahrenheit) {
		return Temperature.CtoK(Temperature.FtoC(degreesFahrenheit));
	}// Ending bracket of method FtoK
	
}// Ending bracket of class Temperature
