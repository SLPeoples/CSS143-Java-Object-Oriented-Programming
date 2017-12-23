/**
 * Account.java
 *
 * This Account class represents bank accounts that stores money for an owner.
 *
 * Author: (put your name here)
 */
class Account
{
// Instance variables
	private double balance;	// invariant: balance >= 0 (should never be negative)
	private String owner;

//Constructor
	public Account(String name)
	{
		this.balance = 0;
		this.owner= name;
	}

public Account() {
		this.balance = 0;
		this.owner = null;
	}

	// Instance methods
	/** Deposits 'amount' into the account
	 */
	public void deposit(int amount)
	{
		this.balance += amount;
	}

	/** Withdraws 'amount' from the account.
	 *	This only makes sense if amount <= balance.
	 *	This method should be re-written so that there is not a possibility of
	 *	having a negative balance.
	 */
	public void withdraw(int amount)
	{
		this.balance -= amount;
	}

	/* Returns the balance of the Account
	 */
	public double getBalance()
	{
		return this.balance;
	}

	/* Returns the owner of the Account
	 */
	public String getOwner()
	{
		return this.owner;
	}
}

