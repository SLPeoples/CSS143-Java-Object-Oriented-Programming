import java.util.Iterator;

/**
 * @author Samuel L. Peoples, 1527650
 * ExpenseAccount list, maintains a list of Bills
 */
public class ExpenseAccount extends ArrayList{
	
	/**
	 * Places new element at location
	 * @param toAdd, element to be inserted
	 * @param i, location it is to be placed
	 */
	public void insert(Bill toAdd, int i) {
		super.insert((Bill)toAdd, i);
	}
	/**
	 * Places new element at the end of the array
	 * @param object, element to be inserted
	 */
	void add(Bill object){
		super.add((Bill) object);
	}
	/**
	 * Getter to check what is at an index
	 * @param index, location
	 * @return the object at this position
	 */
	Bill get(int index){
		return (Bill) super.get(index);
	}
}
