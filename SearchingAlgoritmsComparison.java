import java.util.Arrays;
import java.util.Random;

public class SearchingAlgoritmsComparison {

    // Generate an array of 1000 random integers
    public static int[] generateRandomArray(int size, int bound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // Generates numbers between 0 and bound-1
        }
        return array;
    }

    // Linear Search to find the target
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Binary Search to find the target
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid; // Return index if found
            } else if (array[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        int size = 1000;
        int bound = 1000; // Range of random numbers
        int[] array = generateRandomArray(size, bound);

        int target = array[55]; // Marking target element

        // Measure time taken by Linear Search
        long startTime = System.nanoTime();
        int indexFromLinearSearch = linearSearch(array, target);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        // Sort the array for Binary Search
        Arrays.sort(array);

        // Measure time taken by Binary Search
        startTime = System.nanoTime();
        int indexFromBinarySearch = binarySearch(array, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        // Display results
        System.out.println("Target Value: " + target);
        System.out.println("Linear Search Index: " + indexFromLinearSearch + " and Time Taken " + linearTime + " ns");
        System.out.println("Binary Search Index: " + indexFromBinarySearch + " and Time Taken " + binaryTime + " ns");
    }
}
