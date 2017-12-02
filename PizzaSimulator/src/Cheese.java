
/**
 * @author Samuel L. Peoples, 1527650
 * Cheese ingredient class
 */
public class Cheese extends Ingredient{
	/**
	 * Empty constructor
	 */
	public Cheese(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Cheese(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Cheese empty = new Cheese();
		Cheese notEmpty = new Cheese("notEmpty",new Money(1,1),300);
		Cheese notEmpty2 = new Cheese("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
