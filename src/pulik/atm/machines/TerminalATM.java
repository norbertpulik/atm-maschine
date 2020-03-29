package pulik.atm.machines;

import pulik.atm.cards.Card;

public class TerminalATM extends TellerMachine {
	
	@Override
	public void insert(Card card) {
		System.out.println("inserting\n" + card);
		super.insert(card);
	}
	
	public void eject() {
		System.out.println("ejecting\n" + insertedCard);// todo
		super.eject();

	}
	
	public void inputPin(String pin) {
		boolean correctPin = insertedCard.checkPin(pin); 
		authorised = correctPin;
		if (correctPin) {
			System.out.println("Authorised"); // todo
		} else {
			System.out.println("Denied"); // todo
		}
	}
	
	

}