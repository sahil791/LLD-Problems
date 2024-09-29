package LLD.DesignVendingMachine.VendingMachine;

public class Item {
    private ItemType item;
    private int price;

    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
