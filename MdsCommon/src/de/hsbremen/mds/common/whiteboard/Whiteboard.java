package de.hsbremen.mds.common.whiteboard;

import java.util.HashMap;
/**
 * 
 * Das Whiteboard ist eine HashMap, die einem String (key) einen Eintrag in
 * das Whiteboard (WhiteboardEntry) zuordnet.
 * 
 * @author Interpreter
 *
 */
public class Whiteboard extends HashMap<String, WhiteboardEntry>{

	/**
	 * Setzt ein Attribut des Whiteboards, indem nacheinander die Schlüssel eingesetzt werden, um ann das Attribut zu gelangen
	 * Wenn das Attribut schon exisitiert, wird es überschrieben, andernfalls wird es angelegt
	 * @param value Wert, den das Attribut erhalten soll
	 * @param keys Schlüssel für das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 */
	public void setAttributeValue(Object value, String... keys){
		getAttribute(keys).value = value;
	}
	
	/**
	 * Gibt den Wert des Attributes zurück, dass über die Schlüssel erreicht werden kann
	 * @param keys Schlüssel für das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 * @return
	 */
	public WhiteboardEntry getAttribute(String... keys){
		
		Whiteboard wb = this;
		
		for (int i = 0; i < keys.length-1; i++) {
			wb = (Whiteboard) wb.get(keys[i]).value;
		}
		
		return wb.get(keys[keys.length-1]);
	}
	

}
