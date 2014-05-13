package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

/**
 * 
 * @author ConnectionGroup
 * 
 * Für den Server - Wird nicht von beiden aufgerufen - ComServer -> Interpreter-Server
 *
 */
public interface ComServerInterface {
	   public void onWhiteboardUpdate(WebSocket conn, List<String> keys, WhiteboardEntry value);
	   public boolean onNewConnection(WebSocket conn, ClientHandshake handshake);
}
