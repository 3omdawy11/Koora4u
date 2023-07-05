package objects;

public class Ticket {
	
	protected int id;
	protected String ticketUsername;
	protected String ticketTeam1;
	protected String ticketTeam2;
	protected String ticketCompetition;
	protected String ticketStadium;
	protected String ticketDate;
	protected String ticketTime;
	protected int ticketAvailable;
	public Ticket(int id, String ticketUsername, String ticketTeam1, String ticketTeam2, String ticketCompetition,
			String ticketStadium, String ticketDate, String ticketTime, int ticketAvailable) {
		
		this.id = id;
		this.ticketUsername = ticketUsername;
		this.ticketTeam1 = ticketTeam1;
		this.ticketTeam2 = ticketTeam2;
		this.ticketCompetition = ticketCompetition;
		this.ticketStadium = ticketStadium;
		this.ticketDate = ticketDate;
		this.ticketTime = ticketTime;
		this.ticketAvailable = ticketAvailable;
	}
	public int getId() {
		return id;
	}
	
	public String getTicketUsername() {
		return ticketUsername;
	}
	public void setTicketUsername(String ticketUsername) {
		this.ticketUsername = ticketUsername;
	}
	public String getTicketTeam1() {
		return ticketTeam1;
	}
	public void setTicketTeam1(String ticketTeam1) {
		this.ticketTeam1 = ticketTeam1;
	}
	public String getTicketTeam2() {
		return ticketTeam2;
	}
	public void setTicketTeam2(String ticketTeam2) {
		this.ticketTeam2 = ticketTeam2;
	}
	public String getTicketCompetition() {
		return ticketCompetition;
	}
	public void setTicketCompetition(String ticketCompetition) {
		this.ticketCompetition = ticketCompetition;
	}
	public String getTicketStadium() {
		return ticketStadium;
	}
	public void setTicketStadium(String ticketStadium) {
		this.ticketStadium = ticketStadium;
	}
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}
	public int getTicketAvailable() {
		return ticketAvailable;
	}
	public void setTicketAvailable(int ticketAvailable) {
		this.ticketAvailable = ticketAvailable;
	}

}
