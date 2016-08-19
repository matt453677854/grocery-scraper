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

    @Ignore
    @Test
    public void productShouldParseUnitPrice() throws IOException {

        String html = IOUtils.toString(this.getClass().getResourceAsStream("product.xml"), HTML_FILE_ENCODING);
        Document doc = Jsoup.parseBodyFragment(html);
        Element productElement = doc.body();

        Product product = new Product(productElement);
        assertEquals(new BigDecimal(3.50), product.getUnitPrice());
    }
}
