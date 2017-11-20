/**
 * @author Samuel L. Peoples, 1527650
 * This class uses a static date to set and print the date using a Date object.
 *
 */

public class Date {
	private int month;
	private int day;
	private int year;

	/**
	 * A date object is created, sent to the setDate method, then printed with the report().
	 */
	public static void main(String[] args) {
		Date dt = new Date();	
		dt.setDate(10,21,2015);
		dt.report();
	}	
	
	/**
	 * @param m sets "month"
	 * @param d sets "day"
	 * @param y sets "year"
	 */
	public void setDate(int m, int d, int y) {
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	/**
	 * Prints the date in the correct format.
	 */
	public void report() {
		System.out.println(this.month+"/"+this.day+"/"+this.year);
	}
}
