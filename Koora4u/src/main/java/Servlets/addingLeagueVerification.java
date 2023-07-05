package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Competition;
import objects.JDBC;

/**
 * Servlet implementation class addingLeagueVerification
 */
@WebServlet("/addingLeagueVerification")
public class addingLeagueVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addingLeagueVerification() {
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
		String leagueName = request.getParameter("name");
		String leagueType = request.getParameter("type");
		String leagueCountry = request.getParameter("country");
		String topScorer = request.getParameter("topScorer");
		String topAssister = request.getParameter("topAssister");
		String topCS = request.getParameter("topCleanSheet");
		JDBC j = new JDBC();
		Competition c = new Competition(leagueName, leagueType, leagueCountry, j.getPlayerID(topScorer), j.getPlayerID(topAssister), j.getPlayerID(topCS));
		j.createCompetition(c);
		request.getRequestDispatcher("manageCompetitions.jsp").forward(request, response);
		
		
	}

}
