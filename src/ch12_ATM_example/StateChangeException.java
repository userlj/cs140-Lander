package ch12_ATM_example;

public class StateChangeException extends RuntimeException {

	private static final long serialVersionUID = -4884301332489005851L;

	public StateChangeException() {
		super();
	}

	public StateChangeException(String arg0) {
		super(arg0);
	}

}
