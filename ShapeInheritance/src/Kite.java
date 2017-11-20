import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples, 1527650
 * Constructor for Kite; Length always longer than width
*/
public class Kite extends Shape {
	private int length, width;
	private Color myColor = Color.BLACK;
	/**
	 * Constructs without color
	 * @param x this x
	 * @param y this y
	 * @param l this length
	 * @param w this width
	 */
	public Kite(int x, int y, int l, int w){
		super(x,y);
		if(l>w){
			this.length = l;
			this.width = w;
		}
		else{
			this.length = w;
			this.width = l;
		}
	}
	
	/**
	 * Constructs with color
	 * @param x this x
	 * @param y this y
	 * @param l this length
	 * @param w this width
	 * @param a this color
	 */
	public Kite(int x, int y, int l, int w,Color a){
		super(x,y);
		if(l>w){
			this.length = l;
			this.width = w;
		}
		else{
			this.length = w;
			this.width = l;
		}
		this.myColor = a;
	}
	
	/**
	 * @return this area (Area for Kite)
	 */
	@Override
	public double getArea(){
		return .5*this.width*this.length;
	}
	
	/**
	 * @return this length
	 */
	public int getLength(){
		return this.length;
	}
	
	/**
	 * @return this width
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @return this color
	 */
	public Color getColor(){
		return this.myColor;
	}
	
	/**
	 * @param other, compare to this
	 * @return true if all elements of this are equivalent to other
	 */
	public boolean equals(Kite other){
		if(this.getX() == other.getX()&&
				this.getY() == other.getY()&&
				this.getWidth() == other.getWidth()&&
				this.getLength() == other.getLength()&&
				this.getColor() == other.getColor())
			return true;
		else
			return false;
			
	}
	
	/**
	 * draws the shape, It will cross the length over the width and connect the endpoints.
	 */
	public void draw(Graphics g){
		g.setColor(this.getColor());
		g.drawLine(this.getX(), this.getY()+this.getWidth(), this.getX()+this.getWidth()/2, this.getY()+this.getWidth()/2+this.getWidth());
		g.drawLine(this.getX(), this.getY()+this.getWidth(), this.getX()+this.getWidth()/2, this.getY()-this.getWidth()/2+this.getWidth());
		g.drawLine(this.getX()+this.getWidth()/2, this.getY()+this.getWidth()/2+this.getWidth() , this.getX()+this.getLength(), this.getY()+this.getWidth());
		g.drawLine(this.getX()+this.getWidth()/2, this.getY()-this.getWidth()/2+this.getWidth() , this.getX()+this.getLength(), this.getY()+this.getWidth());
		g.drawLine(this.getX(), this.getY()+this.getWidth(), this.getX()+this.getLength(), this.getY()+this.getWidth());
		g.drawLine(this.getX()+this.getWidth()/2, this.getY()+this.getWidth()/2+this.getWidth(), this.getX()+this.getWidth()/2, this.getY()-this.getWidth()/2+this.getWidth());
	}
	
	/**
	 * toString
	 * @return appropriate data in the form of string
	 */
	@Override
	public String toString(){
		return "X: "+this.getX()+", Y: "+this.getY()+", Width: "+this.getWidth()+", Length: "+this.getLength()+", Area: "+this.getArea()+", Color: "+this.getColor();
	}
	
	/**
	 * Tests the Kite objects for length, width control, and expected values.
	 * @param args, null
	 */
	public static void main( String args[] ) {
		Kite kite1 = new Kite(1,1,2,4,Color.BLUE);
		Kite kite2 = new Kite(3,4,8,4);
		Kite kite3 = new Kite(3,4,4,8);
		Kite kite4 = new Kite(3,4,4,8);
		System.out.println("Kite 1: "+kite1.toString());
		System.out.println("Kite 2: "+kite2.toString());
		System.out.println("Kite 3: "+kite3.toString());
		System.out.println("Kite 4: "+kite4.toString());
		System.out.println("Kite1 = Kite2? (Should be false): "+kite1.equals(kite2));
		System.out.println("Kite1 = Kite3? (Should be false): "+kite1.equals(kite3));
		System.out.println("Kite2 = Kite3? (Should be true): "+kite2.equals(kite3));
		System.out.println("Kite3 = Kite4? (Should be true): "+kite3.equals(kite4));	
	}
	
	
}
