package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierMessagesSupprimes;
import be.condorcet.metiers.MetierSupprimerMessage;

@WebServlet("/MessagesSupprimes")
public class ControleurMessagesSupprimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurMessagesSupprimes() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
    	String adresse = (String) session.getAttribute("adresse");
    	String id = request.getParameter("id");
    	if (adresse != null) { // Verification si la session existe
    		if (request.getParameter("btnNouveauMessage") != null && id != null) { // Crée un message
    			getServletContext().getRequestDispatcher("/JSP/NouveauMessage.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnSupprimerMessage") != null && id != null) { // Supprimer le message selectionné
    			MetierSupprimerMessage metierSupprimerMessage = new MetierSupprimerMessage(Integer.valueOf(id));
    			metierSupprimerMessage.supprimer();
    			// Actualisation de la page
    			MetierMessagesSupprimes metierMessagesSupprimes = new MetierMessagesSupprimes(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesSupprimes.messagesSupprimes());
            	getServletContext().getRequestDispatcher("/JSP/MessagesSupprimes.jsp").forward( request, response );
    		}
    		else {
    			// Actualisation de la page
    			MetierMessagesSupprimes metierMessagesSupprimes = new MetierMessagesSupprimes(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesSupprimes.messagesSupprimes());
            	getServletContext().getRequestDispatcher("/JSP/MessagesSupprimes.jsp").forward( request, response );
    		}
    	}
    	else {
    		getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
    	}
	}
}
