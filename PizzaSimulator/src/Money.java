import java.io.*;

/**
 * @author Samuel L. Peoples, 1527650
 * Money constructor Class 
 * previously tested
 */

public class Money implements Comparable<Money>, Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	private int dollars;
	private int cents;
	
	/**
	 * Empty constructor, sets instance variables to zero
	 */
	public Money() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	/**
	 * Constructor for just dollars
	 * @param dol, int value for dollars
	 */
	public Money(int dol) {
		this.setMoney(dol, 0);
	}
	
	/**
	 * Constructor for dollars and cents input
	 * @param dol, int value for dollars
	 * @param cen, int value for cents
	 */
	public Money(int dol, int cen) {
		this.setMoney(dol, cen);
	}

	/**
	 * Copy constructor
	 * @param other, what to copy from
	 */
	public Money(Money other) {
		this.setMoney(other.getDollars(),other.getCents());
	}

	/**
	 * getter for instance variable for dollars
	 * @return this.dollars
	 */
	public int getDollars() {
		return this.dollars;
	}
	
	/**
	 * getter for instance variable for cents
	 * @return this.cents
	 */
	public int getCents() {
		return this.cents;
	}

	/**
	 * Mutator for this.dollars and this.cents
	 * @param dol, set this.dollars to dol
	 * @param cen, set this.cents to cen
	 */
	public void setMoney(int dol, int cen) {
		this.dollars = dol;
		this.cents = cen;
	}
	
	/**
	 * getter for combined money as double
	 * @return double value for thie Money object
	 */
	public double getMoney(){
		return this.dollars+((double) this.cents/100);
	}
	
	/**
	 * Adds two Money objects together
	 * @param other, what to add to this Money object
	 */
	public void add(Money other){
		int addDollars = this.dollars + other.dollars;
		int addCents = this.cents + other.cents;
		if(addCents>100){
			addCents -= 100;
			addDollars += 1;
		}
		this.setMoney(addDollars, addCents);
	}
	
	/**
	 * Adds dolalrs
	 * @param dol, what to add to this Money object
	 */
	public void add(int dol){
		this.setMoney(this.getDollars()+dol, this.getCents());
	}
	
	/**
	 * Adds cents
	 * @param cen, what to add to this Money object
	 */
	public void add(int dol, int cen){
		int addDollars = this.getDollars() + dol;
		int addCents = this.getCents() + cen;
		if(addCents>100){
			addCents -= 100;
			addDollars += 1;
		}
		this.setMoney(addDollars, addCents);
	}

	/**
	 * Replaces inherited tostring
	 * @return String local to class
	 */
	public String toString(){
		while(this.cents>100){
			this.cents -= 100;
			this.dollars += 1;
		}
		if(this.cents<10)
			return "$"+this.dollars+"."+"0"+this.cents;
		else
			return "$"+this.dollars+"."+this.cents;
	}
	
	/**
	 * Compares instance variables of same tyoe
	 * @param other, what to compare to
	 * @return true, if the dollars and cents are equivalent
	 */
	public boolean equals(Money other){
		if(this.dollars == other.dollars && this.cents ==  other.cents)
			return true;
		else
			return false;
	}
	

	/**
	 * compareTo method, overrides inherited comparable
	 * Checks to see if the classes are the same,
	 * @return int
	 * returns 1 if the money being compared is greater than the parameter money
	 * returns 0 if the money is equivalent
	 * returns -1 if the money being compare is less than the parameter money
	 */
	public int compareTo(Money other) {
		if(this.getClass() != (other.getClass())){
			throw new IllegalArgumentException(this.getClass() +"compareTo( " +other.getClass()+" ); Invalid input.");
		}
		if(this.getDollars() == other.getDollars() && this.getCents() == other.getCents())
			return 0;
		if(this.getMoney() > other.getMoney())
			return 1;

		else return -1;
	}
	
	/**
	 * @return new Money identical to this.
	 */
	public Money clone(){
		return new Money(this.dollars,this.cents);
	}
	
	/**
	 * writeObject() method for serializable implementation, writes to individual files
	 * @throws IOException if file not found
	 */
	public final void writeObject() throws IOException{ 
		try{
			//FileOutputStream outFile = new FileOutputStream("money.ser");
			FileOutputStream outFile = new FileOutputStream(this.getDollars()+"."+this.getCents()+".ser");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(this);
	        out.close();
	        outFile.close();
	        System.out.println("Serialized data is saved in "+this.getDollars()+"."+this.getCents()+".ser");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * readObject() method for serializable implementation
	 * @throws IOException if file not found
	 * @throws ClassNotFoundException if class not found
	 */
	public final void readObject() throws IOException, ClassNotFoundException{
		Money temp = null;
		try{
			//FileInputStream fileIn = new FileInputStream("money.ser");
			FileInputStream fileIn = new FileInputStream(this.getDollars()+"."+this.getCents()+".ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        temp = (Money) in.readObject();
	        in.close();
	        fileIn.close();
		}
		catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }
		catch(ClassNotFoundException c) {
	         System.out.println("Money class not found");
	         c.printStackTrace();
	         return;
		}
		System.out.println("Deserialized Money...");
		System.out.println("Money: " + temp.getMoney());
	    System.out.println("Dollars: " + temp.getDollars());
	    System.out.println("Cents: " + temp.getCents());
	    System.out.println("String: " + temp.toString());
	}
}
