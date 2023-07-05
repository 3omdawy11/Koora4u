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
    <title>Match Form</title>
    <style>
        form {
            width: 400px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="date"],
        input[type="time"],
        input[type="number"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <form action="addMatchServlet" method="post">
        <label for="date">Date:</label>
        <input type="text" id="date" name="date" required>

        <label for="time">Time:</label>
        <input type="text" id="time" name="time" required>

        <label for="stadium">Stadium:</label>
        <input type="text" id="stadium" name="stadium" required>

        <label for="homeTeam">Home Team:</label>
        <input type="text" id="homeTeam" name="homeTeam" required>

        <label for="awayTeam">Away Team:</label>
        <input type="text" id="awayTeam" name="awayTeam" required>

        <label for="homeScore">Home Team Score:</label>
        <input type="number" id="homeScore" name="homeScore" required>

        <label for="awayScore">Away Team Score:</label>
        <input type="number" id="awayScore" name="awayScore" required>

        <label for="competitionName">Competition Name:</label>
        <input type="text" id="competitionName" name="competitionName" required>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
