package edu.mtc.egr281;

/*
 * Player.java
 * 
 * Each Player gets their own Bug. The player will keep rolling if myBug.addPart(...) returns true.
 */

public class Player {

	// fields
	private String name;
	private Bug myBug;
	private boolean isRolling, finishedGame;
	
	public Player() {
		this("Adam");
	}// Ending bracket of constructor
	
	public Player(String newName) {
		this.setName(newName);
		this.myBug = new Bug();
		this.setRolling(true);
	}// Ending bracket of constructor
	
	// the main output for the program
	public void roll(BugPartDie die) {
		this.setRolling(true);
		
		// keep rolling if a part is added to the player's cootie
		do {
			// if the bug is complete, don't roll and setRolling = false to break from loop
			if (this.myBug.isComplete()) {
				System.out.println(this.getName() + " finished their Cootie!");
				this.setFinished(this.myBug.isComplete());
				this.setRolling(false);
			} else {
				// roll and print the status of player's roll
				die.roll();
				System.out.println(this.getName() + " rolled " + die.getValue());
				
				// if addPart is successful, print status to console and allow user to roll again
				if (this.myBug.addPart(die.getValue())) {
					System.out.println(die.getValue() + " was added to " + this.getName() + "'s Cootie!");
				} else {
					// if addPart was not successful, print to console and don't allow another roll
					System.out.println(this.getName() + " couldn't add " + die.getValue() + " to their Cootie...");
					this.setRolling(false);
				}// Ending bracket of if
				
				// print the progress of the bug
				System.out.println(this.myBug.toString());	

			}// Ending bracket of if
			
		} while(this.isRolling());
		
		System.out.println(); 	// formatting
		
	}// Ending bracket of method roll
	
	/*
	 * Mutators and accessors
	 */
	
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	private void setRolling(boolean newValue) {
		this.isRolling = newValue;
	}// Ending bracket of method setKeepRolling
	
	public boolean isRolling() {
		return this.isRolling;
	}// Ending bracket of method isRolling
	
	private void setFinished(boolean finished) {
		this.finishedGame = finished;
	}// Ending bracket of method setFinished
	
	public boolean hasFinished() {
		return this.finishedGame;
	}// Ending bracket of method hasFinished
	
}// Ending bracket of class Player
