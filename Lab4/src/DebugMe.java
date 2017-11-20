/*
 * Samuel L. Peoples, 1527650

 */

public class DebugMe{

	public static void main(String args[]){

		printSums(args);
		compareBoxes();
	}

	//This function is designed to print the sums of all numbers between 1 and the
	//first number entered as an argument to DebugMe
	//For example, if you enter:  DebugMe 3
	//You should get:
	//	The sum of the first 1 numbers is 1.
	//  The sum of the first 2 numbers is 3.
	//  The sum of the first 3 numbers is 6.

	public static void printSums(String args[]){

		int count = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i = 1 ; i <= count ; i++){
			sum += i;
			System.out.println("The sum of the first " + i + " numbers is " + sum + ".");
		}
	}


	//This function demonstrates the use of the Box class
	//DO NOT change anything in this function
	//use it to test your corrections to the Box class

	//The following is what your output should look like when your
	//Box class is correct.

	//Box 0 is larger than Box 1.
	//Box 0 is equivalent to Box 2.
	//Box 0 is smaller than Box 3.
	//Box 0 is larger than Box 4.
	//Box 1 is smaller than Box 2.
	//Box 1 is smaller than Box 3.
	//Box 1 is smaller than Box 4.
	//Box 2 is smaller than Box 3.
	//Box 2 is larger than Box 4.
	//Box 3 is larger than Box 4.
	
	//Just to note, using Length * width * height * grade, this is the correct output.
	/*
	Box 0 is larger than Box 1.
	Box 0 is equivalent to 2.
	Box 0 is larger than Box 3.
	Box 0 is larger than Box 4.
	Box 1 is smaller than Box 2.
	Box 1 is smaller than Box 3.
	Box 1 is smaller than Box 4.
	Box 2 is larger than Box 3.
	Box 2 is larger than Box 4.
	Box 3 is larger than Box 4.
	*/

	public static void compareBoxes(){

		Box[] array = new Box[5];
		array[0] = new Box(4,5,3,2);
		array[1] = new Box(2,3,3,1);
		array[2] = new Box(3,10,2,2);
		array[3] = new Box(4,4,4,1);
		array[4] = new Box(5,7,1,1);

		for(int i = 0; i< array.length;i++){
			for(int j=i+1; j< array.length;j++){
				//compare for box equivalency
				if(array[i].equals(array[j])){
					System.out.println("Box " + i + " is equivalent to " + j + ".");
				}
				else
				{
					//compare box sizes
					if(array[i].equals(array[i].larger(array[j])))
					{
						System.out.println("Box " + i + " is larger than Box " + j + ".");
					}
					else
					{
						System.out.println("Box " + i + " is smaller than Box " + j + ".");
					}

				}

			}
		}

	}
}
