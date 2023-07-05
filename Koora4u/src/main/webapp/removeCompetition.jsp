<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Competition List</title>
    <style>
        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            padding: 10px;
        }

        td {
            padding: 8px;
        }

        .remove-btn {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 6px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            cursor: pointer;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Competition Name</th>
            <th>Action</th>
        </tr>
        <%	
        ArrayList<String> competitions = db.getCompetitionNames();
        for (String c : competitions) {
        %>
        <tr>
            <td><%= c %></td>
            <td>
                <form action="removeCompetitionServlet" method="post">
                    <input type="hidden" name="competitionName" value="<%= c %>">
                    <input type="submit" class="remove-btn" value="Remove">
                </form>
            </td>
        </tr>
        <% } %>
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
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Competition List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            padding: 10px;
        }

        td {
            padding: 8px;
        }

        .remove-btn {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 6px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            cursor: pointer;
            border-radius: 4px;
        }

        .return-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Competition Name</th>
            <th>Action</th>
        </tr>
        <%	
        ArrayList<String> competitions = db.getCompetitionNames();
        for (String c : competitions) {
        %>
        <tr>
            <td><%= c %></td>
            <td>
                <form action="removeCompetitionServlet" method="post">
                    <input type="hidden" name="competitionName" value="<%= c %>">
                    <input type="submit" class="remove-btn" value="Remove">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <a href="manageCompetitions.jsp" class="return-link">Return to Manage Competitions</a>
</body>
</html>
 