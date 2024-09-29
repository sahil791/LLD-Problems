package LLD.DesignSwitch.SwitchStates;

import LLD.DesignSwitch.Switch;

public class OnState implements State {

    @Override
    public void toggle(Switch switchContext) {
        System.out.println("Turning Off");
        switchContext.setSwitchState(new OffState());
    }
}
