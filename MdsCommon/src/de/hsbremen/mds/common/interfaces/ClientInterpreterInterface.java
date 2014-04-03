package de.hsbremen.mds.common.interfaces;

import java.util.List;

import de.hsbremen.mds.common.whiteboard.Whiteboard;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public interface ClientInterpreterInterface {
	   public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry value);
	   public void onFullWhiteboardUpdate(Whiteboard newWhiteboard);
}
