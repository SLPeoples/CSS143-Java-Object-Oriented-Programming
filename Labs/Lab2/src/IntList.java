import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Samuel L. Peoples, 1527650
 * This class writes values to a premade 100-size int list, then writes that list to a file
 */
public class IntList {
	private int[] data = new int[100];
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
	 * @param n, int value to add to list, then changes the length of the list in the counter.
	 * list remains 100-size
	 */
	public void add(int n) {
		data[numElements] = n;
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
				retVal += data[i];
			else
				retVal += data[i]+", ";
		}
			
		return retVal;
	}
	
	/**
	 * @return
	 */
	public int sum() { 
		int sum=0;
		for(int i=0;i<data.length;i++){
			sum += data[i];
		}
		return sum;
	}
	
	/**
	 * @param target, determines whether the value is in the array, then returns the index
	 * @return int value for index of desired value, -1 if it is not in the program
	 */
	public int indexOf(int target) {
		for(int i=0;i<data.length;i++){
			if(target==data[i])
				return data[i];
			else
				continue;
		}
		return -1;
	}
	
	/**
	 * uses a printwriter to write each line of the array to intList.txt
	 */
	public void save(){
		PrintWriter writer;
		try {
			writer = new PrintWriter("intList.txt");
			for(int i=0;i<numElements;i++){
				writer.println(data[i]);
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
