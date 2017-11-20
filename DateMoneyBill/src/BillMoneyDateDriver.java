
/**
 * @author Samuel L. Peoples
 * Driver for Date, Money, Bill
 */
public class BillMoneyDateDriver{
    public static void main(String[] args)
    {
        //Construct some money
        money();
        //Construct some dates
        date();
        //Construct some bills
        bill();
        
    }
    public static void money(){
    	Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
	    
	    
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        
        //Testing constructors, setters
		Money a = new Money();
		a.setMoney(10, 50);
		Money b = new Money();
		b.setMoney(0, 90);
		Money c = new Money();
		c.setMoney(9, 40);
		Money d = new Money();
		d.setMoney(1, 2);
		Money x = new Money(4);
		System.out.println(x);
		Money y = new Money();
		System.out.println(y);
		
		//Testing getters and setters, toString
		System.out.println("a is: "  +a.toString());
		System.out.println("a as double is: "  +a.getMoney());
		System.out.println("a in dollars: "  +a.getDollars());
		System.out.println("a in cents: "  +a.getCents());
		System.out.println("b is: "  +b.toString());
		System.out.println("b as double is: "  +b.getMoney());
		System.out.println("b in dollars: "  +b.getDollars());
		System.out.println("b in cents: "  +b.getCents());
		System.out.println("c is: "  +c.toString());
		System.out.println("c as double is: "  +c.getMoney());
		System.out.println("c in dollars: "  +c.getDollars());
		System.out.println("c in cents: "  +c.getCents());
		System.out.println("d is: "  +d.toString());
		System.out.println("d as double is: "  +d.getMoney());
		System.out.println("d in dollars: "  +d.getDollars());
		System.out.println("d in cents: "  +d.getCents());
		c.add(d);
		System.out.println("c+d is: "  +c.toString());
		System.out.println("does a = c?: "+a.equals(c));
		System.out.println("does a = b?: "+a.equals(b));
		a.add(b);
		System.out.println("a+b is: "+a.toString());
	}
	public static void date(){
		//Testing constructors, uncommenting below will crash program
		Date a = new Date();
		Date b = new Date(1,1,2014);
		Date c = new Date(1,10,2014);
		Date d = new Date(10,10,2014);
		//Date e = new Date(1,10,2013);
		Date f = new Date(1,10,2024);
		//Date g = new Date(1,10,2025);
		//Date h = new Date(1,32,2017);
		//Date i = new Date(14,10,2017);
		Date j = new Date(b);
		Date k = new Date();
		//testing setters
		a.setDate(6,6,2020);
		k.setMonth(6);
		k.setDay(6);
		k.setYear(2020);
		//testing tostring
		System.out.println("Date a is: "+a.toString());
		System.out.println("Date b is: "+b.toString());
		System.out.println("Date c is: "+c.toString());
		System.out.println("Date d is: "+d.toString());
		//System.out.println("Date e is: "+e.toString());
		System.out.println("Date f is: "+f.toString());
		//System.out.println("Date g is: "+g.toString());
		//System.out.println("Date h is: "+h.toString());
		//System.out.println("Date i is: "+i.toString());
		System.out.println("Date j is: "+j.toString());
		System.out.println("Date k is: "+k.toString());
		System.out.println("a=b?: "+a.equals(b));
		System.out.println("a=k?: "+a.equals(k));
		System.out.println("a month, day, year, is: "+a.getMonth()+","+a.getDay()+","+a.getYear());
	}
	public static void bill(){
		//Testing constructors
		Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2014);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2014));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        //Show string values
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
		//Define more money for new bills
		Money a = new Money();
		a.setMoney(10, 50);
		Money b = new Money();
		b.setMoney(0, 90);
		Money c = new Money();
		c.setMoney(9, 40);
		Money d = new Money();
		d.setMoney(1, 10);
		//Associated dates
		Date aa = new Date(6,6,2020);
		Date bb = new Date(1,1,2014);
		Date cc = new Date(1,10,2014);
		Date dd = new Date(10,10,2014);
		//Associated originators
		String aaa = "aaa";
		String bbb = "bbb";
		String ccc = "ccc";
		String ddd = "ddd";
		//new bills
		Bill a1 = new Bill(a,aa,aaa);
		Bill b1 = new Bill(b,bb,bbb);
		Bill c1 = new Bill(c,cc,ccc);
		Bill d1 = new Bill(d,dd,ddd);
		Bill e1 = new Bill(a1);
		Bill f1 = new Bill();
		System.out.println(f1.toString());
		//Testing amount
		System.out.println("a1 amount is " +a1.getAmount() );
		System.out.println("b1 amount is " +b1.getAmount() );
		System.out.println("c1 amount is " +c1.getAmount() );
		System.out.println("d1 amount is " +d1.getAmount() );
		System.out.println("e1 amount is " +e1.getAmount() );
		//testing due date
		System.out.println("a1 DueDate is " +a1.getDueDate() );
		System.out.println("b1 DueDate is " +b1.getDueDate() );
		System.out.println("c1 DueDate is " +c1.getDueDate());
		System.out.println("d1 DueDate is " +d1.getDueDate());
		System.out.println("e1 DueDate is " +e1.getDueDate());
		//testing originator
		System.out.println("a1 originator is " +a1.getOriginator() );
		System.out.println("b1 originator is " +b1.getOriginator() );
		System.out.println("c1 originator is " +c1.getOriginator());
		System.out.println("d1 originator is " +d1.getOriginator());
		System.out.println("e1 originator is " +e1.getOriginator());
		//testing tostring
		System.out.println("a1 is " +a1.toString() );
		System.out.println("b1 is " +b1.toString() );
		System.out.println("c1 is " +c1.toString());
		System.out.println("d1 is " +d1.toString());
		System.out.println("e1 is " +e1.toString());
		//testing ispaid
		System.out.println("a1 is paid? " +a1.isPaid() );
		System.out.println("b1 is paid? " +b1.isPaid() );
		System.out.println("c1 is paid? " +c1.isPaid());
		System.out.println("d1 is paid? " +d1.isPaid());
		System.out.println("e1 is paid? " +e1.isPaid());
		//Testing setters
		Money a1NewMoney = new Money(5,10);
		Date a1NewDate = new Date(1,1,2015);
		Date a1Paid1 = new Date(12,31,2018);
		Date a1Paid2 = new Date(12,31,2014);
		a1.setAmount(a1NewMoney);
		a1.setDueDate(a1NewDate);
		a1.setPaid(a1Paid1);
		a1.setPaid(a1Paid2);
		b1.setAmount(a1.getAmount());
		b1.setDueDate(a1.getDueDate());
		b1.setOriginator(a1.getOriginator());
		b1.setPaid(a1Paid2);
		System.out.println("a1 = b1? "+a1.equals(b1));
		
		System.out.println("a1 is " +a1.toString() );
		System.out.println("b1 is " +b1.toString() );
		System.out.println("c1 is " +c1.toString());
		System.out.println("d1 is " +d1.toString());
		System.out.println("e1 is " +e1.toString());
		
		//testing ispaid
		System.out.println("a1 is paid? " +a1.isPaid() );
		System.out.println("b1 is paid? " +b1.isPaid() );
		System.out.println("c1 is paid? " +c1.isPaid());
		System.out.println("d1 is paid? " +d1.isPaid());
		System.out.println("e1 is paid? " +e1.isPaid());
	}

}
