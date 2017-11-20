import java.io.*;

/**
 * @author Samuel L. Peoples, 1527650
 * Bill constructor class
 */
public class Bill implements Comparable<Bill>, Cloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Money amount = new Money();
	private Date dueDate = new Date();
	private Date paidDate = new Date();
	private String originator;
	/**
	 * empty constructor
	 */
	public Bill(){
		this.amount.setMoney(0, 0);
		this.dueDate.setDate(1, 1, 2024);
		this.originator = "Originator";
	}
	
	/**
	 * Constructor for bill
	 * @param am, amount
	 * @param due, due date
	 * @param orig, originator
	 */
	public Bill(Money am, Date due, String orig) {
		this.amount.setMoney(am.getDollars(), am.getCents());
		this.dueDate.setDate(due.getMonth(), due.getDay(), due.getYear());
		this.originator = orig;
	}

	/**
	 * Copy Construtor
	 * @param other, copy to this
	 */
	public Bill(Bill other) {
		this.amount.setMoney(other.getAmount().getDollars(), other.getAmount().getCents());
		this.dueDate.setDate(other.getDueDate().getMonth(), other.getDueDate().getDay(), other.getDueDate().getYear());
		this.originator = other.getOriginator();
	}
	
	/**
	 * getter for amount
	 * @return this amount
	 */
	public Money getAmount(){
		return this.amount;
	}
	
	/**
	 * getter for due date
	 * @return this due date
	 */
	public Date getDueDate(){
		return this.dueDate;
	}
	
	/**
	 * getter for originator
	 * @return this originator
	 */
	public String getOriginator(){
		return this.originator;
	}
	
	/**
	 * Boolean for whether a bill is paid
	 * @return true if paid
	 */
	public boolean isPaid(){
		if(this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Setter for date paid
	 * @param datePaid, what date to set the bill paid to
	 * @return true if the paid date was updated.
	 */
	public boolean setPaid(Date datePaid){
		if(this.isPaid()||datePaid.getYear() > this.dueDate.getYear()||
				datePaid.getMonth() > this.dueDate.getMonth() &&datePaid.getYear() >= this.dueDate.getYear()||
				datePaid.getDay() > this.dueDate.getDay()&&datePaid.getYear() >= this.dueDate.getYear() &&datePaid.getMonth() >= this.dueDate.getMonth())
			return false;
		else{
			this.paidDate = datePaid;
			return true;
		}
	}
	
	/**
	 * setter for due date
	 * @param nextDate, date to change the due date to
	 * @return true if due date was updated
	 */
	public boolean setDueDate(Date nextDate){
		if(this.isPaid()||this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return false;
		else{
			this.dueDate = nextDate;
			return true;
		}
	}
	
	/**
	 * setter for amount
	 * @param am, amount to set to
	 * @return, true if amount was updated
	 */
	public boolean setAmount(Money am){
		if(this.isPaid()||this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return false;
		else{
			this.amount = am;
			return true;
		}
	}
	
	/**
	 * setter for originator
	 * @param orig, string to set originator to
	 */
	public void setOriginator(String orig){
		this.originator = orig;
	}
	
	/** toString method
	 * @return appropriate string realted to status
	 */
	public String toString(){
		if(this.isPaid())
			return "Amount due: "+this.amount.toString()+", by "+this.dueDate.toString()+", by "+this.originator +"; Paid on: "+this.paidDate;
		else
			return "Amount due: "+this.amount.toString()+", by "+this.dueDate.toString()+", by "+this.originator+"; Balance is outstanding.";
	}
	
	/**
	 * equals method
	 * @param other, what to compare to this
	 * @return true if elements are equivalent
	 */
	public boolean equals(Bill other){
		if(this.amount == other.getAmount() && this.dueDate == other.getDueDate() && this.originator == other.getOriginator() && this.paidDate == other.paidDate)
			return true;
		else
			return false;
	}
	
	

	/**
	 * compareTo method, overrides inherited comparable Compares originator names
	 * Checks to see if the originators are similar. Call sub-compareTo to compare amount and date
	 * @return int
	 * returns 1 if the originator is alphabetically later than the other
	 * returns 0 if the bill originator is equivalent
	 * returns -1 if the bill originator being compared is later than the parameter bill
	 */
	public int compareTo(Bill other) {
		if(this.getClass() != (other.getClass())){
			throw new IllegalArgumentException(this.getClass() +"compareTo( " +other.getClass()+" ); Invalid input.");
		}
		if(this.getOriginator().compareTo(other.getOriginator())<0)
			return -1;
		else if(this.getOriginator().compareTo(other.getOriginator()) == 0)
			return 0;
		else return 1;
		
	}
	
	/**
	 * @return new Money identical to this.
	 */
	public Bill clone(){
		return new Bill(this.amount.clone(),this.dueDate.clone(), this.originator);
	}
	
	/**
	 * writeObject() method for serializable implementation, writes to individual files
	 * @throws IOException if file not found
	 */
	public final void writeObject() throws IOException{ 
		try{
			//FileOutputStream outFile = new FileOutputStream("bill.ser");
			FileOutputStream outFile = new FileOutputStream(this.getOriginator()+"."+this.amount.getDollars()+this.amount.getCents()+".ser");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(this);
	        out.close();
	        outFile.close();
	        System.out.println("Serialized data is saved in "+this.getOriginator()+"."+this.amount.getDollars()+this.amount.getCents()+".ser");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * readObject() method for serializable implementation
	 * @throws IOException if file not found
	 * @throws ClassNotFoundException if class not found
	 */
	public final void readObject() throws IOException, ClassNotFoundException{
		Bill temp = null;
		try{
			//FileInputStream fileIn = new FileInputStream("bill.ser");
			FileInputStream fileIn = new FileInputStream(this.getOriginator()+"."+this.amount.getDollars()+this.amount.getCents()+".ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        temp = (Bill) in.readObject();
	        in.close();
	        fileIn.close();
		}
		catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }
		catch(ClassNotFoundException c) {
	         System.out.println("Bill class not found");
	         c.printStackTrace();
	         return;
		}
		System.out.println("Deserialized Bill...");
		System.out.println("Originator: " + temp.getOriginator());
	    System.out.println("Amount: " + temp.getAmount());
	    System.out.println("Due Date: " + temp.getDueDate());
	}
}
