package objects;

public class Player {
	protected String name;
	protected int id;
	protected int age;
	protected int height;
	protected String sex;
	protected int noOfGoals;
	protected int noOfAssists;
	protected int noOfCleanSheets;
	protected int noOfTotalGoals;
	protected int noOfTotalAssists;
	protected int noOfTotalCleanSheets;
	protected String teamName;
	//protected ArrayList<Trophy>trophies = new ArrayList<>();
	protected int marketValue;
	public Player(int id, String name,String sex,int age, int height, int marketValue,int noOfTotalGoals,int noOfTotalAssists, int noOfTotalCleanSheets, int noOfGoalsint,int noOfAssists, int noOfCleanSheets, String teamName) {
		//Player.id+=1;
		this.name = name;
		this.height = height;
		this.sex = sex;
		this.noOfAssists = 0;
		this.noOfCleanSheets = 0;
		this.noOfGoals = 0;
		this.noOfTotalGoals = 0;
		this.noOfTotalAssists = 0;
		this.noOfTotalCleanSheets = 0;
		this.id = id;
		this.age = age;
		this.marketValue = marketValue;
		this.teamName = teamName;
		//this.trophies = trophies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getNoOfGoals() {
		return noOfGoals;
	}
	public void setNoOfGoals(int noOfGoals) {
		this.noOfGoals = noOfGoals;
	}
	public int getNoOfAssists() {
		return noOfAssists;
	}
	public void setNoOfAssists(int noOfAssists) {
		this.noOfAssists = noOfAssists;
	}
	public int getNoOfCleanSheets() {
		return noOfCleanSheets;
	}
	public void setNoOfCleanSheets(int noOfCleanSheets) {
		this.noOfCleanSheets = noOfCleanSheets;
	}
	public int getNoOfTotalGoals() {
		return noOfTotalGoals;
	}
	public void setNoOfTotalGoals(int noOfTotalGoals) {
		this.noOfTotalGoals = noOfTotalGoals;
	}
	public int getNoOfTotalAssists() {
		return noOfTotalAssists;
	}
	public void setNoOfTotalAssists(int noOfTotalAssists) {
		this.noOfTotalAssists = noOfTotalAssists;
	}
	public int getNoOfTotalCleanSheets() {
		return noOfTotalCleanSheets;
	}
	public void setNoOfTotalCleanSheets(int noOfTotalCleanSheets) {
		this.noOfTotalCleanSheets = noOfTotalCleanSheets;
	}
	public int getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
