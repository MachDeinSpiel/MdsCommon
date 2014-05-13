package de.hsbremen.mds.common.valueobjects.statemachine;

import java.util.List;

import de.hsbremen.mds.common.valueobjects.statemachine.actions.MdsAction;

public class MdsObjectContainer {

    private List<MdsAction> actions;
    private List<MdsState> states;
    
    public MdsObjectContainer(List<MdsAction> actions, List<MdsState> states) {
        this.actions = actions;
        this.states = states;
    }
    
    public List<MdsAction> getActions() {
        return actions;
    }
    public void setActions(List<MdsAction> actions) {
        this.actions = actions;
    }

    public List<MdsState> getStates() {
        return states;
    }
    public void setStates(List<MdsState> states) {
        this.states = states;
    }
    
    
}
