package objects;

public class User {
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String email;
	protected String phoneNumber;
	protected String password;
	protected String age;
	protected String favoriteTeam;
	protected String favoriteCompetition;

	public User(String firstName, String lastName, String userName, String email, String phoneNumber, String password, String age, String favoriteTeam, String favoriteCompetition) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.age = age;
		this.favoriteTeam = favoriteTeam;
		this.favoriteCompetition = favoriteCompetition;
		
	}
	public String getFavoriteTeam() {
		return favoriteTeam;
	}
	public void setFavoriteTeam(String favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}
	public String getFavoriteLeague() {
		return favoriteCompetition;
	}
	public void setFavoriteCompetition(String favoriteCompetition) {
		this.favoriteCompetition = favoriteCompetition;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


}
