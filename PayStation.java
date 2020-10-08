package hw2;

/**
 * Class that has methods allowing the ParkingCard object to be updated to show when
 * a payment is made. 
 * @author selmasaric
 *
 */
public class PayStation {

	/**
	 * Instance variable that holds the current time given into the PayStation constructor.
	 */
	private TimeClock currentTime;
	/**
	 * Instance variable that holds the card when its been inserted into the machine
	 */
	private ParkingCard card;
	/**
	 * Instance variable that holds the total payment amount made to the card.
	 */
	private double totalPayments;

	/**
	 * Constructs a Pay Station that uses the given clock.
	 * @param givenClock - given time
	 */
	public PayStation(TimeClock givenClock) {
		currentTime = givenClock;
		totalPayments = 0.0;
	}
	/**
	 * Simulates inserting the given card into this machine. 
	 * @param t - holds parking card
	 */
	public void insertCard(ParkingCard t) {
		card = t;
	}
	
	/**
	 * Returns a reference to the card currently in this machine or null if there
	 * is no transaction in progress.
	 * @return card - holds parking card
	 */
	public ParkingCard getCurrentCard() {
		if (card != null) {
			return card;
		} 
		else {
			return null;
		}
	}
	
	/**
	 * Returns true if there is currently a card in this machine, false otherwise. 
	 * @return true or false depending on if there is a card in the machine
	 */
	public boolean inProgress() {
		if (card != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the payment due for the card currently in the machine. If there is 
	 * no transaction in progress, 0.0 is returned. 
	 * @return the payment due depending on whether a payment has already been made
	 * once or not
	 */
	public double getPaymentDue() {
		if (card == null) {
			return 0.0;
		}
		if(card.getPaymentTime() != 0) {
			return RateUtil.calculateCost(currentTime.getTime() - card.getStartTime()) - (RateUtil.calculateCost(card.getPaymentTime() - card.getStartTime()));
		}
		return RateUtil.calculateCost(currentTime.getTime() - card.getStartTime());
	}

	/**
	 * Updates the current card with the payment time and adds the payment amount to
	 * this machine's total. If there's no transaction in progress, this method has no effect. 
	 */
	public void makePayment() {
		if (card != null) {
			card.setPaymentTime(currentTime.getTime());
			totalPayments += getPaymentDue();
			
		}
	}

	/**
	 * Simulates ejecting a card from this machine , after which another card can be inserted. 
	 */
	public void ejectCard() {
		card = null;
	}

	/**
	 * Returns the total payments that have been made at this machine. 
	 * @return totalPayments - the total payments made
	 */
	public double getTotalPayments() {
		return totalPayments;
	}
	
	public static void main(String[] args) {
//		TimeClock c = new TimeClock();
//		PayStation ps = new PayStation(c);
//		ParkingCard p = new ParkingCard(0);
//		System.out.println(ps.inProgress()); // expected false
//		ps.insertCard(p);
//		System.out.println(ps.inProgress()); // expected true
//		ParkingCard current = ps.getCurrentCard();
//		System.out.println(current == p); // expected true 
//		ps.ejectCard();
//		System.out.println(ps.inProgress()); // expected false
//		current = ps.getCurrentCard();
//		System.out.println(current == null); // expected true
		
		TimeClock c = new TimeClock();
		c.timePasses(10);
		PayStation ps = new PayStation(c);
		ParkingCard p = new ParkingCard(c.getTime());
		c.timePasses(60);
		ps.insertCard(p);
		System.out.println(ps.getPaymentDue()); // expected 2.00
		ps.ejectCard(); // eject without paying
		c.timePasses(75);
		ps.insertCard(p);
		System.out.println(ps.getPaymentDue()); // expected 5.0 (3 hours)
		ps.makePayment();
		System.out.println(ps.getPaymentDue()); // expected 5.0
		System.out.println(ps.totalPayments);
	
		
		
		
	}

}
