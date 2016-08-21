import exceptions.ProductFetchException;
import fetchers.HTTPProductFetcher;
import fetchers.ProductFetcher;
import models.Products;

public class Main {

    public static void main(String[] args) throws ProductFetchException {
        String productsUri = args[0];
        ProductFetcher productFetcher = new HTTPProductFetcher(productsUri);
        Products products = productFetcher.fetchAllProducts();
        System.out.println(products.toJSON());
    }
}
