package edu.mtc.egr281;

public class GamePlayer {

	private String name;
	private int numWins;
	private GameToken token;
	private boolean isComputer;
	
	// default constructor
	public GamePlayer() {
		this("Computer", true);
	}// Ending bracket of constructor

	// secondary constructor
	public GamePlayer(String newName, boolean isPlayerComputer) {
		this.setName(newName);
		this.setNumWins(0);
		this.setIsComputer(isPlayerComputer);
		token = new GameToken(); 
	}// Ending bracket of constructor

	// sets the value of token
	public void choose(GameToken.Option option) {
		this.token.setValue(option);
	}// Ending bracket of method choose
	
	// randomly sets the value of token
	public void chooseRandom() {
		this.token.setValue(GameToken.randomChoice());
	}// Ending bracket of method chooseRandom
	
	// accessor for tokens value
	public GameToken.Option getChoice() {
		return this.token.getValue();
	}// Ending bracket of method getChoice
	
	// mutator for name
	public void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	// accessor for name
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	// mutator for numWins
	private void setNumWins(int newNum) {
		this.numWins = newNum;
	}// Ending bracket of method setNumWins

	// accessor for numWins
	public int getNumWins() {
		return this.numWins;
	}// Ending bracket of method getNumWins
	
	// increases the value of numWins by 1
	public void incrementWins() {
		this.setNumWins(this.getNumWins() + 1);
	}// Ending bracket of method incrementWins
	
	// accessor for isComputer
	// returns true if the player is computer controlled
	public boolean isComputer() {
		return isComputer;
	}// Ending bracket of method isComputer
	
	// mutator for isComputer
	private void setIsComputer(boolean newIsComputer) {
		this.isComputer = newIsComputer;
	}// Ending bracket of method setIsComputer
	
}// Ending bracket of class GamePlayer
