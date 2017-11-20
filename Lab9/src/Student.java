import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Student implements Serializable {
	private double GPA;
	private String name;
	
	public Student(String n, double gpa) {
		name = n;
		GPA = gpa;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObjectToFile();
		Student a = readObjectFromFile();
		
		if(a != null) {
			System.out.println(a.toString());
		}
	}

	private static Student readObjectFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));
		Student one = (Student) is.readObject();
	
		is.close();
		
		return one;
	}

	private static void writeObjectToFile() throws FileNotFoundException, IOException {
		Student nguyen = new Student("Nguyen", 3.5);

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));
		os.writeObject(nguyen);
			
		os.close();		
	}

}
