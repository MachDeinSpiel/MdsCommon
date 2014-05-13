package de.hsbremen.mds.common.valueobjects;

import java.io.Serializable;

/**
 * @author chumbawamba!
 */

//TODO: diese Klasse löschen
public class MdsItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4299417337934597749L;
	private String name;
	private String imagePath;
	
	public MdsItem(String name, String imagePath) {
			this.name = name;
			this.imagePath = imagePath;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
