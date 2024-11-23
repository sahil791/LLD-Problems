package LLD.DesignAmazon;

public class Product {
    private String name;
    private String desc;
    private double price;
    private ProductCategory productCategory;
    private int availableCount;
    private Account seller;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public Account getSeller() {
        return seller;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
}
