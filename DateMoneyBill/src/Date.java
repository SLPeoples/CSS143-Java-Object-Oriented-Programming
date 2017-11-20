/**
 * @author Samuel L. Peoples, 1527650
 * Date constructor class
 *
 */

public class Date {
	private int month;
	private int day;
	private int year;
	/**
	 * empty constructor for Date
	 */
	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}
	
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
		if(j<1 || j>31){
			System.out.println("Invalid day for month: " +j+", Please enter a value between 1 and 31.");
			System.exit(0);
		}	
		if(k<2014 || k>2024){
			System.out.println("Invalid Year! " +k+" is not between 2014 and 2024");
			System.exit(0);
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
		if(j<1 || j>31){
			System.out.println("Invalid day for month: " +j+", Please enter a value between 1 and 31.");
			System.exit(0);
		}		
		this.day = j;
	}
	
	/**
	 * setter for Year
	 * @param k, sets year to k
	 */
	public void setYear(int k){
		if(k<2014 || k>2024){
			System.out.println("Invalid Year! Please enter a year between 2014 and 2024");
			System.exit(0);
		}
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
	 * @return String dependent on month
	 */
	@Override
	public String toString(){
		String string = "";
		if(this.month < 10)
			string += "0"+this.month;
		else
			string += this.month;
		if(this.day < 10)
			string += "/0"+this.day;
		else
			string += "/"+this.day;
		string += "/"+this.year;
		return string;
			
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
