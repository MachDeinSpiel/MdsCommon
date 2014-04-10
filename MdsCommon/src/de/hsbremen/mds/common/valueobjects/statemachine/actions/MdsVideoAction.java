package de.hsbremen.mds.common.valueobjects.statemachine.actions;

import de.hsbremen.mds.common.interfaces.GuiInterface;
import de.hsbremen.mds.common.valueobjects.MdsVideo;

public class MdsVideoAction implements MdsActionExecutable {

	private static final String videoNotFoundURL = "http://thisvideoisnotfound.com";
	private static final String textNotFound = "Es ist ein Fehler aufgetreten";
	private static final String titleNotFound = "Video";
	
	public MdsVideo vid;
	
	public MdsVideoAction(String title, String url, String text) {	
		
		// set Name
		String i = (title.equals("") || title == null) ? title : title;
		// set URL
		String u = (url.equals("") || url == null) ? videoNotFoundURL : url;
		// set Text
		String t = (text.equals("")|| text == null) ? textNotFound : text;
		vid = new MdsVideo(title, u, t);
	}

	@Override
	public void execute(GuiInterface guiInterface) {
		guiInterface.nextFragment(vid);
	}

}
