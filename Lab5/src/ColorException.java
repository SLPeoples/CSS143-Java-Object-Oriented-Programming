
/**
 * @author Samuel L. Peoples, 1527650
 * ColorException class
 */
public class ColorException extends RuntimeException{
	/**
	 * Throws error to parent
	 */
	public ColorException(){
		super("There was an error in Color");
	}
	/**
	 * Throws error to parent
	 * @param msg, what to report
	 */
	public ColorException(String msg){
		super(msg);
	}
	
	public static void main(String args[]){
		//throw new ColorException();
	}
	
}
