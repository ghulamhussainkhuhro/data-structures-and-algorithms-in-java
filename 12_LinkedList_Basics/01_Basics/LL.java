package Topic_01_Basics;

public class LL { 
	Node head;
	private int size;
	
	public LL() {
		this.size = 0;
	}
	
	class Node{
		String data;
		Node next;
		
		public Node(String data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}
	// add, add first, add last
	
	// add first
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	// add last
	public void addLast(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node currNode = head;
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
	}
	
	// print in linked list
	
	public void printList() {
		Node currNode = head;
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		while(currNode != null) {
			System.out.print(currNode.data+" ->");
			currNode = currNode.next;
		}
		System.out.println("null");
	}
	
	//delete first and delete last
	
	// delete first
	
	public void deleteFirst() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		size--;
		head = head.next;
		
	}
	
	// delete last
	public void deleteLast() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		size--;
		if(head.next == null) {
			head = null;
			return;
		}
		
		Node secondLast = head;
		Node lastNode = head.next;
		
		while(lastNode.next != null) {
			lastNode = lastNode.next;
			secondLast = secondLast.next;
		}
		
		secondLast.next = null;
		
	}
	
	public int getsize() {
		return size;
	}
	
	public static void main(String[] args) {
		
		LL list  = new LL();
		
		list.addFirst("a");
		list.addFirst("is");
		
		list.printList();
		
		list.addLast("list");
		list.printList();
		
		list.addFirst("this");
		list.printList();
		
		list.deleteFirst();
		list.printList();
		
		list.deleteLast();
		list.printList();
		
		System.out.println(list.getsize());
		
		list.addFirst("This");
		System.out.println(list.getsize());
		
		
	}
	
}

