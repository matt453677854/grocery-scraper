import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private static final String HTML_FILE_ENCODING = "UTF-8";

    @Test
    public void productConstructorShouldParseTitle() throws IOException {
        String html = IOUtils.toString(this.getClass().getResourceAsStream("product.html"), HTML_FILE_ENCODING);
        Document doc = Jsoup.parseBodyFragment(html);
        Product product = new Product(doc);
        assertEquals("Sainsbury's Apricot Ripe & Ready x5", product.getTitle());
    }

    @Test
    public void productConstructorShouldParseUnitPrice() throws IOException {
        String html = IOUtils.toString(this.getClass().getResourceAsStream("product.html"), HTML_FILE_ENCODING);
        Document doc = Jsoup.parseBodyFragment(html);
        Product product = new Product(doc);
        assertEquals(new BigDecimal("3.50"), product.getUnitPrice());
    }

    @Test
    public void productConstructorShouldParseDescription() throws IOException {
        String html = IOUtils.toString(this.getClass().getResourceAsStream("product.html"), HTML_FILE_ENCODING);
        Document doc = Jsoup.parseBodyFragment(html);
        Product product = new Product(doc);
        assertEquals("Apricots", product.getDescription());
    }
}
