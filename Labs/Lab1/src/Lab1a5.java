import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*Samuel L. Peoples, 1527650
 * Compiles on Eclipse Neon
 */
public class Lab1a5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		//Define the integer
		int n = input.nextInt();
		try {
			//Define the file
			File dataFile = new File("data5.txt");
			PrintWriter pw = new PrintWriter(dataFile);
			pw.println(n);
			//If it is greater than 1, then it will print the divisors
			if(n>1){
				pw.print("Divisors are ");
				for(int d=1;d<n;d++){
					if(n%d==0) pw.print(d +" ");
				}
			}
			//If the input is 1 or 0, then it just prints itself.
			else pw.println("Divisor is "+n);   
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, incorrect input");
			System.exit(0);
			e.printStackTrace();
		}

	}

}