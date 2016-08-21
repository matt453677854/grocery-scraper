package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serializers.ProductSerializer;
import serializers.ProductsSerializer;

import java.math.BigDecimal;
import java.util.List;

public class Products {

    private List<Product> products;

    /**
     * Construct a new products wrapper
     * @param products List of products
     */
    public Products(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * @return total unit price of all products
     */
    public BigDecimal getTotalUnitPrice() {
        BigDecimal total = new BigDecimal(0);
        for(Product product : products) {
            total = total.add(product.getUnitPrice());
        }
        return total;
    }

    /**
     * Serialise all products to a JSON string
     * @return
     */
    public String toJSON() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Products.class, new ProductsSerializer());
        gsonBuilder.registerTypeAdapter(Product.class, new ProductSerializer());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }
}
