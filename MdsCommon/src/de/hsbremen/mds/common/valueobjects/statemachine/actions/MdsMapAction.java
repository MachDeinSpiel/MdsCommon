package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.MdsMap;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject.InfoType;

// TODO: Vlt gar nicht benötigt?

public class MdsMapAction implements MdsActionExecutable {
	
	public MdsInfoObject map;

	public MdsMapAction(String ident, double lon, double lat) {
		
		// set Name
		String i = ident;
				
		map = new MdsInfoObject(InfoType.MdsImage, i, null, null, null);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		//TODO: Parameter?
		guiInterface.nextFragment(map);

	}

}
