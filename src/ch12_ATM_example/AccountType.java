package ch12_ATM_example;

public enum AccountType {
	CHECKING {
		@Override
		public BankAccount getAcc(Customer cust) {
			return cust.getCheckingAccount();
		}
	},
	SAVINGS {		
	};	
	public BankAccount getAcc(Customer cust) {
		return cust.getSavingsAccount();					
	}
}
