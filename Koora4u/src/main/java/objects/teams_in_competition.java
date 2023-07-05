package objects;

public class teams_in_competition {
protected String teamName;
protected String competitionName;
protected int points;

	public teams_in_competition(String teamName, String competitionName, int points) {
		this.teamName = teamName;
		this.competitionName = competitionName;
		this.points = points;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
