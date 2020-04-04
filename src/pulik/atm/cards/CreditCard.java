package pulik.atm.cards;

import java.math.BigDecimal;

public class CreditCard extends Card {
	
		private BigDecimal minimum;
		
		
		public CreditCard(long cardNumber, String cardHolder, String pin, BigDecimal balance, BigDecimal minimum ) {
			super(cardNumber, cardHolder, pin, balance);
			this.minimum = minimum; 
			
		}
		
		public CreditCard(long cardNumber, String cardHolder, String pin, BigDecimal minimum) {
			super(cardNumber, cardHolder, pin);
			this.minimum = minimum;
			
		}
		
		@Override
		public void withdraw(BigDecimal amount) throws Exception
		{
			if (getBalance().subtract(amount).compareTo(minimum) >= 0 ) {
				super.withdraw(amount);
			}
		}
}
