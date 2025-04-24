package Basic;

import java.util.LinkedList;
import java.util.Random;

class Universal_hashing {
    private int TABLE_SIZE = 10;
    private int a, b, p = 31;  // p is a prime number larger than TABLE_SIZE
    private LinkedList<Integer>[] table;

    public Universal_hashing() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }

        // Generate random values for a and b
        Random random = new Random();
        a = random.nextInt(p - 1) + 1;  // a in range [1, p-1]
        b = random.nextInt(p);          // b in range [0, p-1]
    }

    // Universal hash function
    private int hashFunction(int key) {
        return ((a * key + b) % p) % TABLE_SIZE;
    }

    public void insert(int key) {
        int hash = hashFunction(key);
        table[hash].add(key);
    }

    public boolean search(int key) {
        int hash = hashFunction(key);
        return table[hash].contains(key);
    }

    public void delete(int key) {
        int hash = hashFunction(key);
        table[hash].remove(Integer.valueOf(key));
    }

    public void displayTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("Bucket " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
    	Universal_hashing ht = new Universal_hashing();
        ht.insert(10);
        ht.insert(20);
        ht.insert(15);
        ht.insert(30);
        ht.displayTable();

        System.out.println("Search 15: " + ht.search(15));
        ht.delete(15);
        System.out.println("Search 15 after deletion: " + ht.search(15));
    }
}
