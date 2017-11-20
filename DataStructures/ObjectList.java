
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * @author Samuel L. Peoples, 1527650
 * This class writes values to a premade Object list, then writes that list to a file
 */
public class ObjectList {
	private Object[] objects = new Object[9999999];
	private int numElements = 0;
	/**
	 * Empty main, driver Class handles testing.
	 */
	public static void main(String[] args) {
		
	}
	
	/**
	 * @param nx, Object to add to list, then changes the length of the list in the counter.
	 * list remains 100-size
	 */
	public void add(Object nx) {
		objects[numElements] = nx;
		numElements++;
	}
	
	/* 
	 * @return retVal, Returns a string that represents the array.
	 */
	@Override
	public String toString() { 
		String retVal ="";
		for(int i=0;i<numElements;i++){
			if(i==numElements-1)
				retVal += objects[i];
			else
				retVal += objects[i]+", ";
		}
			
		return retVal;
	}
	
	/**
	 * uses a printwriter to write each line of the array to intList.txt
	 */
	public void save(){
		PrintWriter writer;
		try {
			writer = new PrintWriter("objectList.txt");
			for(int i=0;i<numElements;i++){
				if(objects[i]!=null){
					System.out.println(objects[i]);
					writer.println(objects[i]);
				}
				else continue;
			}
			System.out.println("\nOutput saved to objectList.txt.");
			writer.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Could not write to file.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public int getNumElements(){
		return numElements;
	}
	
	/**
	 * returns the value of a called index
	 * @param index, int value of position being called
	 * @return Fraction, value at position in fractionList
	 */
	public Fraction fractionIndexOf(int index){
		return (Fraction) objects[index];
	}
	
	/**
	 * returns the value of a called index
	 * @param index, int value of position being called
	 * @return FractionCounter, value at position in counterList
	 */
	public FractionCounter fractionCounterIndexOf(int index){
		return (FractionCounter) objects[index];
	}
	
	/**
	 * returns the value of a called index
	 * @param index, int value of position being called
	 * @return String, value at position in stringList
	 */
	public String stringIndexOf(int index){
		return (String) objects[index];
	}
	
	/**
	 * Determines whether a list contains an object
	 * @param object, check if object is in the associated list
	 * @return true, if the object is in the ObjectList.
	 */
	public boolean contains(Object object){
		boolean bool = false;
		for(int i=0; i<numElements;i++){
			if(objects[i].equals(object))
				bool = true;
			else 
				continue;
		}
		return bool;
	}
}
