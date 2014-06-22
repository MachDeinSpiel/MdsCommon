package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.List;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;

public class MdsMiniAppAction implements MdsActionExecutable {

	private static final String identNotFound = "Error";
	
	public MdsInfoObject mdsA;
	
	public MdsMiniAppAction(String game, String text, List<String> buttons) {
		// set Name
		String i = game.equals("") ? identNotFound : game;
		mdsA = new MdsInfoObject(MdsInfoObject.InfoType.MdsMiniApp, i, "", null, buttons);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(mdsA);
	}

}
