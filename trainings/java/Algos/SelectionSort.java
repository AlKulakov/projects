public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 12, 32, 54, 10, 64, 4, 6, 1, 4, 123, 56 };
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = minIndex(arr, i);
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
            System.out.println(arrayToString(arr));
        }
    }

    private static int minIndex(int[] arr, int start) {
        int minInd = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    private static String arrayToString(int[] arr) {
        String toStr = "[";
        for (int i = 0; i < arr.length; i++) {
            toStr += arr[i];
            toStr += " ";
        }
        toStr += "]";
        return toStr;
    }
}
