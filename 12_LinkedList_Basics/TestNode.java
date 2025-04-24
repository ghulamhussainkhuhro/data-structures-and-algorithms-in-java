package Lecture1;

public class TestNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node start = new Node(22);
		Node p = start;
		
		for(int i = 0; i < 4; i++) {
			p.next = new Node(33 + 11*i);
			p = p.next;
		}
		
		for(p = start; p != null; p = p.next) {
			System.out.println(p.data);
		}
		
		for(p = start; p != null; p = p.next) {
			System.out.println(p);
		}

	}
}
