package Servlets;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Account;
import objects.JDBC;
import objects.User;

/**
 * Servlet implementation class loginVerification
 */
@WebServlet("/loginVerification")
public class loginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		if (action.equals("userLogin") || action.equals("userSignUp"))
		{
			if (action.equals("userSignUp"))
			{
				request.getRequestDispatcher("registerationPage.jsp").forward(request, response);
			}
			else
			{
				JDBC j = new JDBC();
				if (!(j.loginVerification(username, password, "user")))
				{	
					out.print("Wrong username or password");
					request.getRequestDispatcher("loginPage.jsp").include(request, response);
				}
				else
				{	
					System.out.println("HEELOOOO");
					JDBC db = new JDBC();
					User u = db.getUser(username, password);
					session.setAttribute("user", u);
					request.getRequestDispatcher("MainMenu.jsp").forward(request, response);
				}
			}
		}
		else
		{
			JDBC j = new JDBC();
			if (!(j.loginVerification(username, password, "admin")))
			{
				out.print("Wrong username or password");
				request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
			}
			else
			{
				JDBC db = new JDBC();
				Account a = db.getAdmin(username, password);
				session.setAttribute("admin", a);
				request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
			}
		}
		
	}

}
