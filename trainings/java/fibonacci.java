import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Scanner;

class fibonacci {
    public static void main(String... args) {
        int n = getNumber();
        System.out.println("\n\n");
        System.out.println(fibonacciFastCicle(n));
    }

    private static long fibonacciSlowRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciSlowRecursive(n - 1) + fibonacciSlowRecursive(n - 2);
    }

    private static long fibonacciFastCicle(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }

    private static int getNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число n : ");
        int n;
        while (true)
            try {
                n = scan.nextInt();
                if (n >= 0)
                    break;
                else
                    continue;
            } catch (InputMismatchException e) {
                continue;
            }
        return n;
    }

    private static void printResult(long arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(String.format("%d ", arr[i]));
    }
}