
/**
 * @author Samuel L. Peoples, 1527650
 * Driver for findFile class.
 * Define targetFile and pathToSearch, as well as the maximum number of files to find, 
 */
public class Driver {
	private static final int MAX_NUMBER_OF_FILES_TO_FIND = 10;

	/**
	 * @param args. not used
	 * @throws FoundFilesException, if max files is found, it stops the program and prints the output.
	 */
	public static void main(String args[]){
		String targetFile = "lesson.css";
		String pathToSearch ="C:\\";
		FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
		try{ 
			finder.directorySearch(targetFile, pathToSearch);
		}
		catch(FoundFilesException e){}
		System.out.println(finder.toString());
		
	}
}
