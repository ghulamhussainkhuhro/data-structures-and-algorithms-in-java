package Sort_Visualizers;

import javax.swing.*;
import java.awt.*;

public class MergeSort_Visualizer extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] array;
    private int barWidth;
    private int delay;

    public MergeSort_Visualizer(int[] array, int delay) {
        this.array = array;
        this.barWidth = Math.max(1, 800 / array.length);  // Ensure bars are visible even for larger arrays
        this.delay = delay;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] + (100*i);
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);

            // Set the font and draw the values on top of each bar
            g.setColor(Color.BLACK);  // Set text color
            g.setFont(new Font("Arial", Font.BOLD, 12));  // Set font for the values
            g.drawString(String.valueOf(array[i]), i * barWidth + barWidth / 4, getHeight() - barHeight - 5);
        }
    }

    public void visualizeSort() {
        new Thread(() -> {
            mergeSort(array, 0, array.length - 1);
        }).start();
    }

    // Merge Sort Implementation
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge two sorted subarrays array[left..mid] and array[mid+1..right]
    private void merge(int[] array, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            repaint();
            sleep();  // Adding delay to visualize the merge process
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            repaint();
            sleep();
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            repaint();
            sleep();
        }
    }

    // Delay the sorting to visualize it clearly
    private void sleep() {
        try {
            Thread.sleep(delay);  // Slow down the sorting process for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Merge Sort Visualization with Values");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[] array = {12, 11, 13, 14, 7, 6};
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int) (Math.random() * 500 + 10);
//        }

        MergeSort_Visualizer visualizer = new MergeSort_Visualizer(array, 1000);
        frame.add(visualizer);
        frame.setVisible(true);

        visualizer.visualizeSort();
    }
}

