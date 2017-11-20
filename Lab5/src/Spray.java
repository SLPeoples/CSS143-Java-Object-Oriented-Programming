import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/*
 * Class Spray
 * 
 * Not exactly the most obvious choice, and this has no getArea() implementation!
 * This is so I didn't give away everything to this assignment.  =)
 * 
 * Author: Rob Nash
 */

/**
 * @author Samuel L. Peoples, 1527650
 * No changes made
 *
 */
class Spray extends Shape {
	private final int RADIUS = 20;
	private final int DENSITY = 10;
	
	
	public Spray( int a, int b ) {
		super( a, b); 	//we explicitly call a superclass constructor that takes 2 ints
	}
	
	
	public void draw( Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		final int x = getX();
		final int y = getY();
		
		g2d.setColor( Color.GREEN );
		g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + RADIUS/4, y + RADIUS/4, Color.BLACK, true) );
		
		int xOffset = 0;
		int yOffset = 0;
		for( int i = 0; i < DENSITY; i++) {
			xOffset = (int) (Math.random()*RADIUS);
			yOffset = (int) (Math.random()*RADIUS);
			g2d.draw( new Ellipse2D.Double( x + xOffset, y + yOffset, x + xOffset+3, y + yOffset+3) );
		}
	
	}
	
}