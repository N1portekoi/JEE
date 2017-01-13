package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierNouveauMessage;

@WebServlet("/NouveauMessage")
public class ControleurNouveauMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurNouveauMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	String adresse = (String) session.getAttribute("adresse");
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String destinataire = (String) request.getParameter("destinataire");
		String objet = (String) request.getParameter("objet");
		String message = (String) request.getParameter("message");
		if (adresse != null) { // Verification si la session existe
			if (request.getParameter("btnEnvoyerMessage") != null) { // Envoyer le message
				System.out.println(destinataire);
				System.out.println(objet);
				System.out.println(message);
				MetierNouveauMessage metierNouveauMessage = new MetierNouveauMessage(destinataire, objet, message, utilisateur, adresse);
				if (metierNouveauMessage.nouveauMessage()) { // Si le message a �t� envoy�
					getServletContext().getRequestDispatcher("/JSP/Messages.jsp").forward( request, response );
				}
				else {
					getServletContext().getRequestDispatcher("/JSP/NouveauMessage.jsp").forward( request, response );
				}
			}
			else {
				getServletContext().getRequestDispatcher("/JSP/Messages.jsp").forward( request, response );
			}
		}
		else {
			getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
		}
	}
}