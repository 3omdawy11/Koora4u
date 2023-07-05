<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expire",0);
		
		HttpSession s = request.getSession();
		if (s.getAttribute("user") == null)
		{
			request.getRequestDispatcher("loginPage.jsp").forward(request,response);
		}

	%>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        :root {
            --color-primary: #0073ff;
            --color-white: #e9e9e9;
            --color-black: #141d28;
            --color-black-1: #212b38;
            --color-green: #3cb371;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: sans-serif;
        }

        .logo {
            float: left;
            width: 100px;
            height: 80px;
        }

        .menu-bar {
            background-color: var(--color-green);
            height: 80px;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 5%;
            position: relative;
        }

        .menu-bar ul {
            list-style: none;
            display: flex;
        }

        .menu-bar ul li {
            padding: 10px 30px;
            position: relative;
        }

        .menu-bar ul li a {
            font-size: 20px;
            color: var(--color-white);
            text-decoration: none;
            transition: all 0.3s;
        }

        .menu-bar ul li a:hover {
            color: var(--color-black);
        }

        .fas {
            float: right;
            margin-left: 10px;
            padding-top: 3px;
        }

        /* dropdown menu style */

        .dropdown-menu {
            display: none;
        }

        .menu-bar ul li:hover .dropdown-menu {
            display: block;
            position: absolute;
            left: 0;
            top: 100%;
            background-color: var(--color-green);
        }

        .menu-bar ul li:hover .dropdown-menu ul {
            display: block;
            margin: 10px;
        }

        .menu-bar ul li:hover .dropdown-menu ul li {
            width: 150px;
            padding: 10px;
        }
    </style>
</head>
<body>
    <div class="menu-bar">
        <a href="#menu-bar">
            <img class="logo" src="Koora4u.png" alt="Go To MainMenu">
        </a>
        <ul>
            <li><a href="MainMenu.jsp">Home</a></li>
            <li><a href="matchPage.jsp">Matches</a></li>
            <li><a href="competitionPage.jsp">Competitions</a></li>
            <li><a href="transfersPage.jsp">Transfers</a></li>
            <li><a href="logoutServlet">Logout</a></li>
        </ul>
    </div>
    
</body>
</html>
