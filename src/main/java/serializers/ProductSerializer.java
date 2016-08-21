package serializers;

import com.google.gson.*;
import models.Product;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class ProductSerializer implements JsonSerializer<Product> {

    public JsonElement serialize(final Product product, final Type t, final JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", product.getTitle());
        jsonObject.addProperty("unit_price", product.getUnitPrice());
        BigDecimal sizeInKb = new BigDecimal(String.valueOf(product.getSize()/1024.0)).setScale(1, BigDecimal.ROUND_HALF_UP);
        jsonObject.addProperty("size", sizeInKb + "kb");
        jsonObject.addProperty("description", product.getDescription());
        return jsonObject;
    }

}
