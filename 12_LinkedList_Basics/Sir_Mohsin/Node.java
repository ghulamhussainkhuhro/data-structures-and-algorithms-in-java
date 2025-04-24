package Topic_01_Sir_Mohsin;

public class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
	
	Node(int data, Node start){
		this.data = data;
		this.next = null;
	}
	
	public static void main(String[] args) {
		Node start = new Node(11);
		start.next = new Node(22);
		start.next.next = new Node(33);
		start.next.next.next = new Node(44);
		start.next.next.next.next = new Node(55);
		
		System.out.println(start.data);
		System.out.println(start.next.next.data);
		System.out.println(start.next.next.next.data);
		System.out.println(start.next.next.next.next.data);
	}

}
