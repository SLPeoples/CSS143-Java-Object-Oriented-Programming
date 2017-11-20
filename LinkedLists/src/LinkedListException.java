/**
 * @author Samuel L. Peoples, 1527650
 * LinkedListException class, simle handling of LinkedListExceptions
 */
public class LinkedListException extends Exception{
	/**
	 * Parametized constructor
	 * @param message, to be sent to superclass
	 */
	public LinkedListException(String message){
		super(message);
	}
	/**
	 * Empty constructor
	 */
	public LinkedListException(){
		super();
	}

}
