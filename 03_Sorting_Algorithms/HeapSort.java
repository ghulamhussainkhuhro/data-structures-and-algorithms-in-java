package Sortings;
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {5,3,7,1,2};

        heapSort(array);

        // Print the sorted array
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);  // Move current root to end
            heapify(array, i, 0);  // Call heapify on the reduced heap
        }
    }

    public static void heapify(int[] array, int n, int i) {
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
            swap(array, i, largest);
            heapify(array, n, largest);  // Recursively heapify the affected subtree
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
