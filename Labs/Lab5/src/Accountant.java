
/**
 * @author Samuel L. Peoples. 1527650
 * Salaried worker constructor class
 *
 */
public class Accountant extends SalariedWorker {

	public static final double ACCOUNTANT_MONTHLY = 8000;
	private double monthlyPay;
	
	
	public Accountant() {
		super();
	}
	
	//the only way to make an Accountant is to specify the name and social, or with the other constructor below that takes name, social, and pay
	/**
	 * Calls super constructor
	 * @param name this name
	 * @param social, this social id
	 */
	public Accountant(String name, int social){
		super(name, social);
		this.monthlyPay = ACCOUNTANT_MONTHLY;
	}
	
	/**
	 * @param name, this name
	 * @param social, this social id
	 * @param monthlyPay, this pay wage
	 */
	public Accountant(String name, int social, double monthlyPay) {
		super(name, social);
		if(monthlyPay >0)
			this.monthlyPay = monthlyPay;
	}
	
	/**
	 * Calculates weekly pay from monthly pay.
	 */
	public double calculateWeeklyPay() {
		return this.monthlyPay/4;
	}
	
}
