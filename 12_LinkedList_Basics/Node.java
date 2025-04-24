package Lecture1;

//Node class representing an element of the linked list
class Node {
	int data;  // Data stored in the node
	Node next;  // Reference to the next node
	static int count = 0; 
 

 // Constructor to create a node with given data
	Node(int data) {
		this.data = data;
		count++;
	}

 // Constructor to create a node with given data and next reference
	Node(int data, Node next) {
		this.data = data;
		this.next = next;  // Set the next reference to the given node
	}
}
