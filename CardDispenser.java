package hw2;

/**
 * Class that constructs a parking card and gives it a time based
 * off of the time that is given. 
 * @author selmasaric
 *
 */
public class CardDispenser {
	
	/**
	 * Instance variable that holds the current given time
	 */
	private TimeClock currentClock;
	
	/**
	 * Constructs a CardDispenser that uses the givenClock
	 * @param givenClock - given time
	 */
	public CardDispenser(TimeClock givenClock) {
		currentClock = givenClock;
	}

	/**
	 * Constructs and returns a new ParkingCard object. The constructed card will have
	 * a start time based on the current value of the card dispenser's clock and a payment 
	 * time of zero.
	 * @return a new ParkingCard object
	 */
	public ParkingCard takeCard() {
		return new ParkingCard(currentClock.getTime());
	}

	public static void main(String[] args) {
		TimeClock c = new TimeClock();
		CardDispenser cd = new CardDispenser(c);
		c.timePasses(10);
		ParkingCard p = cd.takeCard();
		System.out.println(p.getStartTime()); // Expected 10 
		System.out.println(p.getPaymentTime()); // Expected 0
	}
}
