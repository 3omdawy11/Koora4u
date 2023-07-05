package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.EmailSender;
import objects.JDBC;
import objects.User;

/**
 * Servlet implementation class bookingConfirmation
 */
@WebServlet("/bookingConfirmation")
public class bookingConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookingConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String competition = request.getParameter("competition");
		String stadium = request.getParameter("stadium");
		String homeTeam = request.getParameter("homeTeam");
		String awayTeam = request.getParameter("awayTeam");
		HttpSession s = request.getSession();
		int ticketId;
		User u = (User) s.getAttribute("user");
		if (u == null)
			System.out.println("u is null");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		JDBC j = new JDBC();
		if (j.userAvailable(username))
		{
			j.decrementTicket(date, competition, homeTeam, awayTeam);
			request.setAttribute("user", u);
			out.print("operation done");
			String to = username;
			String subject = "Ticket Booked";
				String msg = "Hello " + u.getFirstName() +" " + u.getLastName()+" your ticket has been booked waiting for you to attend the match";
//			EmailSender.send(to, subject, msg);
				EmailSender ss = new EmailSender();
				ss.sendEmail(u.getEmail(),u.getFirstName(),u.getLastName(),date, time, competition, stadium, homeTeam, awayTeam);
			
			
			request.getRequestDispatcher("matchBooked.jsp").forward(request, response);
		}
		else
		{
			out.print("Username not found please try again");
			request.getRequestDispatcher("bookMatch.jsp").include(request, response);
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
