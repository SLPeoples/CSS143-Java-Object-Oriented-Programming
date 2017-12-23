
/**
 * @author Samuel L. Peoples
 * This Class constructs squares and "draws" them, it also calculates area.
 */
public class Square {
	private int x=0;
	private int y=0;
	private double sideLength=0;
	private String shape = "[]";
	
	/**
	 * empty Main.
	 */
	public static void main(String[] args) {}
	
	/**
	 * Empty constructor
	 */
	public Square() {}
	
	/**
	 * constructs a square without a side length
	 * @param nx 
	 * @param ny
	 */
	public Square(int nx, int ny) {
		this.x = nx;
		this.y = ny;
	}

	/**
	 * constructs a square with points and side length
	 * @param nx
	 * @param ny
	 * @param sideLength
	 */
	public Square(int nx, int ny, int sideLength) {
		this.x = nx;
		this.y = ny;
		this.sideLength = sideLength;
	}
	
	/**
	 * "Draws" the square with the string representation.
	 */
	public void draw() { 
		System.out.println(this.toString());
	}
	
	/**
	 * @return x, current Square's x.
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * @return y, current Square's y.
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * @return sideLength, current Square's side length.
	 */
	public double getSideLength(){
		return this.sideLength;
	}
	
	/**
	 * @return area, sidelength^2
	 */
	public double getArea(){
		return this.sideLength*this.sideLength;
	}
	
	/**
	 * @param nx, sets x to nx
	 */
	public void setX(int nx){
		this.x = nx;
	}
	
	/**
	 * @param ny, sets y to ny
	 */
	public void setY(int ny){
		this.y = ny;
	}
	
	/**
	 * @param sl, sets sideLength to sl
	 */
	public void setSideLength(int sl){
		this.sideLength = sl;
	}
	
	/* 
	 * returns string representation defined by shape.
	 */
	@Override
	public String toString() {
		return shape;
	}
	
	/**
	 * @param that, another Square
	 * @return boolean whether points and side length are equivalent
	 */
	public boolean equals(Square that) {
		if(this.x == that.x && this.y == that.y && this.sideLength == that.sideLength)
			return true;
		else
			return false;
	}
}
