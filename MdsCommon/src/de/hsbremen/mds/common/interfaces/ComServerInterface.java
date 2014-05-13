package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public interface ComServerInterface {
	   public void onWhiteboardUpdate(WebSocket conn, List<String> keys, WhiteboardEntry value);

}
