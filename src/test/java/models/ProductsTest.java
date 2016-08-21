package models;

import exceptions.ProductParseException;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductsTest {

    @Test
    public void productsShouldBeSerializedToJSON() throws IOException, ProductParseException {

        Product apricots = new Product("Apricots", new BigDecimal(2.25), 2050, "Delicious apricots");
        Product lemons = new Product("Lemons", new BigDecimal(0.5), 3000, "Zesty lemons");
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(apricots);
        productsList.add(lemons);
        Products products = new Products(productsList);

        String actualJson = products.toJSON();
        String expectedJson = "{\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"title\": \"Apricots\",\n" +
                "      \"unit_price\": 2.25,\n" +
                "      \"size\": \"2.0kb\",\n" +
                "      \"description\": \"Delicious apricots\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Lemons\",\n" +
                "      \"unit_price\": 0.5,\n" +
                "      \"size\": \"2.9kb\",\n" +
                "      \"description\": \"Zesty lemons\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total\": 2.75\n" +
                "}";

        assertEquals(expectedJson, actualJson);
    }

}
