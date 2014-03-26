package de.hsbremen.mds.common.interfaces;

import de.hsbremen.mds.common.valueobjects.statemachine.MdsEvent;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsState;

/**
 * @author JW
 */
public interface FsmInterface {
	
	void onStateChange(MdsState next, MdsState current);

	public MdsState checkEvents();

	void addStateChangedListener(InterpreterInterface interpreter);
	
	/**
 	* 
 	* @return die nächste action
 	*/

	
	
	//TODO: Moar Funktions
}
