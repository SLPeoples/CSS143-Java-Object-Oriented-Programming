import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Samuel L. Peoples
 * Lab 7 Fractal Flake
 */
public class FractalFlake extends Shape{
private final int limit;
private final int branch;
private Color myColor;

	/**
	 * Constructs the object
	 * @param x,  x position
	 * @param y,  y position
	 * @param limit, max limit
	 * @param branch, max branches
	 */
	public FractalFlake(int x, int y, int limit, int branch){
		super(x,y);
		this.limit = limit;
		this.branch = branch;
		this.myColor = Color.BLACK;
	}
	
	/** Overloads the draw function
	 */
	@Override
	public void draw(Graphics g) { //a redirect or facade
	draw(g,getX(), getY(),limit);
	}
	
	/**
	 * Draws the branches and fractals
	 * @param g
	 * @param startX, start x position
	 * @param startY, start y position
	 * @param limit, max fractals
	 */
	private void draw(Graphics g, int startX, int startY, int limit) {
		if(limit>= 3) { //base case is depth <3
			for ( int i = 0; i < this.branch; i++ ){
				int x2 = startX + (int) (limit *
						Math.cos( (2 * Math.PI / this.branch) * i ));
				int y2 = startY - (int) (limit *
						Math.sin( (2 * Math.PI / this.branch) * i ));
				g.drawLine( startX, startY, x2, y2 ); //do a branch
				draw(g, x2, y2, limit/3); //recursive call
			}
		}
	}

}
