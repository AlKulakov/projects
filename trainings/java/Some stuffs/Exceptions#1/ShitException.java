
public class ShitException extends RuntimeException {
    private String word;

    public ShitException(String word) {
        super(String.format("Oh, you have shit word [%s]", word));
        this.word = word;
    }
}
