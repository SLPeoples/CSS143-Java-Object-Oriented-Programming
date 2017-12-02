/*
 * A Simple Threading Application
 * Complete with race conditions, no deadlock avoidance, and minimal comments! =)
 * 
 */

public class Multi implements Runnable {
	private String name = "";
	
	public Multi(String newName ) {
		name = newName;
	}
	
	//This is the key to the Runnable Interface	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			if( Math.random() < .5) {   //on occasion
				try {	//lets go to sleep so the other threads have a chance
					Thread.sleep(2);
				} catch (InterruptedException e) {
					//do nothing other than a trace
					e.printStackTrace();
				}
			}
			System.out.println( name + " : " + i);
		}
	}
	
	//How many threads are active in this application do you think?
	//One is for main, one for the GC, and at least two more for t1 and t2 below...
	public static void main(String[] args) {
		Thread t1 = new Thread( new Multi("foo1") );
		Thread t2 = new Thread( new Multi("foo2") );
		
		t1.start();	//this calls run()
		t2.start();	//start the second thread
	}
}
