package pulik.atm;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {

		TellerMachine atm = new TellerMachine();
		Card c = new DebitCard(1234567890123456L, "Peter", "1234", new BigDecimal(199));
		String inPin = "1234";
		
		atm.insert(c);
		atm.inputPin(inPin);
		
		try { 
			atm.showBalance();
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Access denied");
			System.out.println("Ejecting card");
			
			}
		finally { 
			atm.eject();
		}

	}
}
