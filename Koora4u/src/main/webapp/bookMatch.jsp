<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		HttpSession s = request.getSession();
		if (s.getAttribute("user") == null)
		{
			request.getRequestDispatcher("loginPage.jsp").forward(request,response);
		}

	%>
<%
	String date = request.getParameter("date");
	String stadium = request.getParameter("stadium");
	String homeTeam = request.getParameter("homeTeam");
	String awayTeam = request.getParameter("awayTeam");
	String time = request.getParameter("time");
%>
	<h1>Match Booking Form</h1>
    <form action="bookingConfirmation" method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <input type="hidden" name="date" value="<%=date%>">
        <input type = "hidden" name = "time" value = "<%=time%>">
        <input type="hidden" name="stadium" value="<%=stadium%>">
        <input type="hidden" name="homeTeam" value="<%=homeTeam%>">
        <input type="hidden" name="awayTeam" value="<%=awayTeam%>">
        <button type="submit">Book Match</button>
    </form>
</body>
</html>