
package de.hsbremen.mds.common.valueobjects;

import java.util.HashMap;

/**
 * @author AndroidDeppen
 * Klasse f�r MDS-Objekte
 */
public class MdsObject {

	public HashMap<String, MdsObject> attributes;
	// 0: nicht sichtbar, 1: f�r alle sichtbar, ID der jeweileigen Gruppe um diese sehen zulassen
	public int visibility;
	
	public MdsObject(HashMap<String, MdsObject> attributes, int visibility){
		this.attributes = attributes;
		this.visibility = visibility;
	}
	
	public void addAttribute(String name, MdsObject value) {
		attributes.put(name, value);
	}
	
}
