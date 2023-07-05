package objects;

public class Team {
	protected String name;
	protected String manager;
	protected String stadium;
	protected String Country;
	public Team(String name, String manager, String stadium, String Country) {
		this.name = name;
		this.manager = manager;
		this.stadium = stadium;
		this.Country = Country;
	}
	public String getName() {
		return name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public void setName(String name) {
		this.name = name;
	}

}
