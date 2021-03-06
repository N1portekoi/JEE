package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.condorcet.beans.Utilisateur;
import be.condorcet.metiers.MetierAddAdresseIndesirable;
import be.condorcet.metiers.MetierAdresseIndesirable;
import be.condorcet.metiers.MetierDelAdresseIndesirable;

@WebServlet("/AdressesIndesirables")
public class ControleurAdressesIndesirables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurAdressesIndesirables() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = ((Utilisateur)session.getAttribute("utilisateur"));
		String adresse = ((String)session.getAttribute("adresse"));
		String adresseInde = request.getParameter("selectAdresseInde");
		String nouvelleAdresse = request.getParameter("nouvelleAdresseInde");
		if (utilisateur !=null) { // Verification si la session existe
			if (request.getParameter("btnSupprimerAdresseInde") != null && adresseInde != null) { // Bouton Supprimer Adresse
				MetierDelAdresseIndesirable metierDelAdresseIndesirable = new MetierDelAdresseIndesirable(adresse, adresseInde);
				metierDelAdresseIndesirable.delAdresseInde();
				request.setAttribute("message", metierDelAdresseIndesirable.getMessage());
			}
			else if (request.getParameter("btnAjouterAdresseInde") != null && adresse != null) { // Bouton Ajouter Adresse
				// Ajout de l'adresse indesirable
				MetierAddAdresseIndesirable metierAddAdresseIndesirable = new MetierAddAdresseIndesirable(adresse, nouvelleAdresse);
				metierAddAdresseIndesirable.addAdresseInde();
				request.setAttribute("message", metierAddAdresseIndesirable.getMessage());
			}
			// Actualisation de la page
			MetierAdresseIndesirable metierAdresseIndesirable = new MetierAdresseIndesirable(adresse);
			request.setAttribute("adresses", metierAdresseIndesirable.adresseInde());
			getServletContext().getRequestDispatcher("/JSP/AdressesIndesirables.jsp").forward( request, response );
		}
		else {
			getServletContext().getRequestDispatcher("/JSP/Connexion.jsp").forward( request, response );
		}
	}
}


