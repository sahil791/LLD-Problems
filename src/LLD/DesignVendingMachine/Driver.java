package LLD.DesignVendingMachine;

import LLD.DesignVendingMachine.VendingMachine.*;
import LLD.DesignVendingMachine.VendingStates.State;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("|");
            System.out.println("filing up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Clicking on insert coin");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.DIME);
            vendingState.insertCoin(vendingMachine, Coin.NICKLE);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("Clicking on product selection");
            System.out.println("|");

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception exception) {
            displayInventory(vendingMachine);
        }
    }

    public static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        int itemIndex = 0;
        for(ItemShelf itemShelf : slots) {
            Item item = new Item();
            if(itemIndex >= 0 && itemIndex < 3) {
                item.setItem(ItemType.PEPSI);
                item.setPrice(20);
            }
            if(itemIndex >= 3 && itemIndex < 6) {
                item.setItem(ItemType.COKE);
                item.setPrice(30);
            }
            if(itemIndex >= 6 && itemIndex < 10) {
                item.setItem(ItemType.SODA);
                item.setPrice(10);
            }
            slots[itemIndex].setItem(item);
            slots[itemIndex].setSoldOut(false);
            itemIndex++;
        }
    }

    public static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(ItemShelf itemShelf : slots) {
            System.out.println("Code Number: "+itemShelf.getCode() +
                    " Item: "+itemShelf.getItem().getItem().name() +
                    " Price: "+itemShelf.getItem().getPrice() +
                    " isAvailable: "+!itemShelf.isSoldOut());
        }
    }
}
