import java.io.IOException;
import java.util.Iterator;

/**
 * @author Samuel L. Peoples, 1527650
 * This driver DOES NOT re-test previously submitted code.
 * Extends testing on Date, Money, and Bill
 * Minor changes made to original code, with addition of 
 * compareTo, Cloneable. serializable, and iterable implementations
 * This driver runs tests on these additions.
 */
public class Driver {
	public static void main(String args[]){
		dateTest();
		moneyTest();
		billTest();
	}
	/**
	 * Tests the date changes
	 * Ensures compareTo is correctly configured
	 * Ensures that cloned objects are valid.
	 * Verifies that objects can be serialized and deserialized.
	 */
	public static void dateTest(){
		//Tests are conducted on compareTo, clone, and serializable
		Money money = new Money();
		Date earlyDate = new Date(1,1,2017);
		Date earlyDate2 = new Date(1,2,2017);
		Date earlyDate3 = new Date(2,1,2017);
		Date lateDate = new Date(1,1,2018);
		Date lateDate2 = new Date(1,2,2018);
		Date lateDate3 = new Date(2,1,2018);
		Date earlyDate2Clone = earlyDate2.clone();
		Date earlyDateClone = earlyDate.clone();
		
		//System.out.println(earlyDate.compareTo(money)); // Won't work. Doesn't Compile.
		
		System.out.println("***************Date*********************");
		if(		earlyDate.compareTo(earlyDate) == 0 &&
				earlyDate.compareTo(earlyDate2) == -1 &&
				earlyDate.compareTo(earlyDate3) == -1 &&
				earlyDate.compareTo(lateDate) == -1 &&
				earlyDate.compareTo(lateDate2) == -1 &&
				earlyDate.compareTo(lateDate3) == -1 &&
				lateDate.compareTo(earlyDate) == 1 &&
				lateDate.compareTo(earlyDate2) == 1 &&
				lateDate.compareTo(earlyDate3) == 1 &&
				lateDate.compareTo(lateDate) == 0 &&
				lateDate.compareTo(lateDate2) == -1 &&
				lateDate.compareTo(lateDate3) == -1 &&
				lateDate3.compareTo(earlyDate) == 1 &&
				lateDate3.compareTo(earlyDate2) == 1 &&
				lateDate3.compareTo(earlyDate3) == 1 &&
				lateDate3.compareTo(lateDate) == 1 &&
				lateDate3.compareTo(lateDate2) == 1 &&
				lateDate3.compareTo(lateDate3) == 0 &&
				earlyDateClone.compareTo(earlyDate) == 0 &&
				earlyDateClone.compareTo(earlyDate2) == -1 &&
				earlyDateClone.compareTo(earlyDate3) == -1 &&
				earlyDateClone.compareTo(lateDate) == -1 &&
				earlyDateClone.compareTo(lateDate2) == -1 &&
				earlyDateClone.compareTo(lateDate3) == -1 &&
				earlyDate2Clone.compareTo(earlyDate) == 1 &&
				earlyDate2Clone.compareTo(earlyDate2) == 0 &&
				earlyDate2Clone.compareTo(earlyDate3) == -1 &&
				earlyDate2Clone.compareTo(lateDate) == -1 &&
				earlyDate2Clone.compareTo(lateDate2) == -1 &&
				earlyDate2Clone.compareTo(lateDate3) == -1
			)
			System.out.println("SUCCESS");
		else
			System.out.println("FAIL");
		try{
			earlyDate.writeObject();
			earlyDate2.writeObject();
			earlyDate.readObject();
			earlyDate2.readObject();
		}
		catch(IOException e){}
		catch(ClassNotFoundException e){}
	}
	/**
	 * Tests the money changes
	 * Ensures compareTo is correctly configured
	 * Ensures that cloned objects are valid.
	 * Verifies that objects can be serialized and deserialized.
	 */
	public static void moneyTest(){
		Money money1 = new Money(1, 50);
		Money money2 = new Money(2, 50);
		Money money3 = new Money(3, 50);
		Money money3Clone = money3.clone();
		System.out.println("***************Money*********************");
		if(		money1.compareTo(money2) == -1 &&
				money1.compareTo(money3) == -1 &&
				money1.compareTo(money3Clone) == -1 &&
				money3.compareTo(money1) == 1 &&
				money3.compareTo(money2) == 1 &&
				money3.compareTo(money3Clone) == 0 
			)
			System.out.println("SUCCESS");
		else
			System.out.println("FAIL");
		try{
			money1.writeObject();
			money2.writeObject();
			money1.readObject();
			money2.readObject();
		}
		catch(IOException e){}
		catch(ClassNotFoundException e){}
	}
	/**
	 * Tests the bill changes
	 * Ensures compareTo is correctly configured
	 * Ensures that cloned objects are valid.
	 * Verifies that objects can be serialized and deserialized.
	 * Tests that an ExpenseAccount can be properly populated and manipulated
	 * Verifies that looped serialization is possible
	 * Implements the array as an iterable, then prints the next() with hasNext()
	 */
	public static void billTest(){
		Date dateEarly = new Date(1,1,2017);
		Date dateMid = new Date(1,1,2018);
		Date dateLate = new Date(1,1,2019);
		
		Money money1 = new Money(1,50);
		Money money2 = new Money(2,50);
		Money money3 = new Money(3,50);
		
		Bill bill1 = new Bill(money1, dateEarly, "one");
		Bill bill2 = new Bill(money2, dateMid, "two");
		Bill bill3 = new Bill(money3, dateLate, "three");
		Bill bill4 = bill3.clone();
		
		System.out.println("***************Bill*********************");
		if(		bill1.compareTo(bill2) == -1 &&
				bill1.getAmount().compareTo(bill2.getAmount()) == -1 &&
				bill1.getDueDate().compareTo(bill2.getDueDate()) == -1 &&
				bill1.compareTo(bill4) == -1 &&
				bill1.getAmount().compareTo(bill4.getAmount()) == -1 &&
				bill1.getDueDate().compareTo(bill4.getDueDate()) == -1 &&
				bill4.compareTo(bill1) == 1 &&
				bill4.getAmount().compareTo(bill1.getAmount()) == 1 &&
				bill4.getDueDate().compareTo(bill1.getDueDate()) == 1 &&
				bill4.compareTo(bill3) == 0 &&
				bill4.getAmount().compareTo(bill3.getAmount()) == 0 &&
				bill4.getDueDate().compareTo(bill3.getDueDate()) == 0 
				
			)
			System.out.println("SUCCESS");
		else
			System.out.println("FAIL");
		try{
			bill1.writeObject();
			bill2.writeObject();
			bill1.readObject();
			bill2.readObject();
		}
		catch(IOException e){}
		catch(ClassNotFoundException e){}
		
		
		//Expense Account Tests
		System.out.println("***************ExpenseAccount*********************");
		ExpenseAccount batch = new ExpenseAccount();
		System.out.println("batch is empty:"+batch.isEmpty());
		
		batch.add(bill1);
		batch.insert(bill2, 0);
		batch.insert(bill3, 0);
		batch.add(bill4);
		batch.insert(new Bill(new Money(2,50), new Date(1,1,2020),"Last entry, at pos 1"), 1);
		System.out.println("batch is empty:"+batch.isEmpty());
		for(int i=0;i<batch.size(); i++)
			System.out.println(batch.get(i));
		batch.remove(1);
		System.out.println("Removed position 1");
		System.out.println("******************Serializing*********************");
		for(int i=0;i<batch.size(); i++){
			System.out.println(batch.get(i));
			try {
				batch.get(i).writeObject();
			} 
			catch (IOException e) {}
		}
		System.out.println("******************Deserializing*******************");
		for(int i=0;i<batch.size(); i++){
			try {
				batch.get(i).readObject();
			} 
			catch (IOException e) {} 
			catch (ClassNotFoundException e) {}
			System.out.println(batch.get(i));
		}
		System.out.println("***************Iterator*********************");
		
		//Iterator Tests.
		Iterator<?> iter = batch.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next()); 
		}
	}
	

}
