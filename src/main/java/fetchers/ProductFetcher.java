package fetchers;

import exceptions.ProductFetchException;
import models.Products;

public interface ProductFetcher {
    Products fetchAllProducts() throws ProductFetchException;
}
