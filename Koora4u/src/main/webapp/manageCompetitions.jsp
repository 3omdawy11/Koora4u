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
<title>Manage Competitions</title>
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
    <form>
        <h1>Manage Competitions</h1>
        <a href="addCompetition.jsp">Add Competition</a><br>
        <a href="removeCompetition.jsp">Remove Competition</a><br>
        <a href="AdminPage.jsp">Return to Admin Main Menu</a>
    </form>
</body>
</html>
