import java.awt.*;

/**
 * @author Samuel L. Peoples, 1527650
 * Shape constructor
 *
 */
public class Shape {
	//Check that x,y are nonnegative integers
	//Verify that color is valid
	private int x,y;
	private Color color;
	/**
	 * General constructor
	 * @param i, sets i to x
	 * @param j, sets j to y
	 * @param k, sets k to color.
	 */
	public Shape(int i, int j, Color k) {
		this.x = i;
		this.y = j;
		this.color = k;
	}

	/**
	 * Empty constructor
	 */
	public Shape() {
	}

	/**
	 * Copies b to this shape
	 * @param b, shape to be copied from
	 */
	public Shape(Shape b) {
		this.setX(b.getX());
		this.setY(b.getY());
		this.setColor(b.getColor());
	}

	/**
	 * setter for x
	 * @param i, set to this.x
	 */
	public void setX(int i) {	
		this.x = i;
	}

	/**
	 * Setter for y
	 * @param j, set to this.y
	 */
	public void setY(int j) {
		this.y = j;
	}
	
	/**
	 * setter for color
	 * @param k, Color k
	 */
	public void setColor(Color k){
		this.color = k;
	}
	
	/**
	 * Gets x coordinate
	 * @return x
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * Gets y coordinate
	 * @return y
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * gets color
	 * @return color
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Gets area
	 * @return -1 for now
	 */
	public double getArea(){
		return -1;
	}
	
	/**
	 * Empty for now
	 * @param g
	 */
	public void draw(Graphics g){
	}
	
	/** 
	 * Overrides inherited toString
	 */
	public String toString(){
		return "Shape ("+this.x+","+this.y+"), color: "+this.color+", and area: "+this.getArea();
	}

}
