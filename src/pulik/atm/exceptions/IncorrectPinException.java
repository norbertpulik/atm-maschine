package pulik.atm.exceptions;

public class IncorrectPinException extends Exception {

	
	private static final long serialVersionUID = 3434047292303382543L;

	public IncorrectPinException() {
		super();
	}

	public IncorrectPinException(String message) {
		super(message);

	}

}
