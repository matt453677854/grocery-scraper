import exceptions.ProductFetchException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTTPProductFetcher implements ProductFetcher {

    private final static String PRODUCTS_URI = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    public HTTPProductFetcher() {
    }

    public List<Product> fetchAllProducts() throws ProductFetchException {
        List<Product> products = new ArrayList<Product>();

        // TODO: retry on failure

        try {
            Document productsDocument = Jsoup.connect(PRODUCTS_URI).get();
            Elements productLinkElements = productsDocument.select(".product h3 a");

            for (Element productLinkElement : productLinkElements) {
                String productUri = productLinkElement.attr("href");
                Document productDocument = Jsoup.connect(productUri).get();
                Product product = new Product(productDocument);
                products.add(product);
            }
            return products;
        } catch(IOException ioe) {
            throw new ProductFetchException(ioe);
        }
    }
}
