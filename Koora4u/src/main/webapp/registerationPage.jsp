<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Your Account</title>
<link href="Our CSS/css.css" rel="stylesheet" type="text/css">
<%request.getSession().removeAttribute("OTP"); %>
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
    input[type="number"],
    select {
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
    <form action="registerVerification" method="post">
        <h1>Register Your Account</h1>
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
                <td>Re-enter your password:</td>
            </tr>
            <tr>
                <td><input type="password" name="verifiedPassword" placeholder="Re-enter your password" required></td>
            </tr>
            <tr>
                <td>
                    <label for="favoriteTeam">Choose your favorite team:</label>
                    <select name="favoriteTeam" id="favoriteTeam">
                        <option value="Liverpool FC">Liverpool FC</option>
                        <option value="Chelsea FC">Chelsea FC</option>
                        <option value="Barcelona FC">Barcelona FC</option>
                        <option value="Real Madrid FC">Real Madrid FC</option>
                        <option value="Atletico Madrid FC">Atletico Madrid FC</option>
                        <option value="Manchester City FC">Manchester City FC</option>
                        <option value="Arsenal FC">Arsenal FC</option>
                        <option value="Tottenham FC">Tottenham FC</option>
                        <option value="Juventus FC">Juventus FC</option>
                        <option value="AC Milan FC">AC Milan FC</option>
                        <option value="Inter Milan FC">Inter Milan FC</option>
                        <option value="Napoli FC">Napoli FC</option>
                        <option value="Paris Saint-Germain FC">Paris Saint-Germain FC</option>
                        <option value="Lyon FC">Lyon FC</option>
                        <option value="Marseille FC">Marseille FC</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="favoriteLeague">Choose your favorite league:</label>
                    <select name="favoriteLeague" id="favoriteLeague">
                        <option value="Premier League">Premier League</option>
                        <option value="Serie A">Serie A</option>
                        <option value="Bundesliga">Bundesliga</option>
                        <option value="La Liga">La Liga</option>
                        <option value="Ligue 1">Ligue 1</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Sign up" required></td>
            </tr>
        </table>
    </form>
    <form action="registerVerification" method="post">
        <table>
            <tr>
                <td>Already have an account! <input type="submit" value="Log in" name="action"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
