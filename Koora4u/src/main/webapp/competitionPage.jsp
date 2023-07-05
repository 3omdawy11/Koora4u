<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.teams_in_competition" %>

<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>

<html>
<head>
<meta charset="UTF-8">
<title>League Table</title>
<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expire",0);
		
		HttpSession s = request.getSession();
		if (s.getAttribute("user") == null)
		{
			request.getRequestDispatcher("loginPage.jsp").forward(request,response);
		}

	%>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}
h1 {
    text-align: center;
}
form {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}
label {
    font-weight: bold;
    margin-right: 10px;
}
select {
    padding: 5px;
    margin-right: 10px;
}
button {
    padding: 5px 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
table {
    border-collapse: collapse;
    margin: 20px auto;
}
th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
th {
    background-color: #4CAF50;
    color: white;
}
tr:nth-child(even) {
    background-color: #f2f2f2;
}
</style>
</head>
<body>
    <h1>League Table</h1>
    <form method="get">
        <label for="league">Select a league:</label>
        <select id="league" name="league">
            <option value="Premier League 2020/2021">Premier League 2020/2021</option>
            <option value="La Liga 2020/2021">La Liga 2020/2021</option>
            <option value="Bundesliga 2020/2021">Bundesliga 2020/2021</option>
            <option value="Serie A 2020/2021">Serie A 2020/2021</option>
            <option value="Ligue 1 2020/2021">Ligue 1 2020/2021</option>
        </select>
        <button type="submit">View League Table</button>
    </form>
    <br>
    <% 
        String league = request.getParameter("league");
        if (league != null) {
            ArrayList<teams_in_competition> teams = db.printLeagueTable(league);
            if (teams.isEmpty()) {
                out.print("<p>No teams found for " + league + "</p>");
            } else {
                out.print("<table>");
                out.print("<tr><th>Team Name</th><th>Points</th></tr>");
                for (teams_in_competition t : teams) {
                    out.print("<tr><td>" + t.getTeamName() + "</td><td>" + t.getPoints() + "</td></tr>");
                }
                out.print("</table>");
            }
        }
    %>
    <a href="MainMenu.jsp">Return to the main menu</a>
</body>
</html>
