package LLD.DesignSwitch.SwitchStates;

import LLD.DesignSwitch.Switch;

public class OffState implements State {
    @Override
    public void toggle(Switch switchContext) {
        System.out.println("Turning On");
        switchContext.setSwitchState(new OnState());
    }
}
