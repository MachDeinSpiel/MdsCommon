package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import java.util.List;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsInfoObject;

public class MdsVideoAction implements MdsActionExecutable {

	private static final String videoNotFoundURL = "http://thisvideoisnotfound.com";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	private static final String titleNotFound = "Video";
	
	public MdsInfoObject vid;
	
	public MdsVideoAction(String title, String url, String text, List<String> buttons) {	
		
		// set Name
		String i = (title.equals("") || title == null) ? titleNotFound : title;
		// set URL
		String u = (url.equals("") || url == null) ? videoNotFoundURL : url;
		// set Text
		String t = (text.equals("")|| text == null) ? textNotFound : text;
		
		vid = new MdsInfoObject(MdsInfoObject.InfoType.MdsVideo, title, u, t, buttons);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(vid);
	}

}
