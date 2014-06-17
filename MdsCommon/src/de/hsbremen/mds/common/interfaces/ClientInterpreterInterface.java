package de.hsbremen.mds.common.interfaces;

import java.util.List;

import org.java_websocket.WebSocket;

import de.hsbremen.mds.common.guiobjects.MdsItem;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;
import de.hsbremen.mds.common.whiteboard.WhiteboardUpdateObject;

public interface ClientInterpreterInterface {
	
    public void onButtonClick(String buttonName);
    public void onVideoEnded(String videoName);
    public void onUserLeftGame(int id);
    
    public void onPositionChanged(double longitude, double latitude);
    
    public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry entry);
    public void onFullWhiteboardUpdate(List<WhiteboardUpdateObject> wb);
    
    public void onMinigameResult(int punkte, boolean gewonnen);
    
    public void useItem(MdsItem item, String identifier);
    public void dropItem(MdsItem item);
}
