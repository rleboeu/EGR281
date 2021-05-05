package edu.mtc.egr281;

public class GameBoard {

	public static enum GameMode { ROCK_PAPER_SCISSORS, ROCK_PAPER_SCISSORS_LIZARD_SPOCK };
	public static GameMode gameMode;
	
	private enum VersusMode { HUMAN_HUMAN, HUMAN_COMPUTER, COMPUTER_COMPUTER };
	
	private final int DEFAULT_NUMBER_GAMES = 1;
	
	private VersusMode versusMode;
	private int numberOfTies;
	private int numGames;
	
	// default constructor
	public GameBoard() {
		GameBoard.gameMode = GameMode.ROCK_PAPER_SCISSORS;
		this.setNumberOfTies(0);
		this.setNumberGames(DEFAULT_NUMBER_GAMES);
	}// Ending bracket of constructor

	// main game loop
	public void startGame() {
		
		GamePlayer p1 = null;
		GamePlayer p2 = null;
		GamePlayer winner;	// pointer will either == null or == p1 or == p2

		boolean keepGoing = true;
		// main loop
		do {
			this.setNumberOfTies(0);	// new game, reset the number of ties
			
			this.gameModeMenu();		// ask user which game mode they want
			this.versusMenu();			// ask user which versus mode they want

			// ask user how many rounds to play
			System.out.print("How many rounds do you want to play? : ");
			this.setNumberGames(GameDriver.inputStream.nextInt());
			
			System.out.println();	// formatting
			
			// instantiate the GamePlayers
			switch (this.getVersusMode()) {
			case HUMAN_HUMAN:
				System.out.print("Enter name for Player 1: ");
				p1 = new GamePlayer(GameDriver.inputStream.next(), false);
				
				System.out.println(); // formatting
				
				System.out.print("Enter name for Player 2: ");
				p2 = new GamePlayer(GameDriver.inputStream.next(), false);
				break;
			case HUMAN_COMPUTER:
				System.out.print("Enter your name: ");
				p1 = new GamePlayer(GameDriver.inputStream.next(), false);
				
				System.out.println(); // formatting
				
				p2 = new GamePlayer();
				break;
			case COMPUTER_COMPUTER:
				p1 = new GamePlayer("Computer 1", true);
				p2 = new GamePlayer("Computer 2", true);
				break;
				
				default:
					break;
			}// Ending bracket of switch
			
			// play for numberOfGames rounds
			for (int gameNumber = 1; gameNumber <= this.getNumberGames(); gameNumber++) {
				if (p1.isComputer()) {
					p1.chooseRandom();
				} else {
					GameToken.listOptions();
					
					System.out.print(p1.getName() + " chooses (enter the number): ");
					System.out.println();	// formatting
					
					p1.choose(GameToken.Option.values()[GameDriver.inputStream.nextInt()-1]);
				}// Ending bracket of if
				
				if (p2.isComputer()) {
					p2.chooseRandom();
				} else {
					GameToken.listOptions();
					
					System.out.print(p2.getName() + " chooses (enter the number): ");
					System.out.println();	// formatting
					
					p2.choose(GameToken.Option.values()[GameDriver.inputStream.nextInt()-1]);
				}// Ending bracket of if
				
				// summary of choices
				System.out.println(p1.getName() + " chose " + p1.getChoice());
				System.out.println(p2.getName() + " chose " + p2.getChoice());
				
				winner = this.determineWinner(p1, p2);
				
				if (winner == null) {
					System.out.println("It's a tie!");
					this.incrementTies();
				} else {
					System.out.println("The winner is " + winner.getName() + "!");
					winner.incrementWins();	
				}// Ending bracket of if
				
			}// Ending bracket of for loop
			
			// rounds are over, print total wins and number of ties
			this.printStatistics(p1, p2);
			
			// ask if user wants to start another game
			System.out.print("Play again? [y/n] : ");
			if (GameDriver.inputStream.next().charAt(0) == 'n') {
				keepGoing = false;
			}// Ending bracket of if
			
		} while (keepGoing);
		
		System.out.println("Thanks for playing!");	// closing message
		
	}// Ending bracket of method startGame

	// set the versus mode based on user input
	private void versusMenu() {
		VersusMode userChoice = VersusMode.HUMAN_COMPUTER;
		int userInput = 0;
		
		boolean validInput = false;
		do {
			
			// print the menu options
			System.out.println("==================");
			System.out.println("Choose Versus Mode");
			System.out.println("===================");
			
			for (int i = 0; i < VersusMode.values().length; i++) {
				System.out.println( ( i + 1 ) + " : " + VersusMode.values()[i]);
			}// Ending bracket of for loop
			
			System.out.println("===================");	// formatting
			
			// get the user input
			System.out.print("Enter the number of your selection: ");
			userInput = GameDriver.inputStream.nextInt();
			System.out.println();	// formatting
		
			// make sure the user entered an acceptable integer value
			if (userInput > 0 && userInput <= VersusMode.values().length) {
				validInput = true;
				userChoice = VersusMode.values()[userInput - 1];
			} else {
				System.out.println("You entered an invalid number...\n");
			}// Ending bracket of if
				
		} while (!validInput);
	
		this.setVersusMode(userChoice);
	}// Ending bracket of method versusMenu
	
	// sets the game mode based on user input
	private void gameModeMenu() {
		int userInput = 1;
		boolean validInput = false;
		
		do { 
			// print the menu options
			System.out.println("================");
			System.out.println("Choose Game Mode");
			System.out.println("================");
			
			for (int i = 0; i < GameBoard.GameMode.values().length; i++) {
				System.out.println((i+1) + " :  " + GameBoard.GameMode.values()[i]);
			}// Ending bracket of for loop
			
			System.out.println("================");	// formatting
			
			System.out.print("Enter the number of your selection: ");
			userInput = GameDriver.inputStream.nextInt();
			System.out.println();	// formatting
			
			if (userInput > 0 && userInput <= GameMode.values().length) {
				validInput = true;
			} else {
				System.out.println("\nYou entered an invalid number\n");
			}// Ending bracket of if
			
		} while (!validInput);
		
		GameBoard.gameMode = GameBoard.GameMode.values()[userInput-1];
		
	}// Ending bracket of method gameModeMenu
	
	// determines the player with the winning choice
	private GamePlayer determineWinner(GamePlayer p1, GamePlayer p2) {
		GamePlayer winner = null;
		
		GameToken.Option winningOption; 
		winningOption = GameToken.getPrecedence(p1.getChoice(), p2.getChoice());

		if (winningOption != null) {
			if (p1.getChoice() == winningOption)
				winner = p1;
			else
				winner = p2;
		}// Ending bracket of if
		
		return winner;
	}// Ending bracket of method determineWinner

	// mutator for numberOfTies
	private void setNumberOfTies(int newNum) {
		this.numberOfTies = newNum;
	}// Ending bracket of method setNumberOfTies
	
	// accessor for numberOfTies
	public int getNumberOfTies() {
		return this.numberOfTies;
	}// Ending bracket of method getNumberOfTies
	
	// increases the number of ties by 1
	public void incrementTies() {
		this.setNumberOfTies(this.getNumberOfTies() + 1);
	}// Ending bracket of method incrementTies
	
	// mutator for numGames
	public void setNumberGames(int newNum) {
		this.numGames = newNum;
	}// Ending bracket of method setNumberGames
	
	// accessor for numGames
	public int getNumberGames() {
		return this.numGames;
	}// Ending bracket of method getNumberGames
	
	// mutator for versusMode
	private void setVersusMode(VersusMode newMode) {
		this.versusMode = newMode;
	}// Ending bracket of method setVersusMode
	
	// accessor for versusMode
	private VersusMode getVersusMode() {
		return this.versusMode;
	}// Ending bracket of method getVersusMode
	
	// prints total wins and number of ties for a game
	private void printStatistics(GamePlayer p1, GamePlayer p2) {
		System.out.println("\n");
		
		System.out.println(p1.getName() + " had " + p1.getNumWins() + " wins.");
		System.out.println(p2.getName() + " had " + p2.getNumWins() + " wins.");
		System.out.println("There were " + this.getNumberOfTies() + " ties.");
		
		System.out.println("\n");
	}// Ending bracket of method printStatistics
	
}// Ending bracket of class GameBoard
