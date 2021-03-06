package pulik.atm.cards;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import pulik.atm.exceptions.IncorrectPinException;

public abstract class Card {

	private long cardNumber;
	private BigDecimal balance;
	private String cardHolder;
	private int pinHash;
	private Date expiration;

	// private boolean isBlocked;
	private boolean isUnlocked;

	public Card(long cardNumber, String cardHolder, String pin, BigDecimal balance) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder.toUpperCase();
		this.pinHash = hashPin(pin);
		this.expiration = calculateExpiration();
		this.balance = balance;
		// this.isBlocked = false;

	}

	public Card(long cardNumber, String cardHolder, String pin) {
		this(cardNumber, cardHolder, pin, BigDecimal.ZERO);
	}

	private int hashPin(String pin) {
		int hash = 7;
		for (int c : pin.chars().toArray()) {
			hash = hash * 31 + c;
		}
		return hash;
	}

	private Date calculateExpiration() {
		Calendar expCal = Calendar.getInstance();
		expCal.add(Calendar.YEAR, 2);
		expCal.set(Calendar.DAY_OF_MONTH, expCal.getActualMaximum(Calendar.DAY_OF_MONTH));
		expCal.set(Calendar.HOUR_OF_DAY, 23);
		expCal.set(Calendar.MINUTE, 59);
		expCal.set(Calendar.SECOND, 59);
		expCal.set(Calendar.MILLISECOND, 999);

		return expCal.getTime();
	}

	public BigDecimal getBalance() throws Exception {
		if (!this.isUnlocked) {
			throw new IncorrectPinException("Incorrect Pin.Detaily...");
		}

		this.isUnlocked = false;
		return this.balance;
	}

	public void withdraw(BigDecimal amount) throws Exception {
		if (!this.isUnlocked) {
			throw new IncorrectPinException("Incorrect Pin");
		}

		{
			this.balance = this.balance.subtract(amount);
			this.isUnlocked = false;
		}

	}

	public void unlock(String pin) {
		this.isUnlocked = hashPin(pin) == pinHash;
	}

	@Override
	public String toString() {
		return "Card No.: " + getCardNumberString() + "\n" + "Expiration: " + expiration + "\n" + "Holder: "
				+ cardHolder;
	}

	private String getCardNumberString() {
		String cardstr = String.valueOf(cardNumber);
		String star = "*** **** **** ";

		return cardstr.substring(0, 1) + star + cardstr.substring(12);

	}

}
