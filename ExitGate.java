package hw2;
/**
 * Class that determines if it has been 15 minutes or less from the time
 * you made payment. If yes, you may exit the garage. If not, you must go back to the
 * payment machine and pay some more. 
 * 
 * @author selmasaric
 *
 */

public class ExitGate {
	
/**
 * Instance variable that holds the amount of times you have exited
 * from the parking garage.
 */
	private int exitCount;


	/**
	 * Constructs an ExitGate that uses the given clock and has an initial count of zero. 
	 * @param givenClock - given time
	 */
	public ExitGate(TimeClock givenClock) {
		
	}

	/**
	 * Simulates inserting a card into this machine. 
	 * @param c - the parking card
	 * @return true or false depending on if the card meets the time qualifications. 
	 */
	public boolean insertCard(ParkingCard c) {
		if ((c.getPaymentTime() >= RateUtil.EXIT_TIME_LIMIT) && (c.getPaymentTime() > 0)) {
			exitCount = exitCount + 1;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns a count of the total number of successful exits. 
	 * @return exitCount - the amount of successful exits made off the parking card. 
	 */
	public int getExitCount() {
		return exitCount;
	}

	public static void main(String[] args) {
		TimeClock c = new TimeClock();
		ExitGate eg = new ExitGate(c);
		ParkingCard p = new ParkingCard(c.getTime());
		p.setPaymentTime(10);
		c.timePasses(20);
		boolean canExit = eg.insertCard(p);
		System.out.println(canExit); // Expected true
		ParkingCard p2 = new ParkingCard(0);
		p2.setPaymentTime(30);
		c.timePasses(60);
		canExit = eg.insertCard(p2);
		System.out.println(canExit); // Expected false
		System.out.println(eg.getExitCount()); // Expected 1
	}

}
