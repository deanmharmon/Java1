//Dean Mason
//6-4-25

import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * The PasswordGen class will do all of the generating 
 * of random passwords and catch errors.
 */

public class PasswordGen {

	//start with creation of object and scanner to be used
	
	private WordBank myBank;
	private Scanner input;
	
	/**
	 * Our constructor
	 * @param filename is used to give a file to WordBank and to catch the exception if file is not found
	 */
	public PasswordGen(String filename) {
		try {
			myBank = new WordBank(filename); 
		} catch (FileNotFoundException e) {
			System.out.println("Error! File: " + filename + " cannot be found in the directory");
			System.exit(1);
		}
		input = new Scanner(System.in);
	}
	
	/**Starting the UI 
	 * @return is a void type so no return
	 * Just used to run the program where we create the passwords.
	 */
	public void run() {
		String response = "yes"; //if not initialized to yes, there's a chance it won't be initialized before use
		
		do {
			int numberOfPhrases = getPositiveInt("How many passphrases do you want to generate?");
			int wordsPerPhrase = getPositiveInt("How many words should be in each passphrase?");
			int wordLength = getPositiveInt("Enter the size of each of the words used to make the random passphrases.");
			
			//validation for size of words
			if (!myBank.hasWordsOfSize(wordLength)) {
				System.out.println("Error! No words of length " + wordLength + " have been found.");
				continue;
			}
			
			//generation of passwords
			for (int i = 0; i < numberOfPhrases; i++) {
				StringBuilder phrase = new StringBuilder();
				for (int count = 0; count < wordsPerPhrase; count++) {
					String word = myBank.getRandomWord(wordLength);
					phrase.append(word);
					/*
					 * below is a good testing line to run to make sure that it is actually pulling
					 * the words correctly, it will seperate them to be cleaner to read.
					 * This was necessary to run because all word lists I could find include short words
					 * that are used in places, but not recognizable as 'words'.
					 *  if (count < wordsPerPhrase - 1) phrase.append(" ");
					 */
				}
				/*
				 * This is not the way the output is shown in the example given but I think it looks
				 * better, can be run with no issue
				 * System.out.println("Password " + (i + 1) + ": " + phrase);
				 * if using this line^ comment out the line below
				 */
				System.out.println(phrase);
			}
			
			System.out.print("Would you like to generate more passphrases? (yes/no) ");
			
			//trimming necessary to remove whitespace
			//and forcing lower case allows user to enter any case variation of the word 
			response = input.nextLine().trim().toLowerCase();
			
		} while (response.equals("yes") || response.equals("y"));
		
		System.out.println("Thanks for using this password generator!");
	}
	
	/**
	 * helper method to validate input
	 * @param prompt the string to be displayed before validation
	 * @return value returns the validated input
	 */
	private int getPositiveInt(String prompt) {
		int value = -1;
		while (value < 1) {
			System.out.print(prompt + " ");
			if (input.hasNextInt()) {
				value = input.nextInt();
				input.nextLine(); //to get rid of newline character
				if (value < 1) System.out.println("Please enter a positive number.");
			} else {
				System.out.println("Invalid input. Please enter a number.");
				input.nextLine(); //get rid of bad input
			}
		}
		return value;
	}
	
	/**Test code to see if we can use contains() in WordBank to find a word in the bank
	 * has to be run from here because we can't catch exceptions from WordBank
	 * @param word is the string we are looking for in our list
	 * @return returns true if the word is there, false if it is not.
	 * 
	 */
	public boolean testFor(String word) {
		return myBank.contains(word.toLowerCase());
	}
	
}
