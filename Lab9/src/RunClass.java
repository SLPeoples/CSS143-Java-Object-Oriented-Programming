
/**
 * @author Samuel L. Peoples
 * Runnable RunClass, prints the input string
 */
public class RunClass implements Runnable{
	private String string;
	/**
	 * simple constructor
	 * @param str string to set
	 */
	public RunClass(String str){
		this.string  = str;
	}
	
	/**
	 * prints the input string
	 */
	@Override
	public void run() {
		System.out.println(this.string);
	}
	/**
	 * testing main
	 */
	public static void main(String args[]){
		Thread t1 = new Thread(new RunClass("Pizza"));
		Thread t2 = new Thread(new RunClass("Pasta"));
		t1.start();
		t2.start();
	}
}
