<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Player"%>
 <%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expire",0);
		
		HttpSession s = request.getSession();
		if (s.getAttribute("admin") == null)
		{
			request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
		}

	%>

<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
  <title>League Management</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      text-align: center;
    }

    h1 {
      margin-top: 50px;
    }

    table {
      border-collapse: collapse;
      width: 50%;
      margin: 0 auto;
    }

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    form {
      text-align: center;
      margin-top: 20px;
    }

    label {
      display: block;
      margin-bottom: 10px;
    }

    input[type="text"],
    select {
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      width: auto;
      margin-top: 10px;
      padding: 8px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    .return-link {
      display: block;
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <h1>League Management</h1>

  <form action="addingLeagueVerification" method="post">  
    <% ArrayList<Player> players = db.getPlayers(); %>
    <table>
      <tr>
        <td><label for="name">League Name:</label></td>
        <td><input type="text" id="name" name="name" required></td>
      </tr>
      <tr>
        <td><label for="type">League Type:</label></td>
        <td><input type="text" id="type" name="type" required></td>
      </tr>
      <tr>
        <td><label for="country">League Country:</label></td>
        <td><input type="text" id="country" name="country" required></td>
      </tr>
      <tr>
        <td><label for="topScorer">League Top Scorer:</label></td>
        <td>
          <select id="topScorer" name="topScorer">
            <% for (Player player : players) { %>
              <option value="<%= player.getName() %>"><%= player.getName() %></option>
            <% } %>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="topAssister">League Top Assister:</label></td>
        <td>
          <select id="topAssister" name="topAssister">
            <% for (Player player : players) { %>
              <option value="<%= player.getName() %>"><%= player.getName() %></option>
            <% } %>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="topCleanSheet">League Top Clean Sheet:</label></td>
        <td>
          <select id="topCleanSheet" name="topCleanSheet">
            <% for (Player player : players) { %>
              <option value="<%= player.getName() %>"><%= player.getName() %></option>
            <% } %>
          </select>
        </td>
      </tr>
    </table>

    <input type="submit" value="Add league">
  </form>

  <a class="return-link" href="manageCompetitions.jsp">Return to Manage Competition</a>
</body>
</html>
