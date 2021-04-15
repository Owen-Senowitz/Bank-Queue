/**
 * @author Owen - Senowitz
 * a class that runs the simulation using all the methods created in the EnventList class
 */
package assg7_senowitzo19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) {
		/**
		 * reads all the data from the file and stores it
		 */
		String fileName = "input.txt";
		Scanner readFile = null;
		try {
			readFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
			e.printStackTrace();
		}
		EventList bankQueue = new EventList();
		EventList eventList = new EventList();
		while (readFile.hasNext()) {
			Event arrivalEvent = new Event(readFile.nextInt(), readFile.nextInt());
			eventList.addToQueue(arrivalEvent);
		}
		readFile.close();
		/**
		 * initializes all the variables that will be used during the simulation
		 */
		int totalEvents = 0;
		int totalArrivalTime = 0;
		int totalDepartureTime = 0;
		int totalProcessingTime = 0;
		double averageTime = 0;
		boolean workerReady = true;

		System.out.println("Simulation Begins");
		/**
		 * loop while eventListQueue is not empty
		 */
		while(!eventList.isEmpty()) {
			
			Event x = eventList.head();
			int time = x.getArrivalTime();
			/**
			 * removes the person from the event list when they enter the bank
			 */
			if (x.getEventType() == 1) {
				eventList.removeFromQueue();
				Event customer = x;
				/**
				 * gets the departure time for the person leaving
				 */
				if (bankQueue.isEmpty() && workerReady) {
					int departureTime = time + x.getTransactionTime();
					Event y = new Event(departureTime, 0, 2);
					eventList.addToQueue(y);
					workerReady = false;
				}
				/**
				 * processes arrival event
				 */
				else {
					bankQueue.endOfLine(customer);
				}
				System.out.println("Processing an arrival event at time: " + customer.getArrivalTime());
				totalEvents++;
				totalArrivalTime += customer.getArrivalTime();
				totalProcessingTime += customer.getTransactionTime();
			}
			/**
			 * processes departure event
			 */
			else {
				eventList.removeFromQueue();
				
				if (!bankQueue.isEmpty()) {
					Event customer = bankQueue.head();
					bankQueue.removeFromQueue();
					int departureTime = time + customer.getTransactionTime();
					Event y = new Event(departureTime, 0, 2);
					eventList.addToQueue(y);
				}
				else {
					workerReady = true;
				}
				
				System.out.println("Processing a departure event at time: " + time);
				totalDepartureTime += time;
			}
		}
		/**
		 * finds the average wait time of the people
		 */
		if (totalEvents > 0) {
			averageTime = (double) (totalDepartureTime - totalProcessingTime - totalArrivalTime) / totalEvents;
		}
		/**
		 * stats for the simulation
		 */
		System.out.println("Simulation Ends");
		System.out.println("");
		System.out.println("Final Statistics:");
		System.out.println("Total number of people processed: " + totalEvents);
		System.out.println("Average of time spent waiting: " + averageTime);
	}
}
