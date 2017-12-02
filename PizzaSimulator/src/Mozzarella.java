
/**
 * @author Samuel L. Peoples, 1527650
 * Mozzarella ingredient class
 */
public class Mozzarella extends Cheese{
	/**
	 * Empty constructor
	 */
	public Mozzarella(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Mozzarella(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Mozzarella empty = new Mozzarella();
		Mozzarella notEmpty = new Mozzarella("notEmpty",new Money(1,1),300);
		Mozzarella notEmpty2 = new Mozzarella("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
