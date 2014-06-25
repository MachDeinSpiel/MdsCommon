package de.hsbremen.mds.common.valueobjects;

public class GameResult {

	public String attribute;
	public String setWin = null;
	public String setLoose = null;
	public double addResult = 0;
	public double factor = 1;
	
	public GameResult(String attribute, String setWin, String setLoose, double addResult, double factor) {
		this.attribute = attribute;
		this.setWin = setWin;
		this.setLoose = setLoose;
		this.addResult = addResult;
		if(factor != 0)
			this.factor = factor;
	}

}
