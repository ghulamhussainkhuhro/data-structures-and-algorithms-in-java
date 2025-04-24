package LinkedQueue01;

//Implementation of the Queue using a linked list
public class LinkedQueue implements Queue {

	// Static nested class representing a Node in the linked list
	private static class Node {
		Object data; // Data stored in the node
		Node next = this, prev = this; // Pointers to the next and previous nodes (default is self)

		// Constructor for creating a node with data
		Node(Object data) {
			this.data = data;
		}

		// Constructor for creating a node with data and links to previous and next
		// nodes
		Node(Object data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private int size; // Number of elements in the queue
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

	// Checks if two LinkedQueue instances are equal
	public boolean equals(LinkedQueue lq1, LinkedQueue lq2) {
		if (lq1.size() != lq2.size()) {
			return false; // If sizes are different, queues are not equal
		} else {
			for (Node p1 = lq1.head.next, p2 = lq2.head.next; p1 != head; p1 = p1.next, p2 = p2.next) {
				if (p1.data != p2.data) {
					System.out.println("Loop");
					return false; // If any data is different, queues are not equal
				}
			}
		}
		return true; // Queues are equal if all elements match
	}

}
