/**
 * @author Owen - Senowitz
 * a class that has the constructors and all the get methods
 */
package assg7_senowitzo19;

public class Event {
	/**
	 * our variables
	 */
	private int arrivalTime;
	private int transactionTime;
	private int eventType;
	/**
	 * default constructor
	 */
	public Event() {
		arrivalTime = 0;
		transactionTime = 0;
		eventType = 0;
	}
	/**
	 * 2 parameter constructor
	 * @param arrivalTime
	 * @param transactionTime
	 */
	public Event(int arrivalTime, int transactionTime) {
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		eventType = 1;
	}
	/**
	 * 3 parameter constructor
	 * @param arrivalTime
	 * @param transactionTime
	 * @param eventType
	 */
	public Event(int arrivalTime, int transactionTime, int eventType) {
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.eventType = eventType;
	}
	/**
	 * returns the arrival time
	 * @return
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * returns the transaction time
	 * @return
	 */
	public int getTransactionTime() {
		return transactionTime;
	}
	/**
	 * returns the event type 1 = arrival 2 = departure
	 * @return
	 */
	public int getEventType() {
		return eventType;
	}
}
