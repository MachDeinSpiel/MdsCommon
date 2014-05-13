package de.hsbremen.mds.common.exception;

public class UnknownWhiteboardTypeException extends Exception{
	
	public UnknownWhiteboardTypeException(String s){
		super("Nicht behandelter Typ im Whiteboardvalue: " + s);
	}
}
