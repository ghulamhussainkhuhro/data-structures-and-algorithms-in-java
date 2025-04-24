package TowerOfHanoi;

//package Sorting;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class TowerOfHanoiVisualizer extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numDisks;
    private Stack<Integer>[] rods;  // To store the disks on the rods
    private int delay;

    public TowerOfHanoiVisualizer(int numDisks, int delay) {
        this.numDisks = numDisks;
        this.delay = delay;

        // Initialize the rods
        rods = new Stack[3];
        for (int i = 0; i < 3; i++) {
            rods[i] = new Stack<>();
        }

        // Push all disks onto the first rod (Rod 0)
        for (int i = numDisks; i >= 1; i--) {
            rods[0].push(i);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Drawing the rods as vertical lines
        int rodWidth = 10;
        int rodHeight = 300;
        int baseY = getHeight() - rodHeight;

        for (int i = 0; i < 3; i++) {
            int x = (i + 1) * getWidth() / 4;
            g.fillRect(x - rodWidth / 2, baseY, rodWidth, rodHeight);
        }

        // Drawing the disks on the rods
        for (int i = 0; i < 3; i++) {
            int x = (i + 1) * getWidth() / 4;
            Stack<Integer> rod = rods[i];

            for (int j = 0; j < rod.size(); j++) {
                int diskValue = rod.get(j);
                int diskHeight = 20;
                int diskWidth = diskValue * 30;
                int y = baseY - (j + 1) * diskHeight;
                g.setColor(Color.BLUE);
                g.fillRect(x - diskWidth / 2, y, diskWidth, diskHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x - diskWidth / 2, y, diskWidth, diskHeight);
            }
        }
    }

    // Move the disk from source rod to destination rod
    public void moveDisk(int fromRod, int toRod) {
        int disk = rods[fromRod].pop();
        rods[toRod].push(disk);
        repaint();
        sleep();  // Adding delay to visualize the move
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

    // Delay to make the moves visible
    private void sleep() {
        try {
            Thread.sleep(delay);  // Slow down the moves for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tower of Hanoi Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Number of disks and delay between moves
        int numDisks = 5;
        int delay = 500;  // Half-second delay between moves

        TowerOfHanoiVisualizer visualizer = new TowerOfHanoiVisualizer(numDisks, delay);
        frame.add(visualizer);
        frame.setVisible(true);

        // Solve the Tower of Hanoi problem
        visualizer.solveHanoi(numDisks, 0, 2, 1);  // Move disks from rod 0 to rod 2 using rod 1 as auxiliary
    }
}
