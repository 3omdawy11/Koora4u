package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {

	public JDBC() {
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("connected");
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("error");
		}catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("error");
		}
		finally {
			if (connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void createUser(User u)
	{Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			PreparedStatement stmt = connection.prepareStatement("insert into user_account values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,u.getFirstName());
			stmt.setString(2,u.getLastName());
			stmt.setString(3,u.getUserName());
			stmt.setString(4,u.getEmail());
			stmt.setString(5,u.getPhoneNumber());
			stmt.setString(6,u.getPassword());
			stmt.setString(7,u.getAge());
			stmt.setString(8,u.getFavoriteTeam());
			stmt.setString(9,u.getFavoriteLeague());
			stmt.setString(10, "user");
			stmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void createCompetition(Competition c)
	{Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			PreparedStatement stmt = connection.prepareStatement("insert into competition values (?,?,?,?,?,?)");
			stmt.setString(1,c.getName());
			stmt.setString(2,c.getType());
			stmt.setString(3,c.getCountry());
			stmt.setInt(4,c.getTopScorer());
			stmt.setInt(5,c.getTopAssister());
			stmt.setInt(6,c.getTopCS());
			stmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void createMatch(Match m)
	{Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			PreparedStatement stmt = connection.prepareStatement("insert into matches values (?,?,?,?,?,?,?,?)");
			stmt.setString(1,m.getDate());
			stmt.setString(2,m.getTime());
			stmt.setString(3,m.getStadium());
			stmt.setString(4,m.getHomeTeam());
			stmt.setString(5,m.getAwayTeam());
			stmt.setInt(6,m.getHomeTeamScore());
			stmt.setInt(7,m.getAwayTeamScore());
			stmt.setString(8,m.getCompetitionName());
			stmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public boolean loginVerification(String username, String password, String type)
	{
		Connection connection = null;
		ResultSet rs = null;
		
		int flag = 0;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			if (type.equals("user"))
			{
				rs = stmt.executeQuery("SELECT Username, Password FROM user_account");
			}
			else
			{
				rs = stmt.executeQuery("SELECT Username, Password FROM admin");
			}
			
			while (rs.next())
			{ 
				if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
				{
					//System.out.println(username + " " + password);
					flag = 1;
					break;
				}
			}
			rs.close();
			
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return (flag == 1);
	}
	public boolean checkDuplicateUsername(String username)
	{
		Connection connection = null;
		boolean query = false;
		//boolean query1 = false;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Username FROM user_account WHERE Username = '"+username+"'");
			//query1 = stmt.execute("SELECT Username FROM user_account WHERE Email = \"email\"");
			//System.out.println(query);
			if (rs.next())
				query = true;
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return query;
	}
	public boolean checkDuplicateEmail(String email)
	{
		Connection connection = null;
		boolean query = false;
		//boolean query1 = false;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT Email FROM user_account WHERE Email = '"+email+"'");
			//query1 = stmt.execute("SELECT Username FROM user_account WHERE Email = \"email\"");
			//System.out.println(query);
			if (rs.next())
				query = true;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return query;
	}
	
	public ArrayList<String> getCompetitionNames()
	{
		ArrayList<String>competition = new ArrayList<>();
		Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Name FROM competition");
			while (rs.next())
			{
				competition.add(rs.getString("Name"));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return competition;
	}
	public User getUser(String username, String password) {
	    User user = null;
	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "SELECT * FROM user_account WHERE Username = ? AND Password = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, password);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            user = new User(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getString(6),
	                rs.getString(7),
	                rs.getString(8),
	                rs.getString(9)
	            );
	        }

	        rs.close();
	        statement.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return user;
	}
	public Ticket getTicket(String date,String time, String competition, String stadium, String homeTeam, String awayTeam) {
	    Ticket ticket = null;
	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "SELECT *  FROM ticket WHERE ticketDate = ? AND ticketTime = ? AND ticketCompetition = ? AND ticketStadium = ? AND ticketTeam1 = ? AND ticketTeam2 = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, date);
	        statement.setString(2, time);
	        statement.setString(3, competition);
	        statement.setString(4, stadium);
	        statement.setString(5, homeTeam);
	        statement.setString(6, awayTeam);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            ticket = new Ticket(
	            	rs.getInt(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getString(6),
	                rs.getString(7),
	                rs.getString(8),
	                rs.getInt(9)
	               
	            );
	        }

	        rs.close();
	        statement.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return ticket;
	}
	public Account getAdmin(String username, String password) {
	    Account admin = null;
	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "SELECT * FROM admin WHERE Username = ? AND Password = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, password);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            admin = new Account (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
	        }

	        rs.close();
	        statement.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return admin;
	}
	public int getPlayerID(String name) {
	    int id = 0;
	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "SELECT ID FROM player WHERE Name = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, name);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {  // Move the cursor to the next row
	            id = rs.getInt("ID");  // Retrieve the value by column name
	            System.out.println(name + " has an ID of " + id);
	        }

	        rs.close();
	        statement.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return id;
	}

	public void removeAdmin(String username) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "DELETE FROM admin WHERE Username = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, username);

	        int rowsAffected = statement.executeUpdate();
	        System.out.println(rowsAffected + " row(s) deleted.");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	public void decrementTicket(String date, String competition, String homeTeam, String awayTeam) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "SET ticketAvailable = ticketAvailable - 1\r\n"
	        		+ "WHERE ticketTeam1 = ? AND ticketTeam2 = ? AND ticketCompetition = ? AND TicketDate = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, homeTeam);
	        statement.setString(2, awayTeam);
	        statement.setString(3, competition);
	        statement.setString(4, date);

	        int rowsAffected = statement.executeUpdate();
	        System.out.println(rowsAffected + " row(s) deleted.");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	public void removeCompetition(String name) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "DELETE FROM competition WHERE Name= ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, name);

	        int rowsAffected = statement.executeUpdate();
	        System.out.println(rowsAffected + " row(s) deleted.");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	public void removeTeam(String Team) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u", "root", "Morooter@20031607");
	        System.out.println("Connected");

	        String query = "DELETE FROM team WHERE Name = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, Team);

	        int rowsAffected = statement.executeUpdate();
	        System.out.println(rowsAffected + " row(s) deleted.");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	public User saveUser(String username, String password)
	{
		User u = null;
		Connection connection = null;
		//int flag = 0;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user_account WHERE Username = '"+username+"', Password = '"+password+"'");
			
			u = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			
	
			rs.close();
			
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return u;
	}
	/*
	 * public ArrayList<teams_in_competition> printLeagueTable(String league){
	 * ArrayList<teams_in_competition> list = new ArrayList<>();
	 * 
	 * Connection connection = null; try {
	 * connection=DriverManager.getConnection("jdbc:mysql:localhost:3306/Koora4u",
	 * "root","Morooter@20031607"); Statement stmt=connection.createStatement();
	 * ResultSet result= stmt.
	 * executeQuery("SELECT * FROM teams_in_competition WHERE Competition_Name = 'Premier League 2020/2021'"
	 * ); System.out.println("query executed"); while(result.next()) {
	 * teams_in_competition t = new
	 * teams_in_competition(result.getString(1),result.getString(2),result.getInt(3)
	 * ); list.add(t); }
	 * 
	 * } catch(SQLException e) { e.printStackTrace(); } finally { if (connection
	 * !=null) { try { connection.close(); }catch (SQLException e) {
	 * e.printStackTrace(); } } } return list; }
	 */
	public ArrayList<teams_in_competition> printLeagueTable(String league){
	    ArrayList<teams_in_competition> list = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
	        String query = "SELECT * FROM teams_in_competition WHERE Competition_Name = ? ORDER BY Points DESC";
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, league);
	        result = pstmt.executeQuery();
	        System.out.println("query executed");
	        while(result.next())
	        {
	            teams_in_competition t = new teams_in_competition(result.getString(1),result.getString(2),result.getInt(3));
	            list.add(t);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return list;
	}
	public ArrayList<Match> printMatches(){
	    ArrayList<Match> list = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
	        String query = "SELECT Date, Time, Competition_Name, Stadium, Home_Team, Away_Team FROM matches";
	        pstmt = connection.prepareStatement(query);
	        result = pstmt.executeQuery();
	        System.out.println("query executed");
	        while(result.next())
	        {
	            Match m = new Match(result.getString(1), result.getString(2),result.getString(4),result.getString(5), result.getString(6),0,0,result.getString(3));
	            list.add(m);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return list;
	}
	public boolean userAvailable(String username)
	{
		boolean found = false;
		Connection connection = null;
		//int flag = 0;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user_account WHERE Username = '"+username+"'");
			while (rs.next())
			{
				found = true;
			}
			
			
	
			rs.close();
			
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return found;
	}
	public ArrayList<Account> getAdmins(){
	    ArrayList<Account> list = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
	        String query = "SELECT * FROM admin";
	        pstmt = connection.prepareStatement(query);
	        result = pstmt.executeQuery();
	        System.out.println("query executed");
	        while(result.next())
	        {
	            Account a = new Account(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7));
	            list.add(a);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return list;
	}
	public ArrayList<Team> getTeams(){
	    ArrayList<Team> list = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
	        String query = "SELECT * FROM team";
	        pstmt = connection.prepareStatement(query);
	        result = pstmt.executeQuery();
	        System.out.println("query executed");
	        while(result.next())
	        {
	            Team a = new Team(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
	            list.add(a);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return list;
	}
	public boolean adminUsernameVerification(String username)

	{

		Connection connection = null;
		boolean query = false;

	ResultSet rs = null;

	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			Statement stmt = connection.createStatement();
			rs=stmt.executeQuery("SELECT Username FROM admin WHERE Username = '"+username+"'");

			if (rs.next()) {
				query = true;
			}
			rs.close();
			stmt.close();

	}catch(SQLException e)

	{

	e.printStackTrace();

	}

	finally {

	if (connection !=null)

	{

	try {

	connection.close();

	}catch (SQLException e)

	{

	e.printStackTrace();

	}

	}

	}

	return query;

	}
	public boolean adminEmailVerification(String email)

	{

	Connection connection = null;

	boolean query = false;

	ResultSet rs = null;

	try {

	

	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");

	System.out.println("Connected");

	Statement stmt = connection.createStatement();

	rs=stmt.executeQuery("SELECT Email FROM admin WHERE Email = '"+email+"'");
	//System.out.println("Email Checked");

	if (rs.next()) {

	query = true;

	}

	rs.close();

	stmt.close();

	}catch(SQLException e)

	{

	e.printStackTrace();

	}

	finally {

	if (connection !=null)

	{

	try {

	connection.close();

	}catch (SQLException e)

	{

	e.printStackTrace();

	}

	}

	}

	return query;

	}
	public boolean adminPhoneVerification(String phonenumber)

	{

	Connection connection = null;

	boolean query = false;

	ResultSet rs = null;

	try {

	

	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");

	System.out.println("Connected");

	Statement stmt = connection.createStatement();

	rs=stmt.executeQuery("SELECT Phone_Number FROM admin WHERE Phone_Number = '"+phonenumber+"'");

	if (rs.next()) {

	query = true;

	}

	rs.close();

	stmt.close();

	}catch(SQLException e)

	{

	e.printStackTrace();

	}

	finally {

	if (connection !=null)

	{

	try {

	connection.close();

	}catch (SQLException e)

	{

	e.printStackTrace();

	}

	}

	}

	return query;

	}
	public void createAdmin(Account a)
	{Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			PreparedStatement stmt = connection.prepareStatement("insert into admin values (?,?,?,?,?,?,?)");
			stmt.setString(1,a.getFirstName());
			stmt.setString(2,a.getLastName());
			stmt.setString(3,a.getUserName());
			stmt.setString(4,a.getEmail());
			stmt.setString(5,a.getPhoneNumber());
			stmt.setString(6,a.getPassword());
			stmt.setInt(7,a.getAge());
			
			stmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void createTeam(Team t)
	{Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
			System.out.println("Connected");
			PreparedStatement stmt = connection.prepareStatement("insert into team values (?,?,?,?)");
			stmt.setString(1,t.getName());
			stmt.setString(2,t.getManager());
			stmt.setString(3,t.getStadium());
			stmt.setString(4,t.getCountry());
			
			stmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if (connection !=null)
			{
				try {
					connection.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public ArrayList<Player> getPlayers(){
	    ArrayList<Player> list = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");
	        String query = "SELECT * FROM player";
	        pstmt = connection.prepareStatement(query);
	        result = pstmt.executeQuery();
	        System.out.println("query executed");
	        while(result.next())
	        {
	            Player a = new Player(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),result.getInt(8),result.getInt(9),result.getInt(10),result.getInt(11),result.getInt(12),result.getString(13));
	            list.add(a);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return list;
	}
	public boolean foundTicket(String date, String time, String competition, String stadium, String homeTeam, String awayTeam) {
	    boolean found = false;
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet result = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Koora4u","root","Morooter@20031607");

	        String query = "SELECT * FROM ticket WHERE ticketTeam1 = ? AND ticketTeam2 = ? " +
	                       "AND ticketCompetition = ? AND ticketStadium = ? AND ticketDate = ? " +
	                       "AND ticketTime = ?";
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, homeTeam);
	        pstmt.setString(2, awayTeam);
	        pstmt.setString(3, competition);
	        pstmt.setString(4, stadium);
	        pstmt.setString(5, date);
	        pstmt.setString(6, time);
	        System.out.println(date + " " + time + " " + competition + " " + stadium + " " + homeTeam + " " + awayTeam);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	            int n = result.getInt("ticketAvailable");
	            if (n > 0)
	                found = true;
	            System.out.println(n);
	        }
	        System.out.println("found ticket here");
	        System.out.println(found);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (result != null) {
	            try {
	                result.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return found;
	}

	
	
	

}


