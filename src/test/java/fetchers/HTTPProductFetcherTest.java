package fetchers;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import exceptions.ProductFetchException;
import models.Product;
import models.Products;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class HTTPProductFetcherTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);
    private final String stubProductsUri = "http://127.0.0.1:8089/products";

    @Before
    public void setupHTTPStubs() throws IOException {

        // Mock products list
        String productsHtml = IOUtils.toString(this.getClass().getResourceAsStream("products.html"), "UTF-8");
        stubFor(get(urlEqualTo("/products"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html")
                        .withBody(productsHtml)));

        // Mock individual product pages
        String apricotsHtml = IOUtils.toString(this.getClass().getResourceAsStream("apricots.html"), "UTF-8");
        stubFor(get(urlEqualTo("/products/apricots"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html")
                        .withBody(apricotsHtml)));

        String avocadoHtml = IOUtils.toString(this.getClass().getResourceAsStream("avocado.html"), "UTF-8");
        stubFor(get(urlEqualTo("/products/avocado"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html")
                        .withBody(avocadoHtml)));

        String pearsHtml = IOUtils.toString(this.getClass().getResourceAsStream("pears.html"), "UTF-8");
        stubFor(get(urlEqualTo("/products/pears"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html")
                        .withBody(pearsHtml)));
    }

    @Test
    public void shouldReturnThreeResults() throws ProductFetchException, IOException {
        ProductFetcher productFetcher = new HTTPProductFetcher(stubProductsUri);
        Products products = productFetcher.fetchAllProducts();
        assertEquals(3, products.getProducts().size());
    }

    @Test
    public void shouldReturnTotalPrice() throws ProductFetchException, IOException {
        ProductFetcher productFetcher = new HTTPProductFetcher(stubProductsUri);
        Products products = productFetcher.fetchAllProducts();
        assertEquals(new BigDecimal("6.50"), products.getTotalUnitPrice());
    }

    @Test
    public void firstResultShouldBeApricots() throws ProductFetchException, IOException {
        ProductFetcher productFetcher = new HTTPProductFetcher(stubProductsUri);
        Products products = productFetcher.fetchAllProducts();
        Product apricots = products.getProducts().get(0);
        assertEquals("Sainsbury's Apricot Ripe & Ready x5", apricots.getTitle());
        assertEquals("Apricots", apricots.getDescription());
        assertEquals(44063, apricots.getSize());
        assertEquals(new BigDecimal("3.50"), apricots.getUnitPrice());
    }

}
