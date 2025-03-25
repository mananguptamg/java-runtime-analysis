import java.util.Arrays;
import java.util.Random;

public class SortingTechniqueComparison {

    // Generate an array of random integers
    public static int[] generateRandomArray(int size, int bound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // Generates numbers between 0 and bound-1
        }
        return array;
    }

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }

    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // Merge function for Merge Sort
    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Partition function for Quick Sort
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap elements
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap pivot into correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int size = 10000;
        int bound = 10000; // Range of random numbers
        int[] originalArray = generateRandomArray(size, bound);

        // Measure Bubble Sort time
        int[] bubbleArray = Arrays.copyOf(originalArray, size);
        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long endTime = System.nanoTime();
        long bubbleSortTime = (endTime - startTime)/1_000_000;

        // Measure Merge Sort time
        int[] mergeArray = Arrays.copyOf(originalArray, size);
        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, size - 1);
        endTime = System.nanoTime();
        long mergeSortTime = (endTime - startTime)/1_000_000;

        // Measure Quick Sort time
        int[] quickArray = Arrays.copyOf(originalArray, size);
        startTime = System.nanoTime();
        quickSort(quickArray, 0, size - 1);
        endTime = System.nanoTime();
        long quickSortTime = (endTime - startTime)/1_000_000;

        // Display results
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime + " ms");
        System.out.println("Quick Sort Time: " + quickSortTime + " ms");

    }
}

