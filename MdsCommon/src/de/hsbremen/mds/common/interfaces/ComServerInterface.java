package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.whiteboard.Whiteboard;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public interface ComServerInterface {
	   public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry value);
	   public void onFullWhiteboardUpdate(Whiteboard newWhiteboard);
	   public void onWhiteboardUpdate(WebSocket conn, String value, String visibillity, String... keys);

}
