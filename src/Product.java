import java.time.format.DateTimeFormatter;

public class Product {
    private String description;
    private String gtin;
    private String supplierName;
    private float price;
    private int orderId;
    private DateTimeFormatter date;

    public Product(String description, String gtin, String supplierName, float price, int orderId, DateTimeFormatter date) {
        this.description=description;
        this.gtin=gtin;
        this.supplierName=supplierName;
        this.price=price;
        this.orderId=orderId;
        this.date=date;
    }

    public Product(String supplierName, Float price, String gtin, String description, int orderId) {
        this.description=description;
        this.gtin=gtin;
        this.supplierName=supplierName;
        this.price=price;
        this.orderId=orderId;
    }

    public Product() {

    }

    public int getOrderId() {
        return orderId;
    }

    public Float getPrice() {
        return price;
    }

    public String getGtin() {
        return gtin;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getDescription() {
        return description;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", gtin='" + gtin + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", price=" + price +
                ", orderId=" + orderId +
                '}';
    }
}
