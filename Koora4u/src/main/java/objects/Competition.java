package objects;

public class Competition{
	
	//protected static int id = 0;
	protected String name;
	protected String type;
	protected String country;
	protected int topScorer;
	protected int topAssister;
	protected int topCS;
	public Competition(String name, String type, String country, int topScorer, int topAssister, int topCS) {
		this.name = name;
		this.type = type;
		this.country = country;
		this.topScorer = topScorer;
		this.topAssister = topAssister;
		this.topCS = topCS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTopScorer() {
		return topScorer;
	}
	public void setTopScorer(int topScorer) {
		this.topScorer = topScorer;
	}
	public int getTopAssister() {
		return topAssister;
	}
	public void setTopAssister(int topAssister) {
		this.topAssister = topAssister;
	}
	public int getTopCS() {
		return topCS;
	}
	public void setTopCS(int topCS) {
		this.topCS = topCS;
	}

}
