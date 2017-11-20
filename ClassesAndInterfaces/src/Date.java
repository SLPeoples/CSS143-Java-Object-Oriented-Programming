import java.io.*;


/**
 * @author Samuel L. Peoples, 1527650
 * Date constructor class
 */

public class Date implements Comparable<Date>, Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
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
	 * @param mo, month
	 * @param da, day
	 * @param yr, year
	 */
	public Date(int mo, int da, int yr) {
		this.setDate(mo, da, yr);
	}

	/**
	 * Copies Date b to this date
	 * @param b, date to copy from
	 */
	public Date(Date b) {
		this.setDate(b.month, b.day, b.year);
	}
	
	/**
	 * Setter for date, sets date to da,da,yr
	 * @param mo, sets month to mo
	 * @param da, sets day to da
	 * @param yr, sets year to yr
	 */
	public void setDate(int mo, int da, int yr) {
		if(mo<1 || mo>12){
			System.out.println("Invalid month; Please enter a value between 1 and 12.");
			System.exit(0);
		}
		if(da<1 || da>31){
			System.out.println("Invalid day for month: " +da+", Please enter a value between 1 and 31.");
			System.exit(0);
		}	
		if(yr<2014 || yr>2024){
			System.out.println("Invalid Year! " +yr+" is not between 2014 and 2024");
			System.exit(0);
		}
		
		this.month = mo;
		this.day = da;
		this.year = yr;
	}
	
	/**
	 * setter for Month 
	 * @param mo, sets mo to month.
	 */
	public void setMonth(int mo){
		if(mo<1 || mo>12){
			System.out.println("Invalid month; Please enter a value between 1 and 12.");
			System.exit(0);
		}
		this.month = mo;
	}
	
	/**
	 * setter for Day, determines if the day is logically sound
	 * @param da, sets Day to da.
	 */
	public void setDay(int da){
		if(da<1 || da>31){
			System.out.println("Invalid day for month: " +da+", Please enter a value between 1 and 31.");
			System.exit(0);
		}		
		this.day = da;
	}
	
	/**
	 * setter for Year
	 * @param yr, sets year to yr
	 */
	public void setYear(int yr){
		if(yr<2014 || yr>2024){
			System.out.println("Invalid Year! Please enter a year between 2014 and 2024");
			System.exit(0);
		}
		this.year = yr;
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
	
	/**
	 * determines if this date is after other
	 * @param other, what to compare to
	 * @return true if this date is after other date
	 */
	public boolean isAfter(Date other){
		if((this.getYear () > other.getYear()) ||
				(this.getYear() == other.getYear() && this.getMonth() > other.getMonth()) ||
				(this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() > other.getDay()))
			return true;
		else return false;
	}

	/**
	 * compareTo method, overrides inherited comparable
	 * Checks to see if the classes are the same,
	 * @return int
	 * returns 1 if the date being compared is after the parameter date
	 * returns 0 if the dates are equivalent
	 * returns -1 if the date being compare is before the parameter date
	 */
	public int compareTo(Date other) {
		if(this.getClass() != (other.getClass())){
			throw new IllegalArgumentException(this.getClass() +"compareTo( " +other.getClass()+" ); Invalid input.");
		}
		if(this.getDate().equals(other.getDate()))
			return 0;
		if((this.getYear () > other.getYear()) ||
				(this.getYear() == other.getYear() && this.getMonth() > other.getMonth()) ||
				(this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() > other.getDay()))
			return 1;

		else return -1;
	}
	
	/**
	 * @return new Date identical to this.
	 */
	public Date clone(){
		return new Date(this.month, this.day, this.year);
	}
	
	/**
	 * writeObject() method for serializable implementation, writes to individual files
	 * @throws IOException if file not found
	 */
	public final void writeObject() throws IOException{ 
		try{
			//FileOutputStream outFile = new FileOutputStream("date.ser");
			FileOutputStream outFile = new FileOutputStream(this.getMonth()+this.getDay()+this.getYear()+".ser");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(this);
	        out.close();
	        outFile.close();
	        System.out.println("Serialized data is saved in "+this.getMonth()+this.getDay()+this.getYear()+".ser");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * readObject() method for serializable implementation
	 * @throws IOException if file not found
	 * @throws ClassNotFoundException if class not found
	 */
	public final void readObject() throws IOException, ClassNotFoundException{
		Date temp = null;
		try{
			//FileInputStream fileIn = new FileInputStream("date.ser");
			FileInputStream fileIn = new FileInputStream(this.getMonth()+this.getDay()+this.getYear()+".ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        temp = (Date) in.readObject();
	        in.close();
	        fileIn.close();
		}
		catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }
		catch(ClassNotFoundException c) {
	         System.out.println("Date class not found");
	         c.printStackTrace();
	         return;
		}
		System.out.println("Deserialized Date...");
		System.out.println("Month: " + temp.getMonth());
	    System.out.println("Day: " + temp.getDay());
	    System.out.println("Year: " + temp.getYear());
	    System.out.println("Date: " + temp.getDate());
	}
}
