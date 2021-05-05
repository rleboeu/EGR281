package edu.mtc.egr281;

/*
 * The player class
 */

public class Player {

	// fields
	private String name;
	private int currentTile;
	
	// default constructor
	public Player() {
		this("Thelonius");
	}// Ending bracket of constructor
	
	// secondary constructor
	public Player(String newName) {
		this.setName(newName);
		this.setCurrentTile(GameDriver.START_TILE);
	}// Ending bracket of constructor
	
	// mutator for name
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	// accessor for name
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	// mutator for currentTile
	private void setCurrentTile(int newTile) {
		this.currentTile = newTile;
	}// Ending bracket of method setCurrentTile
	
	// mutator for currentTile
	public void updateCurrentTile(int tilesToMove) {
		System.out.println(this.getName() + " spun a " + tilesToMove);	// notify the result of Spinner.spin()
		
		// player can only move if they aren't going to go past the FINISH_TILE,
		// they must land on FINISH_TILE exactly
		if (this.getCurrentTile() + tilesToMove <= GameDriver.FINISH_TILE) {
			
			// if there is a chute or ladder at currentTile + tilesToMove
			if (GameDriver.isPairedTile(this.getCurrentTile() + tilesToMove)) {
				// print the tileString of the first item in the tilePair
				System.out.println("Square " + (this.getCurrentTile() + tilesToMove) 
						+ ": " + GameDriver.getTileString(this.getCurrentTile() + tilesToMove));
				
				// set the currentTile equal to the second tile in the tilePair
				this.setCurrentTile(GameDriver.getPairedTile(this.getCurrentTile() + tilesToMove));
				
				// print the tileString of the second item in the tilePair (which is equal to the currentTile)
				System.out.println("Square " + (this.getCurrentTile()) 
						+ ": " + GameDriver.getTileString(this.getCurrentTile()));	// print the second tileString
			} else {
				// if there is not a chute or ladder at the destination then just move
				this.setCurrentTile(this.getCurrentTile() + tilesToMove);
			}// Ending bracket of if
			
		} else {
			// notify that the player cannot move because they would exceed the FINISH_TILE
			System.out.println(this.getName() + " cannot move!");
		}// Ending bracket of if
		
		// notify what tile player is on
		System.out.println(this.getName() + " is on square " + this.getCurrentTile());
		
		// notify if the player has won the game
		if (this.getCurrentTile() == GameDriver.FINISH_TILE) {
			System.out.println(this.getName() + " is the winner!");
		}// Ending bracket of if
		
	}// Ending bracket of method updateCurrentTile
	
	// accessor for currentTile
	public int getCurrentTile() {
		return this.currentTile;
	}// Ending bracket for method getCurrentTile
	
}// Ending bracket of class Player
