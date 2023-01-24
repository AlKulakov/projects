import java.util.Random;

class Exceptions1 {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        fillArr(arr);
        printArr(arr);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= arr.length) {
                    throw new MyArraySizeException(arr);
                }
                if (arr[i][j] == 32) {
                    throw new MyArrayDataException();
                }
            }
        }
    }

    private static void fillArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Random rand = new Random();
                arr[i][j] = rand.nextInt(0, 100);
            }
        }
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}