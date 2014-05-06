package de.hsbremen.mds.common.valueobjects;

import de.hsbremen.mds.common.valueobjects.statemachine.MdsQuantifier;

/**
 * @author AndroidDeppen
 * Klasse für MDS-Objekte
 */
public class MdsObject {

	private String name;
	private MdsQuantifier quantifier;
	
	public MdsObject(String name, MdsQuantifier quanti) {
		this.name = name;
		this.quantifier = quanti;
	}
	
	public MdsQuantifier getQuantifier() {
		return quantifier;
	}
	public void setQuantifier(MdsQuantifier quantifier) {
		this.quantifier = quantifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
