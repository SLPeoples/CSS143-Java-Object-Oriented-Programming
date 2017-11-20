
/**
 * @author Samuel L. Peoples, 1527650
 * Linear Search Algorithm to implement a linear search.
 */
public class LinearSearch extends SearchAlgorithm{

	/**
	 * Overrides the abstract search algorithm. Linearlly searches the file, line-by-line to find the item.
	 * @param words, array of words to search
	 * @param wordToFind, target to find
	 * @return index of item to be found (index is the number of comparisons the program has conducted, subtracting one.
	 * @throws ItemNotFoundException, if the item is not in the file, print "Item not found".
	 */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		for(String word : words){
			this.incrementCount();
			if(wordToFind.equals(word))
				return this.getCount()-1;
		}
		throw new ItemNotFoundException();
	}

	/** 
	 * Overrides the inherited recSearch because recursion is not used in a linear search.
	 * Calls search to handle possible user error.
	 */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return search(words, wordToFind);
	}

}
