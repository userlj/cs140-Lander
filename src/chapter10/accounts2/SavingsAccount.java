package chapter10.accounts2;
/**
   An account that earns interest at a fixed rate.
   This is mostly code from Big Java by Horstmann 
 */
public class SavingsAccount extends BankAccount
{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 9062375432288125151L;
	private double interestRate;

	/**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate
	 */
	public SavingsAccount(double rate) 
	{  
		// automatically calls super();
		interestRate = rate;
	}

	/**
      Adds the earned interest to the account balance.
	 */
	public void addInterest() 
	{  
		double interest = getBalance() * interestRate / 100;
		deposit(interest); 
	}

	/**
	  Does end-of-month updates to the accounts, in this case
	  adding interest.
	  This method was not provided in Big Java
	 */
	public void doMonthlyUpdate() {
		addInterest();
	}
}
