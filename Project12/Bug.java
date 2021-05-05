package edu.mtc.egr281;

import java.util.HashMap;

/*
 * Bug.java
 * 
 * A Bug is a HashMap with keys being BugParts (legs, eyes, mouth, etc)
 * and values being the quantity of the keys (1 head, 6 legs, 1 'eyes', etc)
 */
public class Bug extends HashMap<BugPart, Integer> {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_PART_MAX = 1;	// default max value for a part
	private static final int NUM_LEG_MAX = 6;		// max value for legs
	
	// 6 legs and 1 of each other part = 6 + 5 * 1 == 11 
	private static final int TOTAL_PARTS_REQUIRED = 11;
	
	// fields
	private boolean bugComplete;	// are all parts present in the bug?
	
	public Bug() {
		super();
		initializeMap();
		this.setBugComplete(false);
	}// Ending bracket of constructor
	
	// initialize integer values to 0 for each key in this (HashMap)
	private void initializeMap() {
		for (BugPart part : BugPart.values()) {
			this.put(part, 0);
		}// Ending bracket of for each
	}// Ending bracket of method initializeMap
	
	// increments the integer value associated with given BugPart key
	private void increment(BugPart key) {
		this.replace(key, this.get(key) + 1);
	}// Ending bracket of method increment
	
	/*
	 * Returns true if a part was added, false if a part was not added
	 * 
	 * A part cannot be added if:
	 * 	a) The part is trying to be added out of order (i.e. leg before body)
	 *	b) The Bug already has a maximum allowed number of parts (i.e. 1 head or 6 legs)
	 */
	public boolean addPart(BugPart part) {
		boolean wasPartAdded = false;	// return value
		
		// Three special cases: BODY, HEAD, and LEG. Default otherwise.
		switch (part) {
		case BODY:
			if (this.get(part) != DEFAULT_PART_MAX) {
				this.increment(part);
				wasPartAdded = true;
			}// Ending bracket of if
			break;
		
		case HEAD:
			// must have body before adding head
			if (this.get(part) != DEFAULT_PART_MAX && this.hasBody()) {	
				this.increment(part);
				wasPartAdded = true;
			}// Ending bracket of if
			break;
		
		case LEG:
			// must have head and body before adding legs, max 6 legs
			if (this.get(part) != NUM_LEG_MAX && this.hasBody() && this.hasHead()) { 
				this.increment(part);
				wasPartAdded = true;
			}// Ending bracket of if
			break;
			
		case ANTENNAE:
		case EYES:
		case MOUTH:
			
		default:
			if (this.get(part) != DEFAULT_PART_MAX && this.hasHead() && this.hasBody()) {
				this.increment(part);
				wasPartAdded = true;
			}// Ending bracket of if	
			break;
		
		}// Ending bracket of switch
		
		/* Check to see if bug has all required parts. 
		 * 
		 * We can use a sum approach for the total number of bug parts because the
		 * method addPart(BugPart) will not allow duplicate parts or going over the 
		 * part limit (i.e. 12 heads).
		 */
		if (wasPartAdded) {
			int sum = 0;
			
			for (BugPart key : this.keySet()) {
				sum += this.get(key);
			}// Ending bracket of for
			
			this.setBugComplete(sum == TOTAL_PARTS_REQUIRED);
		}// Ending bracket of if
		
		return wasPartAdded;
	}// Ending bracket of method addPart
	
	/*
	 * Mutators and accessors
	 */
	
	private boolean hasHead() {
		return this.get(BugPart.HEAD) == DEFAULT_PART_MAX;
	}// Ending bracket of method hasHead
	
	private boolean hasBody() {
		return this.get(BugPart.BODY) == DEFAULT_PART_MAX;
	}// Ending bracket of method hasBody
	
	private void setBugComplete(boolean isComplete) {
		this.bugComplete = isComplete;
	}// Ending bracket of method setBugComplete
	
	public boolean isComplete() {
		return this.bugComplete;
	}// Ending bracket of method isComplete
	
}// Ending bracket of method main
