package LLD.DesignVendingMachine.VendingMachine;

import LLD.DesignVendingMachine.VendingStates.Impl.IdleState;
import LLD.DesignVendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    State vendingMachineState;
    Inventory inventory;
    List<Coin> coinList;

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
