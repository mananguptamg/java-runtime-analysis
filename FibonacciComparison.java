public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30;
        long startTime = System.nanoTime();
        fibonacciRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = (endTime - startTime) / 1_000_000;

        startTime = System.nanoTime();
        fibonacciIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = (endTime - startTime) / 1_000_000;

        System.out.println("Time taken to print fibonacci series upto " +n+ " using recursive method is " +recursiveTime+ " ms");
        System.out.println("Time taken to print fibonacci series upto " +n+ " using iterative method is " +iterativeTime+ " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
