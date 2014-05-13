package de.hsbremen.mds.common.interfaces;

import java.util.List;

import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public interface ServerInterpreterInterface{
    public void onWhiteboardUpdate(List<String> keys, WhiteboardEntry value);
}
