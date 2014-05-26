package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;
import de.hsbremen.mds.common.whiteboard.WhiteboardUpdateObject;

/**
 * 
 * @author ConnectionGroup
 * 
 * Für den Server - Wird nicht von beiden aufgerufen - ComServer -> Interpreter-Server
 *
 */
public interface ComServerInterface {
	   public void onWhiteboardUpdate(WebSocket conn, List<String> keys, WhiteboardEntry value);
	   public void onFullWhiteboardUpdate(WebSocket conn, List<WhiteboardUpdateObject> wb);
	   public boolean onNewConnection(WebSocket conn, String name);
}
