package de.hsbremen.mds.common.valueobjects.statemachine;


import java.util.List;

import de.hsbremen.mds.common.valueobjects.statemachine.actions.MdsAction;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;


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
	private List<MdsAction> startActions;
	private MdsAction endAction;
	private MdsTransition[] transitions;
	private List<WhiteboardEntry> subjects;
	private List<WhiteboardEntry> objects;
	
	public MdsState(int id, String name, MdsState parentState, MdsAction doAction, List<MdsAction> startActions, MdsAction endAction, boolean startState, boolean finalState) {
		this.setId(id);
		this.name = name;
		this.setParentState(parentState);
		this.setDoAction(doAction);
		this.setStartAction(startActions);
		this.setEndAction(endAction);
		this.setStartState(startState);
		this.setFinalState(finalState);
	}
	
	public MdsState checkEvents(){
		
//		// wenn kein Event zutreffend war
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
	public List<MdsAction> getStartAction() {
		return startActions;
	}
	public void setStartAction(List<MdsAction> startActions) {
		this.startActions = startActions;
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

	public List<WhiteboardEntry> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<WhiteboardEntry> subjects) {
		this.subjects = subjects;
	}

	public List<WhiteboardEntry> getObjects() {
		return objects;
	}

	public void setObjects(List<WhiteboardEntry> objects) {
		this.objects = objects;
	}

}
