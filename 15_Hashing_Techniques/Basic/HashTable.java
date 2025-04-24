package Basic;

import java.util.LinkedList;

public class HashTable {
	private int TABLE_SIZE = 10;
	private LinkedList<Integer>[] table;
	int size;
	private final double LOAD_FACTOR_THRESHOLD = 0.75;

	public HashTable() {
		table = new LinkedList[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = new LinkedList<>();// chaining
		}
		size = 0;
	}

	// SHA ,MD5 - Cryptography

	private int hashFunction(int key) {
//		 return key % TABLE_SIZE;//Division mod function

		 return (int) (TABLE_SIZE * ((key*0.68423049)%1)); //Multiplicative Mod
		// Function

//		return ((((34 * key) + 56) % 101) % TABLE_SIZE);
	}

	public void insert(int key) {
		int hash = hashFunction(key);
		table[hash].add(key);
		size++;

		if (getLoadFactor() > LOAD_FACTOR_THRESHOLD) {
			rehash();
		}
	}

	private double getLoadFactor() {
		return (double) size / TABLE_SIZE;
	}

	private void rehash() {
		System.out.println("Rehashing triggered...");
		LinkedList<Integer>[] oldTable = table;
		TABLE_SIZE *= 2; // Double the table size
		table = new LinkedList[TABLE_SIZE];

		// Initialize the new table
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = new LinkedList<>();
		}

		// Reset size before reinserting elements
		size = 0;

		// Reinsert all elements from the old table to the new table
		for (LinkedList<Integer> bucket : oldTable) {
			for (int key : bucket) {
				insert(key); // Use the insert method to add elements to the new table
			}
		}
	}

	public boolean search(int key) {
		int hash = hashFunction(key);
		return table[hash].contains(key);
	}

	public void delete(int key) {
		int hash = hashFunction(key);
		if (table[hash].remove(Integer.valueOf(key))) {
			size--;
		}
	}

	public void displayTable() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.println("Bucket " + i + ": " + table[i]);
		}
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(10);
		ht.insert(20);
		ht.insert(15);
		ht.insert(30);
		ht.insert(40); // Trigger rehashing when adding more elements
		ht.insert(50);
		ht.insert(60);
		ht.displayTable();
		ht.insert(70);

		ht.displayTable();

		System.out.println("Search 15: " + ht.search(15));
		ht.delete(15);
		System.out.println("Search 15 after deletion: " + ht.search(15));
	}
}