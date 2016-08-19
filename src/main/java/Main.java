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
        Elements productElements = productsDocument.select(".product");

        for(Element productElement : productElements) {
            System.out.println(productElement);
            Product product = new Product(productElement);
            System.out.println(product);
        }
    }
}
