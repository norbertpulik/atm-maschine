package pulik.atm.machines;

import pulik.atm.cards.Card;

public class TerminalATM extends TellerMachine {

	@Override
	public void insert(Card card) {
		System.out.println("inserting\n" + card);
		super.insert(card);
	}

	@Override
	public void eject() {
		System.out.println("ejecting\n" + insertedCard);// todo
		super.eject();
	}

	@Override
	public void showBalance() {
		try {
			System.out.println(insertedCard.getBalance());
		} catch (Exception e) {
			System.out.println("Sorry, incorrect PIN.");
		}
	}

}