package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.JDBC;
import objects.Match;

/**
 * Servlet implementation class addMatchServlet
 */
@WebServlet("/addMatchServlet")
public class addMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMatchServlet() {
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
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String stadium = request.getParameter("stadium");
		String homeTeam = request.getParameter("homeTeam");
		String awayTeam = request.getParameter("awayTeam");
		int homeScore = Integer.parseInt(request.getParameter("homeScore"));
		int awayScore = Integer.parseInt(request.getParameter("awayScore"));
		String competitionName = request.getParameter("competitionName");
		Match m = new Match(date,time,stadium,homeTeam,awayTeam,homeScore,awayScore,competitionName);
		JDBC j = new JDBC();
		j.createMatch(m);
		
	}

}
