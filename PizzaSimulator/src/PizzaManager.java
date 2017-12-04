//package pizzaMainClasses;
import java.util.Scanner;

/**  
    	//PizzaManager Skeleton File
    	//CSS 143, Final Project
   
	    This class is a starting point for your final project and is incomplete.
	    Start by reading the documentation(comments), and then the code.  Find the 
	    empty stub methods you are to fill in using a Top-Down approach (see the
	    assignment for more information on this and Stepwise Refinement)
	  
	    Author: Rob Nash with minor edits by Johnny Lin
 *  
 *  @author Samuel L. Peoples
 *  Completion of the PizzaManager and subclasses.
 *  Utilization of binary searches, and selection/ insertion sorts.
 */

public class PizzaManager {
    private ArrayList pizzas = new ArrayList();
    /* 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    /**
     * start method. Displays pizzas, handles user desires.
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        
        int count = 0;
        while(true) {
            if(count>0) // added to avoid displaying "No pizzas." at the start
            	displayAllPizzas();
            count++;
            displayInstructions();
            
             selection = foo.next().charAt(0);
            
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                addRandomPizza();
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                for(int i=0;i<100;i++)
                                	addRandomPizza();
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                eatSomePizza(foo);
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                				  sortByPrice();
                                  break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                			     sortBySize();
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                			      sortByCalories();
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                				  try{
					        			if(pizzas.isEmpty())
					        				throw new PizzaException();
					        			int cals = foo.nextInt();
		                				  System.out.println("Found a pizza with "+cals+" calories at position "+binarySearchByCalories(cals));
					        		}
					        		catch(PizzaException e){}
					        			//this will still say "no pizzas", 
					        			//will getcaught when pizzaManager displays the empty list
					              break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                System.exit(0);
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }
    
    /**
     * eats pizzas from the arraylist of pizzas
     * @param keys
     */
    private void eatSomePizza(Scanner keys) {
    	//Try catch for wrong input
    	try{
    		if(pizzas.isEmpty())
    			throw new PizzaException();
	    	try{
	    		String input = keys.next();
				if(input.length() <2)
					throw new PizzaException();
		    	String[] input1 = input.split("/", 2);	
				int num = Integer.parseInt(input1[0]);
				int dem = Integer.parseInt(input1[1]);
				System.out.println("At which index?");
				int index = keys.nextInt();
				((Pizza) pizzas.get(index)).eatSomePizza(new Fraction(num,dem));
				if (((Pizza) pizzas.get(index)).getRemianingArea() == 0)
					if(pizzas.size() == 1)
						 pizzas = new ArrayList();
					else pizzas.remove(index);
	    	}
	    	catch(PizzaException e){
				System.out.println("That's not the right input!");
			}
    	}
    	catch(PizzaException e){}
    	//this will still say "no pizzas", 
		//will getcaught when pizzaManager displays the empty list
    }
    
    /**
     * Adds a random pizza, the constructor is randomized, so this is just a constructor call
     */
    private void addRandomPizza() {
    	pizzas.add(new Pizza()); 
    }

    /**
     * iterates through the list of pizzas and prints their values
     */
    private void displayAllPizzas() {
    	try{
    		if(pizzas.isEmpty())
    			throw new PizzaException();
    		for(Object pizza:pizzas)
    		System.out.println(((Pizza) pizza).toString());
    	}
    	catch(PizzaException e){
    		System.out.println("No Pizzas.");
    	}
    }

    /**
     * Insertion sort based on price.
     * Utilizes removes and inserts
     * calls compareto for money comparisons
     */
    private void sortByPrice() {  
    	if(pizzas.isEmpty())
    		return;
    	for(int i = 1; i < pizzas.size(); i++){
        	Pizza current = ((Pizza) pizzas.get(i));
        	int j = i-1;
        	while( (j > -1) && (((Pizza) pizzas.get(j))).compareTo(current) > 0 ){
        		Pizza temp = (Pizza) pizzas.get(j);
        		pizzas.remove(j);
        		pizzas.insert(temp, j+1);
        		j--;
        	}
    	}	
    }
    
    /**
     * Insertion sort based on size
     * checks the size, utilizes removes and inserts
     */
    private void sortBySize() {
    	if(pizzas.isEmpty())
    		return;
    	for(int i = 1; i < pizzas.size(); i++){
        	Pizza current = ((Pizza) pizzas.get(i));
        	int j = i-1;
        	while( (j > -1) && (((Pizza) pizzas.get(j)).getRemianingArea() > current.getRemianingArea())){
        		Pizza temp = (Pizza) pizzas.get(j);
        		pizzas.remove(j);
        		pizzas.insert(temp, j+1);
        		j--;
        	}
    	}	
    }
    
    /**
     * Selection sort based on calories
     */
    private void sortByCalories() {
    	if(pizzas.isEmpty())
    		return;
    	for(int i = 0; i < pizzas.size() - 1; i++){
        	int index = findSmallestClrs(i, pizzas.size());
        	for (int j = i + 1; j < pizzas.size(); j++)
        		if(((Pizza) pizzas.get(j)).getCalories() < ((Pizza) pizzas.get(index)).getCalories())
        			index = j;
        	pizzas.swap(index, i);
        }
        if(((Pizza)pizzas.get(0)).getCalories() > ((Pizza)pizzas.get(0)).getCalories() ||
        		((Pizza)pizzas.get(pizzas.size()-1)).getCalories() < ((Pizza)pizzas.get(pizzas.size()-2)).getCalories())
        	sortByCalories(); //Sometimes things get out of order. This mitigates that issue if an error is made.
    }
    
    /**
     * Helps the calorie sorting
     * @param start index
     * @param end index
     * @return smallest index
     */
    private int findSmallestClrs(int start, int end) {
		int minIndex = start;
		for(int i = start+1; i< end; i++){
			if(((Pizza) pizzas.get(i)).getCalories() > ((Pizza) pizzas.get(start)).getCalories()){
				minIndex = start;
			}
			else
				minIndex = i;
		}
		return minIndex;
	}

	/**
	 * Searches the list for an instance of desired calories
	 * @param cals, desired value
	 * @return first instance of calorie, or -1 if not found
	 */
	private int binarySearchByCalories(int cals) {
		this.sortByCalories();
		int lowIndex = 0;
        int highIndex = pizzas.size()-1;
        int midIndex = highIndex/2;
        return recursiveCals(cals, lowIndex, highIndex, midIndex);
    }
    
    /**
     * recursive binary search, set up by binarySearchByCalories
     * @param cals, desired value
     * @param lowIndex, low value
     * @param highIndex, high value
     * @param midIndex, mid value
     * @return first instance of calorie, or -1 if not found
     */
    private int recursiveCals(int cals, int lowIndex, int highIndex, int midIndex) {
        while(lowIndex <= highIndex){
	    	if(cals == ((Pizza) pizzas.get(midIndex)).getCalories())
	        	return midIndex;
	        else if(cals < ((Pizza) pizzas.get(midIndex)).getCalories())
	        	return recursiveCals(cals, lowIndex, midIndex-1, lowIndex+((midIndex-1-lowIndex)/2));
	        else
				//This will search the upper half of the arraylist
				return recursiveCals(cals, midIndex+1, highIndex, (midIndex+1)+((highIndex-midIndex)/2));
        }
        return -1;
	}

	/*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }


    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
