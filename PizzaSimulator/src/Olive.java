import java.awt.Color;

/**
 * @author Samuel L. Peoples
 * Olive ingredient class
 */
public class Olive extends Vegetable{
	/**
	 * Empty constructor
	 */
	public Olive(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Olive(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Constructor that takes a default color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 * @param clr, color
	 */
	public Olive(String desc, Money cst, int calrs, Color clr){
		super(desc,cst,calrs,clr);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Olive empty = new Olive();
		Olive notEmpty = new Olive("notEmpty",new Money(1,1),300);
		Olive notEmpty2 = new Olive("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
