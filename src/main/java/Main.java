import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public final static String PRODUCTS_URI = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    public static void main(String[] args) throws IOException {
        Document productsDocument = Jsoup.connect(PRODUCTS_URI).get();
        Elements productLinkElements = productsDocument.select(".product h3 a");

        for(Element productLinkElement : productLinkElements) {
            String productUri = productLinkElement.attr("href");
            Document productDocument = Jsoup.connect(productUri).get();
            Product product = new Product(productDocument);
            System.out.println(product);
        }
    }
}
