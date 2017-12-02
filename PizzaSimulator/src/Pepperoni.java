
/**
 * @author Samuel L. Peoples, 1527650
 * Pepperoni ingredient class
 */
public class Pepperoni extends Meat{
	/**
	 * Empty constructor
	 */
	public Pepperoni(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Pepperoni(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
}
