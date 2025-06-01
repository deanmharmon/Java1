//Dean Mason
//5-30-25
//Mid-term, Dice roller

import java.util.Random;

public class DiceFactory {

	// Declare instance variables to store the rolls, sides, and number of dice from
	// the last simulation.
	// We need some of this info for the getResults method and might need all of it
	// for future methods.
    private int myNumberOfDice, myNumberOfRolls, myNumberOfSides;
    private int resultsArray[];
    
	//Random number generator
    Random numGen = new Random();
	//this var just to store while we add to array
	int rollSum;
	
    public void rollDice(int NumberOfRolls, int NumberOfDice, int NumberOfSides) {
    	this.myNumberOfDice = NumberOfDice;
    	this.myNumberOfRolls = NumberOfRolls;
    	this.myNumberOfSides = NumberOfSides;
    	
    	// allows from myNumberOfDice up to myNumberOfDice*myNumberOfSides
    	// after trying like 8 different versions of this logic, this works the best to not have issues
    	int sizeOf = (myNumberOfDice * myNumberOfSides) - myNumberOfDice + 1;
    	
    	resultsArray = new int[sizeOf];
    	//for loop that rolls each die individually, adding to rollSum, then does that for every roll entered
    	//adding 1 to the position in the array of the number it lands on each time
    	for (int i = 0; i < myNumberOfRolls; i++) {
    		rollSum = 0;
    		for (int j = 0; j < myNumberOfDice; j++) {
    			//+1 at end because otherwise it could be 0 and now includes highest number
    			rollSum += numGen.nextInt(myNumberOfSides) + 1;
    		}
    		//subtracting myNumberOfDice to index array starting at 0 for lowest possible num
    		resultsArray[rollSum - myNumberOfDice] += 1;
    	}
    	
    	System.out.println("\n" + getResults());
    }
	/**
	 * The rollDice method simulates rolling numberOfDice with numberOfSides the numberOfRolls times.
	 * The method doesn't return anything.
	 * @param int numberOfRolls - the number of times the dice are to be rolled.
	 * @param int numberOfSides - the number of sides for each die.
	 * @param int numberOfDice - the number of dice to be rolled.
	 */

    public String getResults() {
    	if (resultsArray == null) {
            //in the comments of this code it says error message, but in the instructions it says empty string
    		//apologies if I chose the wrong route, but either work to show that nothing is there.
    		return "You have not entered any dice rolls yet! Try again after completing that.\n";
        }

    	//Alignment to make output look good
    	//Starts at number of dice since that is the lowest possible rolled number
    	String result = "";
    	for (int i = 0; i < resultsArray.length; i++) {
    	    result += String.format("%3d) %7d\n", i + myNumberOfDice, resultsArray[i]);
    	}
    	return result;

    }
	/**
	 * The getResults method builds a String showing the results of the last simulation.
	 * @return - the String containing the results of the simulation.
	 */

	//		Write the getResults method as described in the above comment.
	//      The method does not need parameters.
	//      If the array is null, which means getResults was called before rollDice, then return an error message.

	public int[] getResultsArray() {
		if (resultsArray == null) {
			return null;
		}
		
		return resultsArray.clone();
	}
	/**
	 * Return an int array with the results of the last simulation.
	 * @return int array with the results of the last simulation.
	 */
	
	//If the results array is null, then return null.  Otherwise, return a clone of the results array.

}
