package de.hsbremen.mds.common.guiobjects;

import java.io.Serializable;

/**
 * @author chumbawamba!
 */

//TODO: diese Klasse löschen
public class MdsItem{

	private String name;
	private String imagePath;
	private double longitude;
	private double latitude;
	
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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
