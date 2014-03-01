package chapter10.accounts1;
/**
   A checking account that charges transaction fees.
   This is mostly code from Big Java by Horstmann 
 */
public class CheckingAccount extends BankAccount
{  
	private static final int FREE_TRANSACTIONS = 3;
	private static final double TRANSACTION_FEE = 2.0;

	private int transactionCount;

	/**
      Constructs a checking account with a given balance.
      @param initialBalance the initial balance
	 */
	public CheckingAccount(double initialBalance)
	{  
		// Construct superclass
		super(initialBalance);

		// Initialize transaction count
		transactionCount = 0; 
	}

	@Override
	public void deposit(double amount) 
	{  
		transactionCount++;
		// Now add amount to balance 
		super.deposit(amount); 
	}

	@Override
	public void withdraw(double amount) 
	{  
		transactionCount++;
		// Now subtract amount from balance 
		super.withdraw(amount); 
	}

	/**
      Deducts the accumulated fees and resets the
      transaction count.
	 */
	public void deductFees()
	{  
		if (transactionCount > FREE_TRANSACTIONS)
		{  
			double fees = TRANSACTION_FEE *
					(transactionCount - FREE_TRANSACTIONS);
			super.withdraw(fees);
		}
		transactionCount = 0;
	}

	/**
	  Does end-of-month updates to the accounts, in this case
	  deducting any charges.
	  This method was not provided in Big Java
	 */
	@Override
	public void doMonthlyUpdate() {
		deductFees();
	}

	/**
	  For JUnit testing, need package-level access to transactionCount
	  This method was not provided in Big Java
	 */
	int getTransactionCount() {
		return transactionCount;
	}
}
