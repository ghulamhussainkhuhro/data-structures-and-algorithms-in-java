package BinarySearchTree;

public class BinarySearchTree {
	private int key;
	private BinarySearchTree left, right;
	public static final BinarySearchTree NIL = new BinarySearchTree();

	private BinarySearchTree() {
		left = right = this;
	}

	public BinarySearchTree(int key) {
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

	public BinarySearchTree grow(int key) {
		if (this == NIL)
			return new BinarySearchTree(key);
		if (key == this.key)
			return this; // prevent key duplication
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		return this;
	}

	public boolean search(int key) {
		if (this == NIL)
			return false;
		if (key == this.key)
			return true;
		if (key < this.key)
			return left.search(key);
		else
			return right.search(key);
	}

	public BinarySearchTree delete(int key) {
		if (this == NIL)
			return this;
		if (key < this.key)
			left = left.delete(key);
		else if (key > this.key)
			right = right.delete(key);
		else {
			if (left == NIL)
				return right;
			if (right == NIL)
				return left;
			BinarySearchTree temp = findMin(right);
			this.key = temp.key;
			right = right.delete(temp.key);
		}
		return this;
	}

	private BinarySearchTree findMin(BinarySearchTree node) {
		while (node.left != NIL) {
			node = node.left;
		}
		return node;
	}

	public void inOrderTraversal() {
		if (this != NIL) {
			left.inOrderTraversal();
			System.out.print(key + " ");
			right.inOrderTraversal();
		}
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
		int height = height();
		for (int i = 0; i <= height; i++) {
			printLevel(this, i); 
		}
	}

	// Helper method to print nodes at a specific level
	private void printLevel(BinarySearchTree node, int level) {
		if (node == NIL)
			return; // Base case, do nothing if NIL
		if (level == 0) {
			System.out.print(node.key + " ");
		} else {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}
	}

//	 Method to calculate the height of the tree
	public int height() {
		int leftHeight = (left != NIL) ? left.height() : -1;
		int rightHeight = (right != NIL) ? right.height() : -1;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(18);
		
		System.out.println(bst);

		System.out.println("In-order Traversal:");
		bst.inOrderTraversal(); // 3 5 7 10 12 15 18
		System.out.println();
		System.out.println("Height is :" + bst.height());

		System.out.println("Pre-order Traversal:");
		bst.preOrderTraversal(); // 10 5 3 7 15 12 18
		System.out.println();

		System.out.println("Post-order Traversal:");
		bst.postOrderTraversal(); // 3 7 5 12 18 15 10
		System.out.println();

		System.out.println("Level-order Traversal:");
		bst.levelOrder(); // 10 5 15 3 7 12 18
		System.out.println();

		System.out.println("Search for 7: " + bst.search(7)); // true
		System.out.println("Search for 20: " + bst.search(20)); // false

		bst.delete(10);
		System.out.println("In-order Traversal after deleting 10:");
		bst.inOrderTraversal(); // 3 5 7 12 15 18
	}

}
