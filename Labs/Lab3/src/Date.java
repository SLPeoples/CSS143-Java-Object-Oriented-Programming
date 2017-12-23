/**
 * @author Samuel L. Peoples, 1527650
 * Date class, Lab 3.
 *
 */

/*
 * 1.What is the difference between the public and private access modifiers?
 * 		public is accessible by any class or user, while private must be accessed with a getter. Protects information
 * 2.When data is defined as static...
 * 	a.Can it be accessed or read?
 * 		it can be accessed and read in a static manner, but not during an instance (aka this.X())
 * 	b.Can it be written to?
 * 		It can be written to but will remain in the instance it is created.
 * 	c.If we had declared one static variable and 10 objects declared in RAM, how many static variables 
 * 		would also be in memory?
 * 		It will only store the static location a single time.
 * 3.When data is defined as final...
 * 	a.Can it be accessed/used or read?
 * 		It can be accessed at the class level
 * 	b.Can it be written to other than the first initialization?
 * 		It cannot be changed past its initialization (apart from mutatuon within methods)
 * 	c.Why would it be ok to declare a final (or static final) variable as public?
 * 		Because it will not be altered by the program
 * 	d.Later: How does the concept of a final variable relate to Immutable classes?
 * 		A final variable is similar to an immutable class in that they cannot be changed easily. While finals can be mutated,
 * 		immutable classes cannot.
 */

public class Date {
	private int month;
	private int day;
	private int year;
	
	/**
	 * Constructor for date
	 * @param i, month
	 * @param j, day
	 * @param k, year
	 */
	public Date(int i, int j, int k) {
		this.setDate(i, j, k);
	}

	/**
	 * empty constructor for Date
	 */
	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}

	/**
	 * Copies Date b to this date
	 * @param b, date to copy from
	 */
	public Date(Date b) {
		this.setDate(b.month, b.day, b.year);
	}
	/**
	 * Setter for date, sets date to i,j,k
	 * @param i, sets month to i
	 * @param j, sets day to j
	 * @param k, sets year to k
	 */
	public void setDate(int i, int j, int k) {
		if(i<1 || i>12){
			System.out.println("Invalid month; Please enter a value between 1 and 12.");
			System.exit(0);
		}
		switch(i){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(j<1 || j>31){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 31.");
				System.exit(0);
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if(j<1 || j>30){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 30.");
				System.exit(0);
			}
		case 2:
			if(j<1 || j>29){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 29.");
				System.exit(0);
			}
		}
		
		this.month = i;
		this.day = j;
		this.year = k;
	}
	/**
	 * setter for Month 
	 * @param i, sets i to month.
	 */
	public void setMonth(int i){
		if(i<1 || i>12){
			System.out.println("Invalid month; Please enter a value between 1 and 12.");
			System.exit(0);
		}
		this.month = i;
	}
	
	/**
	 * setter for Day, determines if the day is logically sound
	 * @param j, sets Day to j.
	 */
	public void setDay(int j){
		switch(this.month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(j<1 || j>31){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 31.");
				System.exit(0);
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if(j<1 || j>30){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 30.");
				System.exit(0);
			}
		case 2:
			if(j<1 || j>29){
				System.out.println("Invalid day for month: " +this.month+", Please enter a value between 1 and 29.");
				System.exit(0);
			}
		}
			
		this.day = j;
	}
	
	/**
	 * setter for Year
	 * @param k, sets year to k
	 */
	public void setYear(int k){
		this.year = k;
	}
	
	/**
	 * getter for date
	 * @return String this.toString()
	 */
	public String getDate(){
		return this.toString();
	}
	
	/**
	 * getter for Month
	 * @return this.month
	 */
	public int getMonth(){
		return this.month;
	}
	
	/**
	 * getter for Day
	 * @return this.day
	 */
	public int getDay(){
		return this.day;
	}
	
	/**
	 * getter for Year
	 * @return this.year
	 */
	public int getYear(){
		return this.year;
	}

	/** 
	 * Determines the string to return
	 * @return Strning dependent on month
	 */
	@Override
	public String toString(){
		switch(this.month){
		case 1: return "January "+this.day+", "+this.year;
		case 2: return "February "+this.day+", "+this.year;
		case 3: return "March "+this.day+", "+this.year;
		case 4: return "April "+this.day+", "+this.year;
		case 5: return "May "+this.day+", "+this.year;
		case 6: return "June "+this.day+", "+this.year;
		case 7: return "July "+this.day+", "+this.year;
		case 8: return "August "+this.day+", "+this.year;
		case 9: return "September "+this.day+", "+this.year;
		case 10: return "October "+this.day+", "+this.year;
		case 11: return "November "+this.day+", "+this.year;
		case 12: return "December "+this.day+", "+this.year;
		default: return this.month+", "+this.day+", "+this.year;
		}
	}
	/**
	 * Compares month, day, and year of this Date to other Date
	 * @param other, Date to compare
	 * @return boolean, true if month, day and year are equivalent.
	 */
	public boolean equals(Date other){
		if(this.month==other.month&&this.day==other.day&&this.year==other.year)
			return true;
		else 
			return false;
	}
}
