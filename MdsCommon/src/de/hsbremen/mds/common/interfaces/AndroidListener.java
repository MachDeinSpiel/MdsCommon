package de.hsbremen.mds.common.interfaces;

import java.util.List;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public interface AndroidListener {
	
    public void onButtonClick(String buttonName);
    public void onVideoEnded(String videoName);
    public void onUserLeftGame(int id);
    
    public void onPositionChanged(double longitude, double latitude);
    
    public void updateLocalWhiteboard(List<String> keys, WhiteboardEntry entry);
}

/*
class Responder implements AndroidListener {
    @Override
    public void onEvent(event) {
        System.out.println(event.getName());
    }
    
    @Override
    public void onPositionChanged(loc){
    	loc.getLatitude();
    }
}
*/
