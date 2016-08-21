import exceptions.ProductFetchException;
import fetchers.HTTPProductFetcher;
import fetchers.ProductFetcher;
import models.Products;

public class Main {

    /**
     * Run the application from the console
     * e.g., mvn compile exec:java -Dexec.args="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html
     * @param args URI of the products page
     * @throws ProductFetchException
     */
    public static void main(String[] args) throws ProductFetchException {
        String productsUri = args[0];
        ProductFetcher productFetcher = new HTTPProductFetcher(productsUri);
        Products products = productFetcher.fetchAllProducts();
        System.out.println(products.toJSON());
    }
}
