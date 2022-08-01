package pulik.atm;

import java.math.BigDecimal;

import pulik.atm.cards.Card;
import pulik.atm.cards.DebitCard;
import pulik.atm.machines.TellerMachine;
import pulik.atm.machines.TerminalATM;

public class Main {
	public static void main(String[] args) throws Exception {

		TellerMachine atm = new TerminalATM();
		Card c = new DebitCard(1234567890123456L, "Peter", "1234", new BigDecimal(199));
		String inPin = "1234";

		atm.insert(c);
		atm.inputPin(inPin);
		atm.showBalance();
		atm.eject();

		System.out.println("\n\n");
		System.out.println("\n\n");

		atm.insert(c);
		atm.showBalance();
		atm.eject();
		
	}
}
