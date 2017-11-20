
/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 *  CSS162
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Samuel L. Peoples, 1527650
 * JUnit tests for Bill, Date, Money
 *
 */
public class DateMoneyBillJUnit {
	//DATE TESTS
	/**
	 * Asserts that empty constructor will populate date with zero-values
	 */
	@Test
	public void ConstructEmptyDateTest(){
		Date date = new Date();
		
		assertEquals(0, date.getMonth());
		assertEquals(0, date.getDay());
		assertEquals(0, date.getYear());
	}
	
	/**
	 * Asserts that values are set properly in the constructor
	 */
	@Test
	public void ConstructDateTest(){
		Date date = new Date(1,1,2014);
		
		assertEquals(1, date.getMonth());
		assertEquals(1, date.getDay());
		assertEquals(2014, date.getYear());
	}
	
	/**
	 * Asserts that copying a date will preserve values
	 */
	@Test
	public void CopyDateTest(){
		Date date = new Date(1,1,2014);
		
		Date copy = new Date(date);
		
		assertEquals(date.getDate(), copy.getDate());
	}
	
	/**
	 * Asserts that dates must be between 1,31 days, 1,12 months, and 2014,2024 years
	 */
	@Test
	public void SetDateTest(){
		Date lowDate = new Date();
		Date goodDate = new Date();
		Date highDate = new Date();
		
		//Will exit program due to low values
		//lowDate.setDate(1, 1, 2012);
		//lowDate.setDate(-1, 1, 2014);
		//lowDate.setDate(1,-1,2014);
		
		goodDate.setDate(1, 2, 2014);
		
		assertEquals(1, goodDate.getMonth());
		assertEquals(2, goodDate.getDay());
		assertEquals(2014, goodDate.getYear());
		
		//Will exit due to high values
		//highDate.setDate(13, 1, 2014);
		//highDate.setDate(1, 32, 2014);
		//highDate.setDate(1, 1, 2025);
	}
	
	/**
	 * asserts that month values are stored properly and fails if date is improper
	 */
	@Test
	public void SetMonthTest(){
		//Date badMonth = new Date(13,1,2014);
		Date goodMonth = new Date(1,1,2014);
		
		goodMonth.setMonth(2);
		
		assertEquals(goodMonth.getMonth(), 2);
	}
	
	/**
	 * asserts that day values are stored properly and fails if the date is improper
	 */
	@Test
	public void SetDayTest(){
		//Date badDay = new Date(1,32,2014);
		Date goodDay = new Date(1,1,2014);
		
		goodDay.setDay(10);
		
		assertEquals(goodDay.getDay(), 10);		
	}
	
	/**
	 * Asserts that the year values are between 2014 and 2024, are saved properly, and fails if not
	 */
	@Test
	public void SetYearTest(){
		//Date badYearLow = new Date(1,32,2013);
		//Date badYearHigh = new Date(1,32,2025);
		Date goodYear = new Date(1,1,2014);
		
		goodYear.setYear(2017);
		
		assertEquals(goodYear.getYear(), 2017);		
	}
	
	/**
	 * Asserts that get date returns the proper string of values
	 */
	@Test
	public void GetDateTest(){
		Date date = new Date(1,1,2014);
		Date date2 = new Date(10,1,2014);
		Date date3 = new Date(1,10,2014);
		
		assertEquals(date.getDate(), "01/01/2014");
		assertEquals(date2.getDate(), "10/01/2014");
		assertEquals(date3.getDate(), "01/10/2014");
	}
	
	/**
	 * Asserts that getmonth returns the expected value
	 */
	@Test
	public void GetMonthTest(){
		Date date = new Date(1,10,2014);
		
		assertEquals(date.getMonth(),1);
	}
	
	/**
	 * asserts that getday returns the expected value
	 */
	@Test
	public void GetDayTest(){
		Date date = new Date(1,10,2014);
		
		assertEquals(date.getDay(),10);
	}
	
	/**
	 * Asserts that getyear returns the expected value
	 */
	@Test
	public void GetYearTest(){
		Date date = new Date(1,10,2014);
		
		assertEquals(date.getYear(),2014);
	}
	
	/**
	 * Asserts that the toString forms strings properly
	 */
	@Test
	public void ToStringTest(){
		Date date = new Date(1,1,2014);
		Date date2 = new Date(10,1,2014);
		Date date3 = new Date(1,10,2014);
		
		assertEquals(date.toString(), "01/01/2014");
		assertEquals(date2.toString(), "10/01/2014");
		assertEquals(date3.toString(), "01/10/2014");
	}
	
	/**
	 * Asserts that equals processes equality properly
	 */
	@Test
	public void EqualsTest(){
		Date dateA = new Date(1,1,2014);
		Date dateB = new Date(1,1,2015);
		Date dateC = new Date(dateA);
		Date dateD = new Date(1,1,2015);
		
		assertEquals(dateA.equals(dateC), dateC.equals(dateA));
		assert dateA.equals(dateC) == true;
		
		assertEquals(dateB.equals(dateD),dateD.equals(dateB));
		assert dateD.equals(dateB) == true;
		
		dateC.setDate(1, 1, 2015);
		assertEquals(dateC.equals(dateA),dateA.equals(dateC));
		assert dateC.equals(dateA) == false;
	}
	
	//MONEY TESTS
	
	/**
	 * Asserts that money constructs properly with dollars
	 */
	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);
		
		assertEquals(10, money1.getDollars());		
	}
	
	/**
	 * asserts empty constructor sets values to zero
	 */
	@Test
	public void ConstructEmptyMoneyTest(){
		Money money = new Money();
		
		assertEquals(money.getDollars(),0);
		assertEquals(money.getCents(),0);
	}
	
	/**
	 * Asserts dollars and cents can be set
	 */
	@Test
	public void ConstructDoubleMoneyTest(){
		Money money = new Money(1,50);
		
		assertEquals(money.getDollars(),1);
		assertEquals(money.getCents(),50);
	}
	
	/**
	 * Asserts that copying sets values equivalently
	 */
	@Test
	public void CopyMoneyTest(){
		Money money = new Money(1,50);
		Money money2 = new Money(money);
		
		assertEquals(money.getDollars(),money2.getDollars());
		assertEquals(money.getCents(),money2.getCents());
	}
	
	
	/**
	 * Asserts that getdollars returns expected value
	 */
	@Test
	public void GetDollarsTest(){
		Money money = new Money(1,50);
		
		assertEquals(money.getDollars(),1);
	}
	
	/**
	 * asserts that getcents returns expected value
	 */
	@Test
	public void GetCentsTest(){
		Money money = new Money(1,50);
		
		assertEquals(money.getCents(),50);
	}
	
	/**
	 * Asserts that getmoney returns expected double
	 */
	@Test
	public void GetMoneyTest(){
		Money money = new Money(1,50);
		
		assert money.getMoney() == 1.5;
	}
	
	/**
	 * Asserts that setmoney changes expected value
	 */
	@Test
	public void SetMoneyTest()
	{
		Money money1 = new Money();
		
		money1.setMoney(30,50);
		
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
	}
	
	
	/**
	 * Asserts that addition of two money objects results in expected value 
	 */
	@Test
	public void AddMoneyTest(){
		Money money1 = new Money(1);
		Money money2 = new Money(1,50);
		
		money1.add(money2);
		
		assert money1.getMoney() == 2.5;
	}
	
	/**
	 * Asserts that toString returns expected value
	 */
	@Test
	public void PrintMoneyTest()
	{
		Money money1 = new Money(10);

        money1.setMoney(30,50);
        
        assertEquals("$30.50", money1.toString());
	}
	
	/**
	 * Asserts that dollars and cents of comparison Money object are equivalent to current object
	 */
	@Test
	public void MoneyEqualsTest(){
		Money money1 = new Money(1,50);
		Money money2 = new Money(1,50);
		Money money3 = new Money(1);
		
		assert money1.equals(money2);
		assert money1.equals(money3) == false;
	}
	
	//BILL TESTS
	
	/**
	 * Asserts that empty constructor behaves predictably
	 */
	@Test
	public void ConstructEmptyBillTest(){
		Bill bill = new Bill();
		
		assert bill.getAmount().getMoney() == 0.0;
		assertEquals(bill.getDueDate().toString(), "01/01/2024");
		assertEquals(bill.getOriginator(), "Originator");
	}
	
	/**
	 * Asserts that values defined in constructor are set properly
	 */
	@Test
	public void ConstructBillTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assert bill.getAmount().getMoney() == 1.5;
		assertEquals(bill.getDueDate().toString(), "01/30/2017");
		assertEquals(bill.getOriginator(), "User");
		
	}
	
	/**
	 * Asserts that copying defines values properly
	 */
	@Test
	public void CopyBillTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Bill copy = new Bill(bill);
		
		assert bill.getAmount().getMoney() == copy.getAmount().getMoney();
		assertEquals(bill.getDueDate().toString(), copy.getDueDate().toString());
		assertEquals(bill.getOriginator(), copy.getOriginator());
	}
	
	/**
	 * asserts that getter applies expected function
	 */
	@Test
	public void GetAmountTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assertEquals(bill.getAmount().getDollars(), money.getDollars());
		assertEquals(bill.getAmount().getCents(), money.getCents());	
	}
	
	/**
	 * asserts that getter applies expected function
	 */
	@Test
	public void GetDueTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assert bill.getDueDate().equals(date);	
	}
	
	/**
	 * asserts that getter applies expected function
	 */
	@Test
	public void GetOriginatorTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assertEquals(bill.getOriginator(), "User");
	}
	
	/**
	 * Tests function of isPaid, asserts safeguards to prevent invalid modification 
	 */
	@Test
	public void IsPaidFalseTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assertEquals(bill.isPaid(), false);
	}
	/**
	 * Verfies that paying late is not possible
	 */
	@Test
	public void IsPaidLateTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date latePay = new Date(2,29,2017);
		
		assert bill.setPaid(latePay)== false;
		
	}
	
	/**
	 * Verifies that paying is possible
	 */
	@Test
	public void IsPaidCanPayTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date datePaid = new Date(1,10,2017);
		
		bill.setPaid(datePaid);
		
		assertEquals(bill.isPaid(), true);
	}
	
	/**
	 * Verfies that the bill cannot be paid twice
	 */
	@Test
	public void IsPaidPayTwiceTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date datePaid = new Date(1,10,2017);
		
		bill.setPaid(datePaid);
		Date datePaid2 = new Date(1,11,2017);
		
		assert bill.setPaid(datePaid2) == false;
	}
	
	/**
	 * Verifies that the bill due date cannot change after paid
	 */
	@Test
	public void IsPaidDueDatePostTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date datePaid = new Date(1,10,2017);
		
		bill.setPaid(datePaid);
		Date datePaid2 = new Date(1,11,2017);
		
		assert bill.setDueDate(datePaid2) == false;
	
	}
	
	/**
	 * Verifies that the amount cannot be modified after paid 
	 */
	@Test
	public void IsPaidAmountPostTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date datePaid = new Date(1,10,2017);
		
		bill.setPaid(datePaid);
		Date datePaid2 = new Date(1,11,2017);
		Money money2 = new Money(1,10);
		
		assert bill.setAmount(money2) == false;
	}
	
	/**
	 * Asserts setPaid behaves as expected
	 */
	@Test
	public void  SetPaidTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assertEquals(bill.isPaid(), false);
	}
	/**
	 * Asserts setPaid behaves as expected, cant pay early
	 */
	@Test
	public void  SetPaidNotPaidTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date notPaid = new Date(1,31,2017);
		
		bill.setPaid(notPaid);
		
		assertEquals(bill.isPaid(), false);
		
	}
	
	/**
	 * Asserts setPaid behaves as expected, can pay
	 */
	@Test
	public void  SetPaidCanPayTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date paid = new Date (1,28,2017);
		
		bill.setPaid(paid);
		
		assertEquals(bill.isPaid(), true);
	}
	
	/**
	 * asserts that due date will modify appropriately
	 */
	@Test
	public void SetDueTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Date due = new Date(3,1,2017);
		
		bill.setDueDate(due);
		
		assertEquals(bill.getDueDate().toString(), "03/01/2017");	
	}
	
	/**
	 * Asserts that amount is modified appropriately
	 */
	@Test
	public void SetAmountTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		Money newMoney = new Money(3,50);
		
		bill.setAmount(newMoney);
		
		assert bill.getAmount().getMoney() == 3.5;
	}
	
	/**
	 * Asserts originator is modified properly
	 */
	@Test
	public void SetOriginatorTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		bill.setOriginator("Resu");
		
		assertEquals(bill.getOriginator(), "Resu");	
	}
	
	/**
	 * Asserts tostring provides appropriate conditional response
	 */
	@Test
	public void BillToStringTest(){
		Money money = new Money(1,50);
		Date date = new Date(1,30,2017);
		Bill bill = new Bill(money, date, "User");
		
		assertEquals(bill.toString(), "Amount due: $1.50, by 01/30/2017, by User; Balance is outstanding.");
		
		Date paid = new Date(1,29,2017);
		bill.setPaid(paid);
		
		assertEquals(bill.toString(), "Amount due: $1.50, by 01/30/2017, by User; Paid on: 01/29/2017");
	}
	
	/**
	 * Asserts equals behaves as expected
	 */
	@Test
	public void BillEqualsTest(){
		Money money1 = new Money(1,50);
		Date date1 = new Date(1,30,2017);
		Bill bill1 = new Bill(money1, date1, "User");
		
		Money money2 = new Money(1,50);
		Date date2 = new Date(1,30,2017);
		Bill bill2 = new Bill(money2, date2, "User");

		Money money3 = new Money(2,50);
		Date date3 = new Date(1,29,2017);
		Bill bill3 = new Bill(money3, date3, "User2");
		
		assertEquals(money2.equals(money1), true);
		assertEquals(money2.equals(money3), false);
		
	}
}
