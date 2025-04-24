package Array_Stack;

public class FruitStackObj {

	public static void main(String[] args) {
		
		ArrayStackObj fruitStack = new ArrayStackObj(10);
		fruitStack.push("Banana");
		fruitStack.push("Cheeku");
		fruitStack.push("Grapes");
		fruitStack.push("Mangoes");
		fruitStack.push("Mangoes");
		fruitStack.push("Mangoes");
		fruitStack.push("Mangoes");
		fruitStack.push("Mangoes");
		fruitStack.push("Mangoes");
		fruitStack.push("Grapes");
		fruitStack.push("Grapes");
		

		System.out.println(fruitStack.peek());

		fruitStack.push(new Fruit("Apple", "Red", 150));
		System.out.println(fruitStack.peek());

		System.out.println(fruitStack.size());

		System.out.println(fruitStack.pop());

		System.out.println(fruitStack.peek());

		System.out.println(fruitStack.size());
	}
}

class Fruit {
    String name;
    String color;
    int weight;

    public Fruit(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " (" + color + ", " + weight + "g)";
    }
}
