import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

public class ProductTypeAdapter extends TypeAdapter<Product> {

    @Override
    public void write(JsonWriter jsonWriter, Product product) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("title").value(product.getTitle());
        jsonWriter.name("unitPrice").value(product.getUnitPrice());
        jsonWriter.name("size").value(product.getSize()); // TODO: format in kb
        jsonWriter.name("description").value(product.getDescription());
        jsonWriter.endObject();
    }

    @Override
    public Product read(JsonReader jsonReader) throws IOException {
        throw new NotImplementedException();
    }
}
