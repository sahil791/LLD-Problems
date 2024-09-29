package LLD.DesignVendingMachine.VendingMachine;

public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    public final int value;
    Coin(int value) {
        this.value = value;
    }
}
