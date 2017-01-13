package be.condorcet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.condorcet.metiers.MetierEnregistrement;

@WebServlet("/Enregistrement")
public class ControleurEnregistrement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleurEnregistrement() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/JSP/Enregistrement.jsp").forward( request, response );
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		MetierEnregistrement checkEnregistrement = new MetierEnregistrement(pseudo, password, password2, nom, prenom);
		checkEnregistrement.execute();
		request.setAttribute("message", checkEnregistrement.getMessage());
		getServletContext().getRequestDispatcher("/JSP/Enregistrement.jsp").forward( request, response );
	}
}
