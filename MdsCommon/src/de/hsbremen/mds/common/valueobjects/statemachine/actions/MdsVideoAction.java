package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.MdsVideo;

public class MdsVideoAction implements MdsActionExecutable {

	private static final String videoNotFoundURL = "http://thisvideoisnotfound.com";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	private static final String identNotFound = "Error";
	
	public MdsVideo vid;
	
	public MdsVideoAction(String ident, String url, String text) {	
		
		// set Name
		String i = ident.equals("") ? identNotFound : ident;
		// set URL
		String u = url.equals("") ? videoNotFoundURL : url;
		// set Text
		String t = text.equals("") ? textNotFound : text;
		vid = new MdsVideo(i, u, t);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(vid);
	}

}