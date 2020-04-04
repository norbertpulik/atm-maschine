package pulik.atm.cards;

import java.math.BigDecimal;

public class DebitCard extends Card{
	
	public DebitCard(long cardNumber, String cardHolder, String pin, BigDecimal balance) {
		super(cardNumber, cardHolder, pin, balance);
		
		
	}
	
	public DebitCard(long cardNumber, String cardHolder, String pin) {
		super(cardNumber, cardHolder, pin);
	}


	@Override
	public void withdraw(BigDecimal amount) throws Exception {
		if (amount.compareTo(getBalance())<= 0 ) {
			super.withdraw(amount);
		}
	}

}
