/**
 * @author Samuel L. Peoples, 1527650
 * HourlyWorker class
 * This worker calculates her weekly pay differently than a salaried worker does, so we override the calculateWeeklyPay method
 */


public class HourlyWorker extends Employee {
	private double hourlyPay;
	public static final double MINIMUM_WAGE = 10.0;
	
	/**
	 * Calls super constructor (empty)
	 */
	public HourlyWorker() {
		super();
	}
	
	/**
	 * Constructor for HourlyWorker with name and social id
	 * @param name, this name
	 * @param social, this social
	 */
	public HourlyWorker(String name, int social) {
		super(name, social);
		this.hourlyPay = MINIMUM_WAGE;
	}
	
	public HourlyWorker(String name, int social, double pay) {
		super(name, social);
		
		if( pay > 0.0) {
			this.hourlyPay = pay;
		}
	}
	
	//notice how we override this method to act accordingly for an hourly wage
	public double calculateWeeklyPay() {
		return hourlyPay * 40;
	}
}
