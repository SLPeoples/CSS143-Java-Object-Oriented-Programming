import java.awt.Color;
import java.awt.Graphics;
/**
 * @author Samuel L. Peoples, 1527650
 * Rectangle constructor
 *
 */
public class Rectangle extends Shape{
	
		private int x,y,width,height;
		private SimpleColor myColor;

		/**
		 * Constructs without color
		 * @param x, this x
		 * @param y, this y
		 * @param width, this width
		 * @param height, this height
		 */
		public Rectangle(int x, int y, int width, int height){
			super(x,y);
			this.width = width;
			this.height = height;
		}
		
		/**
		 * Constructs with color
		 * @param x, this x
		 * @param y, this y
		 * @param width, this width
		 * @param height, this height
		 * @param color, this color
		 */
		public Rectangle(int x, int y, int width,int height, SimpleColor color){
			super(x,y);
			this.width = width;
			this.height = height;
			this.myColor = color;
		}
		
		/**
		 * @return this area
		 */
		@Override
		public double getArea(){
			return this.width*this.height;
		}
		
		/**
		 * Draws the shape
		 */
		public void draw(Graphics g){
			g.setColor( Color.ORANGE );
			g.drawRect(this.x, this.y, this.width, this.height);
			
		}

}
