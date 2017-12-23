import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples, 1527650
 * Constructor for circle
 */
public class Circle extends Shape {
	private int radius;
	private Color myColor = Color.BLACK;
	/**
	 * Constructs without color
	 * @param x this x
	 * @param y this y
	 * @param r this radius
	 */
	public Circle(int x, int y, int r){
		super(x,y);
		this.radius = r;
	}
	
	/**
	 * Constructs with color
	 * @param x this x
	 * @param y this y
	 * @param r this radius
	 * @param a this color
	 */
	public Circle(int x, int y, int r, Color a){
		super(x,y);
		this.radius = r;
		this.myColor = a;
	}
	
	/**
	 * @return this area
	 */
	@Override
	public double getArea(){
		return Math.PI*this.radius*this.radius;
	}
	
	/**
	 * @return this radius
	 */
	public int getRadius(){
		return this.radius;
	}
	
	/**
	 * draws the shape
	 */
	public void draw(Graphics g){
		g.setColor( Color.BLACK);
		g.drawOval(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
		g.setColor(this.getColor());
		g.fillOval(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
	}
	/**
	 * @return this color
	 */
	public Color getColor(){
		return this.myColor;
	}
	
	/**
	 * @param other what to compare this Circle to
	 * @return true if all elements are equivalent
	 */
	public boolean equals(Circle other){
		if(this.getX() == other.getX()&&
				this.getY() == other.getY()&&
				this.getRadius() == other.getRadius()&&
				this.getColor() == other.getColor())
			return true;
		else
			return false;
	}
	
	/**
	 * toString
	 * @return appropriate data in the form of string
	 */
	@Override
	public String toString(){
		return "X: "+this.getX()+", Y: "+this.getY()+", Radius: "+this.getRadius()+", Area: "+this.getArea()+", Color: "+this.getColor();
	}
	
	/**
	 * Tests the Circle objects for area and Radius expected values.
	 * @param args, null
	 */
	public static void main( String args[] ) {
		Circle circle1 = new Circle(1,1,2,Color.BLUE);
		Circle circle2 = new Circle(3,4,4);
		Circle circle3 = new Circle(3,4,4);
		Circle circle4 = new Circle(3,4,8);
		System.out.println("Circle 1: "+circle1.toString());
		System.out.println("Circle 2: "+circle2.toString());
		System.out.println("Circle 3: "+circle3.toString());
		System.out.println("Circle 4: "+circle4.toString());
		System.out.println("Circle1 = Circle2? (Should be false): "+circle1.equals(circle2));
		System.out.println("Circle1 = Circle3? (Should be false): "+circle1.equals(circle3));
		System.out.println("Circle2 = Circle3? (Should be true): "+circle2.equals(circle3));
		System.out.println("Circle3 = Circle4? (Should be false): "+circle3.equals(circle4));	
	}
}
