import java.io.File;
import java.util.Stack;

/**
 * @author {Riptide
 * (1) Setup
 * 		Need to initialize array to return files, file name, and target path
 * (2) Input
 * 		Target and path
 * (3) Processing
 * 		Determine if path is valid
 * 		Determine whether populated files are directories or files
 * 		Check subdirectories for target file
 * 		Populate return array with locations of target
 * (4) Output
 * 		Return/ print the location array
 */
public class FileSearch {
	public static void main(String args[]){
		String target = "test.txt";
		//String target = "test1.12.txt";
		//String target = "test1.22.txt";
		//String target = "NotFound.txt";
		String path = System.getProperty("user.dir");
		//v1(target, path);
		v2(target, path);
		System.out.println("No File Found!");
	}
	/**
	 * Finds the first instance of a target file
	 * @param target
	 * @param path
	 */
	public static void v1(String target, String path){
		try{
			Stack<String> directories = new Stack<String>();
			directories.push(path);
			File[] files = new File(path).listFiles();
			for(File file:files){
				if(file.isDirectory())
					directories.push(file.getAbsolutePath());
			}
			for(String folder:directories){
				File[] files2 = new File(folder).listFiles();
				for(File file:files2){
					if(file.getName().equals(target)){
						System.out.println("File found!\n"+file.getAbsolutePath());
						System.exit(0);
					}
					if(file.isDirectory())
						v1(target, file.getAbsolutePath());
				}
			}
		}
		catch(NullPointerException e){}
	}
	
	/**
	 * Recursiveley searches subdirectories until file is found. Similar to v1 above, but more efficient
	 * @param target, files to search for
	 * @param path, Starting point to search. (Searches all subdirectories)
	 */
	public static void v2(String target, String path){
		check(path);
		
		//Creates an array of items to search through
		File[] files = new File(path).listFiles();
		//Will attempt to search the subdirectories for the file in question
		//If the subdirectory is empty, nullpointerexception will be called and the loop will continue
		//If the max count is reached it will throw the foundfilesexception and print the contents.
		try{
			for(File file : files){
				if(file.getName().equals(target)){
					System.out.println("File found!\n"+file.getAbsolutePath());
					System.exit(0);
				}
				else if(file.isDirectory())
					v2(target, file.getAbsolutePath());	
			}
		}
		catch(NullPointerException e){}
	}
	/**
	 * This program did not ever throw an IllegalArgumentException, so I opted to do a check
	 * for an existing filepath. If it does not, it conducts the same operation an exception would.
	 * @param path, path to check
	 */
	public static void check(String path){
		System.out.println("Searching "+path);
		File check = new File(path);
		if(!check.exists()){
			System.out.println(path+" is not a valid directory.");
			System.exit(0);
		}
	}
	
}
