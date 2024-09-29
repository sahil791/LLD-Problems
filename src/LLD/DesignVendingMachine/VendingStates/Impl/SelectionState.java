package LLD.DesignVendingMachine.VendingStates.Impl;

import LLD.DesignVendingMachine.VendingMachine.Coin;
import LLD.DesignVendingMachine.VendingMachine.Item;
import LLD.DesignVendingMachine.VendingMachine.VendingMachine;
import LLD.DesignVendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending machine is in Selection state");
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Choosing Product");
        Item item = machine.getInventory().getItem(codeNumber);
        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()) {
            paidByUser += paidByUser + coin.value;
        }
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient price, Product price "+ item.getPrice() + " and you paid "+ paidByUser);
            throw new Exception("Insufficent amount exception");
        } else if(paidByUser >= item.getPrice()) {
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
                machine.setVendingMachineState(new DispenseState());
            }
        }
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in coin dispense tray");
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned full amount back in coin dispensation tray");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }
}
