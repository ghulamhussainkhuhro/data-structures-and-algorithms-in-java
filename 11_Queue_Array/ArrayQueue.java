package Array_Queue;


public class ArrayQueue implements Queue {
	Object[] a;
	
	ArrayQueue(int size){
		Object[] a = new Object[size];
	}

	private static class Node {
		Object data;
		Node next = this, prev = this; 

		Node(Object data) {
			this.data = data;
		}

		Node(Object data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private int size; 
	private Node head = new Node(null); // Dummy node acting as the head of the queue

	// Returns the size of the queue
	public int size() {
		return size;
	}

	// Returns the first element in the queue without removing it
	public Object first() {
		if (size == 0)
			throw new IllegalStateException("Empty");
		return head.next.data; // First element is the node after the head
	}

	// Removes and returns the first element in the queue
	public Object remove() {
		if (size == 0)
			throw new IllegalStateException("Empty");
		Object temp = head.next.data; // Store the first element's data
		head.next = head.next.next; // Update head's next to the second node
		head.next.prev = head; // Update the second node's prev to head
		--size; // Decrease the size
		return temp; // Return the removed data
	}

	// Adds a new element to the end of the queue
	public void add(Object data) {
		head.prev.next = new Node(data, head.prev, head); // Create a new node at the end
		head.prev = head.prev.next; // Update the last node to be the new node
		++size; // Increase the size
	}
	
	public Object deleteThird() {
		if(size < 3) throw new IllegalStateException("3rd element not found");
		
		Object temp = head.next.next.next.data;
		head.next.next = head.next.next.next.next;
		head.next.next.next.next.prev = head.next.next;
		return temp;
	}

	// Computes the sum of all integer elements in the queue
	public Object sum() {
		int sum = 0;
		for (Node p = head.next; p != head; p = p.next) {
			sum += (int) p.data; // Accumulate sum of data cast to int
		}
		return sum;
	}

	// Converts the queue into an array and prints a confirmation message
	public void toArray(int size) {
		int arr[] = new int[size]; // Create an array of the given size
		int i = 0;
		for (Node p = head.next; p != head; p = p.next) {
			arr[i] = (int) p.data; // Assign node data to array elements
			i++;
		}
		System.out.println("Converted into array");
	}

	// Returns a string representation of the queue
	public String toString() {
		String str = "";
		for (Node p = head.next; p != head; p = p.next) {
			str += p.data + " "; // Concatenate node data to the string
		}
		return str;
	}

	// Creates a deep copy (clone) of the queue
	public LinkedQueue clone() {
		LinkedQueue lq1 = new LinkedQueue(); // New LinkedQueue instance
		for (Node p = head.next; p != head; p = p.next) {
			lq1.add(p.data); // Add each element of the original queue to the new one
		}
		System.out.println("Cloned");
		return lq1;
	}

	// Returns the second last element in the queue
	public Object secondLast() {
		if (size == 0)
			throw new IllegalStateException("Empty");
		return head.prev.prev.data; // Second last element is the node before the last
	}

	// Returns the second element in the queue
	public Object secondElement() {
		if (size == 0)
			throw new IllegalStateException("Empty");
		return head.next.next.data; // Second element is the node after the first
	}

}
