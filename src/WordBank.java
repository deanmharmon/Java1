//Dean Mason
//6-4-25

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * the WordBank class is meant to read all words from a file and 
 * give access to random words. 
 * This is designed to be reusable in any application that may need
 * a word bank
 */
public class WordBank {

	private ArrayList<String> wordBankWords; //to store our words loaded from file
	private HashSet<Integer> wordSizes; //stores the length of words
	private Random randGen; 
	
	/**
	 * Constructor to load the words from a file
	 * @param filename the name of the file to load
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public WordBank(String filename) throws FileNotFoundException {
		wordBankWords = new ArrayList<>();
		wordSizes = new HashSet<>();
		randGen = new Random();
		loadWords(filename, -1); // using -1 loads every word
			
	}
	
	/**
	 * Constructor that only loads words of specific size
	 * @param filename the name of file to be loaded
	 * @param wordLength the specific word length to keep
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public WordBank(String filename, int wordLength) throws FileNotFoundException {
		wordBankWords = new ArrayList<>();
		wordSizes = new HashSet<>();
		randGen = new Random();
		loadWords(filename, wordLength);
		
	}
	/**
	 * Load words from the file into the word bank for use
	 * @param filename the name of file
	 * @param wordLength the length of words to be used (-1 being all)
	 * @throws FileNotFoundException if the file is not found
	 */
	private void loadWords(String filename, int wordLength) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File(filename));
		
		//start a loop that works while there are words to be read
		while (fileScan.hasNext()) {
			String word = fileScan.next().toLowerCase();
			
			//skipping words with non-letter characters
			if (!word.matches("[a-z]+")) continue;
			
			if (wordLength == -1 || word.length() == wordLength) {
				wordBankWords.add(word);
				wordSizes.add(word.length());
			}
			
		}
		
		fileScan.close();
	}
	
	
	/** 
	 * Returning a random word from the bank
	 * @return a random word
	 */
	public String getRandomWord() {
		if (wordBankWords.isEmpty()) return "";
		return wordBankWords.get(randGen.nextInt(wordBankWords.size()));	
	}
	
	/**
	 * Returns a random word of specific size
	 * or an empty string if none exists 
	 * @param length the length of the word to get
	 * @return a random word of the given size or "" if none exist
	 */
	public String getRandomWord(int length) {
		if (!hasWordsOfSize(length)) return "";
		
		//collecting matching words temporarily
		ArrayList<String> matchingWords = new ArrayList<>();
		for (String word : wordBankWords) {
			if (word.length() == length) {
				matchingWords.add(word);
			}
		}
		
		if (matchingWords.isEmpty()) return "";
		return matchingWords.get(randGen.nextInt(matchingWords.size()));
		
	}
	
	/**
	 * checks if a specific word is used in the bank
	 * not used currently, but useful for future
	 * @param word the word to search for
	 * @return true if the word exists, false if it doesn't
	 */
	public boolean contains(String word) {
		return wordBankWords.contains(word.toLowerCase());
	}
	
	/**
	 * checks if word of a specific size are in the bank
	 * @param length the size to check
	 * @return true if there are words of given size, false if there aren't
	 */
	public boolean hasWordsOfSize(int length) {
		return wordSizes.contains(length);
	}
}
