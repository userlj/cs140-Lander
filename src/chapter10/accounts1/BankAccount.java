package chapter10.accounts1;
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
   This is mostly code from Big Java by Horstmann 
 */
public class BankAccount implements Cloneable {  
	private double balance; 
	/**
      Constructs a bank account with a zero balance.
	 */
	public BankAccount() {  
		this(0);
	}

	/**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {  
		balance = initialBalance;
	}

	/**
      Deposits money into the bank account.
      @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		balance = balance + amount;
	}

	/**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {  
		balance = balance - amount;
	}

	/**
      Gets the current balance of the bank account.
      @return the current balance
	 */
	public double getBalance() {  
		return balance; 
	}

	/**
      Transfers money from the bank account to another account
      @param amount the amount to transfer
      @param other the other account
	 */
	public void transfer(double amount, BankAccount other) {  
		withdraw(amount);
		other.deposit(amount);
	}

	/**
	  Does end-of-month updates to the accounts, adding interest
	  and deducting any charges.
	  This method was not provided in Big Java
	 */
	public void doMonthlyUpdate() {
		// no action in the BankAccount
	}
	
	/**
	 * Implementation of clone for BankAccount
	 * @return BankAccount object that copies the balance
	 * field of this object
	 */
	@Override
	public BankAccount clone() {
		BankAccount retVal = null;
		try {
			retVal = (BankAccount)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
