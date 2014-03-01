package ch12_ATM_example;

import java.util.Scanner;

public enum State {
	START {
		@Override
		public State back() {
			throw new StateChangeException("Cannot go back from START state");
		}
		@Override
		public void doActionA(ATM theATM, KeyPad pad) {
			theATM.setCustomerNumber((int) pad.getValue());
		}
		@Override
		public void doActionB(ATM theATM, KeyPad pad) {
			throw new StateChangeException("Cannot respond to B button");
		}
		@Override
		void doActionC(ATM theATM, KeyPad pad) {
			throw new StateChangeException("Cannot respond to C button");
		}		
		@Override
		public String getMessage(ATM theATM) {
			return "Enter customer number\nA = OK";
		}
		@Override
		void processInput(ATM theATM, Scanner in) {
            System.out.print("Enter customer number: ");
            int number = in.nextInt();
            theATM.setCustomerNumber(number);            
		}
	}, 
	PIN {
		@Override
		public State back() {
			return START;
		}
		@Override
		public void doActionA(ATM theATM, KeyPad pad) {
			theATM.selectCustomer((int) pad.getValue());
		}
		@Override
		public void doActionB(ATM theATM, KeyPad pad) {
			throw new StateChangeException("Cannot respond to B button");
		}
		@Override
		public String getMessage(ATM theATM) {
			return "Enter PIN\nA = OK";
		}
		@Override
		void doActionC(ATM theATM, KeyPad pad) {
			throw new StateChangeException("Cannot respond to C button");
		}
		@Override
		void processInput(ATM theATM, Scanner in) {
            System.out.print("Enter PIN: ");
            int pin = in.nextInt();
            theATM.selectCustomer(pin);
		}		
	}, 
	ACCOUNT {
		@Override
		public State back() {
			return PIN;
		}
		@Override
		public void doActionA(ATM theATM, KeyPad pad) {
            theATM.selectAccount(AccountType.CHECKING);
		}
		@Override
		public void doActionB(ATM theATM, KeyPad pad) {
			theATM.selectAccount(AccountType.SAVINGS);
		}
		@Override
		public String getMessage(ATM theATM) {
			return "Select Account\n" 
					+ "A = Checking\nB = Savings\nC = Exit";
		}
		@Override
		void doActionC(ATM theATM, KeyPad pad) {
			theATM.reset();			
		}
		@Override
		void processInput(ATM theATM, Scanner in) {
            System.out.print("A=Checking, B=Savings, C=Quit: ");
            String command = in.next();
            if (command.equalsIgnoreCase("A")) {
               theATM.selectAccount(AccountType.CHECKING);
            }
            else if (command.equalsIgnoreCase("B")) {
               theATM.selectAccount(AccountType.SAVINGS);
            }
            else if (command.equalsIgnoreCase("C")) {
               theATM.reset();
            }
            else {
               System.out.println("Illegal input!");                        
            }
		}		
	}, 
	TRANSACT {
		@Override
		public State back() {
			return ACCOUNT;
		}
		@Override
		public void doActionA(ATM theATM, KeyPad pad) {
            theATM.withdraw(pad.getValue());
            theATM.back();			
		}
		@Override
		public void doActionB(ATM theATM, KeyPad pad) {
            theATM.deposit(pad.getValue());
            theATM.back();
		}
		@Override
		public String getMessage(ATM theATM) {
			return "Balance = " 
					+ theATM.getBalance() 
					+ "\nEnter amount and select transaction\n"
					+ "A = Withdraw\nB = Deposit\nC = Cancel";
		}
		@Override
		void doActionC(ATM theATM, KeyPad pad) {
			theATM.back();			
		}
		@Override
		void processInput(ATM theATM, Scanner in) {
            System.out.println("Balance=" + theATM.getBalance());
            System.out.print("A=Deposit, B=Withdrawal, C=Cancel: ");
            String command = in.next();
            if (command.equalsIgnoreCase("A")) {
               System.out.print("Amount: ");
               double amount = in.nextDouble();
               theATM.deposit(amount);
               theATM.back();
            }
            else if (command.equalsIgnoreCase("B")) {
               System.out.print("Amount: ");
               double amount = in.nextDouble();
               theATM.withdraw(amount);
               theATM.back();
            }
            else if (command.equalsIgnoreCase("C")) {
               theATM.back();
            }
            else {
               System.out.println("Illegal input!");                                    
            }
		}		
	};

	abstract public State back();
	abstract String getMessage(ATM theATM);
	abstract void doActionA(ATM theATM, KeyPad pad);
	abstract void doActionB(ATM theATM, KeyPad pad);
	abstract void doActionC(ATM theATM, KeyPad pad);
	abstract void processInput(ATM theATM, Scanner in);
}
