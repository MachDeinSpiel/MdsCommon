package de.hsbremen.mds.common.valueobjects.statemachine;




/**
 * @author JG, NH, JW, SE, AB, RS, OT
 */

public class MdsTransition {
	
	private MdsState target;
	private MdsCondition condition;
	private EventType eventType;
	
	//Enum für alle gültigen Idents
	public static enum EventType {
		locationEvent,
		uiEvent,
		whiteboardEvent	
	}
	
	public MdsTransition(MdsState target, EventType eventType){
		this.target = target;
		this.setEventType(eventType);
	}
	
	public MdsTransition(MdsState target){
		this.target = target;
	}
	
	public MdsState getTarget() {
		return target;
	}
	
	public void setTarget(MdsState target) {
		this.target = target;
	}
	
	public EventType getEventType() {
		return eventType;
	}
	
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public MdsCondition getCondition() {
		return condition;
	}

	public void setCondition(MdsCondition condition) {
		this.condition = condition;
	}
}
