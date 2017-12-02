import java.awt.Color;

/**
 * @author Samuel L. Peoples, 1527650
 * Pepper ingredient class
 */
public class Pepper extends Vegetable{
	/**
	 * Empty constructor
	 */
	public Pepper(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Pepper(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Constructor that takes a default color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 * @param clr, color
	 */
	public Pepper(String desc, Money cst, int calrs, Color clr){
		super(desc,cst,calrs,clr);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Pepper empty = new Pepper();
		Pepper notEmpty = new Pepper("notEmpty",new Money(1,1),300);
		Pepper notEmpty2 = new Pepper("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
