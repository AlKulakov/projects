public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int[][] arr) {
        super(String.format("Index out of bounds! MAX x: %d, MAX y: %d", arr.length, arr[0].length));
    }
}
