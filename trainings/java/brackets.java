import java.util.Scanner;
import java.util.InputMismatchException;

public class brackets {
    private static int n;

    public static void main(String... args) {
        scanNumber();
        brackets("", 0, 0, n);
    }

    private static void scanNumber() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите общее количество скобок: ");
                n = Math.abs(scan.nextInt());
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }
    }

    private static void brackets(String string, int leftCount, int rightCount, int count) {
        if (leftCount == n / 2 && rightCount == n / 2) {
            System.out.println(string);
        }
        System.out.println(String.format("Left: %d Right %d Count %d", leftCount, rightCount, count));
        if (count > 0 && leftCount < n / 2) {
            brackets(string + "(", leftCount + 1, rightCount, count - 1);
        }
        if (rightCount < leftCount && count > 0) {
            brackets(string + ")", leftCount, rightCount + 1, count - 1);
        }

    }
}
