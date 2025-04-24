package Array_Stack;

public class ArrayStack implements Stack {
	
	Object[] a;
	int size;
	
	public ArrayStack(int capacity) {
		a = new Object[capacity];
	}


	@Override
	public Object peek() {
	    if (size == 0) {
	        throw new IllegalStateException("Stack is empty"); // Corrected exception type
	    }
	    return a[size - 1];
	}

	@Override
	public Object pop() {
		if (size == 0) {
	        throw new IllegalStateException("Stack is empty"); // Corrected exception type
	    }
		Object temp = a[--size];
		a[size] = null;
		return temp;
	}

	@Override
	public void push(String obj) {
//		if(size == a.length) {
//			resize();
//		}
		a[size++] = obj;
		
	}

	@Override
	public int size() {
		return size;
	}

}
