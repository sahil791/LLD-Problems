package LLD.DesignVendingMachine.VendingStates.Impl;

import LLD.DesignVendingMachine.VendingMachine.Coin;
import LLD.DesignVendingMachine.VendingMachine.Item;
import LLD.DesignVendingMachine.VendingMachine.VendingMachine;
import LLD.DesignVendingMachine.VendingStates.State;

import java.util.List;

public class DispenseState implements State {

    public DispenseState() {
        System.out.println("Currently vending machine is in dispensation state");
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return null;
    }
}
