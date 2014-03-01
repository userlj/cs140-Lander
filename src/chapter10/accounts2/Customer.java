package chapter10.accounts2;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 8372419452057927836L;
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


}
