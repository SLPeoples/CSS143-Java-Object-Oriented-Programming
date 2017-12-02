/**
 * @author Samuel L. Peoples, 1527650
 * Fractions V2 Fraction constructor class
 * previously tested
 */
public class Fraction implements Comparable<Fraction>{
	//Numerator and denominator are initialized as 0/1 to catch some exceptions
	private final int numerator;
	private final int denominator;
	//empty main
	public static void main(String[] args) {}
	public Fraction(){
		this.numerator = 0;
		this.denominator = 1;
	}
	public Fraction(int num, int den){
		this.numerator = num;
		this.denominator = den;
	}
	
	/**
	 * Compares 'this' fraction to 'other' fraction
	 * @param other, type Fraction
	 * @return true, if the fractions are equivalent.
	 */
	public boolean equals(Fraction other){
		
		if(reduceFraction(this.numerator, this.denominator).equals(reduceFraction(other.numerator, other.denominator)))
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
	public String reduceFraction(int num, int den) {
	    int gcm = this.gcm(num, den);
	    return (num / gcm) + "/" + (den / gcm);
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
	 * Overrides the inherited toString to meet local requirements
	 * @return the string representation of the reduced fraction.
	 */
	@Override
	public String toString(){
		return reduceFraction(numerator, denominator);
	}
	
	/**
	 * @return numerator, current numerator
	 */
	int getNumerator(){
		return this.numerator;
	}
	
	/**
	 * @return denominator, current denominator
	 */
	int getDenominator(){
		return this.denominator;
	}
	
	/**
	 * Compares fractions
	 * @return -1,0,1 based on fraction values
	 */
	@Override
	public int compareTo(Fraction other) {
		if((double)this.getNumerator()/(double)this.getDenominator() < (double)other.getNumerator()/(double)other.getDenominator())
			return -1;
		else if ((double)this.getNumerator()/(double)this.getDenominator() == (double)other.getNumerator()/(double)other.getDenominator())
			return 0;
		else
			return 1;
	}
}