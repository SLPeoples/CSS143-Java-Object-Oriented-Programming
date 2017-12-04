
/**
 * Meat ingredient class
 * @author Samuel L. Peoples, 1527650
 */
public class Sausage extends Meat{
	/**
	 * Empty constructor
	 */
	public Sausage(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Sausage(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Sausage empty = new Sausage();
		Sausage notEmpty = new Sausage("notEmpty",new Money(1,1),300);
		Sausage notEmpty2 = new Sausage("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
