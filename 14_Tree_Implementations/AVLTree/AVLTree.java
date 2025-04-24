package AVLTree;



public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();

	private AVLTree() {
		left = right = this;
		height = -1;
	}

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.right = right;
		this.left = left;

		height = 1 + Math.max(left.height, right.height);
	}

	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	public String toString() {
		if (this == NIL)
			return " ";
		return left + " " + key + " " + right;
	}

	public boolean add(int key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;
	}

	public AVLTree grow(int key) {

		if (this == NIL)
			return new AVLTree(key);
		if (key == this.key)
			return this; // prevent key duplication
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	private void rebalance() {
		if (right.height > left.height + 1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		} else if (left.height > right.height + 1) {
			if (left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
	
	public void preOrderTraversal() {
		if (this != NIL) {
			System.out.print(key + " ");
			left.preOrderTraversal();
			right.preOrderTraversal();
		}
	}

	public void postOrderTraversal() {
		if (this != NIL) {
			left.postOrderTraversal();
			right.postOrderTraversal();
			System.out.print(key + " ");
		}
	}


	public void levelOrder() {
		if (this == NIL)
			return;
		int height = this.height;
		for (int i = 0; i <= height; i++) {
			printLevel(this, i); 
			System.out.println();
		}
	}

	// Helper method to print nodes at a specific level
	private void printLevel(AVLTree node, int level) {
		if (node == NIL)
			return; // Base case, do nothing if NIL
		if (level == 0) {
			System.out.print(node.key + " ");
		} else {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}
	}


	public static void main(String[] args) {
		 AVLTree avlt = new AVLTree(15);

		    // Add elements to the AVL Tree
		    avlt.add(8);
		    avlt.add(20);
		    avlt.add(7);
		    avlt.add(9);
		    avlt.add(13);
		    avlt.add(5);
		    
//		    avlt.add(135);
//		    avlt.add(70);
//		    avlt.add(60);
//		    avlt.add(75);

		    // Print the tree structure using toString()
		    System.out.println("Tree structure: " + avlt);
		    System.out.println("level:");
		    avlt.levelOrder();
		    System.out.println("post");
		    avlt.postOrderTraversal();
		    System.out.println("pre");
		    avlt.preOrderTraversal();

		    // Check the size of the tree
		    System.out.println("Tree size: " + avlt.size());

		    // Check if adding an element works and prevents duplicates
		    boolean added = avlt.add(32); // Adding a duplicate element
		    System.out.println("Was new element added? " + added);  // Should be false

		    // Add a new element and check size again
		    added = avlt.add(50);
		    System.out.println("Was new element added? " + added);  // Should be true
		    System.out.println("Tree size after adding 50: " + avlt.size());

		    // Final structure of the tree
		    System.out.println("Final tree structure: " + avlt.toString());

	}

}
