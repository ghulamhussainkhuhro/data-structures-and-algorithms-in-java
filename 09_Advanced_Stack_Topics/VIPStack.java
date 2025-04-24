package VIP_Stack;

import Array_Stack.StackObj;

public class VIPStack implements StackObj {

	Object[] a;
	int size;
	
	public void pushAll(Object obj) {
		
	}

	public VIPStack(int capacity) {
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
		if (size == a.length) {
			resize();
		}
		a[size++] = obj;
	}

	public void push(String name, boolean vip_status) {
		Person person = new Person(name, vip_status);
		push(person);
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
		return size == 0;
	}

	public boolean isFull() {
		return size == a.length;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(a[i]);
		}
	}

	public void popVip() {
		for (int i = 0; i < size;) {
			Person person = (Person) a[i];
			if (person.vip_status) {
				System.out.println("Popping VIP: " + person);
				System.arraycopy(a, i + 1, a, i, size - i - 1);
				a[--size] = null;
			}
			i++;

		}
	}
	
	
}

class Person {
	String name;
	boolean vip_status;

	public Person(String name, boolean vip_status) {
		this.name = name;
		this.vip_status = vip_status;
	}

	@Override
	public String toString() {
		return "name= " + name + "	vip_status= " + vip_status;
	}
}
