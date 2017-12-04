import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples
 * Shape object constructor
 * previously tested
 */
abstract class Shape extends Object implements Cloneable{
	private int x = 0;
	private int y = 0;
	private Color myColor = Color.BLACK;
	
	/**
	 * Constructor for shape objects
	 * @param x, this x
	 * @param y, this y
	 */
	public Shape( int x, int y ) {
		this.x=x;
		this.y=y;
	}

	/**
	 * Constructor for shape objects
	 * @param x, this x
	 * @param y, this y
	 */
	public Shape( int x, int y, Color myColor ) {
		this.x=x;
		this.y=y;
		this.myColor = myColor;
	}
	
	/**
	 * @return -1, no area for Superclass
	 */
	public double getArea(){ 
		return -1; 
	}
	
	/**
	 * empty draw
	 * @param g, graphics
	 */
	public void draw( Graphics g ){}
	
	/**
	 * @return this x
	 */
	public int getX() { 
		return this.x; 
	}
	
	/**
	 * @return this y
	 */
	public int getY() { 
		return this.y; 
	}
	
	/**Clones the shape, calls subclass
	 * @see java.lang.Object#clone()
	 */
	public Shape clone(){
		return this.clone();
	}
	
	/**
	 * @return blank, calls subclass nameString
	 * Will return the name of the shape
	 */
	public String nameString(){
		return "";
	}

}