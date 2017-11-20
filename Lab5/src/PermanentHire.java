/**
 * @author Samuel L. Peoples 1527650
 * PerhmanentHire constructor class
 */
public class PermanentHire extends SalariedWorker{
public static final double PERM_MONTHLY = 7500;
public static final double PERM_BONUS = 50;
private double monthlyPay;
	/**
	 * Empty Constructor class 
	 */
	public PermanentHire() {
		super();
	}
	
	/**
	 * calls super constructor
	 * @param name this name
	 * @param social, this social id
	 */
	public PermanentHire(String name, int social){
		super(name, social, PERM_MONTHLY );
	}
	
	/**
	 * calls super constructor
	 * @param name this name
	 * @param social this social id
	 * @param monthlyPay this monthlypay
	 */
	public PermanentHire(String name, int social, double monthlyPay) {
		super(name, social);
		if(monthlyPay > 0)
			this.monthlyPay = monthlyPay;
	}
	
	/** copy constructor
	 * @param other, what to copy to this
	 */
	public PermanentHire(PermanentHire other){
		super(other.getName(), other.getSocial(), (other.calculateWeeklyPay()-PERM_BONUS)*4);
	}
	
	/**
	 * Calls super calcuclateweeklypay and adds the bonus
	 */
	@Override
	public double calculateWeeklyPay(){
		return super.calculateWeeklyPay()+PERM_BONUS;
	}

}
