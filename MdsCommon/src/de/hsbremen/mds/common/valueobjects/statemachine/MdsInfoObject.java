package de.hsbremen.mds.common.valueobjects.statemachine;

import java.util.List;

public class MdsInfoObject {
	
	private String name;
	private String url;
	private String text;
	private List<String> buttons;
	private InfoType type;
	
	public static enum InfoType{
		MdsText,
		MdsImage,
		MdsVideo,
		MdsMap
	}
	
	public MdsInfoObject(InfoType type, String name, String url, String text, List<String> buttons) {
		this.name = name;
		this.url = url;
		this.text = text;
		this.buttons = buttons;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getButtons() {
		return buttons;
	}

	public void setButtons(List<String> buttons) {
		this.buttons = buttons;
	}

	public InfoType getType() {
		return type;
	}

	public void setType(InfoType type) {
		this.type = type;
	}

}
