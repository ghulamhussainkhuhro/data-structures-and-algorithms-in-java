package BinaryTree;

public class BinaryTree {
    Object root;
    BinaryTree left, right;

    public BinaryTree(Object root) {
        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public Object getRoot() {
        return root;
    }

    public void setRoot(Object root) {
        this.root = root;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public int size() {
        if (left == null && right == null)
            return 1;
        if (left == null)
            return 1 + right.size();
        if (right == null)
            return 1 + left.size();
        return 1 + left.size() + right.size();
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer(" ");
        buf.append(root);
        if (left != null) {
            buf.append(left);
        }
        if (right != null) {
            buf.append(right);
        }
        return buf.toString();
    }

    public void preOrder() {
        System.out.print(root + " ");
        if (left != null) left.preOrder();
        if (right != null) right.preOrder();
    }

    public void inOrder() {
        if (left != null) left.inOrder();
        System.out.print(root + " ");
        if (right != null) right.inOrder();
    }

    public void postOrder() {
        if (left != null) left.postOrder();
        if (right != null) right.postOrder();
        System.out.print(root + " ");
    }

    public void levelOrder() {
        int height = height();
        for (int i = 0; i <= height; i++) { // Adjusted for height starting from 0
            printLevel(i);
        }
    }

    public void printLevel(int level) {
        if (level == 0) {
            System.out.print(root + " ");
        } else {
            if (left != null) {
                left.printLevel(level - 1);
            }
            if (right != null) {
                right.printLevel(level - 1);
            }
        }
    }

    // Method to calculate the height of the tree, starting from 0
    public int height() {
        if (left == null && right == null) return 0; // No children, height is 0
        int leftHeight = (left != null) ? left.height() : -1;
        int rightHeight = (right != null) ? right.height() : -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public boolean isFull() {
        int height = this.height();
        int totalNodes = (int)Math.pow(2, height + 1) - 1;
        return this.size() == totalNodes;
    }
    
    public int countLeaves() {
        if (this.isLeaf()) {
            return 1;  // This node is a leaf, so it contributes 1 to the count
        }
        int leftLeaves = (left != null) ? left.countLeaves() : 0;
        int rightLeaves = (right != null) ? right.countLeaves() : 0;
        return leftLeaves + rightLeaves;
    }


    

    public boolean contains(Object value) {
        if (this.root.equals(value)) {
            return true;
        }
        if (this.left != null && this.left.contains(value)) {
            return true;
        }
        if (this.right != null && this.right.contains(value)) {
            return true;
        }
        return false;
    }

    public String postOrderToString() {
        StringBuilder buffer = new StringBuilder();
        if (left != null) buffer.append(left.postOrderToString());
        if (right != null) buffer.append(right.postOrderToString());
        buffer.append(root);
        return buffer.toString();
    }

    public static boolean compareTrees(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.root.equals(tree2.root) && compareTrees(tree1.left, tree2.left) && compareTrees(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        BinaryTree D = new BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree F = new BinaryTree("F");
        BinaryTree B = new BinaryTree("B", D, null);
        BinaryTree C = new BinaryTree("C", E, F);
        BinaryTree A = new BinaryTree("A", B, C);

        System.out.println("Tree structure: " + A);
        System.out.println("Is A leaf: " + A.isLeaf());
        System.out.println("Is B leaf: " + B.isLeaf());
        System.out.println("Is D leaf: " + D.isLeaf());

        System.out.println("Size of A: " + A.size());
        System.out.println("Size of B: " + B.size());
        
        System.out.println("Height of the tree is: "+A.height());

        System.out.print("Pre-order traversal: ");
        A.preOrder();
        System.out.println();

        System.out.print("In-order traversal: ");
        A.inOrder();
        System.out.println();

        System.out.print("Post-order traversal: ");
        A.postOrder();
        System.out.println();

        System.out.print("Level-order traversal: ");
        A.levelOrder();
        System.out.println();
        
        System.out.println("Check if tree A is Full: "+ A.isFull());
        System.out.println("No of leaves in tree A: "+ A.countLeaves());
    }
}
