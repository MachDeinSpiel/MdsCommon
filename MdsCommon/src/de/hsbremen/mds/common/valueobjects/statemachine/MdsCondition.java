package de.hsbremen.mds.common.valueobjects.statemachine;

import java.util.HashMap;

public class MdsCondition {
	
	public static String EXISTS = "exists";
	public static String ALL = "all";
	public static String EQUALS = "equals";
	public static String LOWEQUALS = "lowequals";
	public static String HIGHEQUALS = "highequals";
	public static String LOWER = "lower";
	public static String HIGHER = "higher";
	
	
	

	private String name;
	private HashMap<String, String> params;
	
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

	

}
