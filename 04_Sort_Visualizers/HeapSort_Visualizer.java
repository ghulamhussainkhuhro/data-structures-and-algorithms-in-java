package Sort_Visualizers;

import javax.swing.*;
import java.awt.*;

public class HeapSort_Visualizer extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] array;
    private int barWidth;
    private int delay;

    public HeapSort_Visualizer(int[] array, int delay) {
        this.array = array;
        this.barWidth = Math.max(1, 800 / array.length);
        this.delay = delay;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i];
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString(String.valueOf(array[i]), i * barWidth + barWidth / 4, getHeight() - barHeight - 5);
        }
    }

    public void visualizeSort() {
        new Thread(() -> {
            heapSort();
        }).start();
    }

    private void heapSort() {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(0, i);  // Move current root to end
            repaint();
            sleep();

            // Call heapify on the reduced heap
            heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2;  // right child

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(i, largest);
            repaint();
            sleep();

            // Recursively heapify the affected subtree
            heapify(n, largest);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sleep() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heap Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500 + 10);
        }

        HeapSort_Visualizer visualizer = new HeapSort_Visualizer(array, 1000);
        frame.add(visualizer);
        frame.setVisible(true);

        visualizer.visualizeSort();
    }
}
