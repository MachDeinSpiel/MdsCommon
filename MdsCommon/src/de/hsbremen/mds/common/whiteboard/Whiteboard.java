package de.hsbremen.mds.common.whiteboard;

import java.util.Arrays;
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
	public void setAttributeValue(Object value, String... keys) throws InvalidWhiteboardEntryException{
		if(!(value instanceof String || value instanceof Whiteboard)){
			throw new InvalidWhiteboardEntryException(value);
		}else{
			WhiteboardEntry wbe = getAttribute(keys);
			if(wbe != null){
				wbe.value = value;
			}else{
				String keyString = "";
				for(String k : keys){
					keyString+= "."+k;
				}
				System.err.println("Error in whiteboard: can't setAttribute, keys ["+keyString+"]");
			}
		}
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
				try {
					wb.put(keys[i], new WhiteboardEntry(newWb, "none")); //TODO: Visibility besser setzen
				} catch (InvalidWhiteboardEntryException e) {
					e.printStackTrace();
				}	
				wb = newWb;
			}else{
				wb = (Whiteboard)(wb.getAttribute(keys[i]).value);
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
		if(keys.length <= 0){
			System.err.println("Error: No key given for getting WhiteboardAttribute, please give at least one key.");
			return null;
		}
		Whiteboard wb = this;
		
		for (int i = 0; i < keys.length-1; i++) {
			WhiteboardEntry wbe =  wb.get(keys[i]);
			if(wbe == null){
				String allKeys = "";
				for(String key : keys){
					allKeys += "."+key;
				}
				System.err.println("Error. No key ["+keys[i]+"] found in Whiteboard. All keys:"+allKeys);
				return null;
			}else{
				wb = (Whiteboard)wbe.value;
			}
			
		}
		
		WhiteboardEntry result = wb.get(keys[keys.length-1]);
		if(result == null){
			String allKeys = "";
			for(String key : keys){
				allKeys += "."+key;
			}
			System.err.println("Error. No key ["+keys[keys.length-1]+"] found in Whiteboard. All keys:"+allKeys+". Returning null, an excpetion might be thrown.");
		}
		return result;
	}
	
	/**
	 * Löscht einen Attribut sammt aller Unterattribute
	 * @param keys Schlüssel für das zu löschende Attribut, entweder als einzelne Attribute oder als String-Array
	 */
	public void deleteAttribute(String... keys){
		Whiteboard wb = this;
		for (int i = 0; i < keys.length-1; i++) {
			WhiteboardEntry wbe =  wb.get(keys[i]);
			if(wbe == null){
				String allKeys = "";
				for(String key : keys){
					allKeys += "."+key;
				}
				System.err.println("Error. No key ["+keys[i]+"] found in Whiteboard while deleting "+allKeys);
				return;
			}else{
				wb = (Whiteboard) wbe.value;
			}
		}
		
		wb.remove(keys[keys.length-1]);
	}
	

}
