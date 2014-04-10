package de.hsbremen.mds.common.valueobjects.statemachine;

import de.hsbremen.mds.common.whiteboard.Whiteboard;

public class MdsTrigger {
	
	private Whiteboard attributes;
	
	public MdsTrigger(Whiteboard wb) {
		attributes = wb;
	}
	

	
	public Whiteboard getAttributes(){
		return attributes;
	}
	

}
