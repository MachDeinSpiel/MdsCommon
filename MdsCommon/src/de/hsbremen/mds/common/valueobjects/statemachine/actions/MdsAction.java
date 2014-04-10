package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.HashMap;

/**
 * @author JG, NH, JW, SE, AB, RS, OT
 */

public class MdsAction {
	
	//Enum für alle gültigen Idents
	public static enum MdsActionIdent {
		showVideo,
		showMap,
		showText,
		showImage,
		addToGroup,
		removeFromGroup
		
		
	}
	
	//Konstanten für HashMap-Keys
	public static final String PARAM_URL = "url";
	public static final String PARAM_TEXT = "text";
	public static final String PARAM_DUMMY = "target";
	
	private MdsActionIdent ident;
	private HashMap<String, String> defaults;
	
	public MdsAction (MdsActionIdent ident,HashMap<String, String> params){
		this.ident = ident;
		this.defaults = params;
	}
	
	public MdsActionIdent getIdent() {
		return ident;
	}
	public void setIdent(MdsActionIdent ident) {
		this.ident = ident;
	}
	public HashMap<String, String> getParams() {
		return defaults;
	}
	public void setParams(HashMap<String, String> params) {
		this.defaults = params;
	}
	
}
