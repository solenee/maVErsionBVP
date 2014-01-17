import commandesEnLigne.*;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv
 */
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op =  request.getParameter("op");

		if (op.equals("ajout")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			facade.ajout(nom,  prenom);
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		if (op.equals("liste")) {
			request.setAttribute("liste", facade.liste());
			request.getRequestDispatcher("liste.jsp").forward(request, response);
		}

	}

}


