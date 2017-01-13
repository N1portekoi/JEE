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
import be.condorcet.metiers.MetierAdresseIndesirable;
import be.condorcet.metiers.MetierMessageCorbeille;
import be.condorcet.metiers.MetierMessageIndesirable;
import be.condorcet.metiers.MetierMessagesIndesirables;

@WebServlet("/MessagesIndesirables")
public class ControleurMessagesIndesirables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurMessagesIndesirables() {
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
    		if (request.getParameter("btnAfficherMessage") != null && id != null) { // Lire le message selectionn�
    			MetierMessageIndesirable metierMessageIndesirable = new MetierMessageIndesirable(Integer.valueOf(id));
    			MessageRecu messageIndesirable = metierMessageIndesirable.messageIndesirable();
    			request.setAttribute("qui", messageIndesirable.getExpediteur());
    			request.setAttribute("objet", messageIndesirable.getObjet());
    			request.setAttribute("message", messageIndesirable.getMessage());
    			getServletContext().getRequestDispatcher("/JSP/Message.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnNouveauMessage") != null && id != null) { // Cr�e un nouveau message
    			getServletContext().getRequestDispatcher("/JSP/NouveauMessage.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnSupprimerMessage") != null  && id != null) { // Supprim� le message s�lectionn�
    			MetierMessageCorbeille metierMessageCorbeille = new MetierMessageCorbeille(Integer.valueOf(id));
    			metierMessageCorbeille.corbeille();
    			MetierMessagesIndesirables metierMessagesIndesirables = new MetierMessagesIndesirables(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesIndesirables.messagesIndesirables());
            	getServletContext().getRequestDispatcher("/JSP/MessagesIndesirables.jsp").forward( request, response );
    		}
    		else if (request.getParameter("btnAdressesIndesirables") != null && adresse != null) { // Gerer les adresses ind�sirables
    			MetierAdresseIndesirable metierAdresseIndesirable = new MetierAdresseIndesirable(adresse);
    			request.setAttribute("adresses", metierAdresseIndesirable.adresseInde());
    			getServletContext().getRequestDispatcher("/JSP/AdressesIndesirables.jsp").forward( request, response );
    		}
    		else { // Actualisation de la page
    			MetierMessagesIndesirables metierMessagesIndesirables = new MetierMessagesIndesirables(adresse, utilisateur);
            	request.setAttribute("messages", metierMessagesIndesirables.messagesIndesirables());
            	getServletContext().getRequestDispatcher("/JSP/MessagesIndesirables.jsp").forward( request, response );
    		}
    	}
    	else {
    		getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
    	}
	}
}
