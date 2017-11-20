/**
 * 
 * SearchAlgorithm 
 *	A class used to delegate a search strategy or style
 *
 * @author: originally by cfolsen, this version modified by rnash
 */
/**
 * @author Samuel L. Peoples, 1527650
 * observe recSearch has been removed, and has been implemented individually in each search style.
 */
public abstract class SearchAlgorithm {
	
	/**
	 * Abstract version of search algorithm
	 * 
	 * Precondition: words is a nonempty array and target is a non-null string
	 * Postcondition: if the target word is found, return its index.  
	 * If not found, throw an ItemNotFoundException (a subclass which you have to make)
	 *
	 * @param words, array of words to search
	 * @param wordToFind, target to find
	 * @return index of item to be found
	 * @throws ItemNotFoundException, if the item is not in the file, print "Item not found".
	 */
	public abstract int search(String[] words, String wordToFind) throws ItemNotFoundException;
	private int count = 0;
	/**
	 * Incrememnts the count to determine index
	 */
	public void incrementCount() {
		count++;
	}
	/**
	 * @return the count, aka index of target
	 */
	public int getCount() {
		return count;
	}
	/**
	 * resets the count, if needed.
	 */
	public void resetCount() {
		count = 0;
	}
}
