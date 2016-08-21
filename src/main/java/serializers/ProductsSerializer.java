package serializers;

import com.google.gson.*;
import models.Products;

import java.lang.reflect.Type;

/**
 * JSON serializer for a collection of products, including the total unit price
 */
public class ProductsSerializer implements JsonSerializer<Products> {

    public JsonElement serialize(final Products products, final Type t, final JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("results", context.serialize(products.getProducts()));
        jsonObject.addProperty("total", products.getTotalUnitPrice());
        return jsonObject;
    }
}
