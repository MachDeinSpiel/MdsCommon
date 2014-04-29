package de.hsbremen.mds.common.valueobjects.statemachine;

import java.util.HashMap;

public class MdsCondition {
	
	//Enum für alle gültigen Idents
		public static enum MdsConditionIdent {
			locationEvent,
			uiEvent,
			whiteboardEvent
			
			
		}

	private String name;
	private HashMap<String, String> params;
	private MdsConditionIdent ident;
	
	public MdsCondition(String name, HashMap<String, String> params) {
		this.name = name;
    	this.params = params;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getParams() {
		return params;
	}
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	public MdsConditionIdent getIdent() {
		return ident;
	}

	public void setIdent(MdsConditionIdent ident) {
		this.ident = ident;
	}

}
