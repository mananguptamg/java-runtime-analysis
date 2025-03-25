import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int size = 1000;
        int target = 500; // Target element to search
        Random random = new Random();

        // Generate 1000 random numbers
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt(2000); // Generate random numbers
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Search in Array
        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long endTime = System.nanoTime();
        long arrayTime = (endTime - startTime);

        // Search in HashSet
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        long hashSetTime = (endTime - startTime);

        // Search in TreeSet
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        long treeSetTime = (endTime - startTime);

        System.out.println("Array Time: " + arrayTime + " nanoseconds | Found: " + foundInArray);
        System.out.println("HashSet Time: " + hashSetTime + " nanoseconds | Found: " + foundInHashSet);
        System.out.println("TreeSet Time: " + treeSetTime + " nanoseconds    | Found: " + foundInTreeSet);
    }

    // Linear search in array
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
