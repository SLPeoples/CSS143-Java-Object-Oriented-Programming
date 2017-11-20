/**
 * @author Samuel L. Peoples, 1527650
 * SalariedWorker.java
 * This worker calculates her weekly pay differently than a hourly worker does, so we override the calculateWeeklyPay method
 */

public class SalariedWorker extends Employee {
	private double monthlyPay;
	
	/**
	 * Empty constructor, 
	 */
	public SalariedWorker() {
		super();
	}
	
	/**
	 * Calls super constructor
	 * @param name, this name
	 * @param social, this social id
	 */
	public SalariedWorker(String name, int social) {
		super(name, social);
	}
	
	/**
	 * Calls super constructor
	 * @param name, this name
	 * @param social, this social id
	 * @param pay, this pay wage
	 */
	public SalariedWorker(String name, int social, double pay) {
		super(name, social);
		
		if( pay > 0.0) {
			this.monthlyPay = pay;
		}
	}
	
	/**
	 * Calculates weekly pay from monthly pay.
	 */
	public double calculateWeeklyPay() {
		return this.monthlyPay/4;
	}
}
