import javax.swing.*;
import java.awt.*;
/**
 * @author Samuel L. Peoples, 1527650
 * Testing Driver for Kite, PokeBall, Circle, Square
 * Uncomment Individually in paint( Graphics g)
 */
class TestingDriver extends JFrame {
	public class TestingPanel extends JPanel {		
		Shape[] myShapes= new Shape[10];
		
		/**
		 * Defining randomly-sized shapes, Kites use four and six to verify that length is always longer than width
		 */
		public TestingPanel() {
			int four = 4*getRandInt();
			int six = 6*getRandInt();
			Circle circle = new Circle(getRandInt(),getRandInt(),getRandInt(), Color.GREEN);
			System.out.println("Circle info: "+circle.toString());
			Square square = new Square(getRandInt(),getRandInt(),getRandInt(), Color.RED);
			System.out.println("Square info: "+square.toString());
			PokeBall poke = new PokeBall(getRandInt(),getRandInt(),getRandInt(), Color.YELLOW);
			Circle test = poke;
			System.out.println("test info: "+test.toString());
			System.out.println("PokeBall info: "+poke.toString());
			Kite kite = new Kite(getRandInt(),getRandInt(),four,six, Color.BLUE);
			System.out.println("Kite info: "+kite.toString());
			Kite kite2 = new Kite(getRandInt(),getRandInt(),six,four, Color.CYAN);
			System.out.println("Kite2: "+kite2.toString());
			Circle circleNC = new Circle(getRandInt(),getRandInt(),getRandInt());
			System.out.println("CircleNC: "+circleNC.toString());
			Square squareNC = new Square(getRandInt(),getRandInt(),getRandInt());
			System.out.println("SquareNC: "+squareNC.toString());
			PokeBall pokeNC = new PokeBall(getRandInt(),getRandInt(),getRandInt());
			System.out.println("PokeBallNC: "+pokeNC.toString());
			Kite kiteNC = new Kite(getRandInt(),getRandInt(),four,six);
			System.out.println("KiteNC info: "+kiteNC.toString());
			Kite kite2NC = new Kite(getRandInt(),getRandInt(),six,four);
			System.out.println("Kite2NC info: "+kite2NC.toString());
			
			myShapes[0] = circle;
			myShapes[1] = square;
			myShapes[2] = poke;
			myShapes[3] = kite;
			myShapes[4] = kite2;
			myShapes[5] = circleNC;
			myShapes[6] = squareNC;
			myShapes[7] = pokeNC;
			myShapes[8] = kiteNC;
			myShapes[9] = kite2NC;
		}
	
		/**
		 * draws the uncommented shape.
		 * @param g, graphics
		 */
		public void paint( Graphics g ) {
			super.paint(g);  //don't remove - required for GUI widgets to draw correctly
			/************************
			 * Late Binding Demo
			 ************************/
			//Uncomment individually to view shapes, RESIZING WINDOW IS NECESSARY
			
		//Green Circle
			//myShapes[0].draw(g);
		//Red Square
			//myShapes[1].draw(g);
		//Yellow PokeBall
			//myShapes[2].draw(g);
		//Blue Kite (4:6)
			//myShapes[3].draw(g);
		//Cyan Kite (6:4)
			//myShapes[4].draw(g);
		//Black Circle
			//myShapes[5].draw(g);
		//Black Square
			//myShapes[6].draw(g);
		//Red PokeBall
			myShapes[7].draw(g);
		//Black Kite (4:6)
			//myShapes[8].draw(g);
		//Black Kite (6:4)
			//myShapes[9].draw(g);
		}
	}
	/**
	 * Opens a new window instance
	 * @param args
	 */
	public static void main( String args[] ) {
		TestingDriver myApp = new TestingDriver();
	}
	/**
	 * Opens a window instance
	 */
	public TestingDriver() {
		getContentPane().add( new TestingPanel() );
		setSize( 700,700 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	/**
	 * @return random int(size controlled)
	 */
	public int getRandInt() {
		return ( (int) ( Math.random() * 200 ) );	
	}
	
	
}











