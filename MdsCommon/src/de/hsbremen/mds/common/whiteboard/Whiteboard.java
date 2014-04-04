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

	public void setAttributeValue(Object value, String... keys){
		getAttribute(keys).value = value;
	}
	
	public WhiteboardEntry getAttribute(String... keys){
		
		Whiteboard wb = this;
		
		for (int i = 0; i < keys.length-1; i++) {
			wb = (Whiteboard) wb.get(keys[i]).value;
		}
		
		return wb.get(keys[keys.length-1]);
	}
	

}
