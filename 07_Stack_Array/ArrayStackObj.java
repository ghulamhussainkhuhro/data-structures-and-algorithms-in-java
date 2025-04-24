package Array_Stack;

public class ArrayStackObj implements StackObj {
	
	Object[] a;
	int size;
	
	public ArrayStackObj(int capacity) {
		a = new Object[capacity];
	}
	

	@Override
	public Object peek() {
	    if (size == 0) {
	        throw new IllegalStateException("Stack is empty");
	    }
	    return a[size - 1];
	}

	@Override
	public Object pop() {
		if (size == 0) {
	        throw new IllegalStateException("Stack is empty");
	    }
		Object temp = a[--size];
		a[size] = null;
		return temp;
	}

	@Override
	public void push(Object obj) { 
		if(size == a.length) {
			resize();
		}
		a[size++] = obj;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void resize() {
		Object[] temp = a;
		a = new Object[temp.length * 2];
		System.arraycopy(temp, 0, a, 0, size);
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
	return false;
	}
	
	public boolean isFull() {
		if(size == a.length) {
			return true;
		}
	return false;
	}
	public void display() {
		for(int i = 0; i<size; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	
}
