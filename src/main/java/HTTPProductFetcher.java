import exceptions.ProductFetchException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTTPProductFetcher implements ProductFetcher {

    private String productsUri;

    public HTTPProductFetcher(String productsUri) {
        this.productsUri = productsUri;
    }

    /**
     * Fetch all products listed on products page, following each link
     * @return List of products
     * @throws ProductFetchException
     */
    public List<Product> fetchAllProducts() throws ProductFetchException {
        List<Product> products = new ArrayList<Product>();

        // TODO: retry on failure
        // TODO: tests with stub

        try {
            Document productsDocument = Jsoup.connect(productsUri).get();
            Elements productLinkElements = productsDocument.select(".product h3 a");

            for (Element productLinkElement : productLinkElements) {
                String productUri = productLinkElement.attr("href");
                Product product = fetchProduct(productUri);
                products.add(product);
            }
            return products;
        } catch(IOException ioe) {
            throw new ProductFetchException(ioe);
        }
    }

    /**
     * Fetch a single product
     * @param productUri Product URI
     * @return Product
     * @throws ProductFetchException
     */
    private Product fetchProduct(String productUri) throws ProductFetchException {
        try {
            Connection connection = Jsoup.connect(productUri);
            Document productDocument = connection.get();
            long size = connection.response().body().length();
            return new Product(productDocument, size);
        } catch(IOException ioe) {
            throw new ProductFetchException(ioe);
        }
    }
}
