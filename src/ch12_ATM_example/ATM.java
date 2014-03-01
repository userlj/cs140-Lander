package ch12_ATM_example;
/**
   An ATM that accesses a bank.
 */
public class ATM {  
	private State state;
	private int customerNumber;
	private Customer currentCustomer;
	private BankAccount currentAccount;
	private Bank theBank;

	/**
      Constructs an ATM for a given bank.
      @param aBank the bank to which this ATM connects
	 */    
	public ATM(Bank aBank) {
		theBank = aBank;
		reset();
	}

	/**
      Resets the ATM to the initial state.
	 */
	public void reset() {
		customerNumber = -1;
		currentAccount = null;
		state = State.START;
	}

	/** 
      Sets the current customer number 
      and sets state to PIN. 
      (Precondition: state is START)
      @param number the customer number.
	 */
	public void setCustomerNumber(int number) {
		customerNumber = number;
		state = State.PIN;
	}

	/** 
      Finds customer in bank.
      If found sets state to ACCOUNT, else to START.
      (Precondition: state is PIN)
      @param pin the PIN of the current customer
	 */
	public void selectCustomer(int pin) {  
		currentCustomer = theBank.findCustomer(customerNumber, pin);
		if (currentCustomer == null) {
			state = State.START;
		}
		else {
			state = State.ACCOUNT;
		}
	}

	/** 
      Sets current account to checking or savings. Sets 
      state to TRANSACT. 
      (Precondition: state is ACCOUNT or TRANSACT)
      @param account one of CHECKING or SAVINGS
	 */
	public void selectAccount(AccountType account) {
		currentAccount = account.getAcc(currentCustomer);
		state = State.TRANSACT;
	}

	/** 
      Withdraws amount from current account. 
      (Precondition: state is TRANSACT)
      @param value the amount to withdraw
	 */
	public void withdraw(double value) {  
		currentAccount.withdraw(value);
	}

	/** 
      Deposits amount to current account. 
      (Precondition: state is TRANSACT)
      @param value the amount to deposit
	 */
	public void deposit(double value) {  
		currentAccount.deposit(value);
	}

	/** 
      Gets the balance of the current account. 
      (Precondition: state is TRANSACT)
      @return the balance
	 */
	public double getBalance() {  
		return currentAccount.getBalance();
	}

	/**
      Moves back to the previous state.
	 */
	public void back() {
		state = state.back();
	}

	/**
      Gets the current state of this ATM.
      @return the current state
	 */
	public State getState() {
		return state;
	}
}
