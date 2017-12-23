import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*Samuel L. Peoples, 1527650
 * Compiles on Eclipse Neon
 */
public class Lab1a {
	   public static void main(String[] args){
		  
// 1. Control Structures		   
		   controlStructures();
// 2. Arrays			   
		   arrays();
// 3. File IO		   
		   fileReader();
	   }
	   
	   public static void controlStructures(){
		   //For loop to write first ten digits
		   for(int a=0; a<10; a++){
			   System.out.println(a);
		   }
		   int b = 0;
		   
		   //While loop to write even digits
		   while(b<20){
			   if(b%2==0){
				  System.out.println(b);
			   }
				  b++;
		   }
		   
		   	   //Console input for first five quiz scores
		   	   Scanner keys = new Scanner(System.in);
			   System.out.println("Enter Quiz Score (integers)");
			   int sum = keys.nextInt();
			   for(int i=0; i<4;i++){
				   sum += keys.nextInt();
			   }
			   System.out.println("The score is " +sum);
			   
			   //Calculate and return the averages
			   double avg = sum/5;
			   System.out.println("The average is " +avg);
			   
			   //Determine and output the letter grade
			   String grade = "";
			   if(avg>=90) grade = "A";
			   else if(avg>= 80) grade = "B";
			   else if(avg>= 70) grade = "C";
			   else if(avg>= 60) grade = "D";
			   else if(avg < 60) grade = "F";
	   //Attempting a switch statement here runs into a logical and programming error.
	   //The logical error would be switching between at least 1000 cases for 0.00 to 100.00
	   //The programming error is that switch cannot be used on doubles, so we would have
	   //to do a lot of work to use a switch in this instance.
			   System.out.println("The grade is " +grade);
			   
	   }
	   
	   public static void arrays(){
		   int[] data = {3,1,-8,4,-5,2};
		   //Sum the data
		   System.out.println("The sum of data is "+sum(data));
		   //Average the data
		   System.out.println("The average of data is "+avg(data));   
		   //Input index and print selection
		   System.out.println("Enter an integet between 0-5 to index that position in [Data]");
		   Scanner input = new Scanner(System.in);
		   int index = input.nextInt();
		   System.out.println("The index value for position "+index +" is " +indexOf(data, index));
		   //Sum of positive values
		   System.out.println("The sum of positive values is " +positiveSum(data));
		   //Populates array with values from console	   
		   System.out.println("Please enter a the number of values in your list");
		   int values = input.nextInt();
		   int array[] = new int[values];
		   populateArray(array);
	   }
	   public static int sum(int[] data){
		   //Iterate through for loop to return sum
		   int sum = 0;
		   for(int i = 0; i<data.length; i++)
			   sum += data[i];
		   return sum;
	   }
	   public static double avg(int[] data){
		   //Convert to double and return the average. 
		   double sum = sum(data);
		   double avg = sum/data.length;
		   return avg;
	   }
	   public static int indexOf(int[] data, int target){
		   //Returns index at selected index
		   int dataIndex = data[target];
		   return dataIndex;
	   }
	   public static int positiveSum(int[] data){
		   //Determines if positive, then adds, returns sum
		   int sum = 0;
		   for(int i = 0; i<6; i++)
			   if(data[i]>=0) sum += data[i];
		   return sum;
	   }
	   public static void populateArray(int[] data){
		   //Populates array with input size and data
		   Scanner input = new Scanner(System.in);
		   System.out.println("Please enter your "+data.length +" values");
		   
		   int i=0;
		   while(i<data.length){
			   data[i]=input.nextInt();
			   i++;
		   }
		   //writes it to a new file
		   try {
			   File dataFile = new File("data.txt");
			   PrintWriter pw = new PrintWriter(dataFile);
			   for(int j=0; j<data.length; j++){
				pw.print(data[j]+" ");
			}
			   pw.println();
			   //prints the sum on the next line
			   pw.println("The sum is " +sum(data));
			   //prints the average on the next line
			   pw.print("The average is " +avg(data));
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, incorrect input");
			System.exit(0);
			e.printStackTrace();
		}

	   }
	   public static void fileReader(){
		   //Reads the file created back to the console
		   Scanner fin;
		try {
			fin = new Scanner(new File("data.txt"));
			System.out.println("The file reads as follows:");
			while(fin.hasNextLine()){
				   System.out.println(fin.nextLine());
			   }
		} catch (FileNotFoundException e) {
			System.out.println("Error, incorrect input");
			System.exit(0);
			e.printStackTrace();
		}
	   }
}