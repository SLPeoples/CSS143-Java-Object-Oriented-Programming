
/**
 * @author Samuel L. Peoples, 1527650
 * Marinara ingredient class
 */
public class Marinara extends Base{
	/**
	 * Empty constructor
	 */
	public Marinara(){
		super();
	}
	
	/**
	 * Constructor that does not take color
	 * @param desc, description
	 * @param cst, cost
	 * @param calrs, calories
	 */
	public Marinara(String desc, Money cst, int calrs){
		super(desc,cst,calrs);
	}
	
	/**
	 * Main for testing methods
	 * @param args
	 */
	public static void main(String args[]){
		Marinara empty = new Marinara();
		Marinara notEmpty = new Marinara("notEmpty",new Money(1,1),300);
		Marinara notEmpty2 = new Marinara("notEmpty",new Money(1,1),300);
		System.out.println(empty.toString()+"\n"+notEmpty.toString()+"\n" +notEmpty2.toString()+"\n" );
		System.out.println(empty.equals(notEmpty)+"\n" +notEmpty.equals(notEmpty2));
	}
}
