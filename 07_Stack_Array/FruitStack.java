package Array_Stack;

public class FruitStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack fruitStack = new ArrayStack(10);
		fruitStack.push("Banana");
		fruitStack.push("Cheeku");
		fruitStack.push("Grapes");
		fruitStack.push("Mangoes");
		
		System.out.println(fruitStack.peek());
		
		fruitStack.push("Tomato");
		
		System.out.println(fruitStack.peek());
		
		System.out.println(fruitStack.size());
		
		System.out.println(fruitStack.pop());
		
		System.out.println(fruitStack.peek());
		
		System.out.println(fruitStack.size());
		
		

	}

}
