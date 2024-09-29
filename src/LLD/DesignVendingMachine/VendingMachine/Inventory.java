package LLD.DesignVendingMachine.VendingMachine;

public class Inventory {
    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        intialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }
    public void intialEmptyInventory() {
        int startCode = 101;
        for(int i=0;i<inventory.length;i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == code) {
                itemShelf.item = item;
                itemShelf.setSoldOut(false);
            } else {
                throw new Exception("already item is present, you cannot add item here");
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == code) {
                if(itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid item code");
    }

    public void updateSoldOutItem(int code) {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == code) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
