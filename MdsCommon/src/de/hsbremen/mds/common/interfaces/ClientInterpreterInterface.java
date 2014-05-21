package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.whiteboard.Whiteboard;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;
import de.hsbremen.mds.common.whiteboard.WhiteboardUpdateObject;

public interface ClientInterpreterInterface {
	   public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry value);
	   public void onFullWhiteboardUpdate(WebSocket conn, List<WhiteboardUpdateObject> wb);
}
