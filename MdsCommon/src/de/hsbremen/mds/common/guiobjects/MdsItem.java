package de.hsbremen.mds.common.guiobjects;


/**
 * @author chumbawamba!
 */

public class MdsItem{

	private String name;
	private String imagePath;
	private double longitude;
	private double latitude;
	private String pathKey;
	private boolean isDroppable;
	
	public MdsItem(String name, String imagePath, String pathKey, boolean isDroppable) {	
		this.name = name;
		this.imagePath = imagePath;
		this.pathKey = pathKey;
		this.isDroppable = isDroppable;
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

	public String getPathKey() {
		return pathKey;
	}

	public void setPathKey(String pathKey) {
		this.pathKey = pathKey;
	}

	public boolean isDroppable() {
		return isDroppable;
	}

	public void setDroppable(boolean isDroppable) {
		this.isDroppable = isDroppable;
	}
}
