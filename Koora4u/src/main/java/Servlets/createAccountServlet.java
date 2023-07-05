package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.JDBC;
import objects.User;

/**
 * Servlet implementation class createAccountServlet
 */
@WebServlet("/createAccountServlet")
public class createAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String otp = request.getParameter("OTP");
		String old = (String)request.getSession().getAttribute("number");
		PrintWriter out = response.getWriter();
		System.out.println(otp);
		System.out.println(old);
        response.setContentType("text/html");
		if (otp.equals(old))
		{
			JDBC j = new JDBC();
			String firstName = (String)request.getSession().getAttribute("firstName");
	        String lastName =  (String)request.getSession().getAttribute("lastName");
	        String userName =  (String)request.getSession().getAttribute("userName");
	        String email =  (String)request.getSession().getAttribute("email");
	        String phoneNumber =  (String)request.getSession().getAttribute("phoneNumber");
	        String password =  (String)request.getSession().getAttribute("password");
	        //String verifiedPassword = request.getParameter("verifiedPassword");
	        //String action = request.getParameter("action");
	        String favoriteTeam =  (String)request.getSession().getAttribute("favoriteTeam");
	        String favoriteCompetition =  (String)request.getSession().getAttribute("favoriteCompetition");
	        String age =  (String)request.getSession().getAttribute("age");
	        System.out.println(firstName);
	        System.out.println(lastName);
	        System.out.println(userName);
	        System.out.println(email);
	        System.out.println(phoneNumber);
	        System.out.println(password);
	        User user = new User (firstName, lastName, userName, email, phoneNumber, password, age, favoriteTeam,favoriteCompetition);
        	j.createUser(user);	
        	request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
		else
		{
			out.print("Wrong OTP entered, Please try again");
			request.getRequestDispatcher("confirmingOTP.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
