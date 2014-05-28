package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.List;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;

public class MdsTextAction implements MdsActionExecutable {

	private static final String identNotFound = "Error";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	
	public MdsInfoObject mdsT;
	
	public MdsTextAction(String ident, String text, List<String> buttons) {
		// set Name
		String i = ident.equals("") ? identNotFound : ident;
		// set Text
		String t = text.equals("") ? textNotFound : text;
		mdsT = new MdsInfoObject(MdsInfoObject.InfoType.MdsText, i, "", t, buttons);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(mdsT);
	}

}
