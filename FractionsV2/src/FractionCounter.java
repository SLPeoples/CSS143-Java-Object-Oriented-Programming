/**
 * @author Samuel L. Peoples, 1527650
 * Fractions V2 FractionCounter class
 * Stores a reference to a Fraction Object, then counts the iterations of each associated fraction
 */
public class FractionCounter {
	Fraction fraction;
	int count;
	public static void main(String[] args) {}
	/**
	 * @param theFraction, defines the fraction
	 */
	public void fractionCounter(Fraction theFraction){
		this.fraction = theFraction;
	}
	
	/**
	 * Increments if theFraction is equivalent to newFraction
	 * @param newFraction, compares newFraction to theFraction
	 * @return true, if the fractions are equivalent
	 */
	public boolean compareAndIncrement(Fraction newFraction){
		if(fraction.equals(newFraction)){
			count++;
			return true;
			}
		else
			return false;
	}
	
	/**
	 * Overrides the inherited toString to meet local requirements
	 * @returns the developed string
	 */
	public String toString(){
		return fraction.toString()+" has a count of "+count;
	}

}
