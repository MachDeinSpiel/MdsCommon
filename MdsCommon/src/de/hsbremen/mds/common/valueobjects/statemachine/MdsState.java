package de.hsbremen.mds.common.valueobjects.statemachine;

import de.hsbremen.mds.common.valueobjects.statemachine.actions.MdsAction;
import de.hsbremen.mds.interpreter.EventParser;


/**
 * @author JW, JG, NH, SE, AB, RS, OT
 */

public class MdsState {
	
	private int id;
	private String name;
	private MdsState parentState;		
	private boolean startState;
	private boolean finalsState;
	private MdsAction doAction;
	private MdsAction startAction;
	private MdsAction endAction;
	private MdsTransition[] transitions;
	
	public MdsState(int id, String name, MdsState parentState, MdsAction doAction, boolean startState, boolean finalState) {
		this.setId(id);
		this.name = name;
		this.setParentState(parentState);
		this.setDoAction(doAction);
		this.setStartState(startState);
		this.setFinalState(finalState);
	}
	
	public MdsState checkEvents(){
		
		//TODO: die transitionen des Currentstate mit dem Eventparser auf erfüllung (.)(.) prüfen dann in den nächsten state wechseln und returnen 
		for(MdsTransition t : transitions) {
			if (EventParser.checkEvent(t.getEvent(), wb.itemList.items, pos)) {
				notifyListeners(t.getTarget(), currentState);
				return t.getTarget();
			}
		}
		// wenn kein Event zutreffend war
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStartState() {
		return startState;
	}
	public void setStartState(boolean startState) {
		this.startState = startState;
	}
	public boolean isFinalsState() {
		return finalsState;
	}
	public void setFinalState(boolean finalsState) {
		this.finalsState = finalsState;
	}
	public boolean getFinalState() {
		return finalsState;
	}
	public MdsAction getDoAction() {
		return doAction;
	}
	public void setDoAction(MdsAction doAction) {
		this.doAction = doAction;
	}
	public MdsAction getStartAction() {
		return startAction;
	}
	public void setStartAction(MdsAction startAction) {
		this.startAction = startAction;
	}
	public MdsAction getEndAction() {
		return endAction;
	}
	public void setEndAction(MdsAction endAction) {
		this.endAction = endAction;
	}
	public MdsTransition[] getTransitions() {
		return transitions;
	}
	public void setTransitions(MdsTransition[] transitions) {
		this.transitions = transitions;
	}

	public MdsState getParentState() {
		return parentState;
	}

	public void setParentState(MdsState parentState) {
		this.parentState = parentState;
	}

}
