<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
    body {
        background-color: #E3F2FD;
    }
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background-color: white;
        padding: 40px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        text-align: left;
        width: 100%;
    }
    input[type=text], input[type=password] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-bottom: 20px;
    }
    button[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button[type=submit]:hover {
        background-color: #45a049;
    }
    .img-container {
        display: flex;
        justify-content: space-between;
        margin-top: 30px;
    }
    .img-container img {
        height: 100px;
    }
</style>
</head>
<body>
    <div class="container">
        <form action="loginVerification" method="post">
            <h1>Koora4u</h1>
            <label for="username">Username:</label>
            <input type="text" name="username" placeholder="Enter Username" required>
            <label for="password">Password:</label>
            <input type="password" name="password" placeholder="Enter Password" required>
            <!-- <div>
                <input type="radio" value="admin" name="loginChoice" id="admin" required>
                <label for="admin">Admin</label>
                <input type="radio" value="user" name="loginChoice" id="user" required>
                <label for="user">User</label>
            </div> -->
            <button type="submit" name="action" value = "userLogin">Log in</button>
             
           </form>
           <form action = "loginVerification" method = "post">
           <button type = "submit" name = "action" value = "userSignUp">sign up</button>
           </form>
       
    </div>
</body>
</html>