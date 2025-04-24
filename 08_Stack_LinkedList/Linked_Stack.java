package Linked_Stack;

public class Linked_Stack implements Stack{
	
	private static class Node{
		Object data;
		Node next;
		
		Node(Object data, Node next){
			this.next = next;
			this.data = data;
		}
	}
	
	private Node top;
	private int size;

	@Override
	public Object peek() {
		if(size == 0) throw new IllegalStateException("Stack is empty!");
		return top.data;
	}

	@Override
	public Object pop() {
		if(size == 0) throw new IllegalStateException("Stack is empty");
		--size;
		Object oldtop = top.data;
		top = top.next;
		return oldtop;
	}

	@Override
	public void push(Object obj) {
		top = new Node(obj, top);
		size++;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void traverse() {
		
		for(Node p=top; p!=null; p=p.next) {
			System.out.println(top.data);
		}
	}
	
}
