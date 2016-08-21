package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialisers.ProductTypeAdapter;

import java.math.BigDecimal;
import java.util.List;

public class Products {

    private List<Product> results;
    private BigDecimal total;

    public Products(List<Product> products) {
        results = products;
        total = calculateTotal(products);
    }

    public BigDecimal calculateTotal(List<Product> products) {
        BigDecimal total = new BigDecimal(0);
        for(Product product : products) {
            total = total.add(product.getUnitPrice());
        }
        return total;
    }

    public String toJSON() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Product.class, new ProductTypeAdapter());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }
}
