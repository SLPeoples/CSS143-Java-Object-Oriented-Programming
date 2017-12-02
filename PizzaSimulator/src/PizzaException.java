/**
 * @author Samuel L. Peoples, 1527650
 * PizzaException class, simle handling of PizzaExceptions
 */
public class PizzaException extends Exception{
	/**
	 * Parametized constructor
	 * @param message, to be sent to superclass
	 */
	public PizzaException(String message){
		super(message);
	}
	/**
	 * Empty constructor
	 */
	public PizzaException(){
		super();
	}

}
