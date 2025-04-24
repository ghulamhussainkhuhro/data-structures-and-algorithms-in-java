package TowerOfHanoi;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class TowerOfHanoi2 extends JPanel {
    private static final long serialVersionUID = 1L;
    private int numDisks;
    private Stack<Integer>[] rods;  // To store the disks on the rods
    private int delay;
    private Color[] diskColors;

    public TowerOfHanoi2(int numDisks, int delay) {
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

        // Initialize unique colors for each disk
        diskColors = new Color[numDisks];
        for (int i = 0; i < numDisks; i++) {
            diskColors[i] = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gradient background
        Graphics2D g2d = (Graphics2D) g;
        Color startColor = Color.CYAN;
        Color endColor = Color.MAGENTA;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        // Drawing the rods as vertical lines
        int rodWidth = 10;
        int rodHeight = 300;
        int baseY = getHeight() - rodHeight;

        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            int x = (i + 1) * getWidth() / 4;
            g2d.fillRect(x - rodWidth / 2, baseY, rodWidth, rodHeight);
            
            // Rod labels (A, B, C)
            String rodLabel = (i == 0) ? "A" : (i == 1) ? "B" : "C";
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.drawString(rodLabel, x - 5, baseY + rodHeight + 20);
        }

        // Drawing the base of rods
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(getWidth() / 4 - rodWidth / 2 - 50, baseY + rodHeight, getWidth() / 2 + 100, 20);

        // Drawing the disks on the rods
        for (int i = 0; i < 3; i++) {
            int x = (i + 1) * getWidth() / 4;
            Stack<Integer> rod = rods[i];

            for (int j = 0; j < rod.size(); j++) {
                int diskValue = rod.get(j);
                int diskHeight = 20;
                int diskWidth = diskValue * 30;
                int y = baseY - (j + 1) * diskHeight;

                // Color each disk differently
                g2d.setColor(diskColors[diskValue - 1]);
                g2d.fillRect(x - diskWidth / 2, y, diskWidth, diskHeight);
                
                // Disk border
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x - diskWidth / 2, y, diskWidth, diskHeight);
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

        TowerOfHanoi2 visualizer = new TowerOfHanoi2(numDisks, delay);
        frame.add(visualizer);
        frame.setVisible(true);

        // Solve the Tower of Hanoi problem
        visualizer.solveHanoi(numDisks, 0, 2, 1);  // Move disks from rod 0 to rod 2 using rod 1 as auxiliary
    }
}
