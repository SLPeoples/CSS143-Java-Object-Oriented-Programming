import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Samuel L. Peoples, 1527650
 * FindFile class, recursively searches all subdirectories until max count is met.
 */
public class FindFile{
	private int maxNumFiles;
	private int count =0;
	String[] results;
	
	/**
	 * Constructor for the FindFile object
	 * @param maxFiles, number of files to match.
	 */
	FindFile(int maxFiles){
		this.maxNumFiles = maxFiles;
		this.results = new String[this.maxNumFiles];
	}
	
	/**
	 * Recursiveley searches subdirectories until maxNumFiles is met.
	 * @param targetFile, files to search for
	 * @param pathToSearch, Starting point to search. (Searches all subdirectories)
	 */
	void directorySearch(String targetFile, String pathToSearch) throws FoundFilesException{
		check(pathToSearch);
		
		/* * * * * *
		 * Verbose *
		 * * * * * */
		System.out.println("Searching "+pathToSearch+" for "+targetFile);
		
		//Creates an array of items to search through
		File[] files = new File(pathToSearch).listFiles();
		//Will attempt to search the subdirectories for the file in question
		//If the subdirectory is empty, nullpointerexception will be called and the loop will continue
		//If the max count is reached it will throw the foundfilesexception and print the contents.
		try{
			for(File file : files){
				if(this.count == this.maxNumFiles)
					throw new FoundFilesException();
				if(file.getName().equals(targetFile)){
					results[count] = file.getAbsolutePath();
					this.count++;
				}
				else if(file.isDirectory())
					directorySearch(targetFile, file.getAbsolutePath());	
			}
		}
		catch(NullPointerException e){}
	}
	
	/**
	 * @return this count
	 */
	int getCount(){
		return this.count;
	}
	
	/**
	 * @return String array of results
	 */
	String[] getFiles(){
		return this.results;		
	}
	
	/**
	 * This program did not ever throw an IllegalArgumentException, so I opted to do a check
	 * for an existing filepath. If it does not, it conducts the same operation an exception would.
	 * @param path, path to check
	 */
	void check(String path){
		File check = new File(path);
		if(!check.exists()){
			System.out.println(path+" is not a valid directory.");
			System.exit(0);
		}
	}
	
	/**
	 * Overwrites the native toString with a list of found files.
	 */
	@Override
	public String toString(){
		String out = "Files found: ";
		if(this.getCount() == 0)
			return out+= "\nNo files found.";
		for(int i=0;i<this.getFiles().length;i++)
			if(this.getFiles()[i]!=null)
				out+="\n"+this.getFiles()[i];
		return out;
	}
}
