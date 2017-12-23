import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples
 * Shape object constructor
 */
abstract class Shape extends Object {
	private int x = 0;
	private int y = 0;
	private Color myColor;
	
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
}