import exceptions.ProductParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;

public class Product {

    private String title;
    private BigDecimal unitPrice;
    private long size;
    private String description;

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
            throw new ProductParseException("Error parsing price");
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

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", unitPrice=" + unitPrice +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }
}
