package de.hsbremen.mds.common.whiteboard;

/**
 * 
 * Eintrag in ein Whiteboard, bestehend aus einem Wert (value), der 
 * ein weiteres Whiteboard, ein Set oder ein anderen Wert sein kann, und
 * einem Wert für die Sichtbarkeit (visibility)
 * 
 * @author Interpreter
 *
 */
public class WhiteboardEntry {
	
	public Object value;
	public String visibility;
	
	public WhiteboardEntry(Object value, String visibility){
		this.value = value;
		this.visibility = visibility;
	}

}
