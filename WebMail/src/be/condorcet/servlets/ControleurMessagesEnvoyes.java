package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.MessageEnvoye;
import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierMessageEnvoye;
import be.condorcet.metiers.MetierMessagesEnvoyes;
import be.condorcet.metiers.MetierSupprimerMessage;

@WebServlet("/MessagesEnvoyes")
public class ControleurMessagesEnvoyes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurMessagesEnvoyes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String adresse = (String) session.getAttribute("adresse");
		String id = request.getParameter("id");
		if (adresse != null) { // Verification si la session existe
			if (request.getParameter("btnAfficherMessage") != null && id != null) { // Bouton pour lire le mail selectionn�
    			MetierMessageEnvoye metierMessageEnvoye = new MetierMessageEnvoye(Integer.valueOf(id));
    			MessageEnvoye messageEnvoye = metierMessageEnvoye.messageEnvoye();
    			request.setAttribute("qui", messageEnvoye.getDestinataire());
    			request.setAttribute("objet", messageEnvoye.getObjet());
    			request.setAttribute("message", messageEnvoye.getMessage());
    			getServletContext().getRequestDispatcher("/JSP/Message.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnNouveauMessage") != null) { // Pour creer un nouveau message
    			getServletContext().getRequestDispatcher("/JSP/NouveauMessage.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnSupprimerMessage") != null && id != null) { // Suppression du message
    			MetierSupprimerMessage metierSupprimerMessage = new MetierSupprimerMessage(Integer.valueOf(id));
    			metierSupprimerMessage.supprimer();
    			MetierMessagesEnvoyes metierMessagesEnvoyes = new MetierMessagesEnvoyes(adresse, utilisateur);
    	    	request.setAttribute("messages", metierMessagesEnvoyes.messagesEnvoyes());
    	    	getServletContext().getRequestDispatcher("/JSP/MessagesEnvoyes.jsp").forward( request, response );
    		}
    		else { // Actualisation de la page
    			MetierMessagesEnvoyes metierMessagesEnvoyes = new MetierMessagesEnvoyes(adresse, utilisateur);
    	    	request.setAttribute("messages", metierMessagesEnvoyes.messagesEnvoyes());
    	    	getServletContext().getRequestDispatcher("/JSP/MessagesEnvoyes.jsp").forward( request, response );
    		}
		}
		else {
			getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
		}
	}
}