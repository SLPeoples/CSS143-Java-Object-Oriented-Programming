import javax.swing.JFrame;
/**
 * @author Samuel L. Peoples, 1527650
 * Opens JFrame window
 */
public class Window extends JFrame {

	/**
	 * Opens a window instance
	 */
	public Window() {
	      setSize(400,400);
	      setVisible(true);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	  
	/**
	 * tests the window
	 * @param args
	 */
	public static void main (String[] args) {
	       //Window a = new Window();
	    }
   
}

