class Main {
    public static void main(String[] args) {
        String[][] arr = new String[5][5];
        checkArr(arr);
    }

    private static void checkArr(String[][] arr) {
        if (arr.length > 4 || arr[0].length > 4) {
            throw new MyArraySizeException(arr);
        }
    }
}