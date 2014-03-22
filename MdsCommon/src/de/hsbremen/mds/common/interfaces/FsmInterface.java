package de.hsbremen.mds.common.interfaces;

import de.hsbremen.mds.common.valueobjects.statemachine.MdsState;

/**
 * @author JW
 */
public interface FsmInterface {
	

	
	/*
	 * Der Interpreter wird vom Fsmmgr immer �ber das fsminterface angesprochen (eventing),
	 * Der benachrichtigte ist also der Interpreter
	 * 
	 */
	
	/*
	 * �ndert sich der State im fsm sollen alle listener benachrichtigt werden (alle = interpreter)
	 */
	void onStateChange(MdsState state);
	
	//TODO: Moar Funktions
}
