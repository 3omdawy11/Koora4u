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
<title>Register Your Account</title>
<link href="Our CSS/css.css" rel="stylesheet" type="text/css">
<style>
    body {
        background-color: #f0fff0;
    }
    
    h1 {
        color: #008000;
    }
    
    table {
        background-color: #f0fff0;
        border-collapse: collapse;
        width: 400px;
        margin-top: 20px;
    }
    
    td {
        padding: 10px;
    }
    
    input[type="text"],
    input[type="password"],
    input[type="email"],
    input[type="number"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 14px;
    }
    
    input[type="submit"] {
        background-color: #008000;
        color: white;
        border: none;
        padding: 10px;
        cursor: pointer;
        font-size: 14px;
        border-radius: 4px;
    }
    
    input[type="submit"]:hover {
        background-color: #006400;
    }
    
    input[type="submit"]:focus {
        outline: none;
    }
</style>
</head>
<body>
<div align="center">
    <form action="adminRegisterationVerification" method="post">
        <h1>Register Your Account</h1>
        <br>
        <table>
            <tr>
                <td>First Name:</td>
            </tr>
            <tr>
                <td><input type="text" name="firstName" placeholder="Enter your first name" required></td>
            </tr>
            <tr>
                <td>Last Name:</td>
            </tr>
            <tr>
                <td><input type="text" name="lastName" placeholder="Enter your last name" required></td>
            </tr>
            <tr>
                <td>Age:</td>
            </tr>
            <tr>
                <td><input type="number" name="age" placeholder="Enter your age" required></td>
            </tr>
            <tr>
                <td>Username:</td>
            </tr>
            <tr>
                <td><input type="text" name="userName" placeholder="Enter your username" required></td>
            </tr>
            <tr>
                <td>E-mail:</td>
            </tr>
            <tr>
                <td><input type="email" name="email" placeholder="Enter your e-mail" required></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
            </tr>
            <tr>
                <td><input type="text" name="phoneNumber" value="20" maxlength="12" required></td>
            </tr>
            <tr>
                <td>Password:</td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Enter your password" required></td>
            </tr>
            <tr>
                <td>Re-enter Your Password:</td>
            </tr>
            <tr>
                <td><input type="password" name="verifiedPassword" placeholder="Re-enter your password" required></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Add Admin"></td>
            </tr>
        </table>
        <br>
        <a href="manageAdmins.jsp">Return</a>
    </form>
</div>
</body>
</html>
