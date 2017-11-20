import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

//  InterfaceDriver
//  CSS162
//  By Rob Nash
//

public class InterfaceDriver {

    //comment and uncomment the demo functions in main to test
    public static void main(String[] args) {
        comparableDemo();
        cloneableDemo();
        serializableDemo();
        actionListenerDemo();
    }
    
    public static void actionListenerDemo() {
        Application a = new Application();
        
    }
    
    public static void serializableDemo() {
        writeObjectsToFile();
        readObjectsFromFile();
    }
    
    private static void readObjectsFromFile() {
        try {
            //ObjectInputStream is = new ObjectInputStream( new FileInputStream("object.dat"));
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));
            
            StudentClass a = (StudentClass)is.readObject();  //cast is required since object is returned
            StudentClass b = (StudentClass)is.readObject();
            
            System.out.println("From file : " + a);
            System.out.println("From file : " + b);
            
            is.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Bad OOS");
        }
    }
    
    private static void writeObjectsToFile() {
        try {
            //ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("object.dat"));
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));
            StudentClass a = new StudentClass("FileIO1", 3.0);
            StudentClass b = new StudentClass("FileIO2", 4.0);
        
            os.writeObject(a);
            os.writeObject(b);
            os.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Bad OOS");
        }
    
        
    }

    public static void comparableDemo() {
        StudentClass a = new StudentClass("Rob", 3.0);
        StudentClass b = new StudentClass("Bill", 4.0);
        StudentClass c = new StudentClass("Mary", 4.0);
        
        
        System.out.println( " a compareTo b :" + a.compareTo(b));
        System.out.println( " b compareTo a :" + b.compareTo(a));
        System.out.println( " b compareTo c :" + b.compareTo(c));
    }
    
    
    public static void cloneableDemo() {
        StudentClass a = new StudentClass("Evan", 3.0);
        StudentClass c = (StudentClass)a.clone();
        
        System.out.println(a);
        System.out.println(c);
        
        System.out.println("Changing object a");
        a.setName("Boo");
        a.setGPA(3.5);
        
        System.out.println(" new name: " + a.getName());
        System.out.println(" new GPA: " + a.getGPA());
        System.out.println(" The object a: " + a);  
        System.out.println(" The object c: " + c);  
    }
    
    
}
