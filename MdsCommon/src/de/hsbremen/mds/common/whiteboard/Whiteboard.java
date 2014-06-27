package de.hsbremen.mds.common.whiteboard;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
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
	 * Setzt ein Attribut des Whiteboards, indem nacheinander die Schl�ssel eingesetzt werden, um ann das Attribut zu gelangen
	 * @param value Wert, den das Attribut erhalten soll
	 * @param keys Schl�ssel f�r das Whiteboard, entweder als einzelne Attribute oder als String-Array
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
	
	public void setAttributeValue(Object value, List<String> firstKeys, String... keys) throws InvalidWhiteboardEntryException{
		if(!(value instanceof String || value instanceof Whiteboard)){
			throw new InvalidWhiteboardEntryException(value);
		}else{
			WhiteboardEntry wbe = getAttribute(firstKeys, keys);
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
	 * Das zusetzende Attribut wird durch nacheinander Einsetzen des Schl�ssel des Parameters keys erreicht,
	 * wenn ein Schl�ssel auf ein noch nicht existierendes Whiteboard zeigt, wird dieses entsprechend angelegt .
	 * @param attribute Whiteboardeintrag, des gesetzt werden soll
	 * @param keys Schl�ssel f�r das Whiteboard, entweder als einzelne Attribute oder als String-Array
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
	
public void setAttribute(WhiteboardEntry attribute, List<String> firstKeys, String... keys){
		
		Whiteboard wb = this;
		
		for (int i = 0; i < firstKeys.size(); i++) {
			if(!wb.containsKey(firstKeys.get(i))){
				Whiteboard newWb = new Whiteboard();
				try {
					wb.put(firstKeys.get(i), new WhiteboardEntry(newWb, "none")); //TODO: Visibility besser setzen
				} catch (InvalidWhiteboardEntryException e) {
					e.printStackTrace();
				}	
				wb = newWb;
			}else{
				wb = (Whiteboard)(wb.getAttribute(firstKeys.get(i)).value);
			}
		}
		
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
	 * Setzt die Sichtbarkeit eines Attribut des Whiteboards, indem nacheinander die Schl�ssel eingesetzt werden, um ann das Attribut zu gelangen
	 * @param value Wert, den das Attribut erhalten soll
	 * @param keys Schl�ssel f�r das Whiteboard, entweder als einzelne Attribute oder als String-Array
	 */
	public void setAttributeVisibility(String visiblity, String... keys){
		getAttribute(keys).visibility = visiblity;
	}
	
	
	
	/**
	 * Gibt den Wert des Attributes zur�ck, dass �ber die Schl�ssel erreicht werden kann
	 * @param keys Schl�ssel f�r das Whiteboard, entweder als einzelne Attribute oder als String-Array
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
	
	public WhiteboardEntry getAttribute(List<String> firstKeys, String... keys){
		if(keys.length <= 0){
			System.err.println("Error: No key given for getting WhiteboardAttribute, please give at least one key.");
			return null;
		}
		Whiteboard wb = this;
		String allKeys = "";
		
		for(int i = 0; i < firstKeys.size(); i++) {
			WhiteboardEntry wbe = wb.get(firstKeys.get(i));
			if(wbe == null) {
				for(String key : firstKeys){
					allKeys += "."+key;
				}
				System.err.println("Error. No key ["+firstKeys.get(i)+"] found in Whiteboard. All keys:"+allKeys);
			} else {
				wb = (Whiteboard)wbe.value;
			}
		}
		
		for (int i = 0; i < keys.length-1; i++) {
			WhiteboardEntry wbe =  wb.get(keys[i]);
			if(wbe == null){
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
			System.err.println("Error. No key ["+keys[keys.length-1]+"] found in Whiteboard. All keys:"+allKeys+". Returning null, an excpetion might be thrown.");
		}
		return result;
	}
	
	/**
	 * L�scht einen Attribut sammt aller Unterattribute
	 * @param keys Schl�ssel f�r das zu l�schende Attribut, entweder als einzelne Attribute oder als String-Array
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
	
	/**
	 * Gibt den Parent des Objectes zu welchem der Key-Pfad angegeben ist
	 * @param key Schl�ssel f�r das Objekt, dessen Parent zur�ckgegeben werden soll
	 */
	public WhiteboardEntry getParent(String... keys){
		if(keys.length <= 0){
			System.err.println("Error: No key given for getting WhiteboardAttribute, please give at least one key.");
			return null;
		}
		Whiteboard wb = this;
		
		for (int i = 0; i < keys.length-2; i++) {
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
		
		WhiteboardEntry result = wb.get(keys[keys.length-2]);
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
	 * Returns the group/Whiteboard the player is in
	 * @param playerName KeyPath des Spielers, dessen Gruppe gefunden werden soll
	 * @return
	 */
	public List<String> getGroupString(String elementName) {
		
		// FIXME: nur 2 tiefen
		Whiteboard wb = this;
		List<String> keys = new Vector<String>();
		// go through the whole whiteboard and search for keyPath
		for(String key : wb.keySet()) {
			if (wb.getAttribute(key, elementName) != null) {
				keys.add(key);
				return keys;
			}
			for(String innerKey : ((Whiteboard)wb.getAttribute(key).value).keySet()) {
				if(wb.getAttribute(key, innerKey, elementName) != null) {
					keys.add(key);
					keys.add(innerKey);
					return keys;
				}
			}
		}
		System.out.println("No Group found of " + elementName + ". Returning null");
		return null;
	}
	

}
