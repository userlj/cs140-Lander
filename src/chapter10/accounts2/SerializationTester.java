package chapter10.accounts2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
   This program tests the BankAccount class and
   its subclasses. 
 */
public class SerializationTester
{  
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{  
		BankAccount temp = new SavingsAccount(0.5);
		Customer mom = new Customer("Mom", temp);

		ByteArrayOutputStream baos = new ByteArrayOutputStream( );
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(mom);
		ByteArrayInputStream bais = 
				new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Customer momCopy = (Customer)ois.readObject( );    	  

		temp = new CheckingAccount(100);
		Customer harry = new Customer("Harry", temp);

		mom.getAccount().deposit(10000);
		momCopy.getAccount().deposit(500);

		mom.getAccount().transfer(2000, harry.getAccount());
		harry.getAccount().withdraw(1500);
		harry.getAccount().withdraw(80);      

		mom.getAccount().transfer(1000, harry.getAccount());
		harry.getAccount().withdraw(400);      

		// Simulate end of month
		((SavingsAccount)mom.getAccount()).addInterest();
		((CheckingAccount)harry.getAccount()).deductFees();

		// If Customer clone is shallow, mom gets extra
		// $500 from monCompy but also momCopy also gives
		// money to Harry.
		System.out.println("Mom's savings balance: "
				+ mom.getAccount().getBalance());
		System.out.println("Expected: 7035");
		System.out.println("The copy of Mom's savings balance: "
				+ momCopy.getAccount().getBalance());

		System.out.println("Harry's checking balance: "
				+ harry.getAccount().getBalance());
		System.out.println("Expected: 1116");
	}
}
