package models;

import exceptions.ProductParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.math.BigDecimal;

public class Product {

    private String title;
    private BigDecimal unitPrice;
    private long size;
    private String description;

    /**
     * Construct a new product
     * @param title Product title
     * @param unitPrice Product unit price in pounds
     * @param size Product page size in bytes
     * @param description Product description
     */
    public Product(String title, BigDecimal unitPrice, long size, String description) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.size = size;
        this.description = description;
    }

    /**
     * Construct a new product by parsing its HTML product page
     * @param productDocument HTML product page
     * @param size Product page size in bytes
     * @throws ProductParseException
     */
    public Product(Document productDocument, long size) throws ProductParseException {
        Element productElement = productDocument.body();
        title = parseTitle(productElement);
        unitPrice = parseUnitPrice(productElement);
        this.size = size;
        description = parseDescription(productElement);
    }

    private String parseTitle(Element productElement) throws ProductParseException {
        Element titleElement = productElement.select("h1").first();
        if(titleElement != null) {
            return titleElement.text();
        } else {
            throw new ProductParseException("Error parsing title");
        }
    }

    private BigDecimal parseUnitPrice(Element productElement) throws ProductParseException {
        Element unitPriceElement = productElement.select(".pricePerUnit").first();
        if(unitPriceElement != null) {
            String unitPriceString = unitPriceElement.text().replace("£", "").replace("/unit", "");
            return new BigDecimal(unitPriceString);
        } else {
            throw new ProductParseException("Error parsing unit price");
        }
    }

    private String parseDescription(Element productElement) throws ProductParseException {
        Element titleElement = productElement.select(".productText").first();
        if(titleElement != null) {
            return titleElement.text();
        } else {
            throw new ProductParseException("Error parsing description");
        }
    }

    /**
     * @return product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return product title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return product unit price in pounds
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @return product page size in bytes
     */
    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "models.Product{" +
                "title='" + title + '\'' +
                ", unitPrice=" + unitPrice +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }
}
