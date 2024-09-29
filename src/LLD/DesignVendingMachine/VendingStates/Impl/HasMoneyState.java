package LLD.DesignVendingMachine.VendingStates.Impl;

import LLD.DesignVendingMachine.VendingMachine.Coin;
import LLD.DesignVendingMachine.VendingMachine.Item;
import LLD.DesignVendingMachine.VendingMachine.VendingMachine;
import LLD.DesignVendingMachine.VendingStates.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepting the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refunded full amount back in Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }
}
