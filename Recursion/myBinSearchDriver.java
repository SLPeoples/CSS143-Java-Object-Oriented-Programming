/**
 * Linear and Binary Search Homework 5 Driver
 * CSS 162
 * 
 * Note that nothing in this class needs to be changed except for your FILE_AND_PATH variable
 * 
 * Implement the Binary Search using both the iterative and recursive techniques covered
 * in class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Samuel L. Peoples, 1527650
 * Nothing in this file has been changed apart from commenting adjustments and additional tests.
 */
public class BinSearchDriver {
	public final static String FILE_AND_PATH = "longwords.txt";
	//Note how we deal with Java's Catch-or-Declare rule here by declaring the exceptions we might throw
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(FILE_AND_PATH));
		int wordCount = 0;
		ArrayList<String> theWords = new ArrayList<String>();
		//read in words, count them
		while(input.hasNext())  {
			theWords.add( input.next() );
			wordCount++;
		}
		//make a standard array from an ArrayList
		String[] wordsToSearch = new String[theWords.size()];
		theWords.toArray(wordsToSearch);
		
		//start with the linear searches
		System.out.println("Linear Search:");
		tryLinearSearch(wordsToSearch, "FOO");
		tryLinearSearch(wordsToSearch, "DISCIPLINES");
		tryLinearSearch(wordsToSearch, "TRANSURANIUM");
		tryLinearSearch(wordsToSearch, "HEURISTICALLY");
		tryLinearSearch(wordsToSearch, "FOO");
		
		System.out.println("\nBinary Search:");
		//and compare these results to the binary searches
		tryBinarySearch(wordsToSearch, "FOO");
		tryBinarySearch(wordsToSearch, "DISCIPLINES");
		tryBinarySearch(wordsToSearch, "TRANSURANIUM");
		tryBinarySearch(wordsToSearch, "HEURISTICALLY");
		tryBinarySearch(wordsToSearch, "FOO");
		
	}

	/**
	 * Creates a binarySearch item, observe that recSearch has been replaced by its own search algorithm
	 * 
	 * precondition: wordsToSearch is a nonempty array of Strings, and target is a non-null string to search for 
	   in our collection of strings
	 * postcondition: Uses a BinarySearch object (which implements this style of search) to try to find the target string
	 * 
	 * @param wordsToSearch, array of words to search through.
	 * @param target, item to find
	 */
	private static void tryBinarySearch(String[] wordsToSearch, String target) {
		//Todo: Build a LinearSearch class that inherits from SearchAlgorithm, and put it in the same directory as this class to successfully compile
		SearchAlgorithm bs = new BinarySearch();
		try {
			System.out.print( target + " found at index: " + bs.search(wordsToSearch,target));
			System.out.println( " taking " + bs.getCount() + " comparisons.");
		} 
		catch( ItemNotFoundException e ) {
			System.out.println( target + ":" + e.getMessage());
		}	
	}

	/**
	 * Creates a linearSearch item, observe that search is independent.
	 * precondition: wordsToSearch is a nonempty array of Strings, and target is a non-null string to search for 
	   in our collection of strings
	 * postcondition: Uses a LinearSearch object to try to find the target string
	 * 
	 * @param wordsToSearch, array of words to search through.
	 * @param target, item to find
	 */
	private static void tryLinearSearch(String[] wordsToSearch, String target) {
		//Todo: Build a LinearSearch class that inherits from SearchAlgorithm, and put it in the same directory as this class to successfully compile
		SearchAlgorithm ls = new LinearSearch();
		try {
			System.out.print( target + " found at index: " + ls.search(wordsToSearch,target));
			System.out.println( " taking " + ls.getCount() + " comparisons.");
			
		} 
		catch( ItemNotFoundException e ) {
			System.out.println( target + ":" + e.getMessage());
		}	
	}
}
