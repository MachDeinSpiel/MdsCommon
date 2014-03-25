package de.hsbremen.mds.common.interfaces;

import de.hsbremen.mds.common.valueobjects.statemachine.MdsEvent;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsState;

/**
 * @author JW
 */
public interface FsmInterface {
	
	void onStateChange(MdsState next, MdsState current, MdsEvent e);
	
	/**
 	* 
 	* @return die nächste action
 	*/

	
	
	//TODO: Moar Funktions
}
