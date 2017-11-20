
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * @author Samuel L. Peoples, 1527650
 * This class writes values to a premade 100-size Object list, then writes that list to a file
 */

/* Questions and Observations

(1)Why did we do so much copying-and-pasting in our software above?
	A lot of the logic was the same, where definitions of variables and some functions were different.
	
	a.How can this approach be problematic?
		It is very easy to forget to change comments, logic, or functions, which would result in a headache 
		and difficulty in debugging. It could also be difficult to distinguish between different classes if
		they are all essentially the same.

(2)Are there obvious improvements that could be made here with respect the software design for Squares and Circles?
	The squares and circles could be drawn on a plot based on their side length/radius and x,y coordinates,
	rather than just returning the string representation of the object.

(3)What programming constructs were you familiar with, and which did you need to look up?
	The programming was relatively simple once the class level variables and constructors were understood.

(4)Assume we used a separate array for Square sand for Circles rather than one unifying Object array. 
	a.How would this complicate the task of adding a new Shape (say, a Triangle) to our ObjectList class?
		It would require that we create a new array for Triangle objects, which would require that we
		modify the program. If we have one single array for all the objects, all we must do is create
		the constructor class, and our ObjectList class can remain universal.
*/

public class ObjectList {
	private Object[] myShapes = new Object[100];
	private int numElements = 0;
	/**
	 * Driver main, tests different values
	 */
	public static void main(String[] args) {
		IntList a = new IntList();
		a.add(95);
		a.add(100);
		a.add(58);
		System.out.println(a.toString() );
		System.out.println(a.sum() );
		System.out.println(a.indexOf(100));
		//uncomment these to work on next
		System.out.println(a.indexOf(20));
		a.save();
	}
	
	/**
	 * @param nx, Object to add to list, then changes the length of the list in the counter.
	 * list remains 100-size
	 */
	public void add(Object nx) {
		myShapes[numElements] = nx;
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
				retVal += myShapes[i];
			else
				retVal += myShapes[i]+", ";
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
				writer.println(myShapes[i]);
			}
			writer.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Could not write to file.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
