package de.hsbremen.mds.common.valueobjects;

public class GameResult {

	public String attribute;
	public String setWin;
	public String setLoose;
	public double addWin = 0;
	public double addLoose = 0;
	
	public GameResult(String attribute, String setWin, String setLoos, double addWin, double addLoose) {
		this.attribute = attribute;
		this.setWin = setWin;
		this.setLoose = setLoos;
		this.addWin = addWin;
		this.addLoose = addLoose;
	}

}
