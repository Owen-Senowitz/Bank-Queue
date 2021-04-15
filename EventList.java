/**
 * @author Owen - Senowitz
 * a class that has all the methods for the bank queue simulation
 */
package assg7_senowitzo19;

public class EventList {
	private class Node {
		Event data;
		Node next;
		
		public Node(Event data) {
			this.data = data;
			this.next = null;
		}
		public Node(Event data, Node newNext) {
			this.data = data;
			this.next = newNext;
		}
		public Event getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node x) {
			this.next = x;
		}
	}
	private Node head;
	private int size;
	
	EventList() {
		head = null;
		size = 0;
	}
	/**
	 * finds it the queue is empty
	 * @return
	 */
	boolean isEmpty() {
		return size == 0;
	}
	/**
	 * puts them in the bank of the line inside the bank
	 * @param x
	 * @return
	 */
	boolean endOfLine(Event x) {
		if (x == null) {
			return false;
		}
		if (head == null) {
			head = new Node(x, head); 
				size++;
				return true;
		}
		Node current = head;
		
		while (current.next != null) {
			current = current.getNext();
		}
		current.setNext(new Node(x));
		
		size++;
		return true;
	}
	/**
	 * adds to the queue
	 * @param x
	 * @return
	 */
	boolean addToQueue(Event x) {
		if (x == null) {
			return false;
		}
		if (head == null || x.getArrivalTime() < head.getData().getArrivalTime()) {
			head = new Node(x, head);
			size++;
			return true;
		}
		
		Node current = head;
		Node previous = null;
		
		while (current != null && (x.getArrivalTime() > current.getData().getArrivalTime())) {
			previous = current;
			current = current.getNext();
		}
		Node newNode = new Node(x, previous.getNext());
		previous.setNext(newNode);
		size++;
		return true;
	}
	/**
	 * removes them from queue
	 * @return
	 */
	boolean removeFromQueue() {
		if (size == 0) {
			return false;
		}
		head = head.getNext();
		size--;
		return true;
	}
	/**
	 * get the person in the front of the queue
	 * @return
	 */
	Event head() {
		if (size == 0) {
			return new Event();
		}
		else {
			return head.getData();
		}
	}
}
