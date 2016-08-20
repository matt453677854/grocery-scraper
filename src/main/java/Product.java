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

    public Product(Element productElement) {
        this.title = getTitle(productElement);
        this.unitPrice = getUnitPrice(productElement);
        // TODO: size
        // TODO: description
    }

    private String getTitle(Element productElement) {
        Element titleElement = productElement.select("h1").first();
        return titleElement.text();
    }

    private BigDecimal getUnitPrice(Element productElement) {
        Element unitPriceElement = productElement.select(".pricePerUnit").first();
        String unitPriceString = unitPriceElement.text().replace("£", "").replace("/unit", "");
        return new BigDecimal(unitPriceString);
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
