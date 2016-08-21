import exceptions.ProductFetchException;
import fetchers.HTTPProductFetcher;
import fetchers.ProductFetcher;
import models.Products;

public class Main {

    public static void main(String[] args) throws ProductFetchException {
        String productsUri = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
        ProductFetcher productFetcher = new HTTPProductFetcher(productsUri);
        Products products = productFetcher.fetchAllProducts();
        System.out.println(products.toJSON());
    }
}
