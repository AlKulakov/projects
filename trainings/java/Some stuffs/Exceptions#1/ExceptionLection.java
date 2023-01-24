public class ExceptionLection {
    public static void main(String[] args) {
        String word = "Bastard";
        if (word.equals("Bastard")) {
            throw new ShitException(word);
        }
    }
}