package exceptions;

public class ProductFetchException extends Exception {
    public ProductFetchException(Exception e) {
        super(e);
    }
}
