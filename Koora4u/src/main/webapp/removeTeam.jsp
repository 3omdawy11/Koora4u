<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Team" %>
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team List</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    
    tr:hover {background-color: #f5f5f5;}
    
    .btn {
        padding: 5px 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>Team Name</th>
            <th>Manager</th>
            <th>Stadium</th>
            <th>Country</th>
            <th></th>
        </tr>
        <%
            ArrayList<Team> teams = db.getTeams();
            for (Team team : teams) {
        %>
        <tr>
            <td><%= team.getName() %></td>
            <td><%= team.getManager() %></td>
            <td><%= team.getStadium() %></td>
            <td><%= team.getCountry() %></td>
            <td>
                <form action="removeTeamServlet" method="get">
                    <input type="hidden" name="teamName" value="<%=team.getName()%>">
                    <input class="action-button" type="submit" value="Remove Team">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
 --%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Team" %>
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team List</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    
    th, td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    
    tr:hover {
        background-color: #e1e1e1;
    }
    
    .btn {
        padding: 8px 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        border-radius: 4px;
    }

    .btn:hover {
        background-color: #45a049;
    }

    .return-link {
        display: inline-block;
        margin-top: 10px;
        color: #4CAF50;
        text-decoration: none;
        font-weight: bold;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>Team Name</th>
            <th>Manager</th>
            <th>Stadium</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        <%
            ArrayList<Team> teams = db.getTeams();
            for (Team team : teams) {
        %>
        <tr>
            <td><%= team.getName() %></td>
            <td><%= team.getManager() %></td>
            <td><%= team.getStadium() %></td>
            <td><%= team.getCountry() %></td>
            <td>
                <form action="removeTeamServlet" method="get">
                    <input type="hidden" name="teamName" value="<%=team.getName()%>">
                    <input class="btn" type="submit" value="Remove">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a class="return-link" href="manageTeams.jsp">Return to Manage Teams</a>
</body>
</html>
