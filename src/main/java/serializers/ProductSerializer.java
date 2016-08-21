package serializers;

import com.google.gson.*;
import models.Product;

import java.lang.reflect.Type;

public class ProductSerializer implements JsonSerializer<Product> {

    public JsonElement serialize(final Product product, final Type t, final JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", product.getTitle());
        jsonObject.addProperty("unit_price", product.getUnitPrice());
        jsonObject.addProperty("size", product.getSize()/1024 + "kb");
        jsonObject.addProperty("description", product.getDescription());
        return jsonObject;
    }

}
