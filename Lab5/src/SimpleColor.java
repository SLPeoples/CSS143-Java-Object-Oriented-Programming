
/**
 * @author Samuel L. Peoples, 1527650
 * SimpleColor Class
 *
 */
public class SimpleColor {
	private int r;
	private int g;
	private int b;
	
	
	/**
	 * @return this red
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r, set this to red
	 */
	public void setR(int r) {
		if(r<0||r>255)
			throw new ColorException();
		this.r = r;
	}

	/**
	 * @return this green
	 */
	public int getG() {
		return g;
	}

	/**
	 * @param g, set this to green
	 */
	public void setG(int g) {
		if(g<0||g>255)
			throw new ColorException();
		this.g = g;
	}

	/**
	 * @return this blue
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b set this to blue
	 */
	public void setB(int b) {
		if(b<0||b>255)
			throw new ColorException();
		this.b = b;
	}

	/**
	 * Set Color method
	 * @param a, red
	 * @param b, blue
	 * @param c, grenn
	 */
	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}
	/**
	 * Empty constructor
	 */
	public SimpleColor() {}
	
	/**
	 * RGB constructor
	 * @param r, red
	 * @param g, green
	 * @param b, blue
	 */
	public SimpleColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
	/**
	 * Copy constructor
	 * @param b, copy other to this
	 */
	public SimpleColor(SimpleColor b) {
		this(b.r,b.g,b.b);
	}
	
	/**
	 * Overrides toString
	 * @return specific string for this class
	 */
	@Override
	public String toString(){
		return "Red: "+this.getR()+" Green: "+this.getG()+" Blue: "+this.getB();
	}
	
	/**
	 * Equals method
	 * @param other, what to compare this to
	 * @return true if all elements are equivalent
	 */
	public boolean equals(SimpleColor other){
		if(this.getR() == other.getR() && this.getG() == other.getG() && this.getB() == other.getB())
			return true;
		else 
			return false;
	}
	
}
