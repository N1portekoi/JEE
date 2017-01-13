package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierConnexion;

@WebServlet("/Connexion")
public class ControleurConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurConnexion() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Suppression de la session si existante
    	HttpSession session = request.getSession();
    	session.invalidate();
    	// Simple affichage de la page connexion
		getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pseudo = request.getParameter("pseudo").trim();
		String password = request.getParameter("password").trim();
		MetierConnexion connexion = new MetierConnexion(pseudo, password);
		Utilisateur utilisateur = connexion.connexion();
		if(utilisateur != null) {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			getServletContext().getRequestDispatcher("/Adresses").forward(request, response);
		}
		else {
			request.setAttribute("message", connexion.getMessage());
			getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
		}
	}
}
