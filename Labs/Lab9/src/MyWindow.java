import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * @author Samuel L. Peoples
 * MyWindow class, interacts with mouse click
 */
public class MyWindow extends JFrame implements MouseListener{
	ArrayList<Student> students = new ArrayList<Student>();
	/**
	 * Constructs the window
	 */
	public MyWindow() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(this);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * Adds students to a list of students, based on location clicked. Lists students as user clicks
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked: "+e.getX()+", "+e.getY());
		students.add(new Student("x:"+e.getX()+", y:"+e.getY(),(e.getX()*e.getY())/(Math.PI*800)));
		for(Student student:students)
			System.out.println(student);
	}
	
	//A one line main
		public static void main(String[] args) {
			MyWindow app = new MyWindow();
		}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 * no changes
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 * no changes
	 */
	@Override
	public void mouseExited(MouseEvent e) {}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 * no changes
	 */
	@Override
	public void mousePressed(MouseEvent e) {}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 * no changes
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}
}