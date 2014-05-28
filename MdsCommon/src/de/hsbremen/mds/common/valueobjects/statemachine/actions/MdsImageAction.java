package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.List;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;

public class MdsImageAction implements MdsActionExecutable {

	private static final String videoNotFoundURL = "http://thisvideoisnotfound.com";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	private static final String identNotFound = "Error";
	
	public MdsInfoObject img;
	
	public MdsImageAction(String ident, String url, String text, List<String> buttons) {	
		
		// set Name
		String i = ident.equals("") ? identNotFound : ident;
		// set URL
		String u = url.equals("") ? videoNotFoundURL : url;
		// set Text
		String t = text.equals("") ? textNotFound : text;
		img = new MdsInfoObject(MdsInfoObject.InfoType.MdsImage, i, u, t, buttons);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(img);
	}

}
