import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The Application Class is both a Window and an Event Handler (or will be)
 *   Find the TODOs and implement the ActionListener interface below
 *   
 *   @author Samuel L. Peoples
 *   Application class 
 */

public class Application extends JFrame implements ActionListener {
	JButton myButton = new JButton( "Hello World" );
	/**
	 * Application constructor
	 */
	public  Application() {
		super("Window");
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add the button to the display
		this.add(myButton);
		myButton.addActionListener(this);
	}
	
	//A one line main
	public static void main(String[] args) {
		JFrame app = new Application();
	}

	/**
	 * changes the button text to indicate an action performed
	 * @param evnt
	 */
	@Override
	public void actionPerformed(ActionEvent evnt) {
		Application a = new Application();
		a.myButton.setText("Button Pressed");
	}

}
