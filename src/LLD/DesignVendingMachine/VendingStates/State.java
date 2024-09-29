package LLD.DesignVendingMachine.VendingStates;

import LLD.DesignVendingMachine.VendingMachine.Coin;
import LLD.DesignVendingMachine.VendingMachine.Item;
import LLD.DesignVendingMachine.VendingMachine.VendingMachine;

import java.util.List;

public interface State {
    void clickOnInsertCoin(VendingMachine machine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
    void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
}
