
/**
 * @author Samuel L. Peoples, 1527650
 *
 */
public class Consultant extends HourlyWorker{
	private double hourlyPay;
	private static final double WAGE = 3;
	
	/**
	 * empty constructor
	 */
	public Consultant(){
		super();
	}
	
	/**
	 * calls super constructor
	 * @param name, this name
	 * @param social, this social
	 */
	public Consultant(String name, int social){
		super(name, social);
		this.hourlyPay = WAGE;
	}
	
	/**
	 * Constructor calls super
	 * @param name, this name
	 * @param social, this social
	 * @param pay, this pay
	 */
	public Consultant(String name, int social, double pay){
		super(name, social);
		if(pay>0)
			this.hourlyPay = pay;
	}
	
	/**
	 * copy constructor
	 * @param other, what to copy to this
	 */
	public Consultant(Consultant other){
		super(other.getName(), other.getSocial());
		this.hourlyPay = other.calculateWeeklyPay()/20;
	}
	
	/**
	 * calls calculateweeklyPay from super, then multiplies by 20 (PT)
	 */
	@Override
	public double calculateWeeklyPay(){
		return this.hourlyPay*20;
	}
}

