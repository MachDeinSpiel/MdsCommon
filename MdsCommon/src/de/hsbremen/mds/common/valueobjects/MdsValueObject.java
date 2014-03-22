package de.hsbremen.mds.common.valueobjects;

public class MdsValueObject extends MdsObject {

	public Object value;
	
	public MdsValueObject(String value, int visibility) {
		super(null, visibility);
		this.value = value;
	}
	
	public MdsValueObject(int value, int visibility) {
		super(null, visibility);
		this.value = value;
	}
	
}
