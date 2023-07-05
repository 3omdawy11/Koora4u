package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Account;
import objects.JDBC;

/**
 * Servlet implementation class JDBCserv
 */
@WebServlet("/adminRegisterationVerification")
public class adminRegisterationVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminRegisterationVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String email = request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String verifiedPassword = request.getParameter("verifiedPassword");
		int age = Integer.parseInt(request.getParameter("age"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		JDBC j = new JDBC();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (j.adminUsernameVerification(username))
		{
			out.print("this username is already taken");
			request.getRequestDispatcher("addAdmin.jsp").include(request, response);
			
		}
		else if(j.adminEmailVerification(email)) {
			out.print("this email is already taken");
			request.getRequestDispatcher("addAdmin.jsp").include(request, response);
		}
		else if (j.adminPhoneVerification(phoneNumber))
		{
			out.print("this phone number is already taken");
			request.getRequestDispatcher("addAdmin.jsp").include(request, response);
		}
		else if (!password.equals(verifiedPassword)){
			out.print("Passwords dont match");
			request.getRequestDispatcher("addAdmin.jsp").include(request, response);
		}
		else
		{
			Account admin = new Account(firstName, lastName, username, email, phoneNumber, password, age);
			j.createAdmin(admin);
			out.print("<html><body><form action=\"AdminPage.jsp\"> Admin added <input type=\"submit\" value=\"Go to Main menu\"></form></body></html>");

			
		}
		
	}

}
