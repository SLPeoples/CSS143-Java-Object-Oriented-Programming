import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Samuel L. Peoples, 1527650
 * Fractions V2 Driver
 * Opens a declared file, reads the fractions of form A/B, then reports  
 * the reduced fraction and their count to the console and a new file.
 * Assumes each line of the file is of the form "A/B" where A,B are int.
 */
public class Driver {
	static File file = new File("fractions.txt");
	//ObjectLists are created to manage information
	static ObjectList fractionList = new ObjectList();
	static ObjectList counterList = new ObjectList();
	static ObjectList stringList = new ObjectList();
	/**
	 * Main driver for the class
	 */
	public static void main(String[] args) {
		//Open the file
		fileOpen(file);
		//Increment the counts
		incrementer();
		//Build the strings
		stringBuilder();
		//Report and save output
		stringList.save();			
	}
	
	/**
	 * Opens the file defined within the method
	 */
	public static void fileOpen(File file){
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				//Build the list of objects
				fractionBuilder(scan.nextLine());
			}
			scan.close();
		}
		//General 404 error
		catch (FileNotFoundException e) {
			System.out.println("Error, "+file.getName()+" not found!");
			System.exit(0);
			e.printStackTrace();
		}
	}
	/**
	 * Creates the objects in the Counter and Fraction ObjectLists
	 * @param fracString, takes in the individual string and creates
	 * fraction and counter objects
	 */
	public static void fractionBuilder(String fracString){
		Fraction fraction = new Fraction();
		FractionCounter counter = new FractionCounter();
		counter.fraction = fraction;	
		fractionList.add(fraction);
		counterList.add(counter);
		fraction.setNumerator(Integer.parseInt(fracString.substring(0, fracString.indexOf('/'))));
		fraction.setDenominator(Integer.parseInt(fracString.substring(fracString.indexOf('/')+1, fracString.length())));
	}
	
	/**
	 * Passes the individual elements of the fractionList to the incrementor in the FractionCounter class
	 */
	public static void incrementer(){
		for(int i=0; i<fractionList.getNumElements();i++){
			for(int j=0; j<fractionList.getNumElements();j++){
				counterList.fractionCounterIndexOf(i).compareAndIncrement(fractionList.fractionIndexOf(j));
			}			
		}
	}
	/**
	 * Passes individual items from the fractionCounter list to check if the string is present in the
	 * stringList, if it is not present, it will add the item to the string list.
	 */
	public static void stringBuilder(){
		for(int j=0; j<counterList.getNumElements();j++){
			if(stringList.contains(counterList.fractionCounterIndexOf(j).toString())) 
				continue;	
			else
				stringList.add(counterList.fractionCounterIndexOf(j).toString());
		}
	}
}


