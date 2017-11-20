
/**
 * @author Samuel L. Peoples 1527650
 * ItemNotFoundException to handle Search algorithm inability to find.
 */
public class ItemNotFoundException extends Exception {
	
	/**
	 * @param message, message to repeat back to the superclass
	 */
	public ItemNotFoundException(String message){
		super(message);
	}
	
	/**
	 * Returns "Item not found" to the super class.
	 */
	public ItemNotFoundException(){
		super("Item not found");
	}
}
