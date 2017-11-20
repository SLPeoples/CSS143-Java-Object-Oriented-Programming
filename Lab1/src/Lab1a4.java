import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*Samuel L. Peoples, 1527650
 * Compiles on Eclipse Neon
 */
public class Lab1a4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Start at 1 so the first iteration is nullified
		int product = 1;
		System.out.println("Enter an integer: ");
		//Define the integer
		int n = input.nextInt();
		//Print the values and calculate factorial.
		try {
			//define the file   
			File dataFile = new File("data4.txt");
			PrintWriter pw = new PrintWriter(dataFile);   
			   for(int i=1; i<=n; i++){
				   //print the value as it grows
				   pw.print(i);
				   if(i<n) pw.print(" * ");
				   else pw.println();
				   //conduct the operation for each step
				   product = product * i;
				}
				pw.println(product);
			    pw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error, incorrect input");
			System.exit(0);
			e.printStackTrace();
		}

	}

}
	
