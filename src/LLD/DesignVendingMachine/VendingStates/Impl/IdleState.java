package LLD.DesignVendingMachine.VendingStates.Impl;

import LLD.DesignVendingMachine.VendingMachine.Coin;
import LLD.DesignVendingMachine.VendingMachine.Item;
import LLD.DesignVendingMachine.VendingMachine.VendingMachine;
import LLD.DesignVendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState() {
        System.out.println("Vending machine is in Idle state");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Vending machine is in Idle state");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
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
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return null;
    }
}
