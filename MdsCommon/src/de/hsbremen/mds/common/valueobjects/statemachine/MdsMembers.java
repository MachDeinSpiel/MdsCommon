package de.hsbremen.mds.common.valueobjects.statemachine;

import java.util.HashMap;

/**
 * @author SE, AB
 */

public class MdsMembers {

	private HashMap<Object, Object> members;

	public MdsMembers(HashMap<Object, Object> members) {
		this.setMembers(members);
	}

	public HashMap<Object, Object> getMembers() {
		return members;
	}

	public void setMembers(HashMap<Object, Object> members) {
		this.members = members;
	}
}
