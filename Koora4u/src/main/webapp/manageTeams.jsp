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
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Teams</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        padding: 20px;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 20px;
        border: 1px solid #dddddd;
        border-radius: 4px;
    }

    a {
        display: block;
        margin-bottom: 10px;
        padding: 8px 16px;
        font-size: 14px;
        font-weight: bold;
        text-transform: uppercase;
        background-color: #4caf50;
        border: none;
        color: #ffffff;
        cursor: pointer;
        border-radius: 4px;
        text-decoration: none;
        text-align: center;
    }

    a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<%
    String choice = request.getParameter("choice");
    String link = choice + ".jsp";
%>
<form>
    <a href="addTeam.jsp">Add Team</a>
    <a href="removeTeam.jsp">Delete Team</a>
    <a href="AdminPage.jsp">Return to Main Menu</a>
</form>
</body>
</html>
