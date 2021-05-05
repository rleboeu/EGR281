package edu.mtc.egr281;

import java.util.ArrayList;
import java.util.List;

/*
 * Ryan LeBoeuf
 * Due 	: 03.31.21
 * Date : 03.25.21
 * 
 * TemperatureDriver.java
 * Tests all functionality of the Temperature class
 * and the Scale enum.
 * 
 */

public class TemperatureDriver {

	public static void main(String[] args) {
		List<Temperature> tempList = new ArrayList<Temperature>();
		Temperature temp1 = new Temperature(Scale.C, 100f);
		Temperature temp2 = new Temperature(Scale.K, 373.15f);
		
		// instantiations
		tempList.add(new Temperature());
		tempList.add(new Temperature(100f));
		tempList.add(new Temperature(Scale.K));
		tempList.add(new Temperature(Scale.F, 300f));
		
		System.out.println("------------");				// formatting
		System.out.println("TESTING TOSTRING METHOD");	// formatting
		System.out.println();							// formatting
		
		// test constructors (and toString method)
		for (Temperature t : tempList) {
			System.out.println(t.toString());
		}// Ending bracket of for
		
		tempList.clear();	// done with the list items
		
		System.out.println("-------------");	// formatting
		System.out.println("PRINTED OBJECT");	// formatting
		
		System.out.println(temp1.toString());
		
		// test accessors
		System.out.println("ACCESSOR METHODS");	// formatting
		System.out.println("Current Scale : " + temp1.getCurrentScale().getScaleString());
		System.out.println(temp1.getDegreesCelsius() + " degrees " + Scale.C.getScaleString());
		System.out.println(temp1.getDegreesKelvin() + " degrees " + Scale.K.getScaleString());
		System.out.println(temp1.getDegreesFahrenheit() + " degrees " + Scale.F.getScaleString());
		
		// test setScale and setDegrees
		System.out.println("--------------");			// formatting
		System.out.println("setScale and setDegrees");	// formatting
		
		temp1.setScale(Scale.K);
		temp1.setDegrees(273.15f);
		
		System.out.println(temp1.toString());
		
		// test setDegreeAndScale
		System.out.println("--------------");
		System.out.println("test setDegreeAndScale");
		
		temp1.setDegreeAndScale(Scale.F, 212f);
		
		System.out.println(temp1.toString());
		
		// comparison methods
		System.out.println("-------------");
		
		System.out.println("TEMP1 VARIABLE");
		System.out.println(temp1.toString());

		System.out.println("TEMP2 VARIABLE");
		System.out.println(temp2.toString());
		
		System.out.println("COMPARISONS");
		
		System.out.println("temp1 == temp2 : " + temp1.equals(temp2));
		System.out.println("temp1 > temp2 : " + temp1.greaterThan(temp2));
		System.out.println("temp1 < temp2 : " + temp1.lessThan(temp2));
		
	}// Ending bracket of method main

}// Ending bracket of class TemperatureDriver
