package de.hsbremen.mds.common.interfaces;


import java.util.ArrayList;

import de.hsbremen.mds.common.guiobjects.MdsItem;
import de.hsbremen.mds.common.valueobjects.MdsImage;
import de.hsbremen.mds.common.valueobjects.MdsMap;
import de.hsbremen.mds.common.valueobjects.MdsText;
import de.hsbremen.mds.common.valueobjects.MdsVideo;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;

public interface GuiInterface {

        void nextFragment(MdsInfoObject mds);
        
        void showMap(ArrayList<MdsItem> items2display);
        void addToBackpack(MdsItem item);
        void removeFromBackpack(MdsItem item);
        
        void update();
}