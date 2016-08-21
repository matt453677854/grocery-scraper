import exceptions.ProductFetchException;

import java.util.List;

public interface ProductFetcher {
    Products fetchAllProducts() throws ProductFetchException;
}
