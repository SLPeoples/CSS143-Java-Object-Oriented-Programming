/* 
 * CSS 162 Assert Demo
 * 
 * Usage: This software is configured to crash your program immediately upon execution.
 * If your software doesn't crash, you don't have assertions enabled (use "-ea")
 * in your editor.  Google the name of your editor and "how to enable asserts" or follow
 * the instructions specific to BlueJ or Eclipse in the lab.
 * 
 * Author: Rob Nash
 */

/*
 * Reflection
 * 1. I prefer to follow my code with the debugger, rather than make asserts, because I can usually tell where my logic fails.
 * 2. For longer programs, it would be difficult to follow the entire progression of the execution, so assertions may be more effective.
 * 3. The debugger with a graphics interface allows the user to visualize the progression of their logic, where more abstract executions 
 * 		tend to fail most.
 * 4. By commenting the intended input, action, and conditions of a method or execution, there are preset parameters that can be worked
 * 		around, allowing the debugging process to be much simpler.
 */
/*
 * Samuel L. Peoples, 1527650
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AssertDemo {

	/* Work on this in a piecewise fashion by uncommenting and focusing on one section at a time
	 * in isolation rather than running everything at once.
	 */
	public static void main(String[] args) {
		assert(true);
		//assert(false);
		
		warmUpAsserts();
		
		assertWithPrimitives();
		
		assertWithObjects();
		
		homeworkRelatedAsserts();
	}

	/*
	 * Just a few warm-up asserts here.
	 * Add two new assert() statements after the TODO below
	 */
	private static void warmUpAsserts() {	
			assert( 5 > 1 );
			
			int a = 30;
			assert(a != 0);
	
			assert(null == null);	  //could this ever be false?
			assert(true == true);	  //a bad day indeed if this could be false
			assert(4 == 8/2);
			assert('k' == 'k');
	}

	/*
	 * Using asserts in conjunction with primitive types is familiar to you;
	 * just as in a loop or if, you want to form a true/false (boolean) expression
	 * by employing the relational operators.
	 */
	private static void assertWithPrimitives() {
		//assert below to ensure a Fraction's denominator is never 0
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();
				
		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();
				
		assert(denom != 0);
	
		//assert that all ArrayLists start empty
		ArrayList<String> emptyList = new ArrayList<String>();
		assert(emptyList.size() == 0);
		assert(2 > 1);
		int i = 0;
		int j = 0;
		assert(i == j);
	}
	
	/*
	 * Asserts work with both primitives and objects.  Just as you 
	 * use "==" with primitives and ".equals()" with objects, so too 
	 * will you use ".equals()" in asserts that deal with object equality. 
	 */
	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);		
		//guess what .equals() does if you don't create one yourself? (hint ==)
		assert( ad.equals(ad) );  
	}


	/*
	 * This function compares the address at "this" to the address of the object handed 
	 * into the function.
	 */
	public void checkAddress(Object input) {
		//The address of this references the assertDemo object address, and ensures that the addresses are identical
		System.out.println("Address of this :" + this);
		System.out.println("Address of input:" + input);
		
		assert(this == input);  //== does an address check for objects, which is frequently NOT what we want
	}

	/*	
	 * Asserts are a useful tool for transforming postconditions and class invariants into code.
	 * Lets build a few asserts that work with your current Bill & Money assignment.
	 * Change the value of paidDate and cents to trip the asserts and observe the asserted error message. 
	 */
	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();  //really, a Date 
		assert( paidDate != null);  	 //perhaps one rule is that paidDate shouldn't be null after calling setPaidDate()
		int cents = 0;
		assert( cents >= 0 && cents <=99);  //another class invariant is written as an assert here.
		Box a = new Box(1,2,3,4);
		Box b = new Box(1,2,3,4);
		Box c = new Box(a.getWidth(), a.getHeight(),a.getDepth(),a.getGrade());
		Box d = a;
		assert(a.equals(b));
		assert(d.equals(a));
		assert(d == a);
		assert(a.equals(c));
	}
}
