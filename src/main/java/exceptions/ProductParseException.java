package exceptions;

/**
 * An error occurred parsing product pages or the product list
 */
public class ProductParseException extends Exception {
    public ProductParseException(String message) {
        super(message);
    }
    public ProductParseException(Exception e) {
        super(e);
    }
}
