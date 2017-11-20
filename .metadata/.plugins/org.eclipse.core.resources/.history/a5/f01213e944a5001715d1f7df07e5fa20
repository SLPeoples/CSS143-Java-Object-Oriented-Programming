import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 * NewAndReviewExamples.java
 *
 * Depends on Rectangle.java
 * 
 * See the Lab for more instructions.
 * Use this file to comment/uncomment and test each of the methods below, 
 * while following along in the lab.  Experiment and convince yourself of
 * Java's pass-by-reference characteristics for objects, the this parameter,
 * and learning the basics of getters/setters (or, accessors and mutators)
 * 
 * 
 */


public class NewAndReviewExamples {

	//Modify the code below to select the case and topic you'd like to work with	
	public static void main(String[] args) {
		int i = 6;	//this is the "selector" for the switch statement below
		
		
		switch(i) {
			case 0:		gettersSettersExample();
					break;
					
			case 1:		thisExample();
					System.out.println( "But how come in main there is no this?");
					//System.out.println(this);
					//see the isEquals function for more proof that static methods have no object target!
					break;
					
			case 2:		overloadingExample();
					break;
					
			case 3:		equalsVSisEquals();  //this also demonstrates static vs nonstatic methods
					break;
					
			case 4: 	overridingExample();
					break;
					
			case 5:		System.out.println("primitive (in main) before function call:" + i);
					byValueExample(i);
					System.out.println("primitive (in main) after function call:" + i);
					break;
					
			case 6: 	Rectangle watchMe = new Rectangle(1,1,1,1);
					System.out.println("watchMe's X,Y: " + watchMe.getXY());
					ByReferenceExample(watchMe);
					System.out.println("watchMe's X,Y: " + watchMe.getXY());
					break;
					
			default: 	arrayListExample();
					//break;
		}
	}

	private static void gettersSettersExample() {
		JOptionPane.showMessageDialog(null, "Check out getXY() and setXY() in Rectangle");
	}

	private static void byReferenceExample(Rectangle watchMe) {
		watchMe.setXY(5,6);
	}

	private static void byValueExample(int i) {
		i = -1;
		System.out.println("i in ByValueExample is now :" + i);
	}

	private static void equalsVSisEquals() {
		Rectangle rect1 = new Rectangle(1,1,5,5);
		Rectangle rect2 = new Rectangle(1,1,5,5);
		Rectangle rect3 = new Rectangle(2,3,4,5);
	
		//first, using the static IsEquals method
	}

	private static void overridingExample() {
		JOptionPane.showMessageDialog( null, "Check out the Overridden equals() method in Rectangle");
		
	}

	private static void overloadingExample() {
		JOptionPane.showMessageDialog( null, "Check out the constructors in Rectangle");
		
	}

	public static void thisExample() {
		Rectangle myRect = new Rectangle(1,3,9,9);
		
		System.out.println( "myRect lives at address:" + myRect);
	
		myRect.printMemoryAddress();
		
		//old way has no concept of this, as you MUST pass the record/struct you wish to operate on
		//new way automatically includes the target "record/struct" as part of the function call
		
		//old: printMemoryAddress(myRect);
		//new: myRect.printMemoryAddress();
		
		//old: public void printMemoryAddress(Rectangle this)
		//new: public void printMemoryAddress()  //'this' is built-in!
		
		//'This' is a link to the object on which the function was called!
		
	}
	
	public static void arrayListExample() {  //note that this is just a StringList, IntList, or CharList that we have already designed
		ArrayList<String> myStrings = new ArrayList<String>();
		
		myStrings.add( "Foo" );
		myStrings.add( "Boo" );
		myStrings.add( "Ethics" );
		
		System.out.println( "Size is " + myStrings.size() );
		//JOptionPane.showMessageDialog( null, "Size is " + myStrings.size());
		
		System.out.println( "Elements are " + myStrings );
		System.out.println( "And toString yields " + myStrings.toString() );
		
		
		for( int counter = 0; counter < myStrings.size(); counter++) {
			System.out.println( "Item at index:" + counter + " is " + myStrings.get(counter));
		}
		
	}
	
}