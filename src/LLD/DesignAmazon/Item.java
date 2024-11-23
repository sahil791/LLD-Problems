package LLD.DesignAmazon;

public class Item {
    private int quantity;
    private double price;

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
}
