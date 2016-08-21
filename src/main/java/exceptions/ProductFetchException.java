package exceptions;

/**
 * An error occurred fetching product pages or the product list
 */
public class ProductFetchException extends Exception {
    public ProductFetchException(Exception e) {
        super(e);
    }
}
