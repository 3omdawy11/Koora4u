<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="adminMainMenuServlet" method="post">
    <h1>Hello Admin</h1>
    <a href = "manageAdmins.jsp">Manage Admins</a><br>
    <a href = "manageTeams.jsp">Manage Teams</a><br>
    <a href = "manageCompetitions.jsp">Manage Competitions</a>
      <!-- <hr>
    <input type="submit" name="manageChoice" value="manageAdmins">
    <br>
    <input type="submit" name="manageChoice" value="manageTeams">
    <br>
    <input type="submit" name="manageChoice" value="manageLeagues">
    <br><br><br><br><br><br><br><br>
    <input type="submit" name="manageChoice" value="Logout"> -->
</form>
</body>
</html>
 --%>
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
<meta charset="UTF-8">
<title>Admin Main Menu</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
    }

    h1 {
        margin-top: 50px;
    }

    a {
        display: inline-block;
        margin: 10px 0;
        font-size: 18px;
        text-decoration: none;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border-radius: 4px;
    }

    a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <form action="adminMainMenuServlet" method="post">
        <h1>Hello Admin</h1>
        <a href="manageAdmins.jsp">Manage Admins</a><br>
        <a href="manageTeams.jsp">Manage Teams</a><br>
        <a href="manageCompetitions.jsp">Manage Competitions</a><br>
        <a href="adminLogoutServlet">Log out</a>
    </form>
</body>
</html>
 