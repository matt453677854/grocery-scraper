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
        ProductFetcher productFetcher = new HTTPProductFetcher();
        List<Product> products = productFetcher.fetchAllProducts();
        System.out.println(products);
    }
}
