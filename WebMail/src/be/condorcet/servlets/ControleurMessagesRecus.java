package be.condorcet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.MessageRecu;
import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierMessageCorbeille;
import be.condorcet.metiers.MetierMessageRecu;
import be.condorcet.metiers.MetierMessagesRecus;

@WebServlet("/MessagesRecus")
public class ControleurMessagesRecus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurMessagesRecus() {
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
    		if (request.getParameter("btnAfficherMessage") != null && id != null) { // Afficher le mail selectionn�
    			MetierMessageRecu metierMessageRecu = new MetierMessageRecu(Integer.valueOf(id));
    			MessageRecu messageRecu = metierMessageRecu.messageRecu();
    			request.setAttribute("qui", messageRecu.getExpediteur());
    			request.setAttribute("objet", messageRecu.getObjet());
    			request.setAttribute("message", messageRecu.getMessage());
    			getServletContext().getRequestDispatcher("/JSP/Message.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnNouveauMessage") != null) { // Cr�er un nouveau message
    			getServletContext().getRequestDispatcher("/JSP/NouveauMessage.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnSupprimerMessage") != null && id != null) { // Supprimer le message selectionn�
    			MetierMessageCorbeille metierMessageCorbeille = new MetierMessageCorbeille(Integer.valueOf(id));
    			metierMessageCorbeille.corbeille();
    			MetierMessagesRecus metierMessagesRecus = new MetierMessagesRecus(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesRecus.messagesRecus());
            	getServletContext().getRequestDispatcher("/JSP/MessagesRecus.jsp").forward( request, response );
    		}
    		else { // Actualiser la page
    			MetierMessagesRecus metierMessagesRecus = new MetierMessagesRecus(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesRecus.messagesRecus());
            	getServletContext().getRequestDispatcher("/JSP/MessagesRecus.jsp").forward( request, response );
    		}
    	}
    	else {
    		getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
    	}
	}
}
