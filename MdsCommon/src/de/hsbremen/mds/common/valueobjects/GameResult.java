package de.hsbremen.mds.common.valueobjects;

public class GameResult {

	public String attribute;
	public String setWin = null;
	public String setLoose = null;
	public String addResult = null;
	public double factor = 1;
	public int minScore = -10;
	
	public GameResult(String attribute, String setWin, String setLoose, String addResult, double factor, int minScore) {
		this.attribute = attribute;
		this.setWin = setWin;
		this.setLoose = setLoose;
		this.addResult = addResult;
		if(factor != 0)
			this.factor = factor;
		this.minScore = minScore;
	}

}
