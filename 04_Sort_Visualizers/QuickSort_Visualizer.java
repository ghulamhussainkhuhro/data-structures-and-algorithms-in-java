package Sort_Visualizers;

import javax.swing.*;
import java.awt.*;

public class QuickSort_Visualizer extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] array;
    private int barWidth;
    private int delay;

    public QuickSort_Visualizer(int[] array, int delay) {
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
            quickSort(0, array.length - 1);
        }).start();
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            repaint();
            sleep();

            quickSort(low, pi - 1);  // Recursively sort elements before partition
            quickSort(pi + 1, high);  // Recursively sort elements after partition
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
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
        JFrame frame = new JFrame("Quick Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500 + 10);
        }

        QuickSort_Visualizer visualizer = new QuickSort_Visualizer(array, 50);
        frame.add(visualizer);
        frame.setVisible(true);

        visualizer.visualizeSort();
    }
}
