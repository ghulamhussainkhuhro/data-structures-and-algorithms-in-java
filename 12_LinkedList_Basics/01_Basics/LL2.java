package Topic_01_Basics;
import java.util.*;

public class LL2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("a");
		list.addFirst("is");
		System.out.println(list);
		
		list.addLast("list"); // if we only add then by default elements will be added at last
		list.addFirst("This");
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ->");
		}
		System.out.println("null");
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == "a") {
				System.out.println(list.get(i)+ " found at index "+i);
			}
		}
		
//		list.removeFirst();
//		System.out.println(list);
//		list.removeLast();
//		System.out.println(list);
		
		list.remove(3); // delete element at index 3
		System.out.println(list);
		

	}

}
