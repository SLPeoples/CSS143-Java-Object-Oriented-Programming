
/**
 * @author Samuel L. Peoples, 1527650
 * Base ingredient class
 */
public class Base extends Ingredient{
	/**
	 * Empty constructor
	 */
	public Base(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Base(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Base empty = new Base();
		Base notEmpty = new Base("notEmpty",new Money(1,1),300);
		Base notEmpty2 = new Base("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
