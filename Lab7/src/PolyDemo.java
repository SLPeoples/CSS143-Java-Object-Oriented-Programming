import javax.swing.*;
import java.awt.*;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * Author: Rob Nash
/**
 * @author Samuel L. Peoples, 1527650
 */
class PolyDemo extends JFrame {
	//moved for easier control
	private int numShapes = 1;
	private Shape[] myShapes = new Shape[numShapes];
	/**
	 * Constructs the window
	 */
	public PolyDemo() {
		getContentPane().add( new PolyDemoPanel() );
		//just some windowing stuff that must happen for all Frames
		setSize( 700,700 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	/**
	 * Creates a window instance
	 * @param args
	 */
	public static void main( String args[] ) {
		PolyDemo myApp = new PolyDemo();
	}

	/**
	 * Facilitates drawing the shapes in the same window
	 */
	public class PolyDemoPanel extends JPanel {		
		/**
		 * Constructor for the myShapes array
		 */
		public PolyDemoPanel() {
			for( int i = 0; i < numShapes; i++ ) {
				myShapes[i] =  getRandShape();
			}
		}
		
		/**
		 * Draws the shapes overlaying one another.
		 */
		public void paint( Graphics g ) {
			super.paint(g);  //don't remove - required for GUI widgets to draw correctly
			
			for( int i = 0; i < myShapes.length; i++ ){
				myShapes[i].draw( g );
				myShapes[i].toString();
			}	
		}
			
		/**
		 * @return rand int
		 */
		public int getRandInt() {
			return ( (int) ( Math.random() * 200 ) );	
		}
		
		/**
		 * Added Circle, Square, Pokeball, and Kite
		 * @return retval
		 */
		public Shape getRandShape() {
			Shape retVal = null;
			final int x = getRandInt();
			final int y = getRandInt();
			final int r = getRandInt();
			final int w = getRandInt();
			switch( ( int )(Math.random() * 4) ) {
			
				case 0: 	retVal = new FractalFlake(x,y,10,5);
							break;
				case 1: 	retVal = new FractalFlake(x,y,20,8);
							break;
				case 2: 	retVal = new FractalFlake(x,y,30,10);
							break;
				case 3: 	retVal = new FractalFlake(x,y,40,12);
							break;				
			}
			return retVal;
		}
		/**
		 * @return retval, random choice between RGBY
		 */
		public Color getRandColor(){
			Color retVal = null;
			switch( ( int )(Math.random() * 4) ) {
			
			case 0: 	retVal = Color.BLUE;
						break;
			case 1: 	retVal = Color.GREEN;
						break;
			case 2: 	retVal = Color.RED;
						break;
			case 3: 	retVal = Color.YELLOW;
						break;				
		}
		return retVal;
		}
	}	
}











