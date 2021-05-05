package edu.mtc.egr281;

/*
 * Ryan LeBoeuf
 * Project 15
 * Color Sampler
 * Due: 04.28.21
 * 
 * This program takes a color from the user and sees if it exists as a constant in the Color class.
 * If it does, the program will set the background of the content pane to the user-specified color.
 * If it doesn't, the program will set the background of the content pane to white and throw a new
 * UnknownColorException while setting the text field's text to the exception's message.
 */

public class ColorSamplerDemo {

	public static void main(String[] args) {
		ColorSampler sampler = new ColorSampler();
		sampler.setVisible(true);

	}// Ending bracket of method main

}// Ending bracket of class ColorSamplerDemo
