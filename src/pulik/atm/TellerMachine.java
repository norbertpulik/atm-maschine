package pulik.atm;

import pulik.atm.exceptions.IncorrectPinException;

public class TellerMachine {

	protected Card insertedCard;
	private boolean authorised;

	public void insert(Card card) {
		insertedCard = card;
	}

	public void eject() {
		insertedCard = null;

	}

	public void inputPin(String pin) throws Exception {
		boolean correctPin = insertedCard.checkPin(pin); 
		authorised = correctPin;
		if (!correctPin) {
			throw  new IncorrectPinException("Pin incorrect");
		}
		
	}

	public void showBalance() {
		if (!authorised) {
			throw new IllegalArgumentException();
		}

		System.out.println(insertedCard.getBalance()); // todo
	}

}
