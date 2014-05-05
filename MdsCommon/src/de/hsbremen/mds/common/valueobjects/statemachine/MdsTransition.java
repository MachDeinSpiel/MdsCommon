package de.hsbremen.mds.common.valueobjects.statemachine;

/**
 * @author JG, NH, JW, SE, AB, RS, OT
 */

public class MdsTransition {
	
	private MdsState target;
	private MdsEvent event;
	private String eventName;
	
	public MdsTransition(MdsState target, MdsEvent event, String eventName){
		this.target = target;
		this.setEvent(event);
		this.setEventName(eventName);
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
	
	public MdsEvent getEvent() {
		return event;
	}
	
	public void setEvent(MdsEvent event) {
		this.event = event;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
