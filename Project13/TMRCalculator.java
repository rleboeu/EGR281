package edu.mtc.egr281;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * A LinkedHashMap is used to store the key-value pairs so that insertion order is
 * maintained while still benefiting from O(1) access. The program only adds new key-value
 * pairs in populateMap(Map) and are inserted in segments based on the starting
 * city.
 */
public class TMRCalculator {

	public static final String[] cities = { "Boston", "Chicago", "Dallas", "Reno", "LosAngeles", 
		"Miami", "NewOrleans", "Toronto", "Vancouver", "DC" };
	
	public static final double DOLLARS_PER_MILE = 0.56d;
	
	private Map<String, Integer> destinationDistance;
	private DecimalFormat roundTwo;
	
	private int totalMileage;
	private double totalReimbursement;
	private String route;
	
	public TMRCalculator() {
		this.roundTwo = new DecimalFormat("#.##");
		this.initializeMap();
	}// Ending bracket of constructor
	
	public void startNewCalculation(Scanner inputStream) {
		this.generateRoute(inputStream);
		this.calculateDistance();
	}// Ending bracket of method startNewCalculation
	
	public void printStatusReport() {
		System.out.println(); 	// formatting
		System.out.println("Overall route = " + this.getRoute());
		System.out.println("Total mileage = " + this.getTotalMileage() + " miles");
		System.out.println("Reimbursement = $" + this.roundTwo.format(totalMileage * DOLLARS_PER_MILE));
		System.out.println();   // formatting
	}// Ending bracket of method printStatusReport
	
	private void calculateDistance() {
		String[] citiesTraveled = this.getRoute().split(":");
		Integer delta = 0;
		
		/*
		 * Key Boston:Chicago is not stored as Chicago:Boston even though they have the same value.
		 * Therefore, it is necessary to switch the order of the two cities in the key String if the
		 * first attempt to Map.get() returns null.
		 */
		for (int i = 1; i < citiesTraveled.length; i++) {
			delta = this.destinationDistance.get(citiesTraveled[i-1] + ":" + citiesTraveled[i]);
			
			if ( delta == null ) {
				delta = this.destinationDistance.get(citiesTraveled[i] + ":" + citiesTraveled[i-1]);
			}// Ending bracket of if
			
			this.addToMileage(delta); 
		}// Ending bracket of for
		
		this.setTotalReimbursement(this.getTotalReimbursement() * DOLLARS_PER_MILE);
	}// Ending bracket of method calculateDistance
	
	private void printCities() {
		System.out.println("Cities are named as follows: ");
		
		for (int i = 0; i < cities.length; i++) {
			if (i < cities.length - 1) {
				System.out.print(cities[i] + ", ");
			} else {
				System.out.print(cities[i]);
			}// Ending bracket of if
			
			if (i == cities.length / 2) {
				System.out.println();
			}// Ending bracket of if
		}// Ending bracket of for
		
		System.out.println("\n");
		
	}// Ending bracket of method printCities

	// returns a route string in the form of Start:next:next:Finish (e.g. Boston:Chicago:Dallas:Miami:Boston)
	private void generateRoute(Scanner inputStream) {
		String startingCity = "";
		
		this.printCities();
		
		System.out.print("Starting city: ");
		startingCity = inputStream.next().trim();
		this.setRoute(startingCity);
		
		int otherCities = 0;
		System.out.print("How many other stops in your route: ");
		otherCities = inputStream.nextInt();
		
		for (int i = 0; i < otherCities; i++) {
			if (i == otherCities - 1) {
				System.out.print("Final: ");
			} else {
				System.out.print("Next: ");
			}// Ending bracket of if
			
			this.setRoute(this.getRoute() + ":" + inputStream.next().trim());
		}// Ending bracket of for
		
		/*
		 * have to include getting back to start. even if the final position is the start position,
		 * the distance between the same city is zero
		 */
		this.setRoute(this.getRoute() + ":" + startingCity);
		
	}// Ending bracket of method getRouteFromUser
	
	/*
	 * Initializes the key-value pairs
	 * Map key is String formatted as "start:finish" and map value is the distance between start and finish
	 * Only half of the supplied table is necessary as Boston:Chicago is the same value as Chicago:Boston
	 */
	private void initializeMap() {
		this.destinationDistance = new LinkedHashMap<String, Integer>();
		
		// Boston
		this.destinationDistance.put("Boston:Boston", 0);
		this.destinationDistance.put("Boston:Chicago", 1004);
		this.destinationDistance.put("Boston:Dallas", 1753);
		this.destinationDistance.put("Boston:Reno", 2752);
		this.destinationDistance.put("Boston:LosAngeles", 3017);
		this.destinationDistance.put("Boston:Miami", 1520);
		this.destinationDistance.put("Boston:NewOrleans", 1507);
		this.destinationDistance.put("Boston:Toronto", 609);
		this.destinationDistance.put("Boston:Vancouver", 3155);
		this.destinationDistance.put("Boston:DC", 448);
		
		// Chicago
		this.destinationDistance.put("Chicago:Chicago", 0);
		this.destinationDistance.put("Chicago:Dallas", 921);
		this.destinationDistance.put("Chicago:Reno", 1780);
		this.destinationDistance.put("Chicago:LosAngeles", 2048);
		this.destinationDistance.put("Chicago:Miami", 1397);
		this.destinationDistance.put("Chicago:NewOrleans", 919);
		this.destinationDistance.put("Chicago:Toronto", 515);
		this.destinationDistance.put("Chicago:Vancouver", 2176);
		this.destinationDistance.put("Chicago:DC", 709);
		
		// Dallas
		this.destinationDistance.put("Dallas:Dallas", 0);
		this.destinationDistance.put("Dallas:Reno", 1230);
		this.destinationDistance.put("Dallas:LosAngeles", 1399);
		this.destinationDistance.put("Dallas:Miami", 1343);
		this.destinationDistance.put("Dallas:NewOrleans", 517);
		this.destinationDistance.put("Dallas:Toronto", 1435);
		this.destinationDistance.put("Dallas:Vancouver", 2234);
		this.destinationDistance.put("Dallas:DC", 1307);
		
		// Reno
		this.destinationDistance.put("Reno:Reno", 0);
		this.destinationDistance.put("Reno:LosAngeles", 272);
		this.destinationDistance.put("Reno:Miami", 2570);
		this.destinationDistance.put("Reno:NewOrleans", 1732);
		this.destinationDistance.put("Reno:Toronto", 2251);
		this.destinationDistance.put("Reno:Vancouver", 1322);
		this.destinationDistance.put("Reno:DC", 2420);
		
		// Los Angeles
		this.destinationDistance.put("LosAngeles:LosAngeles", 0);
		this.destinationDistance.put("LosAngeles:Miami", 2716);
		this.destinationDistance.put("LosAngeles:NewOrleans", 1858);
		this.destinationDistance.put("LosAngeles:Toronto", 2523);
		this.destinationDistance.put("LosAngeles:Vancouver", 1278);
		this.destinationDistance.put("LosAngeles:DC", 2646);
		
		// Miami
		this.destinationDistance.put("Miami:Miami", 0);
		this.destinationDistance.put("Miami:NewOrleans", 860);
		this.destinationDistance.put("Miami:Toronto", 1494);
		this.destinationDistance.put("Miami:Vancouver", 3447);
		this.destinationDistance.put("Miami:DC", 1057);
		
		// New Orleans
		this.destinationDistance.put("NewOrleans:NewOrleans", 0);
		this.destinationDistance.put("NewOrleans:Toronto", 1307);
		this.destinationDistance.put("NewOrleans:Vancouver", 2734);
		this.destinationDistance.put("NewOrleans:DC", 1099);
		
		// Toronto
		this.destinationDistance.put("Toronto:Toronto", 0);
		this.destinationDistance.put("Toronto:Vancouver", 2820);
		this.destinationDistance.put("Toronto:DC", 571);
		
		// Vancouver
		this.destinationDistance.put("Vancouver:Vancouver", 0);
		this.destinationDistance.put("Vancouver:DC", 2887);
		
		// DC
		this.destinationDistance.put("DC:DC", 0);
	}// Ending bracket of method populatethis.destinationDistance

	/*
	 * Mutators and accessors
	 */
	
	private void setTotalMileage(int newMileage) {
		this.totalMileage = newMileage;
	}// Ending bracket of method setTotalMileage
	
	private void addToMileage(int delta) {
		this.setTotalMileage(this.getTotalMileage() + delta);
	}// Ending bracket of method addToMileage
	
	public int getTotalMileage() {
		return this.totalMileage;
	}// Ending bracket of method getTotalMileage
	
	private void setTotalReimbursement(double newReimburse) {
		this.totalReimbursement = newReimburse;
	}// Ending bracket of method setTotalReimbursement
	
	public double getTotalReimbursement() {
		return this.totalReimbursement;
	}// Ending bracket of method getTotalReimbursement
	
	private void setRoute(String newRoute) {
		this.route = newRoute;
	}// Ending bracket of method setRoute
	
	public String getRoute() {
		return this.route;
	}// Ending bracket of method getRoute
	
}// Ending bracket of class TMRCalculator
