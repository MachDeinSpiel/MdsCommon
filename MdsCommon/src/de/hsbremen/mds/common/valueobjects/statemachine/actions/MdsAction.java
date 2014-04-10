package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.HashMap;

/**
 * @author JG, NH, JW, SE, AB, RS, OT
 */

public class MdsAction {
	
	//Enum f�r alle g�ltigen Idents
	public static enum MdsActionIdents {
		showVideo,
		showMap,
		showText,
		showImage,
		addToGroup,
		removeFromGroup
		
		
	}
	
	//Konstanten f�r HashMap-Keys
	public static final String PARAM_URL = "url";
	public static final String PARAM_TEXT = "text";
	public static final String PARAM_DUMMY = "target";
	
	private String ident;
	private HashMap<String, String> defaults;
	
	public MdsAction (String ident,HashMap<String, String> params){
		this.ident = ident;
		this.defaults = params;
	}
	
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public HashMap<String, String> getParams() {
		return defaults;
	}
	public void setParams(HashMap<String, String> params) {
		this.defaults = params;
	}
	
}
