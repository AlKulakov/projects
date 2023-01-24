class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String[][] arr) {
        super("Out of bounds!");
    }
}