package de.hsbremen.mds.common.whiteboard;

import java.util.List;
/*
 * Klasse für die Übertragungen zwischen Server und Android, der Whiteboardeinträge als ein Objekt
 */
public class WhiterboardUpdateObject {

	private List<String> keys; 
	private WhiteboardEntry value;
	
	public WhiterboardUpdateObject(List<String> keys, WhiteboardEntry value){
		this.keys = keys;
		this.value = value;
	}
	
	public List<String> getKeys() {
		return keys;
	}
	public WhiteboardEntry getValue() {
		return value;
	}
}
