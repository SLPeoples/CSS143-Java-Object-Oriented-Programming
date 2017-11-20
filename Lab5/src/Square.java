import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples, 1527650
 * Square constructor
 */
public class Square extends Shape{
	private int sideLength;
	private Color myColor = Color.BLACK;
	/**
	 * constructs without color
	 * @param x this x
	 * @param y this y
	 * @param sideLength this sidelength
	 */
	public Square(int x, int y, int sideLength){
		super(x,y);
		this.sideLength = sideLength;
	}
	
	/**
	 * Constructs with color
	 * @param x this x
	 * @param y this y
	 * @param sideLength this sidelength
	 * @param color this color
	 */
	public Square(int x, int y, int sideLength, Color color){
		super(x,y);
		this.sideLength = sideLength;
		this.myColor = color;
	}
	
	/**
	 * @return this area
	 */
	@Override
	public double getArea(){
		return this.sideLength*this.sideLength;
	}
	
	/**
	 * @return this side length
	 */
	public int getSideLength(){
		return this.sideLength;
	}
	
	/**
	 * draws the shape
	 */
	public void draw(Graphics g){
		g.setColor( Color.BLACK );
		g.drawRect(this.getX(), this.getY(), this.getSideLength(), this.getSideLength());
		g.setColor( this.getColor() );
		g.fillRect(this.getX(), this.getY(), this.getSideLength(), this.getSideLength());
	}
	
	/**
	 * @return this color
	 */
	public Color getColor(){
		return this.myColor;
	}
	
	/**
	 * @param other what to compare this square to
	 * @return true if all elements are equivalent
	 */
	public boolean equals(Square other){
		if(this.getX() == other.getX()&&
				this.getY() == other.getY()&&
				this.getSideLength() == other.getSideLength()&&
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
		return "X: "+this.getX()+", Y: "+this.getY()+", Side Length: "+this.getSideLength()+", Area: "+this.getArea()+", Color: "+this.getColor();
	}
	
	/**
	 * Tests the Square objects for area and SideLength expected values.
	 * @param args, null
	 */
	public static void main( String args[] ) {
		Square square1 = new Square(1,1,2,Color.BLUE);
		Square square2 = new Square(3,4,4);
		Square square3 = new Square(3,4,4);
		Square square4 = new Square(3,4,8);
		System.out.println("Square 1: "+square1.toString());
		System.out.println("Square 2: "+square2.toString());
		System.out.println("Square 3: "+square3.toString());
		System.out.println("Square 4: "+square4.toString());
		System.out.println("Square1 = Square2? (Should be false): "+square1.equals(square2));
		System.out.println("Square1 = Square3? (Should be false): "+square1.equals(square3));
		System.out.println("Square2 = Square3? (Should be true): "+square2.equals(square3));
		System.out.println("Square3 = Square4? (Should be false): "+square3.equals(square4));	
	}
}
