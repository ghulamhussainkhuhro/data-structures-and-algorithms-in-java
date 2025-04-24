package TowerOfHanoi;

public class TowerOfHanoi3 {

    // Recursive function to solve Tower of Hanoi
    public static void solveTowerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case: If there's only one disk, move it from source to target rod
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        // Move n-1 disks from source rod to auxiliary rod
        solveTowerOfHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from source rod to target rod
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);

        // Move n-1 disks from auxiliary rod to target rod
        solveTowerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // Change this to any number of disks
        System.out.println("Steps to solve Tower of Hanoi for " + numberOfDisks + " disks:");
        solveTowerOfHanoi(numberOfDisks, 'A', 'C', 'B');
    }
}
