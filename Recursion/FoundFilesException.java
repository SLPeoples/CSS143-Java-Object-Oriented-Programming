
/**
 * @author Samuel L. Peoples, 1527650
 * FoundFilesException Exception
 */
public class FoundFilesException extends Exception{
	
	/**
	 * FoundFilesException constructor
	 */
	public FoundFilesException(){
		super("Found max files");
	}
	
	/**
	 * nonEmpty FoundFilesException constructor
	 */
	public FoundFilesException(String message){
		super(message);
	}
}
