package LLD.DesignAmazon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
     List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        this.items.add(item);
        return true;
    }
}
