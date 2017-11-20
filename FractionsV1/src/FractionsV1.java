import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FractionsV1 {

	public static void main(String[] args) {
		Double val[]= new Double[31];
		String exp[]= new String[31];
		int count[]= new int[31];
		
		try {
			Scanner frac = new Scanner(new File("fractions.txt"));
			int i=0;
			while(frac.hasNextLine()) {
				exp[i] = frac.nextLine();
				val[i] = (Double.parseDouble(exp[i].substring(0, exp[i].indexOf('/'))) / Double.parseDouble(exp[i].substring(exp[i].indexOf('/')+1, exp[i].length()))); 
				i++;
			}
			frac.close();
			for(i=0;i<val.length;i++){
				for(int j=0;j<val.length;j++){
					if(val[i].equals(val[j])) count[i]++;
					else continue;
				}
				System.out.println(exp[i]+" has a count of " +count[i]);
			}
		}
		catch (FileNotFoundException e) {
				System.out.println("Error, \"fractions.txt\" not found!");
				System.exit(0);
				e.printStackTrace();
			}

	}

}
