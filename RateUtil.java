package hw2;

/**
 * 
 * Calculates the cost of the parking card depending on how long you have been parked in
 * the parking garage
 * @author selmasaric
 *
 */

public class RateUtil {
	
	/**
	 * Constructor that makes this class serve as a container for
	 * calculating the cost of the card
	 */
	private RateUtil() {

	}
	
	/**
	 * Constant variable that is the amount of minutes you have to leave the parking 
	 * garage once you have made a payment on the card.
	 */
	public static final int EXIT_TIME_LIMIT = 15;

	/**
	 * Calculates the cost of the card you put in based off of how many minutes you have
	 * been in the parking garage for. 
	 * @param minutes - the amount of minutes the person has been in the parking garage for
	 * @return cost - final cost of parking card
	 */
	public static double calculateCost(int minutes) {

		int days = minutes / 1440;
		if (days > 0) {
			minutes = minutes - (days * 1440);
		}
		double cost = days * 13;

		if (minutes <= 30) {
			cost += 1.00;
		} else if (minutes <= 60) {
			cost += 2.00;
		} else if (minutes <= 120) {
			cost += 3.50;
		} else if (minutes <= 180) {
			cost += 5.00;
		} else if (minutes <= 240) {
			cost += 6.50;
		} else if (minutes <= 300) {
			cost += 8.00;
		} else if ((minutes <= 360)) {
			cost += 9.25;
		} else if (minutes <= 420) {
			cost += 10.50;
		} else if (minutes <= 480) {
			cost += 11.75;
		} else {
			cost += 13.00;
		}
		return cost;

	}

	public static void main(String[] args) {
		System.out.println(RateUtil.calculateCost(29));
		System.out.println(RateUtil.calculateCost(32));
		System.out.println(RateUtil.calculateCost(80));
		System.out.println(RateUtil.calculateCost(135));
		System.out.println(RateUtil.calculateCost(205));
		System.out.println(RateUtil.calculateCost(264));
		System.out.println(RateUtil.calculateCost(310));
		System.out.println(RateUtil.calculateCost(392));
		System.out.println(RateUtil.calculateCost(479));
		System.out.println(RateUtil.calculateCost(550));
		System.out.println(RateUtil.calculateCost(1450));
		System.out.println(RateUtil.calculateCost(2890));
	}
}
