package de.hsbremen.mds.common.whiteboard;

public class InvalidWhiteboardEntryException extends Exception {
	
	private Object value;
	
	public InvalidWhiteboardEntryException(Object value){
		this.value = value;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Value for WhiteboardEntry with class "+value.getClass().toString()+". Use String or Whiteboard.";
	}
}
