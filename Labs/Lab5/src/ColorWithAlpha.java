
/**
 * @author Samuel L. Peoples, 1527650
 * ColorWithAlpha constructor class
 */
public class ColorWithAlpha extends SimpleColor{
	int alpha;
	
	/**
	 * Constructor for a simpleColor with RBG input
	 */
	public ColorWithAlpha(){
		super(0, 0, 0);
	}
	/**
	 * Constructor for simpleColor with additional alpha, no RBG
	 * @param alpha, value for alpha
	 */
	public ColorWithAlpha(int alpha) {
		super(0,0,0);
		this.setAlpha(alpha);
	}
	/**
	 * Constructor for simpleColor with RGB and alpha
	 * @param r, red
	 * @param g, green
	 * @param b, blue
	 * @param alpha, alpha code
	 */
	public ColorWithAlpha(int r, int g, int b, int alpha) {
		super(r,g,b);
		this.setAlpha(alpha);
	}
	
	/**
	 * Copy constructor from b to this
	 * @param b, other simpleColor with alpha code
	 */
	public ColorWithAlpha(ColorWithAlpha b) {
		super(b.getR(),b.getG(),b.getB());
		this.setAlpha(b.getAlpha());
	}
	public void setAlpha(int alpha) {
		if(alpha < 0 || alpha > 255)
			throw new ColorException();
		this.alpha = alpha;
	}
	
	/**
	 * getter for alpha
	 * @return this alpha
	 */
	public int getAlpha(){
		return this.alpha;
	}
	
	/** 
	 * Overrides toString
	 * @return appended string
	 */
	@Override
	public String toString(){
		return super.toString() + " Alpha: "+this.alpha;
	}
	
	/**
	 * @param other, what to compare to
	 * @return true if all elements are equivalent
	 */
	public boolean equals(ColorWithAlpha other){
		super.equals(other);
		if(this.alpha == other.alpha && super.equals(other))
			return true;
		else
			return false;
	}
}

