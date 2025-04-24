package Linked_Stack;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Linked_Stack ls = new Linked_Stack();
		ls.push("Apple");
		ls.push("Grapes");
		ls.push("Banana");
		
		System.out.println("Elemets added successfully...");
		
//		System.out.println("Peaked"+ls.peek());
		
		ls.traverse();
		
	}

}
