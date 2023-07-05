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
<title>Team Information</title>
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

    label {
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: auto;
        padding: 8px 16px;
        font-size: 14px;
        font-weight: bold;
        text-transform: uppercase;
        background-color: #4caf50;
        border: none;
        color: #ffffff;
        cursor: pointer;
        border-radius: 4px;
    }

    a {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #4caf50;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <form action="addTeamServlet" method="post">
        <label for="teamName">Team Name:</label>
        <input type="text" id="teamName" name="teamName" required>

        <label for="manager">Manager:</label>
        <input type="text" id="manager" name="manager" required>

        <label for="stadium">Stadium:</label>
        <input type="text" id="stadium" name="stadium" required>

        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required>

        <input type="submit" value="Submit">
    </form>
    <a href="manageTeams.jsp">Return to Manage Teams</a>
</body>
</html>
