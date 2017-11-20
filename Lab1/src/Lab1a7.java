import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*Samuel L. Peoples, 1527650
 * Compiles on Eclipse Neon
 */
public class Lab1a7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the file you would like to read? Example: \"data4.txt\"");
		String filename = input.nextLine();
		
		//Reads the file created back to the console
		Scanner foo;
		try {
			foo = new Scanner(new File(filename));
			System.out.println("The file reads as follows:");
			while(foo.hasNextLine()) System.out.println(foo.nextLine());  
			foo.close();
		}
		catch (FileNotFoundException e) {
				System.out.println("Error, incorrect input");
				System.exit(0);
				e.printStackTrace();
			}
		input.close();
	}
}
