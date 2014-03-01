package big.java.chap9;
/**
   A checking account has a limited number of free deposits and withdrawals.
 */
public class CheckingAccount extends BankAccount
{
	private int withdrawals;

	/**
      Constructs a checking account with a zero balance.
	 */
	public CheckingAccount()
	{
		withdrawals = 0;
	}

	@Override
	public void withdraw(double amount)
	{
		final int FREE_WITHDRAWALS = 3;
		final int WITHDRAWAL_FEE = 1;

		super.withdraw(amount);  
		withdrawals++;
		if (withdrawals > FREE_WITHDRAWALS)
		{
			super.withdraw(WITHDRAWAL_FEE);  
		}
	}

	@Override
	public void monthEnd()
	{
		withdrawals = 0;
	}
}

