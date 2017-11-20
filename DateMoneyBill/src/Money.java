/**
 * @author Samuel L. Peoples, 1527650
 * Money constructor Class 
 */
public class Money {
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
		this.dollars = addDollars;
		this.cents = addCents;
	}

	/**
	 * Replaces inherited tostring
	 * @return String local to class
	 */
	public String toString(){
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
}
