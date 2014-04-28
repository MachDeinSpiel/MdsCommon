package de.hsbremen.mds.common.valueobjects.statemachine;




/**
 * @author JG, NH, JW, SE, AB, RS, OT
 */

public class MdsTransition {
	
	private MdsState target;
	private MdsEvent event;
	private MdsCondition condition;
	
	public MdsTransition(MdsState target, MdsEvent event){
		this.target = target;
		this.setEvent(event);
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

	public MdsCondition getCondition() {
		return condition;
	}

	public void setCondition(MdsCondition condition) {
		this.condition = condition;
	}
}
