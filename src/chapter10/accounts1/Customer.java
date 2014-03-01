package chapter10.accounts1;

public class Customer implements Cloneable {
	private String ownerName;
	private BankAccount account;

	public Customer(String ownerName, BankAccount account) {
		super();
		this.ownerName = ownerName;
		this.account = account;
	}
		
	public String getOwnerName() {
		return ownerName;
	}

	public BankAccount getAccount() {
		return account;
	}

	public Customer clone() {
		Customer retVal = null;
		try {
			retVal = (Customer)super.clone();
			retVal.account = account.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
