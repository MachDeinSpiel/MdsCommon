package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.MdsMap;

// TODO: Vlt gar nicht benötigt?

public class MdsMapAction implements MdsActionExecutable {

	public MdsMapAction(String ident, double lon, double lat) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		//TODO: Parameter?
		guiInterface.nextFragment(new MdsMap("Whatever", "belongs", "here"));

	}

}
