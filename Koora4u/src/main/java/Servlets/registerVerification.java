package Servlets;
import objects.OTP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Account;
import objects.Competition;
import objects.EmailSender;
import objects.JDBC;
import objects.Team;
import objects.User;

/**
 * Servlet implementation class registerVerification
 */
@WebServlet("/registerVerification")
public class registerVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerVerification() {
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
			
		  	String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String userName = request.getParameter("userName");
	        String email = request.getParameter("email");
	        String phoneNumber = request.getParameter("phoneNumber");
	        String password = request.getParameter("password");
	        String verifiedPassword = request.getParameter("verifiedPassword");
	        String action = request.getParameter("action");
	        String favoriteTeam = request.getParameter("favoriteTeam");
	        String favoriteCompetition = request.getParameter("favoriteLeague");
	        String age = request.getParameter("age");
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        if(action.equals("Log in")) {
	            request.getRequestDispatcher("loginPage.jsp").forward(request, response);

	        }
	        else {
	        	JDBC j = new JDBC();
	        	//make connection with database
	            //if username exist in the database return message to user to enter another username...
	            //if email exist in the database return message to user to enter another email...
	        	//Team favoriteTeam = new Team(age, age, age);
	        	//Competition favoriteCompetition = new Competition(age, age, age);
	        	if (j.checkDuplicateUsername(userName))
	        	{
	        		out.print("Username is already taken");
	        		request.getRequestDispatcher("registerationPage.jsp").include(request, response);
	        	}
	        	else if (j.checkDuplicateEmail(email))
	        	{
	        		out.print("Email already in use");
	        		request.getRequestDispatcher("registerationPage.jsp").include(request, response);
	        	}
	        	else if (!password.equals(verifiedPassword))
	        	{
	        		System.out.println("Please check the password entered");
	        		request.getRequestDispatcher("registerationPage.jsp").include(request, response);
	        	}
	        	else
	        	{
//	        		User user = new User (firstName, lastName, userName, email, phoneNumber, password, age, favoriteTeam,favoriteCompetition);
//		        	j.createUser(user);
	        		OTP o = new OTP();
	        		String number = o.generateOTP();
	        		EmailSender es = new EmailSender();
	        		es.sendEmail(email, number);
	        		request.getSession().setAttribute("firstName", firstName);
	        		request.getSession().setAttribute("lastName", lastName);
	        		request.getSession().setAttribute("userName", userName);
	        		request.getSession().setAttribute("email", email);
	        		request.getSession().setAttribute("phoneNumber", phoneNumber);
	        		request.getSession().setAttribute("password", password);
	        		request.getSession().setAttribute("age", age);
	        		request.getSession().setAttribute("favoriteTeam", favoriteTeam);
	        		request.getSession().setAttribute("favoriteCompetition", favoriteCompetition);
	        		request.getSession().setAttribute("number", number);
	        		//request.setAttribute("number", number);
		        	//request.getRequestDispatcher("loginPage.jsp").forward(request, response);
	        		request.getRequestDispatcher("confirmingOTP.jsp").forward(request, response);
	        	}
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	// Insert them into database
	            
	        }
	 }	
}

