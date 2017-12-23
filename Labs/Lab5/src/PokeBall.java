import java.awt.Color;
import java.awt.Graphics;
/**
 * @author Samuel L. Peoples, 1527650
 * Constructor for PokeBall
 */
public class PokeBall extends Circle {
	private Color myColor;
	/**
	 * Constructs without color
	 * @param x this x
	 * @param y this y
	 * @param r this radius
	 */
	public PokeBall(int x, int y, int r){
		super(x,y,r);
		this.myColor = Color.RED;
	}
	
	/**
	 * Constructs with color
	 * @param x this x
	 * @param y this y
	 * @param r this radius
	 * @param a this color
	 */
	public PokeBall(int x, int y, int r, Color a){
		super(x,y,r);
		this.myColor = a;
	}
	
	/**
	 * draws the PokeBall, with the color of choice shading the upper region.
	 */
	public void draw(Graphics g){
		g.setColor(this.myColor);
		g.fillArc(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2, 180, -180);
		g.setColor(Color.WHITE);
		g.fillArc(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2, 180, 180);
		g.setColor(Color.BLACK);
		g.drawArc(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2, 90, 360);
		g.drawLine(this.getX(), this.getY()+this.getRadius(), this.getX()+this.getRadius()*2, this.getY()+this.getRadius());
		g.drawOval(this.getX()+this.getRadius()-this.getRadius()/8, this.getY()+this.getRadius()-this.getRadius()/8, this.getRadius()/4, this.getRadius()/4);
		g.setColor(Color.WHITE);
		g.fillOval(this.getX()+this.getRadius()-this.getRadius()/8, this.getY()+this.getRadius()-this.getRadius()/8, this.getRadius()/4, this.getRadius()/4);
		g.setColor(Color.BLACK);
		g.fillOval(this.getX()+this.getRadius()-this.getRadius()/16, this.getY()+this.getRadius()-this.getRadius()/16, this.getRadius()/8, this.getRadius()/8);
	}
	
	/**
	 * @return this color
	 */
	@Override
	public Color getColor(){
		return this.myColor;
	}
	
	
	/**
	 * Tests the PokeBall objects for area and radius expected values.
	 * @param args, null
	 */
	public static void main( String args[] ) {
		PokeBall pokeBall1 = new PokeBall(1,1,2,Color.BLUE);
		PokeBall pokeBall2 = new PokeBall(3,4,4);
		PokeBall pokeBall3 = new PokeBall(3,4,4);
		PokeBall pokeBall4 = new PokeBall(3,4,8);
		System.out.println("PokeBall 1: "+pokeBall1.toString());
		System.out.println("PokeBall 2: "+pokeBall2.toString());
		System.out.println("PokeBall 3: "+pokeBall3.toString());
		System.out.println("PokeBall 4: "+pokeBall4.toString());
		System.out.println("PokeBall1 = PokeBall2? (Should be false): "+pokeBall1.equals(pokeBall2));
		System.out.println("PokeBall1 = PokeBall3? (Should be false): "+pokeBall1.equals(pokeBall3));
		System.out.println("PokeBall2 = PokeBall3? (Should be true): "+pokeBall2.equals(pokeBall3));
		System.out.println("PokeBall3 = PokeBall4? (Should be false): "+pokeBall3.equals(pokeBall4));	
	}
	
}
