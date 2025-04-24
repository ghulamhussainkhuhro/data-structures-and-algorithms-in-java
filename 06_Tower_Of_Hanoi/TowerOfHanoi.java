package TowerOfHanoi;

import java.util.Stack;

public class TowerOfHanoi {

    private int numDisks;
    private Stack<Integer>[] rods;  // To store the disks on the rods

    public TowerOfHanoi(int numDisks) {
        this.numDisks = numDisks;

        // Initialize the rods as stacks
        rods = new Stack[3];
        for (int i = 0; i < 3; i++) {
            rods[i] = new Stack<>();
        }

        // Push all disks onto the first rod (Rod 0)
        for (int i = numDisks; i >= 1; i--) {
            rods[0].push(i);
        }
    }

    // Move the disk from source rod to destination rod
    public void moveDisk(int fromRod, int toRod) {
        if (!rods[fromRod].isEmpty()) {
            int disk = rods[fromRod].pop();
            rods[toRod].push(disk);
            System.out.println("Move disk " + disk + " from rod " + fromRod + " to rod " + toRod);
        } else {
            System.out.println("Error: No disk to move from rod " + fromRod);
        }
    }

    // Recursive Tower of Hanoi algorithm
    public void solveHanoi(int n, int fromRod, int toRod, int auxRod) {
        if (n == 1) {
            moveDisk(fromRod, toRod);
            return;
        }

        // Move n-1 disks from fromRod to auxRod using toRod as auxiliary
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from fromRod to toRod
        moveDisk(fromRod, toRod);

        // Move the n-1 disks from auxRod to toRod using fromRod as auxiliary
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        // Number of disks
        int numDisks = 3;

        TowerOfHanoi hanoi = new TowerOfHanoi(numDisks);

        // Solve the Tower of Hanoi problem
        hanoi.solveHanoi(numDisks, 0, 2, 1);  // Move disks from rod 0 to rod 2 using rod 1 as auxiliary
    }
}
