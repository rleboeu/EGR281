package edu.mtc.egr281;

public class GameToken {

	// possible token values
	public static enum Option { ROCK, PAPER, SCISSORS, LIZARD, SPOCK };
	
	// token's value
	private Option value;
	
	// default constructor
	public GameToken() {
		this.setValue(Option.ROCK);
	}// Ending bracket of constructor

	// mutator for value
	public void setValue(Option newValue) {
		this.value = newValue;
	}// Ending bracket of method setValue
	
	// accessor for value
	public Option getValue() {
		return this.value;
	}// Ending bracket of method getValue

	// randomly generates an option depending on the gameMode
	public static Option randomChoice() {
		int index;
		
		switch (GameBoard.gameMode) {
		case ROCK_PAPER_SCISSORS:
			index = (int) (Math.random() * (Option.values().length - 2));
			break;
		case ROCK_PAPER_SCISSORS_LIZARD_SPOCK:
			index = (int) (Math.random() * (Option.values().length));
			break;
			
			default:
				index = 0;
		}// Ending bracket of switch
		
		return Option.values()[index];
	}// Ending bracket of method randomChoice
	
	// determines which option 'wins' or takes precedence over the other
	// will return null if the two options are equal
	public static Option getPrecedence(Option opOne, Option opTwo) {
		Option superiorOption = null;

		if (opOne != opTwo) {
			switch (opOne) {
			case ROCK:
				if (opTwo == Option.SPOCK || opTwo == Option.PAPER) {
					superiorOption = opTwo;
				} else {
					superiorOption = opOne;
				}// Ending bracket of if
				break;
			case PAPER:
				if (opTwo == Option.SCISSORS || opTwo == Option.LIZARD) {
					superiorOption = opTwo;
				} else {
					superiorOption = opOne;
				}// Ending bracket of if
				break;
			case SCISSORS:
				if (opTwo == Option.ROCK || opTwo == Option.SPOCK) {
					superiorOption = opTwo;
				} else {
					superiorOption = opOne;
				}// Ending bracket of if
				break;
			case SPOCK:
				if (opTwo == Option.LIZARD || opTwo == Option.PAPER) {
					superiorOption = opTwo;
				} else {
					superiorOption = opOne;
				}// Ending bracket of if
				break;
			case LIZARD:
				if (opTwo == Option.SCISSORS || opTwo == Option.ROCK) {
					superiorOption = opTwo;
				} else {
					superiorOption = opOne;
				}// Ending bracket of if
				break;
			default:
				break;
			}// Ending bracket of switch
		}// Ending bracket of if
		
		return superiorOption;
	}// Ending bracket of method getPrecedence
	
	// prints a list of the possible Options depending on gameMode
	public static void listOptions() {
		int modifier = 0;
		
		// decreases the size of the iterated array by 2 since LIZARD and SPOCK aren't
		// part of regular Rock Paper Scissors
		if (GameBoard.gameMode == GameBoard.GameMode.ROCK_PAPER_SCISSORS)
			modifier = -2;	// *** there is probably a better way to do this...
		
		for (int i = 0; i < Option.values().length + modifier; i++) {
			System.out.println((i+1) + " : " + Option.values()[i]);
		}// Ending bracket of for loop
	}// Ending bracket of method listOptions
	
}// Ending bracket of class GameToken