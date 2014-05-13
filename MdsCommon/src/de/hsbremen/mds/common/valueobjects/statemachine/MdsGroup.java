package de.hsbremen.mds.common.valueobjects.statemachine;

/**
 * @author SE, AB
 */

public class MdsGroup {

	private String name;
	private MdsMembers[] membersArray;

	public MdsGroup(String name, MdsMembers[] membersArray) {
		this.setName(name);
		this.setMembersArray(membersArray);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MdsMembers[] getMembersArray() {
		return membersArray;
	}

	public void setMembersArray(MdsMembers[] membersArray) {
		this.membersArray = membersArray;
	}
}
