import exceptions.ProductFetchException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ProductFetchException {
        String productsUri = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
        ProductFetcher productFetcher = new HTTPProductFetcher(productsUri);
        List<Product> products = productFetcher.fetchAllProducts();
        System.out.println(products);
    }
}
