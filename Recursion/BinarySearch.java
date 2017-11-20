
/**
 * @author Samuel L. Peoples, 1527650
 * BinarySearch algorithm for conducting a recursive search. 
 * This is only applicable if the words array is alphabetically sorted. 
 */
public class BinarySearch extends SearchAlgorithm{
	
	/**
	 * Overrides the abstract search algorithm. Recursively searches the file for target item.
	 * @param words, array of words to search
	 * @param wordToFind, target to find
	 * @return index of item to be found
	 * @throws ItemNotFoundException, if the item is not in the file, print "Item not found".
	 */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		int lowIndex = 0;
		int highIndex = words.length-1;
		int midIndex = highIndex/2;
		return recSearch(words, wordToFind, lowIndex, highIndex, midIndex);
	}
	
	/**
	 * Manages the recursive actions, passing indecies as reference
	 * (<20 comparisons)
	 * @param words, array of words to search
	 * @param wordToFind, target to find
	 * @param lowIndex, low index of current search
	 * @param highIndex, high index of current search
	 * @param midIndex,  midpoint between low and high
	 * @return midIndex, aka to index of the item to be found
	 * @throws ItemNotFoundException, if the item is not in the file.
	 */
	int recSearch(String[] words, String wordToFind, int lowIndex, int highIndex, int midIndex) throws ItemNotFoundException{
			while(lowIndex <= highIndex){
				this.incrementCount();
				if(wordToFind.equals(words[midIndex]))
					//This process will "zero" in on the midIndex we're looking for, and inevitably return the desired result.
					return midIndex;
				if(wordToFind.compareTo(words[midIndex])<0)
					//This will search the lower half of the words array
					return recSearch(words, wordToFind, lowIndex, midIndex-1, lowIndex+((midIndex-1-lowIndex)/2));
				else
					//This will search the upper half of the words array
					return recSearch(words, wordToFind, midIndex+1, highIndex, (midIndex+1)+((highIndex-midIndex)/2));
			}
			throw new ItemNotFoundException();
	}

	/** Overrides the inherited recSearch so that more parameters may be used.
	 * Calls search to handle possible error.
	 */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return search(words, wordToFind);
	}
}
