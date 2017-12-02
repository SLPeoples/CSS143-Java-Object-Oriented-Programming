
/**
 * @author Samuel L. Peoples, 1527650
 * Goat ingredient class
 */
public class Goat extends Cheese{
	/**
	 * Empty constructor
	 */
	public Goat(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Goat(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Goat empty = new Goat();
		Goat notEmpty = new Goat("notEmpty",new Money(1,1),300);
		Goat notEmpty2 = new Goat("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
