
/**
 * @author Samuel L. Peoples
 * Meat ingredient class
 */
public class Meat extends Ingredient{
	/**
	 * Empty constructor
	 */
	public Meat(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Meat(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Meat empty = new Meat();
		Meat notEmpty = new Meat("notEmpty",new Money(1,1),300);
		Meat notEmpty2 = new Meat("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
