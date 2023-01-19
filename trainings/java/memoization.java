
import java.util.Arrays;

public class memoization {
    public static void main(String... args) {
        int n = 100;
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(fibonacciSlowRecursive(n, mem));
    }

    private static long fibonacciSlowRecursive(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];
        if (n <= 1)
            return n;
        long result = fibonacciSlowRecursive(n - 1, mem) + fibonacciSlowRecursive(n - 2, mem);
        mem[n] = result;
        return result;
    }
}
