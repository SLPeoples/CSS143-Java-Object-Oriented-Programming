import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Samuel L. Peoples 1527650
 * Fractions V1
 * Given an input file "fractions.txt", the calculator reads the fractions and returns the count of iterations
 * Code was written and compiled on Java Neon 4.6.1
 * 
 * This version utilizes a single array, but in-turn have more computations and the program is thus more cumbersome.
 * Specifically, the program reads the entirety of the file multiple times with three scanners, which could benefit
 * from some optimizaton.
 * 
 * 
 * Can you complete this without using arrays? 
 * 		I could not find a simple approach that did not use arrays as I needed to cache information as I went. 
 * 		It could possibly be done by printing each line, and conducting a count before printing each line,
 * 		but that would be incredibly inefficient.
 * What is the least number of variables you can use to solve this problem?
 * 		I feel that I may have used more than needed, but this could be done in 4-8, where I initially used 
 * 		6, but finished with 9.
 * Can you use just one array to solve this? What would the data type be of that array?
 * 		Declaring the array as a String array and carefully indexing. Calculations can be done by converting the
 * 	    values in-line; it could allow one to cast variables in and out of the array. I have adjusted this program 
 * 		to display this possibility.
 * Can you nest* one class (data type) within another, like we observe with nested loops?
 * 		 Yes, classes are frequently nested when Java's built-in functions are called such as .length or .equals()
 * What are some solutions to the reduction problem other than Euclid's GCD (greatest common divisor) algorithm?
 * 		The GCD can also be found using common prime factorizations.
 */
public class PeoplesSamuel_FractionsV1 {
	public static void main(String[] args) {
		
		//filename is declared so it can be modified for the user.
		File file = new File("fractions.txt");
		//One array is declared for a placeholder as counting is conducted.
		//size() is called to check the size of the file in question.
		String exp[]= new String[size(file)];
		//A total of three try-catch scanners are used to facilitate the single-array.
		try {
			//Read the fractions.txt file
			Scanner frac = new Scanner(file);
			//Reset the main iterator
			int i=0;
			while(frac.hasNextLine()) {
				//Initialize the element before they are split and calculated
				exp[i] = frac.nextLine();
				i++;
			}
			//at this point, exp is populated with Strings of fractions
			frac.close();
			//Prints the values and their counts
			printer(exp, file);
		}
		//Generic error, quits if filename is incorrectly entered.
		catch (FileNotFoundException e) {
				System.out.println("Error, "+file.getName()+" not found!");
				System.exit(0);
				e.printStackTrace();
		}
	}
	
	/**
	 * A separate method is needed to determine the size of the arrays needed.
	 * @param file, current working file
	 * @return int i, document length (lines)
	 */
	public static int size(File file){
		int i = 0;
		try {
			//Initially a scanner is opened to determine the size of the file for the arrays.
			Scanner len = new Scanner(file);
			while(len.hasNextLine()) {
				i++;
				len.nextLine();
			}
			len.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error, "+file.getName()+" not found!");
			System.exit(0);
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * This method facilitates the printing of the output.
	 * @param exp, array of fraction Strings
	 * @param file
	 */
	public static void printer(String[] exp, File file){
		try {
			//Initially a scanner is opened to determine the size of the file for the arrays.
			Scanner prin = new Scanner(file);
			while(prin.hasNextLine()) {
				for(int i=0;i<exp.length;i++){
					//Instead of using an array for the count, a separate method is used to tally the count.
					System.out.println(prin.nextLine()+" has a count of "+count(exp, i));
				}
			}
			prin.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error, "+file.getName()+" not found!");
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	/**
	 * This method iteratively counts as the console prints.
	 * @param exp, array of fraction values
	 * @param i, int value of position
	 * @return int j, count of incidence of fraction
	 */
	public static int count(String exp[], int i){
		int j=0;
		for(int k=0;k<exp.length;k++){
			//The fractions are cross multiplied and if the results are the same, a counter will iterate.
			//Note nA is numerator A, and dA is denominator A. The integers are parsed based on the '/' delimitter.
			int nA = Integer.parseInt(exp[i].substring(0, exp[i].indexOf('/')));
			int dA = Integer.parseInt(exp[i].substring(exp[i].indexOf('/')+1, exp[i].length()));
			int nB = Integer.parseInt(exp[k].substring(0, exp[k].indexOf('/')));
			int dB = Integer.parseInt(exp[k].substring(exp[k].indexOf('/')+1, exp[k].length()));
			if(nA*dB == nB*dA) j++;
			else continue;
		}
		//returns iterated count
		return j;
	}
}
