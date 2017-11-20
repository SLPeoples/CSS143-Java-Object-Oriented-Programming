import java.util.ArrayList;

/**
 * @author Samuel L. Peoples, 1527650
 * Employee Driver
 *
 */
public class EmployeeDriver {
	
	
	public static void main(String[] args) {
		Accountant emp1 = new Accountant( "Rick", 123456789);
		//this next employee makes a bit more than Rick
		Accountant emp2 = new Accountant( "Tim", 55555555,10000);
		//and lets make an hourly worker
		HourlyWorker emp3 = new HourlyWorker( "Jim", 11111111);
		//then a salaried worker
		SalariedWorker emp4 = new SalariedWorker( "Jane", 222222222, 5000);
		HourlyWorker emp5 = new HourlyWorker( "Joe", 11111111,20);
		PermanentHire emp6 = new PermanentHire("Mike",1111112);
		PermanentHire emp7 = new PermanentHire("Lucy",1111112, 75);
		PermanentHire emp8 = new PermanentHire(emp6);
		Consultant emp9 = new Consultant("Maria", 1111113);
		Consultant emp10 = new Consultant("Hailey", 1111114, 6);
		Consultant emp11 = new Consultant(emp9);
		
		//todo: Build some PermanentHire and Consultant objects here
		//and add them to the ArrayList below
		
		//and build a set of workers, all of which are employees
		ArrayList<Employee> myEmployees = new ArrayList<Employee>();
		
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		myEmployees.add(emp4);
		myEmployees.add(emp5);
		myEmployees.add(emp6);
		myEmployees.add(emp7);
		myEmployees.add(emp8);
		myEmployees.add(emp9);
		myEmployees.add(emp10);
		myEmployees.add(emp11);
		/*
		 * ColorWithAlpha a = new ColorWithAlpha(1,1,1,1);
		 * myEmployees.add(a);
		 * ERROR, can't add a non Employee object
		 * 
		 */
		
		//todo: add a sixth and seventh employee to this list that you create
		
		
		//this code doesn't need to change, even if you add 10 new employee classes and 
		//add 102 new employees - this is an example of generic code that can be written 
		//when inheritance hierarchies are in use
		for( int i = 0; i < myEmployees.size(); i++) {
			Employee current = myEmployees.get(i);
			System.out.println( current.toString() + " Social: "+current.getSocial());
		}
		
		
		
	}
}
