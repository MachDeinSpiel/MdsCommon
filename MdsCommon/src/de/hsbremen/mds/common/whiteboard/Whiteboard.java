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
	 * @param value Wert, den das Attribut erhalten soll
	 * @param keys Schlüssel für das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 */
	public void setAttributeValue(Object value, String... keys){
		getAttribute(keys).value = value;
	}
	
	
	/**
	 * Setzt ein Attribut des Whiteboards als ganzen Eintrag sammt Wert und Sichtbarkeit.
	 * Das zusetzende Attribut wird durch nacheinander Einsetzen des Schlüssel des Parameters keys erreicht,
	 * wenn ein Schlüssel auf ein noch nicht existierendes Whiteboard zeigt, wird dieses entsprechend angelegt .
	 * @param attribute Whiteboardeintrag, des gesetzt werden soll
	 * @param keys Schlüssel für das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 */
	public void setAttribute(WhiteboardEntry attribute, String... keys){
		Whiteboard wb = this;
		
		for (int i = 0; i < keys.length-1; i++) {
			if(!wb.containsKey(keys[i])){
				Whiteboard newWb = new Whiteboard();
				wb.put(keys[i], new WhiteboardEntry(newWb, "none"));	//TODO: Visibility besser setzen
				wb = newWb;
			}
		}
		wb.put(keys[keys.length-1], attribute);
	}
	
	
	/**
	 * Setzt die Sichtbarkeit eines Attribut des Whiteboards, indem nacheinander die Schlüssel eingesetzt werden, um ann das Attribut zu gelangen
	 * @param value Wert, den das Attribut erhalten soll
	 * @param keys Schlüssel für das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 */
	public void setAttributeVisibility(String visiblity, String... keys){
		getAttribute(keys).visibility = visiblity;
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
	
	/**
	 * Löscht einen Attribut sammt aller Unterattribute
	 * @param keys Schlüssel für das zu löschende Attribut, entweder als einzelne Attribute oder als String-Array
	 */
	public void deleteAttribute(String... keys){
		Whiteboard wb = this;
		for (int i = 0; i < keys.length-1; i++) {
			wb = (Whiteboard) wb.get(keys[i]).value;
		}
		
		wb.remove(keys[keys.length-1]);
	}
	

}
