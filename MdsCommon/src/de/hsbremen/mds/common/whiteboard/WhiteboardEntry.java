package de.hsbremen.mds.common.whiteboard;

import java.io.Serializable;

/**
 * 
 * Eintrag in ein Whiteboard, bestehend aus einem Wert (value), der 
 * ein weiteres Whiteboard, ein Set oder ein anderen Wert sein kann, und
 * einem Wert für die Sichtbarkeit (visibility)
 * 
 * @author Interpreter
 *
 */
public class WhiteboardEntry implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8411200425558570022L;
	
	public Object value;
	public String visibility;
	
	public WhiteboardEntry(Object value, String visibility) throws InvalidWhiteboardEntryException{
		if(!(value instanceof String || value instanceof Whiteboard)){
			throw new InvalidWhiteboardEntryException(value);
		}else{
			this.value = value;
			this.visibility = visibility;
		}
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) throws InvalidWhiteboardEntryException {
		if(!(value instanceof String || value instanceof Whiteboard)){
			throw new InvalidWhiteboardEntryException(value);
		}else{
			this.value = value;
		}
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

}
