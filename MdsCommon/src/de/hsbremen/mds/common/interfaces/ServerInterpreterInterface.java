package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

/**
 * 
 * @author ConnectionGroup
 * 
 * Für den Client - Der Interpreter-Client ruft onWhiteboardUpdate() vom "Android" auf
 *
 */
public interface ServerInterpreterInterface{
    public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry value);
}
