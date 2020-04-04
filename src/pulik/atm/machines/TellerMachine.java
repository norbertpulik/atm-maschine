package pulik.atm.machines;

import pulik.atm.cards.Card;
import pulik.atm.exceptions.IncorrectPinException;

public abstract class  TellerMachine {

	protected Card insertedCard;
	protected boolean authorised;

	public void insert(Card card) {
		insertedCard = card;
	}

	public void eject() {
		insertedCard = null;

	}

	public void inputPin(String pin) {
		insertedCard.unlock(pin);
	}

	public abstract void showBalance();
	
		
	}
		
	


