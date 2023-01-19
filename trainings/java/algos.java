import java.util.Scanner;

import java.util.Scanner;

public class algos {
    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        int firstNumber = 34;
        int secondNumber = 12;
        System.out.print("Print N: ");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        double result = Math.pow(
                ((firstNumber + 1) * (secondNumber + 1) - firstNumber - secondNumber - firstNumber * secondNumber), N);
        System.out.println(result);
    }
}
