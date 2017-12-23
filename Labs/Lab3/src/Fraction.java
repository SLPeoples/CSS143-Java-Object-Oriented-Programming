
/**
 * @author Samuel L. Peoples, 1527650
 * Fraction Constructor Class *
 */
public class Fraction {
	int num = 0;
	int den = 0;
	/**
	 * Empty Constructor
	 */
	public Fraction(){}
	
	/**
	 * Sets numerator and denominator
	 * @param i, num
	 * @param j, den
	 */
	public Fraction(int i, int j) {
		this.num = i;
		this.den = j;
	}

	/**
	 * Copy constructor
	 * @param b, sets b to this
	 */
	public Fraction(Fraction b) {
		this.num = b.num;
		this.den = b.den;
	}
	
	/**
	 * Replaces inherited tostring
	 */
	public String toString(){
		return this.num+"/"+this.den;
	}

	/**
	 * @return this numerator
	 */
	public String getNum() {
		return Integer.toString(this.num);
	}
	
	/**
	 * @return this denominator
	 */
	public String getDen() {
		return Integer.toString(this.den);
	}
	
	/**
	 * @param a, sets a to this numerator
	 */
	public void setNum(int a) {
		this.num = a;
	}
	
	/**
	 * @param b, sets b to this denominator
	 */
	public void setDen(int b) {
		this.den = b;
	}

	/**
	 * Determines GCM comparing this to b, then adds them, and reduces the fraction.
	 * @param b
	 */
	public void add(Fraction b) {
		int gcm = this.gcm(num, den);
		this.num = (this.num*b.den+b.num*this.den)/gcm;
		this.den = (this.den*b.den)/gcm;
	}
	
	/**
	 * Determines the GCM
	 * @param num, numerator of fraction
	 * @param den, denominator of fraction
	 * @return gcm, integer value
	 */
	private int gcm(int num, int den) {
	    return den == 0 ? num : gcm(den, num % den);
	}
	
	/**
	 * Compares 'this' fraction to 'other' fraction
	 * @param other, type Fraction
	 * @return true, if the fractions are equivalent.
	 */
	public boolean equals(Fraction other){
		
		if(reduceFraction(this.num, this.den).equals(reduceFraction(other.num, other.den)))
			return true;
		else
			return false;
	}
	
	/**
	 * Reduces the fraction to check equivalence
	 * @param num, numerator of fraction
	 * @param den, denominator of fraction
	 * @return the reduced fraction
	 */
	private String reduceFraction(int num, int den) {
	    int gcm = this.gcm(num, den);
	    return (num / gcm) + "/" + (den / gcm);
	}
}
