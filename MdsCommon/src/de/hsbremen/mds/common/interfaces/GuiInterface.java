package de.hsbremen.mds.common.interfaces;


import java.util.ArrayList;

import de.hsbremen.mds.common.guiobjects.MdsItem;
import de.hsbremen.mds.common.valueobjects.MdsImage;
import de.hsbremen.mds.common.valueobjects.MdsMap;
import de.hsbremen.mds.common.valueobjects.MdsText;
import de.hsbremen.mds.common.valueobjects.MdsVideo;

public interface GuiInterface {

        void nextFragment(MdsImage mds);
        void nextFragment(MdsVideo mds);
        void nextFragment(MdsText mds);
        void nextFragment(MdsMap mds);
        
        void showMap(ArrayList<MdsItem> items2display);
        void addToBackpack(MdsItem item);
        
        void update();
}