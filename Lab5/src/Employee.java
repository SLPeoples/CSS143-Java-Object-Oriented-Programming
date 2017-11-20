/*
 * Employee.java - Abstract
 * This is the superclass of all workers in this company
 *   All employees must have a name and social security number. 
 *   
 *   What methods are polymorphic in the Employee Hierarchy?
 *   	calculateWeeklyPay has different forms, and is subClass specific.
 *   How could we build a method like getRandShape() above but for use with Employees?
 *   public Employee getRandEmployee() {
			Shape retVal = null;
			final String name = getRandName(); //This would be defined to return one of many names
			final int social = getRandSocial(); //Defined to return 9-digit random number
			final int pay = getRandInt()*100;
			
			switch( ( int )(Math.random() * 4) ) {
			
				case 0: 	retVal = new PermanentHire(name, social, pay);
							break;
				case 1: 	retVal = new Consultant(name,social,pay);
							break;
				case 2: 	retVal = new Accountant(name,social,pay);
							break;
				case 3: 	retVal = new HourlyWorker(name,social,pay);
							break;				
			}
			return retVal;
		}
		
 *   If we built a getRandomEmployee() method that returns various Employee subclass
 *   objects; write a few lines of code that would demonstrate late binding
 *   	if the employees were populated to myEmployees through the getRandEmployee() method
 *   for( int i = 0; i < myEmployees.size(); i++) {
			System.out.println( myEmployees.get(i).getName() + " makes " + myEmployees.get(i).calculateWeeklyPay() + " per week.");
		}
	the above from the employee driver is an example of late binding
 */

//notice the abstract keyword? That prevents us from making objects of this type!
public abstract class Employee {
	private String name;
	private int social;
	
	/**
	 * Empty Constructor
	 */
	public Employee() {}
	
	/**
	 * Constructor with name and social id
	 * @param newName, name
	 * @param newSocial, social id
	 */
	public Employee(String newName, int newSocial) {
		this.name = newName;
		this.social = newSocial;
	}
	
	/**
	 * @return this name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param name, set this name to name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter for social id
	 * @return this social id
	 */
	public int getSocial() {
		return this.social;
	}
	
	/**
	 * setter for social
	 * @param social set to social
	 */
	public void setSocial(int social) {
		this.social = social;
	}
	
	public String toString(){
		return this.name+" makes "+this.calculateWeeklyPay()+" per week.";
	}
	

	public abstract double calculateWeeklyPay();
	
}
