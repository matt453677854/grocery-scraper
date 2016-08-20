import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;

public class Product {

    public static class Builder {
        // TODO: use builder pattern
    }

    private String title;
    private BigDecimal unitPrice;
    private Long size;
    private String description;

    public Product(Document productDocument) {
        Element productElement = productDocument.body();
        title = parseTitle(productElement);
        unitPrice = parseUnitPrice(productElement);
        size = null;
        description = parseDescription(productElement);
    }

    private String parseTitle(Element productElement) {
        Element titleElement = productElement.select("h1").first();
        return titleElement.text();
    }

    private BigDecimal parseUnitPrice(Element productElement) {
        Element unitPriceElement = productElement.select(".pricePerUnit").first();
        String unitPriceString = unitPriceElement.text().replace("£", "").replace("/unit", "");
        return new BigDecimal(unitPriceString);
    }

    private String parseDescription(Element productElement) {
        Element titleElement = productElement.select(".productText").first();
        return titleElement.text();
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
