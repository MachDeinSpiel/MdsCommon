package de.hsbremen.mds.common.valueobjects.statemachine;

public class MdsQuantifier {

	private String checktype;
	private String value;
	
	public MdsQuantifier(String checktype, String value) {
		this.checktype = checktype;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getChecktype() {
		return checktype;
	}

	public void setChecktype(String checktype) {
		this.checktype = checktype;
	}

}
