
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
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Pepperoni empty = new Pepperoni();
		Pepperoni notEmpty = new Pepperoni("notEmpty",new Money(1,1),300);
		Pepperoni notEmpty2 = new Pepperoni("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
