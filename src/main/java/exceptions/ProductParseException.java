package exceptions;

public class ProductParseException extends Exception {
    public ProductParseException(String message) {
        super(message);
    }
    public ProductParseException(Exception e) {
        super(e);
    }
}
