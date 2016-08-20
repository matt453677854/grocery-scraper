import exceptions.ProductFetchException;

import java.util.List;

public interface ProductFetcher {
    List<Product> fetchAllProducts() throws ProductFetchException;
}
