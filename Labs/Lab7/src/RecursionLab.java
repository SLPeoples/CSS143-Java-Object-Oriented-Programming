/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:
 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */ 

import java.awt.Dimension;
import javax.swing.*;
	
/**
 * @author Samuel L. Peoples
 * Lab 7
 */
public class RecursionLab {
	
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;
	
	public static void main( String args[] ) {	//invoke the recursive method here...
		final long startTime = System.currentTimeMillis();
		/**
		 * TODO: switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behaviour in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
		//int solution = iterativeSum( 0 );
		//int solution = recursiveSum( 5 );
		//int solution = recursiveFactorial( 5 );
		//int solution = recursiveFactorial( 3 );
		/*
		 * Note. Both the given recursiveSum and new recursiveFactorial will not accept 0.
		 */
		//int solution = recursiveExponent(2,0);
		//int solution = recursiveExponent(1,50);
		//int solution = recursiveExponent(2,4);
		//int solution = recursiveExponent(1,50);
		//int solution = binaryExponent(2,0);
		//int solution = binaryExponent(2,1);
		//int solution = binaryExponent(2,2);
		//int solution = binaryExponent(2,3);
		//int solution = binaryExponent(2,4);
		//int solution = binaryExponent(1,50);
		//int solution = binaryExponent(0,5);
		//int solution = binaryExponent(2,5);	
		
		/*
		 * The execution time for the binary method is marginally faster than the recursive version
		 * because it conducts roughly half of the method calls by dividing the exponent in half and squaring.
		 * 
		 * For the first exponent equation f1(x) can be represented as n, where g(x) = n, and c=1, k=0
		 * Thus |f1(x)\leq|g(x)| \forall x>0
		 * 
		 * For the second exponent equation, f2(x) can be represented as n/2 where g(x) = n, and c=1/2, k=0
		 * Thus |f1(x)\leq|g(x)/2| \forall x>0
		 */
		//System.out.println(fib(20));
		//System.out.println();
		//int solution = choose(10,1);
		//int solution = choose(10,8);
		int solution = choose(10,3);

		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		//Some GUI details
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );
		
		//good form to include an exit call when GUIing in Java 
		System.exit(0);
	}
	/**
	 * Combination calculator n choose r
	 * @param n
	 * @param r
	 * @return n choose r
	 */
	public static int choose(int n, int r){
		return (recursiveFactorial(n)/(recursiveFactorial(r)*recursiveFactorial(n-r)));
	}
	/**
	 * Fibonacci string formula
	 * @param n, number of fibonacci numbers to list
	 * @return a series of fibonacci numbers.
	 */
	public static String fib(int n){
		if(n == 0 || n == 1)
			return("1");
		int a=1;
		int b=1; 
		int fibo=1; 
		for(int i= 3; i<= n; i++){ 
			//Fibonacci number is sum of previous two Fibonacci number 
			fibo = a + b; 
			a = b; 
			b = fibo; 
			} 
		return(fib(n-1)+" "+fibo); //Fibonacci number 
	} 
	/**
	  * Binary exponent method.
	 * @param x, value to raise
	 * @param n, exponent
	 * @return x^n
	 */
	public static int binaryExponent( int x,  int n ){
		 updateExponentDisplay(n);
		 if( n==0 )
			 return 1;
		 if(n%2==0){
			 int a = binaryExponent(x,n/2);
			 return(a*a);
		 }
		 else{
			 int a = binaryExponent(x,(n-1)/2);
			 return x* (a*a);
		 }
	 }
	
	/**
	  * recursive exponent method.
	 * @param x, value to raise
	 * @param n, exponent
	 * @return x^n
	 */
	public static int recursiveExponent( int x,  int n ){
		 updateExponentDisplay(n);
		 if( n==0 )
			 return 1;
		 else
			 return(x*recursiveExponent(x,n-1));
	 }
	
	 /**
	  * recursive factorial method. Returns n*(n-1)*...*1
	 * @param n, for n!
	 * @return n!
	 */
	public static int recursiveFactorial( int n ){
		 updateFactorialDisplay(n);
		 if( n==1 )
			 return 1;
		 else
			 return(n*recursiveFactorial(n-1));
	 }
	
	
	/** recursion is similar to iterative looping, but we
	 *  use method calls to repeat computations (or decompose the problem) 
	 *  instead of explicit looping control structures 
	 */
	public static int recursiveSum( int n ) {
		updateRecursiveDisplay(n);			//overhead for nice output, not required
	
		if( n == 1)			//if we're at the base case...
			return 1;		//then return the answer to the simplest problem which we know how to solve
		else				//otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
			return ( n + recursiveSum( n - 1) );
	}						//for this method to terminate, we must be breaking the problem down into smaller
							//and smaller problems, until we reach the simplest form of the problem which we know
							//how to solve (in this case, it's the fact that sum( 1 ) == 1 )

	//the iterative counterpart to the above recursion
	//notice how it's longer? At times, an iterative solution may require more code than the recursive counterpart, 
	//but, the recursive solution is slower and more memory intensive.  We can always recast recursion as iteration.
	public static int iterativeSum( int i ) {
		int total = 0;
		
		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}						
	
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();
		
		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
	}
							
							
	//ignore this method unless interested in the output string						
	public static void updateRecursiveDisplay(int n) {
		
		count++;
		String text = myArea.getText();
		
		
		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}
		
		
		text += "\n/*******************Method invocation " + count + "*********************";
		
		
		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
		
		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
		
	}
	//ignore this method unless interested in the output string						
		public static void updateFactorialDisplay(int n) {
			
			count++;
			String text = myArea.getText();
			
			
			if( count == 1 )  {
				text += "\n       return ( n * recursiveFactorial( n - 1 ) ) \n\n";
				text += "       CALL STACK IN MAIN MEMORY                ";
			}
			
			
			text += "\n/*******************Method invocation " + count + "*********************";
			
			
			text += "\n Calling recursiveSum( int n = " + n +" ). ";
			text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
			
			if( n != 1 ) {
				text += "\n The return statement which invokes the recursive call is \"return ( " + n + " * recursiveFactorial( "+ (n - 1) +" ));";
			} else {
				text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
				text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
				text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
			}
			text += "\n***************************************************************************/";
			
			myArea.setText( text );
			
		}
		//ignore this method unless interested in the output string						
				public static void updateExponentDisplay(int n) {
					
					count++;
					String text = myArea.getText();
					
					
					if( count == 1 )  {
						text += "\n       return ( x * recursiveExponent(x,  n - 1 ) ) \n\n";
						text += "       CALL STACK IN MAIN MEMORY                ";
					}
					
					
					text += "\n/*******************Method invocation " + count + "*********************";
					
					
					text += "\n Calling recursiveSum( int n = " + n +" ). ";
					text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
					
					if( n != 1 ) {
						text += "\n The return statement which invokes the recursive call is \"return ( " + " x * recursiveExponent( x, "+ (n - 1) +" ));";
					} else {
						text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
						text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
						text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
					}
					text += "\n***************************************************************************/";
					
					myArea.setText( text );
					
				}
}
	

	
	
	
