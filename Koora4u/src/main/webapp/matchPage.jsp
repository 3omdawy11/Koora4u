 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Match" %>
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Match Information</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Competition</th>
            <th>Stadium</th>
            <th>Home Team</th>
            <th>Away Team</th>
            <th>Actions</th>
        </tr>
        <% 
        ArrayList<Match> matches = db.printMatches();
        for (Match match : matches) {
            boolean found = db.foundTicket(match.getDate(), match.getTime(), match.getCompetitionName(), match.getStadium(), match.getHomeTeam(), match.getAwayTeam());
            
        %>
        <tr>
            <td><%= match.getDate() %></td>
            <td><%= match.getTime() %></td>
            <td><%= match.getCompetitionName() %></td>
            <td><%= match.getStadium() %></td>
            <td><%= match.getHomeTeam() %></td>
            <td><%= match.getAwayTeam() %></td>
            <td>
                <form action="bookMatch.jsp" method="get">
                    <input type="hidden" name="date" value="<%= match.getDate() %>">
                    <input type="hidden" name="time" value="<%= match.getTime() %>">
                    <input type="hidden" name="competition" value="<%= match.getCompetitionName() %>">
                    <input type="hidden" name="stadium" value="<%= match.getStadium() %>">
                    <input type="hidden" name="homeTeam" value="<%= match.getHomeTeam() %>">
                    <input type="hidden" name="awayTeam" value="<%= match.getAwayTeam() %>">
                    <% if (found) { %>
                        <button class="button" type="submit">Book Match</button>
                    <% } %>
                </form>
            </td>
        </tr>
        <% 
        }
        %>
    </table>
    <a href="MainMenu.jsp">Return to the main menu</a>
</body>
</html>
