package LLD.DesignSwitch;

import LLD.DesignSwitch.SwitchStates.OffState;
import LLD.DesignSwitch.SwitchStates.State;


public class Switch {
    private State switchState;


    public State getSwitchState() {
        return switchState;
    }

    public void setSwitchState(State switchState) {
        this.switchState = switchState;
    }

    public Switch() {
        System.out.println("Your switch is ready to use");
        this.switchState = new OffState();
    }

    public void toggle() {
        switchState.toggle(this);
    }
}
