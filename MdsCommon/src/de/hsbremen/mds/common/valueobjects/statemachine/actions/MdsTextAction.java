package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.MdsText;

public class MdsTextAction implements MdsActionExecutable {

	private static final String identNotFound = "Error";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	
	MdsText mdsT;
	
	public MdsTextAction(String ident, String text) {
		// set Name
		String i = ident.equals("") ? identNotFound : ident;
		// set Text
		String t = text.equals("") ? textNotFound : text;
		mdsT = new MdsText(i, t);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(mdsT);
	}

}
