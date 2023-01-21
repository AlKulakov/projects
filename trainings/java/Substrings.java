import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str.length() % 2 == 1) {
            str += "_";
        }
        String[] arr = splitStr(str);
    }

    private static String[] splitStr(String str) {
        String[] arr = new String[str.length() / 2];
        int index = 0;
        int i = 0;
        while (index < str.length()) {
            arr[i] = "" + str.charAt(index) + str.charAt(index + 1);
            index += 2;
            i++;
        }
        for (String item : arr) {
            System.out.println(item);
        }
        return arr;
    }
}