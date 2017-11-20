/**
 * @author Samuel L. Peoples, 1527650
 * This class manipluates and tests 2d data points, and determines their relationship to other 2d objects
 *
 */
public class Point2D {
	private int x;
	private int y;
	
	/**
	 * Driver for the class with tests
	 */
	public static void main(String[] args) {
		Point2D a = new Point2D();
		a.setX(5);
		a.setY(2);
		System.out.println("Point at (" + a.getX() + ", " + a.getY() +")");
		a.translate(-1,-1);
		System.out.println("Point at (" + a.getX() + ", " + a.getY() +")");
		a.resetToOrigin();
		System.out.println("Point at (" + a.getX() + ", " + a.getY() +")");
		Point2D b = new Point2D();
		Point2D c = new Point2D();
		System.out.println(b.toString());
		System.out.println(c);  //Question: why don’t I need c.toString()here?
		//Java automatically uses the most relevant toString method instead of printing the address.
		//Java automatically calls toString for primitive types.
		System.out.println("Are b and c equal: " + b.equals(c));
		b.translate(-1, 4);
		c.translate(1, -4);
		System.out.println("Point at (" + b.getX() + ", " + b.getY() +")");
		System.out.println("Point at (" + c.getX() + ", " + c.getY() +")");
		System.out.println("Are b and c equal: " + b.equals(c));
		b.resetToOrigin();
		c.resetToOrigin();
		System.out.println("Point at (" + b.getX() + ", " + b.getY() +")");
		System.out.println("Point at (" + c.getX() + ", " + c.getY() +")");
		System.out.println("Are b and c equal: " + b.equals(c));
	}
	
	/**
	 * @param nX int that sets the current x value for the object
	 */
	public void setX(int nX){
		this.x = nX;
	}
	
	/**
	 * @param nY int that sets the current y value for the object
	 */
	public void setY(int nY){
		this.y = nY;
	}
	
	/**
	 * @return the current object's x value
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * @return the current object's y value
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 *  sets x and y to zero for the current object.
	 */
	public void resetToOrigin() { 
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * @param dx adds dx to the x value of the current object
	 * @param dy adds dy to the y value of the current object
	 */
	public void translate(int dx, int dy) { 
		x += dx;
		y += dy;
	}

	@Override//Question: what does @Override do?
	//It prevents the inherited toString from working and forces  the use of this method.
	/**
	 * Returns the String of (x,y).
	 */
	public String toString() {
		return "("+x+","+y+")";  //returns a string representation of the point
	}
	
	/**
	 * @param that, compares current object to another object
	 * @return true if this equals that.
	 */
	public boolean equals(Point2D that) {//compare this vs that
		if (this.x== that.x && this.y==that.y)
			return true;//returns true if this is equal to that; don’t just use "this == that"
		else
			return false;
	}
}
