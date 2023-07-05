<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Account" %>
<jsp:useBean id="db" class="objects.JDBC" scope="application"></jsp:useBean>
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
<title>Admin Accounts</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    
    th, td {
        text-align: left;
        padding: 8px;
    }
    
    th {
        background-color: #f2f2f2;
    }
    
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    
    .action-button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 6px 12px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        cursor: pointer;
    }
    
    .action-button:hover {
        background-color: #45a049;
    }
    
    .return-link {
        display: block;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Password</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <%
            ArrayList<Account> admins = db.getAdmins();
            for (Account a : admins) {
        %>
        <tr>
            <td><%= a.getFirstName() %></td>
            <td><%= a.getLastName() %></td>
            <td><%= a.getUserName() %></td>
            <td><%= a.getEmail() %></td>
            <td><%= a.getPhoneNumber() %></td>
            <td><%= a.getPassword() %></td>
            <td><%= a.getAge() %></td>
            <td>
                <form action="removingAdminServlet" method="get">
                    <input type="hidden" name="accountUsername" value="<%= a.getUserName() %>">
                    <input class="action-button" type="submit" value="Remove Admin">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a class="return-link" href="manageAdmins.jsp">Return to Manage Admins</a>
</body>
</html>
