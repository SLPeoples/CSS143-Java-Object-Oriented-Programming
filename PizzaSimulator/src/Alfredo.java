import java.awt.Color;

/**
 * @author Samuel L. Peoples, 1527650
 * Alfredo ingredient class
 */
public class Alfredo extends Base{
	/**
	 * Empty constructor
	 */
	public Alfredo(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Alfredo(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Alfredo empty = new Alfredo();
		Alfredo notEmpty = new Alfredo("notEmpty",new Money(1,1),300);
		Alfredo notEmpty2 = new Alfredo("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
